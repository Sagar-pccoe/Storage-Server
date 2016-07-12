import java.net.*;
import java.io.*;

class Client implements UserCommandSet,FileCommandSet
{
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    User user;
    Path dirPath;
   
     Client(String ip,int port) throws Exception
    {
        socket=new Socket(ip,port);
        out=new ObjectOutputStream(socket.getOutputStream());
         in=new ObjectInputStream(socket.getInputStream());
         dirPath=null;
     }
    
    
    public int registerUser(User u) throws Exception
    {
        Command c=new Command(1);
        Response r; 
        out.writeObject(c);
        out.writeObject(u);
        r=(Response)in.readObject();
        return r.r;
    }
    
    public int loginUser(User u)throws Exception
    {
          Command c=new Command(2);
           Response r;
         
         out.writeObject(c);
         out.writeObject(u);
         r=(Response)in.readObject();
         if(r.r==SUCCESS)
         user=(User)in.readObject();
         return r.r;
    }

    public int updateUser(User u)throws Exception
    {
        Command c=new Command(3);
        Response r;
        out.writeObject(c);
        out.writeObject(u);
        r=(Response) in.readObject();
        if(r.r==5)
            user=u;
        return r.r;
    }

    public int unregisterUser(User u)throws Exception
    {
        Command c=new Command(4);
        Response r;
        out.writeObject(c);
        r=(Response) in.readObject();
        return r.r;
    }
    
    public void disconnectUser()throws Exception
    {
        Command c=new Command(100);
        Response r;
        out.writeObject(c);
        in.close();
        out.close();
        socket.close();
        
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void close()throws Exception
    {
        in.close();
        out.close();
        socket.close();
    }

     public int updatePassword(String pwd)throws Exception
    {
        Command c=new Command(7);
        Response r;
        out.writeObject(c);
        out.writeObject(pwd);
        r=(Response) in.readObject();
        if(r.r==5)
            user.password=pwd;
        return r.r;
    }
     
     		//overiding the methods of FileCommandSet
		
public	int createFile(File f)throws Exception
{
return FAILED;
}
public 	int deleteFile(File f)throws Exception
{
	return FAILED;
}
	
public 	int createDirectory(File f)throws Exception
{
	Command c=new Command(CREATE_DIR);
        Response r;
        out.writeObject(c);
        out.writeObject(f.getName());
        r=(Response)in.readObject();
	return r.r;
}
public 	int deleteDirectory(File f)throws Exception
{
        Command c=new Command(DELETE_DIR);
        Response r;
        out.writeObject(c);
        out.writeObject(f.getName());
        r=(Response)in.readObject();
        System.out.println("Delete response:"+r.r);
	return r.r;
}
	
public	int sendFile(File f)throws Exception
{
       
	return FAILED;
}
public int receiveFile(File f)throws Exception
{
	return FAILED;
}

public	void sendList(Path p) throws Exception
{
	out.writeObject(p);
} 
public Path receiveList() throws Exception
{ 
    dirPath=(Path) in.readObject();
    return dirPath;
}

public Path changeDirectory(String f) throws Exception
{
  
      Command c=new Command(CHANGE_DIR);
      Response r;
     out.writeObject(c);
     out.writeObject(f);
     dirPath=(Path)in.readObject();
    
     return dirPath;
 }

}