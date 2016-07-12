
import java.util.Arrays;
import javax.swing.*;

public class RegistrationPanel extends javax.swing.JPanel {
    
    Client client;
    public RegistrationPanel() {
        initComponents();
    
      AddServer.readIP(cmbServer);     
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblServer = new javax.swing.JLabel();
        lblSecurity = new javax.swing.JLabel();
        txtSecurity = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblErrorFirstName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblErrorUser = new javax.swing.JLabel();
        lblErrorContact = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        lblErrorEmail = new javax.swing.JLabel();
        lblErrorServer = new javax.swing.JLabel();
        lblErrorSecurity = new javax.swing.JLabel();
        lblErrorConfirm = new javax.swing.JLabel();
        cmbServer = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(153, 217, 234));

        lblFirstName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblFirstName.setText("First Name:");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblLastName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLastName.setText("Last Name:");

        lblUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUserName.setText("User Name:");

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        lblConfirmPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblConfirmPassword.setText("Confirm Password:");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblEmail.setText("Email-ID:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblContact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblContact.setText("Contact No:");

        lblServer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblServer.setText("Server IP/Host Name:");

        lblSecurity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSecurity.setText("Security Question:Place of Birth");

        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContact, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorContact, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblServer)
                        .addGap(85, 85, 85)
                        .addComponent(cmbServer, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorServer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSecurity)
                        .addGap(20, 20, 20)
                        .addComponent(txtSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorContact, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbServer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblServer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorServer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblErrorSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         clearAll();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       ClientWindow.card.show(ClientWindow.panel,"Login");
       clearAll();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       String str1 = txtFirstName.getText();
       String str2 = txtLastName.getText();
       String str3 = txtUserName.getText();
       String str4 = txtContact.getText();
       String str5 = txtEmail.getText(); 
       String str7 = txtSecurity.getText();
       char pwd[];
       String name = "[A-Z][a-zA-Z]*";
       
       String emailreg = "[a-zA-Z0-9[!#$%&'()*+,/\\-_\\.\\\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\\\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\\\"\\.]]+";
       boolean a = str1.matches(name);
       boolean c = str2.matches(name);
       boolean b = str5.matches(emailreg);
       //boolean d = str6.matches(server);
        pwd = txtPassword.getPassword();
        int l = txtPassword.getPassword().length;
     
     
       if(Arrays.equals(txtPassword.getPassword(), txtConfirmPassword.getPassword())){
          lblErrorConfirm.setText(""); lblErrorPassword.setText("");
          
       }else { lblErrorConfirm.setText("Error");
               }
       
       if(str1.equals("")){
           lblErrorFirstName.setText("*");
       }else if(a==true){ lblErrorFirstName.setText("");}
       else { lblErrorFirstName.setText("Error");  }
      
       if (str2.equals("")){
           jLabel1.setText("*");
       }else if(c==true){ jLabel1.setText("");}
       else { jLabel1.setText("Error");}
       
       
       if (str3.equals("")){
           lblErrorUser.setText("*");
       }else{ lblErrorUser.setText("");}
       
       
       if(str5.equals("")){
           lblErrorEmail.setText("*");
       }else if(b==true){
           lblErrorEmail.setText("");
       }else{lblErrorEmail.setText("Error"); }
           
       if(l == 0){
            lblErrorPassword.setText("*");   
       }
       
       if (str4.equals("")){
           lblErrorContact.setText("*");
       }
       else if(str4.length() != 10){
           lblErrorContact.setText("Error");
       } else{ lblErrorContact.setText("");}
       
       
       if(str7.equals("")){
           lblErrorSecurity.setText("*");
       }else { lblErrorSecurity.setText(""); }
       
       String ErrorFirstName = lblErrorFirstName.getText();
       String ErrorLastName = jLabel1.getText();
       String ErrorUser = lblErrorUser.getText();
       String ErrorPassword = lblErrorPassword.getText();
       String ErrorConfirm = lblErrorConfirm.getText();
       String ErrorEmail = lblErrorEmail.getText();
       String ErrorContact = lblErrorContact.getText();
       String ErrorSecurity = lblErrorSecurity.getText();
       
 if(ErrorConfirm.equals("") && ErrorPassword.equals("") && ErrorFirstName.equals("") && ErrorLastName.equals("") && ErrorUser.equals("") && ErrorEmail.equals("") && ErrorContact.equals("") && ErrorSecurity.equals(""))      
     {     
       try
       {
         
       client=new Client((String)cmbServer.getSelectedItem(),1111);
       int r=client.registerUser(new User(str3,new String(pwd),str1,str2,str5,Long.parseLong(str4),str7,(java.net.InetAddress.getLocalHost().toString())));
        client.disconnectUser();
        
       if(r==5)
       {
           JOptionPane.showMessageDialog(RegistrationPanel.this,"Registration Successful..!","Storage Service",JOptionPane.INFORMATION_MESSAGE);
           ClientWindow.card.show(ClientWindow.panel,"Login");
           clearAll();
       }
       else
            JOptionPane.showMessageDialog(RegistrationPanel.this,"Can't registered",""
                    + "Error in data",JOptionPane.ERROR_MESSAGE);
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(RegistrationPanel.this,""+e,"Error in connection",JOptionPane.ERROR_MESSAGE);
       }
     }
     else
     {
        JOptionPane.showMessageDialog(RegistrationPanel.this,"Fill all the Details Properly.....");
      }
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

   void clearAll()
   {
         txtFirstName.setText("");
         txtLastName.setText("");
         txtUserName.setText("");
         txtPassword.setText("");
         txtConfirmPassword.setText("");
         txtContact.setText("");
         txtEmail.setText("");
        
         txtSecurity.setText("");
         lblErrorFirstName.setText("");
         jLabel1.setText("");
         lblErrorUser.setText("");
         lblErrorPassword.setText("");
         lblErrorConfirm.setText("");
         lblErrorContact.setText("");
         lblErrorEmail.setText("");
         lblErrorServer.setText("");
         lblErrorSecurity.setText("");
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSubmit;
    public javax.swing.JComboBox cmbServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorConfirm;
    private javax.swing.JLabel lblErrorContact;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorFirstName;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorSecurity;
    private javax.swing.JLabel lblErrorServer;
    private javax.swing.JLabel lblErrorUser;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSecurity;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSecurity;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
