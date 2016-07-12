import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
public class LoginPanel1 extends javax.swing.JPanel {

 static  int result;
  String userName;
  String pwd;
  
    public LoginPanel1() {
        
        initComponents();
        
        lblForgotPassword.addMouseListener(new MouseAdapter()
        {
        
            public void mouseClicked(MouseEvent me)
            {
                ClientWindow.card.show(ClientWindow.panel,"Forgot Password");
             
            }
            public void mousePressed(MouseEvent me)
            {
                 ClientWindow.card.show(ClientWindow.panel,"Forgot Password");

            }
        
        });
       
        AddServer.readIP(cmbServer);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        LoginPanel = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblServer = new javax.swing.JLabel();
        cmbServer = new javax.swing.JComboBox();
        lblForgotPassword = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 217, 234));

        btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSignUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSignUp.setText("New User! SignUp");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUserName.setText("User Name:");

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPassword.setText("Password:");

        lblServer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblServer.setText("Server IP/Host Name:");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword)
                    .addComponent(txtUserName)
                    .addComponent(cmbServer, 0, 156, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblForgotPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblForgotPassword.setText("Forgot Your Password?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblForgotPassword)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgotPassword)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        ClientWindow.card.show(ClientWindow.panel,"Registration");
        clear();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
            try
            {
                
               userName=txtUserName.getText();
               pwd=new String(txtPassword.getPassword());
            
             if(!userName.equals("") && ! pwd.equals(""))
             {
         if(ClientWindow.client==null)// TODO add your handling code here:
         {
             
            ClientWindow.client=new Client((String)cmbServer.getSelectedItem(),1111);
            
            ClientWindow.user=new User(userName,pwd);   
            result=ClientWindow.client.loginUser(ClientWindow.user);
            if(result==5)
            {
                JOptionPane.showMessageDialog(LoginPanel1.this,"Login Successful..!","Congrats",JOptionPane.INFORMATION_MESSAGE);    
                ClientWindow.user=ClientWindow.client.getUser();
                ClientWindow.loggedInPanel.currentDir=ClientWindow.client.receiveList();
                ClientWindow.profile.setEnabled(true);
                ClientWindow.settings.setEnabled(false);
                ClientWindow.loggedInPanel.display(ClientWindow.loggedInPanel.currentDir);
                ClientWindow.card.show(ClientWindow.panel,"Logged In");
                clear();
            }
            else if(result==11)
            {
                JOptionPane.showMessageDialog(LoginPanel1.this,"User already logged in.","Sorry",JOptionPane.ERROR_MESSAGE);
                ClientWindow.client.disconnectUser();
                ClientWindow.client=null;
            } 
            else
            {
                JOptionPane.showMessageDialog(LoginPanel1.this,"Incorrect login Credentials","Sorry",JOptionPane.ERROR_MESSAGE);
                ClientWindow.client.disconnectUser();
                ClientWindow.client=null;
            }
            }
             }else
                 JOptionPane.showMessageDialog(LoginPanel,"Please Enter All the fields.");
             }catch(Exception e)
            {
                JOptionPane.showMessageDialog(LoginPanel1.this,"Server Unreachable.","Connection Error",JOptionPane.ERROR_MESSAGE);
                ClientWindow.client=null;
        
            }
    }//GEN-LAST:event_btnLoginActionPerformed

    void clear()
    {
        txtUserName.setText("");
        txtPassword.setText("");
     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    public javax.swing.JComboBox cmbServer;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
