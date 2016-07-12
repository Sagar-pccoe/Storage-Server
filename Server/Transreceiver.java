
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

class Transreceiver implements Runnable
{	

	int id;
	Socket s;
    SocketChannel sc;
    
    ObjectInputStream objin;
    ObjectOutputStream objout;  
    
    File file;	  
    FileInfo fileInfo;
    
    FileInputStream fin;
    FileOutputStream fout;
    FileChannel fileChannel;
    
    boolean receive;
    ByteBuffer bf;
    String userDir;
    Thread thread;
    
    
    Transreceiver(int id,SocketChannel sc,FileInfo fileInfo,boolean b,String userDir) throws Exception
    {   
    	this.id=id;          
        this.sc=sc;
        s=sc.socket();
        
        objin=new ObjectInputStream(s.getInputStream());
        objout=new ObjectOutputStream(s.getOutputStream());
        
        this.fileInfo=fileInfo;
        file=new File(fileInfo.dir,fileInfo.name);
        this.userDir=userDir;
        this.receive=b;//Used to indicate reception if it is true otherwise transmission 
    	thread=new Thread(this);
    	thread.start();
    }
    
    public void run()
    {
        try
        {
        	if(receive)
        	{
        		if(fileInfo.isFile)
        		 readFrom();
        		else
        		 receiveFolder();
        	}else
        	{
        		/*buffer is required only for sending file to user*/
        		bf=ByteBuffer.allocate(1024*1024);
        		if(fileInfo.isFile)
        			
        			sendFile();
        		else
        			sendFolder();
        		
        	}
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	try
        	{
        		objin.close();
        		objout.close();
        		sc.close();
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }
    }
    
   void receiveFile() throws Exception
    {
    	int bytesRead=0;
    	long totalBytes=0;
    	fout=new FileOutputStream(file);
    	fileChannel=fout.getChannel();
    	bf=ByteBuffer.allocate((int)fileInfo.size);
		while(true)
		{    	
    	   bytesRead=sc.read(bf);
    	   
    	   if(bytesRead==-1)
    	   	break;
    	   	
    	   	totalBytes+=bytesRead;
    	   	System.out.println("Total bytes read:"+totalBytes);
    	    
    	    bf.flip();
    	 
    	 	while(bf.hasRemaining())
    	    	fileChannel.write(bf);
    	   
    	 bf.clear();
    	 
    	 if(totalBytes==fileInfo.size)
    	 	return;
    	 
       	}
    	fileChannel.close();
    	fout.close();    	
    }
    
    void readFrom() throws Exception
    {
    	fout=new FileOutputStream(file);
    	fileChannel=fout.getChannel();
        fileChannel.transferFrom(sc,0,fileInfo.size);
        fileChannel.close();
        fout.close();
    }
    
    void receiveFolder() throws Exception
    {
    	boolean flag=true;
    	Command c;
    	if(file.mkdir())
    	{
    	
    		do
    		{
    	  			c=(Command)objin.readObject();
    	  			System.out.println("File Command 1/2(file/dir):"+c.c);
    	  			switch(c.c)
    	  			{
    	  				case 1:
    	  					fileInfo=(FileInfo)objin.readObject();
    	  					file=new File(fileInfo.dir,fileInfo.name);
    						System.out.println("Uploading a file:"+fileInfo);
    	  					readFrom();
    	  					break;
    	  				case 2:
    	  					 fileInfo=(FileInfo)objin.readObject();
    	  					 file=new File(fileInfo.dir,fileInfo.name);
       						 System.out.println("Uploading a dir:"+fileInfo);
    	  					 file.mkdir();
    	  				break;
    	  			
    	  				 case 3:
    	  				 	flag=false;
    	  				 	break;
    	  				 	
    	  					default:
    	  						System.out.println("Invalid command..");
    	  				}
    		}while(flag);
    	}
    }


void sendFile()throws Exception
{
int bytesRead=0,totalBytes=0;	
fin=new FileInputStream(file);
fileChannel=fin.getChannel();
//fileChannel.transferTo(0,fileInfo.size,sc);
 while(true)
            {
            
            bytesRead=fileChannel.read(bf);
           
                if(bytesRead==-1)
                break;
            
            totalBytes+=bytesRead;
           
            bf.flip();
            
            while(bf.hasRemaining())
            sc.write(bf);
                        
            bf.clear();
            }	
fileChannel.close();
fin.close();	
}

void sendFolder()throws Exception
{
    	Command c;
        FileInfo tempFileInfo;
        File files[];
  
        Queue q=new Queue(20);
        
        q.enqueue(file);
        q.enqueue(userDir);
        
        String dir;
         
       while(!q.isEmpty())
       {
           file=(File)q.dequeue();
           userDir=(String)q.dequeue();
           
           dir=userDir+"/"+file.getName();
        
           System.out.println("Sending dir:"+dir);
           
           files=file.listFiles();
         
               for(int i=0;i<files.length;i++)
               {
                  
                   tempFileInfo=new FileInfo(files[i].getName(),files[i].length(),dir,files[i].isFile());
                   
                   if(tempFileInfo.isFile)
                   {  
                       c=new Command(1);
                       objout.writeObject(c);
                       objout.writeObject(tempFileInfo);
                       file=files[i];
                       System.out.println("Sending a file:"+tempFileInfo);
                       sendFile();
                       
                   }
                    else
                   {
                       q.enqueue(files[i]);
                       q.enqueue(dir);
                       
                       c=new Command(2);
                       objout.writeObject(c);
                       objout.writeObject(tempFileInfo);  
                   }
                  
               }
            
           }
          c=new Command(3);
          objout.writeObject(c);
	
}
}



