import java.io.File;
class Path implements java.io.Serializable
{
	String pathName;
        DirectoryContents dc;
	
        Path()
        {
            pathName=null;
            dc=null;
        }
        
        Path(Path p)
        {
            pathName=p.pathName;
            dc=p.dc;
        
        }
	Path(String pn)
	{
		
		pathName=pn;
		dc=new DirectoryContents(new File(pathName));
	}

	String getPath()
	{
		return pathName;
	}
	
	 DirectoryContents getDirectoryContents()
        {
            return dc;
        }

         void setDirectoryContents(DirectoryContents d)
         {
             dc=d;
         }
}


