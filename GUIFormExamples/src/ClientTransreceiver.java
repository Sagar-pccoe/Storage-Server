
import java.awt.CardLayout;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samsung
 */
public class ClientTransreceiver extends javax.swing.JPanel implements Runnable{
    
    int port;
    ServerSocketChannel serverChannel;
    ServerSocket serverSocket;
    SocketChannel sc;
    Socket s;
    
   ObjectInputStream objin;
   ObjectOutputStream objout;
       
    File file;
    FileInfo fileInfo;
    
    long fileSize;
    FileInputStream fin;
    FileOutputStream fout;
    FileChannel fileChannel;
    
    ByteBuffer bf;
    StatusPanel status;
    Thread thread;
    
    String userDir;
    boolean receive;
  
    CardLayout card;
     double kb=1024;
     double mb=1024 * 1024;
    ClientTransreceiver(File file,FileInfo fileInfo,int port,boolean b) throws Exception
    {
        this();       
        this.file=file;
        this.fileInfo=fileInfo;
        userDir=fileInfo.dir;
        this.port=port;
        receive=b;
      
        thread=new Thread(this);
        bf=ByteBuffer.allocate(1024*1024);
        serverChannel=ServerSocketChannel.open();
        serverSocket=serverChannel.socket();
        serverChannel.bind(new InetSocketAddress(port));
        thread.start();
    }
    
    ClientTransreceiver(FileInfo fileInfo,int port,boolean b) throws Exception
    {
        this();
        this.fileInfo=fileInfo;
        file=new File(fileInfo.dir,fileInfo.name);
        this.port=port;
        receive=b;   
        thread=new Thread(this);
        bf=ByteBuffer.allocate(1024*1024);
        serverChannel=ServerSocketChannel.open();
        serverSocket=serverChannel.socket();
        serverChannel.bind(new InetSocketAddress(port));
        thread.start();
    }
    
    public ClientTransreceiver() {
        
        initComponents();
        
        card=new CardLayout();
        
        setLayout(card);
        status=new StatusPanel();
        
        add(borderPanel,"FilePanel");
        add(status,"StatusPanel");
       
    }

    /*This Method sets up a Panel configuration */
    
    void setPanel() throws Exception
    {
       
        
        name.setText(file.getName());
        bar.setMaximum((int)fileSize);  
       
        if(fileSize >= mb)
            size.setText((fileSize/mb) + "MB");
        else if(fileSize >= kb)          
            size.setText((fileSize/kb) + "KB");
        else 
            size.setText(fileSize + "bytes");
          
    }
   
    public void run() 
    {
        try
        {
            sc=serverChannel.accept();
            s=sc.socket();
            System.out.println("Server thread connected..");
            objout=new ObjectOutputStream(s.getOutputStream());
            objin=new ObjectInputStream(s.getInputStream());
            
            /*if receive is true then server is sending a file */
            if(receive)
            {
                borderPanel.setBorder(BorderFactory.createTitledBorder("Downloading"));
                
                if(fileInfo.isFile)
                {  
                    if(receiveFile())
                    {
                        //JOptionPane.showMessageDialog(borderPanel,"File Successfully Downloaded...!");
                        status.setPanel(name.getText(),(int)fileSize,"Downloaded...!");
                        card.show(ClientTransreceiver.this,"StatusPanel");
                    }
                    else
                    {
                        status.setPanel(new ImageIcon("wrong.png"),name.getText(),(int)fileSize,"Downloading Cancelled !");
                        card.show(ClientTransreceiver.this,"StatusPanel");
                    }
                
                }
                else
                {
                    if(receiveFolder())
                    {
                        //JOptionPane.showMessageDialog(borderPanel,"File Successfully Downloaded...!");
                        status.setPanel(name.getText(),(int)fileSize,"Downloaded...!");
                        card.show(ClientTransreceiver.this,"StatusPanel");
                        
                    }else
                    {
                        status.setPanel(new ImageIcon("wrong.png"),name.getText(),(int)fileSize,"Downloading Cancelled !");
                        card.show(ClientTransreceiver.this,"StatusPanel");
                    }
                }
            }
            else
            {
                /*if receive is false then client is sending a file to server*/
              if(!fileInfo.isFile)
              {
                  if(uploadDirectory())
                  {
                      
                            //JOptionPane.showMessageDialog(borderPanel,"File Successfully Uploaded...!");
                            status.setPanel(name.getText(),(int)fileSize,"Uploaded...!");
                            card.show(ClientTransreceiver.this,"StatusPanel");
                  }else
                  {
                            status.setPanel(new ImageIcon("wrong.png"),name.getText(),(int)fileSize,"Uploading Cancelled !");
                            card.show(ClientTransreceiver.this,"StatusPanel");
                  }
              }
              else{ 
                        if(uploadFile())
                         {
                            //JOptionPane.showMessageDialog(borderPanel,"File Successfully Uploaded...!");
                            status.setPanel(name.getText(),(int)fileSize,"Uploaded...!");
                            card.show(ClientTransreceiver.this,"StatusPanel");
                        }
                        else
                        {
                            status.setPanel(new ImageIcon("wrong.png"),name.getText(),(int)fileSize,"Uploading Cancelled !");
                            card.show(ClientTransreceiver.this,"StatusPanel");
                        }
                 }
            }
            
            Thread.sleep(100);
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
                {
                    try
                    {
                     serverChannel.close();
                     sc.close();
                    }catch(Exception ee)
                    {
                        ee.printStackTrace();
                    }
                        
                }
    }
    
    public boolean uploadFile() throws Exception
    {       
           
            fileSize=file.length();
            fin=new FileInputStream(file);
            fileChannel=fin.getChannel();
          
            int bytesRead,totalBytes=0;
            setPanel();
            while(true)
            {
            
            bytesRead=fileChannel.read(bf);
           
                if(bytesRead==-1)
                break;
            
            totalBytes+=bytesRead;
           
            bf.flip();
            
            while(bf.hasRemaining())
            sc.write(bf);
            
            
            bar.setValue(totalBytes);
            
            bf.clear();
            }
            
            fileChannel.close();
            fin.close();
            
            if(totalBytes==fileSize)
            return true;
            else 
            return false;
    }
    
    boolean uploadDirectory() throws Exception
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
        
        //   System.out.println("Sending dir:"+dir);
           
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
                      // System.out.println("Sending a file:"+tempFileInfo);
                       uploadFile();
                       
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
       return true;
    }
    
    boolean receiveFile()throws Exception
    {
        fout=new FileOutputStream(file);
        fileChannel=fout.getChannel();
        fileSize=fileInfo.size;
        setPanel();
        int bytesRead=0,totalBytes=0;
        while(true)
        {
            bytesRead=sc.read(bf);
            
            if(bytesRead==-1)
                break;
            totalBytes+=bytesRead;
            
            bf.flip();
            
            while(bf.hasRemaining())
                fileChannel.write(bf);
            
            bar.setValue(totalBytes);
            bf.clear();
        }
        
        fileChannel.close();
        fout.close();
        
        if(totalBytes==fileInfo.size)
            return true;
        else
            return false;
    }
    
    void readFrom() throws Exception
    { 
       
        name.setText(file.getName());
        
    	fout=new FileOutputStream(file);
    	fileChannel=fout.getChannel();
        bar.setMaximum((int)fileInfo.size);
        if(fileInfo.size >= mb)
            size.setText((fileInfo.size/mb) + "MB");
        else if(fileInfo.size >= kb)          
            size.setText((fileInfo.size/kb) + "KB");
        else 
            size.setText(fileInfo.size + "bytes");
        int sb=0;

        while(sb < fileInfo.size)
        {
       fileChannel.transferFrom(sc,sb,1);
        sb++;
        bar.setValue(sb);
        }
       
        fileChannel.close();
        fout.close();
    }
    
    boolean receiveFolder()throws Exception
    {
        boolean flag=true;
    	Command c;
       
    	if(file.mkdir())
    	{
                  
    		do
    		{
    	  			c=(Command)objin.readObject();
    	  			//System.out.println("File Command 1/2(file/dir):"+c.c);
    	  			switch(c.c)
    	  			{
    	  				case 1:
    	  					fileInfo=(FileInfo)objin.readObject();
    	  					file=new File(fileInfo.dir,fileInfo.name);
    						//System.out.println("Downloading a file:"+fileInfo);
    	  					readFrom();
    	  					break;
    	  				case 2:
    	  					 fileInfo=(FileInfo)objin.readObject();
    	  					 file=new File(fileInfo.dir,fileInfo.name);
       						// System.out.println("Downloading a dir:"+fileInfo);
    	  					 file.mkdir();
    	  				break;
    	  			
    	  				 case 3:
    	  				 	flag=false;
    	  				 	break;
    	  				 	
    	  					default:
    	  					//	System.out.println("Invalid command..");
                                }
    		}while(flag);     
    	}
        
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borderPanel = new javax.swing.JPanel();
        bar = new javax.swing.JProgressBar();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblFileSize = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        size = new javax.swing.JLabel();

        borderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Uploading"));

        bar.setStringPainted(true);

        btnCancel.setText("Cancel");

        jButton1.setText("Pause");

        lblName.setText("File Name  : ");

        lblFileSize.setText("File size     :");

        name.setText("jLabel1");

        size.setText("jLabel2");

        javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
        borderPanel.setLayout(borderPanelLayout);
        borderPanelLayout.setHorizontalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(borderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(borderPanelLayout.createSequentialGroup()
                                .addComponent(lblFileSize)
                                .addGap(10, 10, 10)
                                .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(borderPanelLayout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        borderPanelLayout.setVerticalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(size)
                    .addComponent(lblFileSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCancel)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar bar;
    private javax.swing.JPanel borderPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFileSize;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel name;
    private javax.swing.JLabel size;
    // End of variables declaration//GEN-END:variables
}
