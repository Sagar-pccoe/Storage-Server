
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Sagar Rathod
 */
public class ProgressPanel extends javax.swing.JPanel{
    
      Copy copy;
      File src,dest;
      ByteBuffer b;
      int blockSize;
      Stack<File> stack=new Stack<File>();
  
    
        
    public ProgressPanel() {
        initComponents();
              
    }
    
    boolean copy(String s,String d) throws Exception
    { 
       this.src=new File(s);
       this.dest=new File(d,src.getName());
       
       //Allocate Buffer of size 10 MegaBytes
   
       blockSize=1024*1024*10;
       b=ByteBuffer.allocate(blockSize);
 
        if(src.isFile())
       {
           copy=new Copy(src,dest,b); 
           setPanel(src,dest);
          return copy.copyFile();
       }else
           return copyFolder();
    }
    
  
    
    boolean copyFolder()
    {   
        File list[];
        File tempDest;
       try
        {  
                stack.push(dest);
                stack.push(src);
                do
                {
                    src=stack.pop();
                    dest=stack.pop();
                    
                    list=src.listFiles();
                    dest.mkdir();
                    
                    for(int i=0;i<list.length;i++)
                    {
                        if(list[i].isDirectory())
                        {
                            tempDest=new File(dest,list[i].getName());
                            stack.push(tempDest);
                            stack.push(list[i]);
                            
                        }
                        else
                        {
                            tempDest=new File(dest,list[i].getName());
                            copy=new Copy(list[i],tempDest,b);
                            setPanel(list[i],tempDest);
                            copy.copyFile();
                            copy=null;
                        }
                     }
                }while(!stack.isEmpty());
             
               
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
        
    }

    void setPanel(File src,File dest) throws Exception
    {
            String s=src.getPath();
            String d=dest.getPath();
            
            bar.setMaximum((int)copy.size);
            size.setText(copy.size + " bytes");
            int lastIndex=s.lastIndexOf(File.separatorChar);
          
           //Set up a panel
         name.setText(s.substring(lastIndex+1,s.length()));
         from.setText(s.substring(0,lastIndex+1));
         to.setText(d.substring(0,d.lastIndexOf(File.separatorChar)+1));
          
    }
    
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        
        JFrame f=new JFrame("File Progress");
        ProgressPanel p=new ProgressPanel();
        f.setSize(350,220);
        f.setLocation(50,50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(f);
        f.setVisible(true);
       boolean flag=true;
        try {
            long start=System.currentTimeMillis();
         //  flag=p.copy("D:/database","E:/");
           long end=System.currentTimeMillis();
           System.out.println("Time taken:"+(end-start));
        } catch (Exception ex) {
          flag=false;
          ex.printStackTrace();
         
        }
        
        if(flag)
           {
               JOptionPane.showMessageDialog(p,"File copied successfully");
           }else
               JOptionPane.showMessageDialog(p,"Error in copying file.");
           
          
    }
    
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bar = new javax.swing.JProgressBar();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblFrom = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        lblFileSize = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        to = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bar.setStringPainted(true);

        btnCancel.setText("Cancel");

        jButton1.setText("Pause");

        lblName.setText("Name     : ");

        lblFrom.setText("From      :");

        lblTo.setText("To          :");

        lblFileSize.setText("File size  :");

        name.setText("jLabel1");

        size.setText("jLabel2");

        from.setText("jLabel3");

        to.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFrom)
                            .addComponent(lblTo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblFileSize)
                            .addGap(10, 10, 10)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFileSize)
                    .addComponent(size))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTo)
                    .addComponent(to))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCancel)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JProgressBar bar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFileSize;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel name;
    private javax.swing.JLabel size;
    private javax.swing.JLabel to;
    // End of variables declaration//GEN-END:variables
}
class Copy
{
    FileInputStream fin;
    FileChannel srcFileChannel;
    
    FileOutputStream fout;
    FileChannel destFileChannel;
   
    ByteBuffer bf;
    
    long size;
    
    int bytesRead=0;
    int bytesWritten=0;
    boolean flag=false;
   
    
    Copy(File src,File dest,ByteBuffer b) throws Exception
    {
        fin=new FileInputStream(src);
        fout=new FileOutputStream(dest);
         
         srcFileChannel=fin.getChannel();
         destFileChannel=fout.getChannel();
         
         size=srcFileChannel.size();
         
         bf=b;
         
    }
    
    boolean copyFile() throws Exception
    {
         
        try
        {   flag=false;  
            bytesRead=0;
            int totalBytes=0;
           while(true)
           {
               bytesRead=srcFileChannel.read(bf);
               totalBytes+=bytesRead;
               if(bytesRead==-1)
                   break;
               bf.flip();
               while(bf.hasRemaining())
                bytesWritten+=destFileChannel.write(bf); 
               
               bf.clear();
               ProgressPanel.bar.setValue(totalBytes);
              
           }
            return true;
            
        }catch(Exception e)
        {   
            e.printStackTrace();
            return false;
        }finally
        {
             fin.close();
             fout.close();
        }
    }
}