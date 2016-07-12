
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class Transreceiver implements Runnable
{
    ServerSocketChannel serverChannel;
    ServerSocket serverSocket;
    
    SocketChannel sc;
    Socket s;
    ObjectInputStream objin;
    ObjectOutputStream objout;
    
    File file;
    FileInputStream fin;
    FileOutputStream fout;
    FileChannel fileChannel;
    int port;
    ByteBuffer bf;
    Thread thread;
    
    Transreceiver(File file,int port) throws Exception
    {
        this.file=file;
        this.port=port;
        fin=null;
        fout=null;
        thread=new Thread(this);
        bf=ByteBuffer.allocate(1024*1024);
        serverChannel=ServerSocketChannel.open();
        serverSocket=serverChannel.socket();
        serverChannel.bind(new InetSocketAddress(port));
        thread.start();
    }
    
    
    public void run() 
    {
        try
        {
            sc=serverChannel.accept();
            System.out.println("Server initiated a connection.");
            s=sc.socket();
            objin=new ObjectInputStream(s.getInputStream());
            objout=new ObjectOutputStream(s.getOutputStream());
            
            fin=new FileInputStream(file);
            fileChannel=fin.getChannel();
            int bytesRead;
            
            while(true)
            {
            
            bytesRead=fileChannel.read(bf);
            
            if(bytesRead==-1)
                break;
            
            bf.flip();
            while(bf.hasRemaining())
            sc.write(bf);
            
            bf.clear();
            }
            
            Thread.sleep(1000);
                    
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
   
}