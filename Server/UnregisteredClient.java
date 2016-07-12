import java.io.*;
import java.net.*;
import java.nio.channels.SocketChannel;
class UnregisteredClient implements Runnable,UserCommandSet
{
	private Socket socket;
	private	ObjectInputStream in;
	private	ObjectOutputStream out;
	private Thread clientThread;
	private InetAddress clientIP;
	boolean threadFlag=true;
	private RegisteredUser regUser;
    static User user;
	static Command command=new Command();
	static Response response=new Response(FAILED);	
	
	UnregisteredClient(Socket socket,InputStream in,OutputStream out) throws Exception
	{
		this.socket=socket;
		this.in=new ObjectInputStream(in);
		this.out=new ObjectOutputStream(out);
		clientIP=socket.getInetAddress();
		regUser=null;
		user=null;
		clientThread=new Thread(this,"Client");
		clientThread.start();
	}
	
	Socket getSocket()
	{
		return socket;
	}
	 
	 InputStream getInputStream()
	 {
	 	return in;
	 }
	 
	 OutputStream getOutputStream()
	 {
	 	return out;
	 }
	 
	 public void run()
	 {
	 		System.out.println("Client connected...");
		 
	 	 while(threadFlag)
	 	 {
		 	try
		 	{
		 							
					command=(Command)in.readObject();	//read command

					System.out.println("Command received:"+command.c);
						switch(command.c)
						{
							case REGISTER_USER:
							 	user=(User)in.readObject();
							  	response.r=registerUser(user);
							  	out.writeObject(response);
								break;
								
							 case LOGIN_USER:
							 	
							 user=(User)in.readObject();
							 response.r=loginUser(user.userName,user.password);
							 System.out.println("Login response:"+response.r);
							 if(response.r==SUCCESS)
							 {
							 	
							 	out.writeObject(response);	//first pass the response to the client
							 	out.writeObject(user); // pass the user information
							 	user.setLoggedIn(true);
							 	regUser.login();    // transfer control to the file operation	
							 }else
							 {
							 	out.writeObject(response);
							 }	
							 	break;
							 	
							 	case FORGOT_PASSWORD:
							 	String userName=(String)in.readObject();
							 	 user=Database.search(userName);
							 	 if(user!=null)
							 	 {
							 	 	response.r=5;
							 	 	out.writeObject(response);
							 	 	out.writeObject(user);
							 	 }else
							 	 {
							 	 	response.r=INVALID_USER_NAME;
							 	 	out.writeObject(response);
						
							 	 }
							 	 break;
							 	 
							 	 						 
							 case DISCONNECT:		//for disconnection request
							 	disconnectUser();
							 	threadFlag=false;
							 	break;
							 default:
							 	System.out.println("Invalid command..");
							 	response.r=101;
							 	out.writeObject(response);
						}
						
						Thread.sleep(1000);

		 		
		 }catch(InterruptedException e)
		 {
		 	System.out.println("Client Thread interrupted:");
		 	e.printStackTrace();
		 	threadFlag=false;
		 }catch(ClassNotFoundException e)
		 {
		 	System.out.println("Invalid command...");
		 	e.printStackTrace();
		 	threadFlag=false;
		 }catch(IOException e)
		 {
		 	System.out.println("Input output error...");
		 	e.printStackTrace();
		 	threadFlag=false;
		 }catch(Exception e)
		 {
		 	e.printStackTrace();
		 	threadFlag=false;
		 }	 	
	 }
}
		 //methods of UserCommandSet interface
public int registerUser(User u)throws Exception
		{
			boolean flag=false;
			flag=Database.insert(u);
			if(flag)
			{
			createUserDirectory();
			return SUCCESS;
			}
			else
			return FAILED;
		}
		
public	int loginUser(String un,String pwd)throws Exception
{
	User u=Database.search(un,pwd);
	if(u!=null) 
	{
		if(u.loggedIn) //user should not be already logged in
		{
		 return ALREADY_LOGGED_IN;
		}else
		{
		regUser=new RegisteredUser();
		user=u;
		System.out.println(user);
		return SUCCESS;
		}
	}
	else
		return FAILED;
}
public	int updateUser(User temp)throws Exception
{
		user.firstName = temp.firstName;
		user.lastName = temp.lastName;
		user.contactNo = temp.contactNo;
		user.email = temp.email;
		return 5;
}
public	int unregisterUser(User u)throws Exception
{
	boolean flag=Database.delete(u.userName);
	System.out.println(flag+ " Deleted:"+user);
	if(flag)
	return SUCCESS;
	else
	return FAILED;
}
	
public void disconnectUser()throws Exception
{
	 	    user.loggedIn=false;
			in.close();
	 		out.close();
	 		socket.close();
	 		
}

void createUserDirectory()
{
	new File("Storage Server/"+user.userName).mkdir();
	new File("Storage Server/"+user.userName+"/"+"Documents").mkdir();
	new File("Storage Server/"+user.userName+"/"+"Programs").mkdir();
	new File("Storage Server/"+user.userName+"/"+"Videos").mkdir();
	new File("Storage Server/"+user.userName+"/"+"Compressed").mkdir();

}


	class RegisteredUser implements FileCommandSet
	{
		Command command=new Command(-1);
		Response response=new Response(-1);
		String home="Storage Server/"+user.userName;
		Path currentDir;
		User temp;
		String dir;
		File tempFile;
		int tCount=0;
		Transreceiver t[]=new Transreceiver[5];
		FileInfo f;
		void login()
		{
			
			System.out.println("Client logged in...");
			try
			{
				/*Once client logged in immediately send the list of files to him/her. */
				
				currentDir=new Path(home);
				sendList(currentDir);
		
				while(threadFlag)
				{
					 command=(Command)in.readObject();  //read command
					
					System.out.println("Command received:"+command.c);
				
					switch(command.c)
					{
						/*User Information Releated Command  */
					case UPDATE_USER:
					    temp=(User)in.readObject();
						updateUser(temp);
						response.r=5;
						out.writeObject(response);
						temp=null;
						break;
						
					case UNREGISTER_USER:
						response.r=unregisterUser(user);
						out.writeObject(response);
						if(response.r==5)
						{
							threadFlag=false;
							in.close();
	 						out.close();
	 						socket.close();
	 					}
						break;
					
					case CHANGE_PASSWORD:
					    dir=(String)in.readObject();
						user.password=dir;
						response.r=5;
						out.writeObject(response);
						break;
						
					case HOME:
						currentDir=new Path(home);
						out.writeObject(currentDir);
						break;
						
					case REFRESH:
						currentDir=new Path(currentDir.pathName);
						out.writeObject(currentDir);	 	 	
						break;
	
					
					case DISCONNECT:
						threadFlag=false;
						break;
						
						/*File Related Commands */
						
					case CREATE_FILE:
						break;
					
					case DELETE_FILE:
						break;
					
					case SEND:
						f=(FileInfo)in.readObject();
						System.out.println("Download request:"+f);
						dir=(String)in.readObject();
						t[tCount]=new Transreceiver(tCount,SocketChannel.open(new InetSocketAddress(socket.getInetAddress(),f.port)),f,false,dir);
						tCount++;
						break;
						
					case RECEIVE:
						f=(FileInfo)in.readObject();
						t[tCount]=new Transreceiver(tCount,SocketChannel.open(new InetSocketAddress(socket.getInetAddress(),f.port)),f,true,null);
						tCount++;
						break;
						
					case CREATE_DIR:
						 dir=(String) in.readObject();
						tempFile=new File(currentDir.pathName+"/"+dir);
						response=new Response(createDirectory(tempFile));
						out.writeObject(response);
						if(response.r==5)
						{
							currentDir=new Path(currentDir.pathName);
							sendList(currentDir);	
						}
						break;
						
					case DELETE_DIR:
						dir=(String)in.readObject();
						tempFile=new File(currentDir.pathName+"/"+dir);
						response=new Response(deleteDirectory(tempFile));
						System.out.println("Delete dir:"+response.r);
						out.writeObject(response);
						if(response.r==5)
						{
							currentDir=new Path(currentDir.pathName);
							sendList(currentDir);	
						}
						break;	
						
					case SEND_LIST:
						break;
						
					case RECEIVE_LIST:
						break;
					
				     case CHANGE_DIR:
				     	dir=(String)in.readObject();
				     	tempFile=new File(dir);
				     	currentDir=changeDirectory(dir);
				     	sendList(currentDir);	
				     	break;
						
					default:
						System.out.println("Invalid command...");
						response.r=101;
					}
			
						  // write response
				
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
				try
				{
					disconnectUser();
					threadFlag=false;
					for(int i=0;i<tCount;i++)
					{
						t[i]=null;
					}
						System.gc();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
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
	
public 	int createDirectory(File f)
{
	if(f.mkdir())
	 return SUCCESS;
	 else
	return FAILED;
}
public 	int deleteDirectory(File f)
{
	if(f.delete())
	return SUCCESS;
	else
	return FAILED;
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
	return new Path("a");
}
		
public Path changeDirectory(String f) throws Exception
{
	Path p=new Path(f);
	return p;
}
		

  }
		
}