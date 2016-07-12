import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientWindow extends javax.swing.JFrame implements ActionListener{
    
   static JMenuBar bar;
   static JMenu settings;
   static JMenuItem addServer;
   static JMenu profile;
   static JMenuItem showProfile;
   static JMenuItem unRegister;
   static JMenuItem changePassword;
   static JMenuItem logout;
    
    static JPanel panel;
    static JFrame frame;
    static  CardLayout card;
    static  LoginPanel1 loginPanel1;
    static RegistrationPanel regPanel;
    static LoggedInPanel loggedInPanel;
    static ProfilePanel profilePanel;
    static ChangePasswordPanel changePasswordPanel;
    static ForgotPasswordPanel forgotPasswordPanel;
    static Client client;
    static AddServer sip;
    static User user;
    Toolkit t;
    Dimension d;
    public ClientWindow() {
        
        t=getToolkit();
        d=t.getScreenSize();
		
        setSize(d.width,d.height-40);
        setBackground(new Color(153,217,234));
        setTitle("Server Storage System");
        setIconImage((new ImageIcon("folder.png").getImage()));
        card=new CardLayout();
        panel=new JPanel(card);
        
        add(panel);
        settings=new JMenu("Settings");
        profile=new JMenu("Profile");
    
        showProfile=new JMenuItem("Show Profile");
        changePassword=new JMenuItem("Change Password");
        unRegister=new JMenuItem("Unregister Account");
        logout=new JMenuItem("Logout");
        profile.setEnabled(false);
        
        profile.add(showProfile);
        profile.add(changePassword);
        profile.add(unRegister);
        profile.add(logout);
        
        addServer=new JMenuItem("Add Server");
        settings.add(addServer);
        bar=new JMenuBar();
        
        bar.add(profile);
        bar.add(settings);
        
        setJMenuBar(bar);
         sip=new AddServer();
        loginPanel1=new LoginPanel1();
        regPanel=new RegistrationPanel();
        loggedInPanel=new LoggedInPanel();
        profilePanel=new ProfilePanel();
        changePasswordPanel=new ChangePasswordPanel();
        forgotPasswordPanel=new ForgotPasswordPanel();
       
        
        panel.add(loginPanel1,"Login");
        panel.add(regPanel,"Registration");
        panel.add(loggedInPanel,"Logged In");
        panel.add(profilePanel,"Profile");
        panel.add(changePasswordPanel,"Change Password");
        panel.add(forgotPasswordPanel,"Forgot Password");
        panel.add(sip,"Add Server");
        
        showProfile.addActionListener(this);
        changePassword.addActionListener(this);
        unRegister.addActionListener(this);
        logout.addActionListener(this);
        
        addServer.addActionListener(this);
               try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		SwingUtilities.updateComponentTreeUI(this);
	
    
               addWindowListener(new WindowAdapter()
               {
            @Override
                   public void windowClosing(WindowEvent we)
                   {
                       try
                       {    if(client!=null)
                            logout();
                           System.exit(0);
                       }catch(Exception e)
                       {
                       
                       }
                   }
              });
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 913, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClientWindow().setVisible(true);
            }
        });
    }
 
    public void actionPerformed(ActionEvent ae)
    {   String c=ae.getActionCommand();
    try{    
    
        if(c.equals("Add Server"))
        {
            card.show(panel,"Add Server");
        }
        else if(c.equals("Show Profile"))
        {
         card.show(panel,"Profile");
         profilePanel.showProfile(user);
        }
        else if(c.equals("Change Password"))
        {
                card.show(panel,"Change Password");
       
        }
        else if(c.equals("Logout"))
        {
           logout();
           
       }else if(c.equals("Unregister Account"))
       {
           int i=JOptionPane.showConfirmDialog(null,"Are you sure you want to unregister your account?");
           if(i==0)
           {
               i=client.unregisterUser(user);
               if(i==5)
               {
                   JOptionPane.showMessageDialog(null,"You are Successfully Unregistered..!");
                   client.close();
                   client=null;
                   profile.setEnabled(false);
                   settings.setEnabled(true);
                   card.show(panel, "Login");
               }
           }  
       }
        
    }catch (IOException e){}
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(null, e);
       
    }

    }
   
    void logout() throws Exception
    {
           client.disconnectUser();
           LoggedInPanel.fileStatusPanel.removeAll();
           card.show(panel, "Login");
           profile.setEnabled(false);
           settings.setEnabled(true);
           client=null;
           System.gc();
    
    }
    
}
