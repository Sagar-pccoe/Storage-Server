import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.awt.event.*;
class MyTable extends JFrame
{
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane jsp;
	FileInputStream fin;
	ObjectInputStream objin;
	File file;
	MyTable(String tableName,String colHeader[],File f)
	{
		super(tableName);
		setLocation(50,50);
		setSize(900,600);
		setVisible(true);
		tableModel=new DefaultTableModel(colHeader,0);
		table=new JTable(tableModel){
			
			public boolean isCellEditable(int a0,int a1)
			{
				return false;
			}
			};
		
		jsp=new JScrollPane(table);
		add(jsp);
		file=f;
		
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
			
			});
	}
	
	public void showData()
	{
		try
		{
		
			User user;
			fin=new FileInputStream(file);
			objin=new ObjectInputStream(fin);
			int count=0;
			while((user=(User)objin.readObject())!=null)
			{
				count++;
				tableModel.addRow(new Object[]{count,user.userName,user.password,user.firstName,user.lastName,user.email,user.contactNo,user.seqAns,user.ip_hostName,user.loggedIn});
			}
			
		}catch(EOFException e)
		{
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
					try{
					
						objin.close();
						fin.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
		}
		
	}

}