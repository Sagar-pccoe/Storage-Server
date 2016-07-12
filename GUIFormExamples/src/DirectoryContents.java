
import java.io.File;

class DirectoryContents implements java.io.Serializable
{
	FileInfo list[];
	
	DirectoryContents(File f)
	{
		listDirectoryContents(f);
	}
        
 	void listDirectoryContents(File f)
	{
                list=null;
                File files[]=f.listFiles();

	 	list=new FileInfo[files.length];
		for(int i=0;i< files.length;i++)
		{
		list[i]=new FileInfo(files[i].getName(),files[i].length(),files[i].getParent(),files[i].isFile());
		}
	}
        
public	void displayContents()
	{
		System.out.println("Contents are:");
		for(int i=0;i<list.length;i++)
			System.out.println(i+":"+list[i]);
	}

FileInfo find(String name)
{
    for(int i=0;i<list.length;i++)
    {
        if(name.equals(list[i].name))
            return list[i];
    }
 return null;   
}


}
