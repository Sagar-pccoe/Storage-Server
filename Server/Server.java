import java.net.*;
class Server implements Runnable
{
	ServerSocket serverSocket;
	Socket clientSocket;
	Thread serverThread;
	UnregisteredClient user;
	static int activeUserCount=0;
	boolean threadFlag;
	
	public void run()
	{
		try
		{
			while(threadFlag)
			{
				
			System.out.println("Waiting for connection..");
			clientSocket=serverSocket.accept();
			user=new UnregisteredClient(clientSocket,clientSocket.getInputStream(),clientSocket.getOutputStream());
			activeUserCount++;
			
			Thread.sleep(200);
		  }
		}catch(SocketException e)
		{
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	void startServer() throws Exception
	{	
		Database.readFile();				//first read the registerd user file into the Database LinkedList object
		serverSocket=new ServerSocket(1111);
		serverThread=new Thread(this);
		serverThread.start();
		threadFlag=true;
	}
	
	void stopServer()
	{
		try
		{
		threadFlag=false;
		Database.writeFile(false);// write the Database's linked list objects back to the file before closing
		serverSocket.close();
		}catch(SocketException e)
		{
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}