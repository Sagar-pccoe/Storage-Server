
import java.io.File;

class FileInfo implements java.io.Serializable
{
	String name;
        String dir;
	long size;
	int port;
	boolean isFile;
	
	FileInfo()
	{
		dir=name=null;
		size=port=-1;
		isFile=true;	
	}
        
        FileInfo(String n,long s,String d,boolean b)
	{
		name=n;
                dir=d;
		size=s;
		port=-1;
		isFile=b;
	}
	
	FileInfo(String n,long s,String d,int p,boolean b)
	{
		name=n;
                dir=d;
		size=s;
		port=p;
		isFile=b;
	}
        
        FileInfo(FileInfo f)
        {
            name=f.name;
            dir=f.dir;
            size=f.size;
            port=f.port;
            isFile=f.isFile;
        }

        void setPort(int i)
        {
            port=i;
        }
	public String toString()
	{
		return "FileInfo: " + name +" "+size+" "+dir+" "+port+" "+isFile;
	}
}