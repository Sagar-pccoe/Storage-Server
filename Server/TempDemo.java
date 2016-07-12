/**
 * @(#)TempDemo.java
 *
 *
 * @author 
 * @version 1.00 2014/2/19
 */
import java.io.File;
public class TempDemo {
        
    /**
     * Creates a new instance of <code>TempDemo</code>.
     */
    public TempDemo() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file=new File("Storage Server/sagar");
        System.out.println("Name:"+file.getName());
        System.out.println("Path:"+file.getParent());
        System.out.println("Is directory:"+file.isDirectory());
        System.out.println("Size:"+file.length());
        System.out.println("Total Space:"+file.getTotalSpace());
        System.out.println("Free Space:"+file.getFreeSpace());
        for(String s:file.list())
        {
        	System.out.println(s);
        }
        
    }
}
