import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;

class StorageServer
{
 static ServerFrame sf;
		
	public static void main(String args[])
	{
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				
				sf=new ServerFrame(); 
			}
			
		});	
		
	}
}
class ServerFrame extends JFrame
{
	Toolkit t;
	Dimension d;
	ServerCenterPanel scp;
	
	ServerWestPanel swp;
	
	
	JMenuBar mbar=new JMenuBar();

	JMenu admin=new JMenu("Administrator");
	JMenu config=new JMenu("Configuration");
	JMenu user=new JMenu("User Statistics");
	
	JMenuItem adminProfile=new JMenuItem("Admin Profile");
	JMenuItem regUser=new JMenuItem("Registered User");
	JMenuItem showLogFile=new JMenuItem("Show Log File");
	JMenuItem userReports=new JMenuItem("User Reports");
	
	ServerFrame()
	{
		super("Server Storage System");
		t=Toolkit.getDefaultToolkit();
		d=t.getScreenSize();
		setSize(d.width,d.height-40);
		setIconImage(new ImageIcon("serverimages/small.jpeg").getImage());
		
		scp=new ServerCenterPanel();
	
		swp=new ServerWestPanel();
		
		
		
		add(swp,BorderLayout.WEST);
	
		add(scp,BorderLayout.CENTER);
		
		admin.add(adminProfile);
		
		user.add(regUser);
	    user.add(showLogFile);
	    user.add(userReports);
	    
	    regUser.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
	    	{
	    		try
	    		{
	  
			Database.writeFile();
	    	String col[]={"Sr_No","User_Name","Password","First_Name","Last_Name","Email_ID","Contact_No","SecurityQAns","UserMachine's IP","Active_Status"};
			MyTable table=new MyTable("Registered User",col,new java.io.File("RegisteredUser"));
			table.showData();
	    		}
			catch(Exception e)
	    	{
	    		JOptionPane.showMessageDialog(StorageServer.sf,e,"File read error",JOptionPane.ERROR_MESSAGE);
	    	}
	   	 	}	
	    });
	    mbar.add(admin);
	    mbar.add(user);
		mbar.add(config);
		setJMenuBar(mbar);
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		SwingUtilities.updateComponentTreeUI(this);
		setVisible(true);
		Database.readFile();		
				
				
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent we)
		{
			swp.shutdownServer();
			System.exit(0);
		}
		
	});			
	}
}

class ServerCenterPanel extends JPanel
{	
	JLabel serverImage;
	ImageIcon serverIcon;
		
	ServerCenterPanel()
	{		
			setBorder(BorderFactory.createEtchedBorder());
			setBackground(new Color(153,217,234));
			setLayout(new BorderLayout());
			serverIcon=new ImageIcon("serverimages/server3.jpg");
		
			serverImage=new JLabel(serverIcon);
		
			add(serverImage,BorderLayout.CENTER);
	}
	
public Insets getInsets()
{
	return new Insets(10,10,100,100);
}

}

class ServerNorthPanel extends JPanel
{
	ServerNorthPanel()
	{
		setSize(80,10);
		setBorder(BorderFactory.createEtchedBorder());
	}
}

class ServerWestPanel extends JPanel implements ActionListener
{	JPanel btnPanel;
	JButton startServer;
	JButton stopServer;
	ServerStatusPanel statusPanel;
	Server server=null;
	JPanel ipPanel;
	IPConfig ip;
	ServerWestPanel()
	{
		setLayout(new GridLayout(15,1));
		setBorder(BorderFactory.createEtchedBorder());
		setBackground(Color.white);
		btnPanel=new JPanel();
		
		ip=new IPConfig();
		ipPanel=new JPanel(new GridLayout(2,1));
		ipPanel.setBackground(Color.white);
		JLabel sn=new JLabel("Server Name:"+ ip.hostName);
		JLabel sip=new JLabel("Server IP :" +ip.hostAddress);
		Font f=new Font("Time New Roman",Font.PLAIN,14);
		sn.setFont(f);
		sip.setFont(f);
		ipPanel.add(sn);
		ipPanel.add(sip);
		btnPanel.setBackground(Color.white);
		btnPanel.setBorder(BorderFactory.createEtchedBorder());
		startServer=new JButton("Start Server");
		stopServer=new JButton("Shutdown");
		stopServer.setEnabled(false);
		statusPanel=new ServerStatusPanel();
		btnPanel.add(startServer);
		btnPanel.add(stopServer);	
		add(ipPanel);
		add(statusPanel);
		add(btnPanel);
		startServer.addActionListener(this);
		stopServer.addActionListener(this);
		try
		{
		server=new Server();
	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String b=ae.getActionCommand();
		if(b.equals("Start Server"))
		{
		    	startServer();
		}
		else if(b.equals("Shutdown"))
		{
			shutdownServer();
		}
	}
	void startServer()
	{
		try
			{
			server.startServer();
			startServer.setEnabled(false);
			stopServer.setEnabled(true);
			statusPanel.startTime();
			statusPanel.setServerStatus("Running");
			}catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(StorageServer.sf,""+e,"Exception",JOptionPane.ERROR_MESSAGE);
			}
		
	}

	void shutdownServer()
	{
		try
			{
			server.stopServer();
			startServer.setEnabled(true);
			stopServer.setEnabled(false);
			statusPanel.stopTime();
			statusPanel.setServerStatus("Stopped");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	Server getServer()
	{
		return server;
	}

}

class ServerEastPanel extends JPanel
{
	ServerEastPanel()
	{	setSize(20,80);
		setBorder(BorderFactory.createEtchedBorder());
	}
}

class IPConfig
{
	InetAddress ip;
	String hostName;
	String hostAddress;
	IPConfig() 
	{
		try
		{
		ip=InetAddress.getLocalHost();
		hostName=ip.getHostName();
		hostAddress=ip.getHostAddress();
		}catch(UnknownHostException une)
		{
			hostName="UnknownHost";
			hostAddress="UnKnownAddress";
			System.out.println(une);
		}
	}
}


class ServerStatusPanel extends JPanel implements Runnable
{	
	JLabel serverStatus;
	JLabel timeElapsed;
	JPanel timePanel;
	Font font;
	Thread time;
	boolean threadFlag;
	ServerStatusPanel()
	{
		
		setBackground(Color.white);
		setLayout(new GridLayout(2,1));
		timePanel=new JPanel(new GridLayout(1,1));
		timePanel.setBackground(Color.white);
		serverStatus=new JLabel("Server Status: Stopped");
		timeElapsed=new JLabel("Time Elapsed:0:0:0:0");
		font=new Font("Time New Roman",Font.PLAIN,14);
		serverStatus.setFont(font);
		timeElapsed.setFont(font);
		add(serverStatus);
		timePanel.add(timeElapsed);
		add(timePanel);
		time=new Thread(this,"Time");
	}
	
	void setServerStatus(String st)
	{
		serverStatus.setText("Server Status: "+st);
	}
	
	public void run()
	{	
		int days,hh,mm,ss;
		try
		{
			for(days=0;threadFlag;days++)
			{
			  for(hh=0;hh<23&&threadFlag;hh++)
			  {
			  	for(mm=0;mm<59&&threadFlag;mm++)
			  	{
			  		for(ss=0;ss<59&&threadFlag;ss++)
			  		{
			  
			  			setTime(days+":"+hh+":"+mm+":"+ss);
			  			Thread.sleep(1000);	
			  		}		
			  	}
			  }
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	void startTime()
	{
	 	time=new Thread(this,"Time");
	    time.start();
	    threadFlag=true;
	}
	
	void stopTime()
	{
		threadFlag=false;	
		setTime("0:0:0:0");
	}

	void setTime(String time)
	{
		timeElapsed.setText("Time Elapsed:"+time);
	}
}