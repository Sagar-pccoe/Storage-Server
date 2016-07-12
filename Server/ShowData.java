import javax.swing.*;
import java.io.*;
import java.awt.Font;

class ShowData
{
	JFrame f;
	JScrollPane s;
	JTextArea txtArea;
	ShowData()
	{
		f=new JFrame();
		f.setSize(1300,600);
		f.setLocation(50,50);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		txtArea=new JTextArea();
		txtArea.setFont(new Font("Times New Roman",Font.PLAIN,15));
		s=new JScrollPane(txtArea);
		txtArea.setEditable(false);
		f.add(s);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new ShowData();
	}
	
	void showData(String frameTitle,String columnHeader,File file)
	{	try
		{	
		f.setTitle(frameTitle);
		FileInputStream fin=new FileInputStream(file);
		ObjectInputStream in=new ObjectInputStream(fin);
		User u;
		txtArea.append(columnHeader);
		int count=0;
		while((u=(User)in.readObject())!=null)
		{
			count++;
			txtArea.append(count+"\t"+u.toString()+"\n");
		}
		}catch(EOFException e)
		{	
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}