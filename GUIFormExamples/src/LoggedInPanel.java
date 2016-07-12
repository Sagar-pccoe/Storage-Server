
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import javax.swing.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sagar Rathod
 */
public class LoggedInPanel extends javax.swing.JPanel implements MouseListener {

   
    GridLayout fl;
    Path currentDir;
    ImageIcon folderIcon;
    ImageIcon fileIcon;
    JLabel label=new JLabel();
    File tempFile;
  
    String folder;
    int i;
    ProgressPanel panel;
    JFileChooser fileChooser;
    Random r;
    ClientTransreceiver t[]=new ClientTransreceiver[5];
    int tCount=0;
    
    public LoggedInPanel() {
        initComponents();
        fl=new GridLayout(5,6);
        folderPanel.setLayout(fl);
        fileStatusPanel.setLayout(new GridLayout(10,1));
        folderIcon=new ImageIcon("folder.jpg");
        fileIcon=new ImageIcon("file.png");
        fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
       
        r=new Random();
        try
	{
	  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        
	}catch(Exception e)
		{
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(fileChooser);    
    }
  
    void display(Path p)
    {
        folderPanel.removeAll();
        txtAddressBar.setText(p.pathName);
        for(FileInfo i:p.dc.list)
        {   
            label=new JLabel(i.name);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            label.setVerticalTextPosition(SwingConstants.BOTTOM);
            if(i.isFile)
                label.setIcon(fileIcon);
            else
                label.setIcon(folderIcon);
                label.addMouseListener(LoggedInPanel.this);
                folderPanel.add(label);
        }
        folderPanel.updateUI();
        if(p.pathName.equals("Storage Server/"+ClientWindow.user.userName))
        {
            btnBack.setEnabled(false);
            btnHome.setEnabled(false);
        }
        else
        {    btnBack.setEnabled(true);
             btnHome.setEnabled(true);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnPanel = new javax.swing.JPanel();
        lblFilePath = new javax.swing.JLabel();
        txtFilePath = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        btnCreateFolder = new javax.swing.JButton();
        btnDeleteFolder = new javax.swing.JButton();
        lblAddressBar = new javax.swing.JLabel();
        txtAddressBar = new javax.swing.JTextField();
        lblProgressIndicator = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        folderPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileStatusPanel = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(153, 217, 234));

        btnPanel.setBackground(new java.awt.Color(153, 217, 234));
        btnPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblFilePath.setText("Current Selection :");

        txtFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilePathActionPerformed(evt);
            }
        });

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/upload.jpg"))); // NOI18N
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download.jpg"))); // NOI18N
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        btnCreateFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/createFolder.jpg"))); // NOI18N
        btnCreateFolder.setToolTipText("Create Folder");
        btnCreateFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFolderActionPerformed(evt);
            }
        });

        btnDeleteFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteFolder.jpg"))); // NOI18N
        btnDeleteFolder.setToolTipText("Delete Folder");
        btnDeleteFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFilePath))
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAddressBar.setText("Address Bar :");

        txtAddressBar.setEditable(false);
        txtAddressBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressBarActionPerformed(evt);
            }
        });

        lblProgressIndicator.setText("Progress Indicator :");

        folderPanel.setBackground(new java.awt.Color(255, 255, 255));
        folderPanel.setMaximumSize(new java.awt.Dimension(2000, 2000));

        javax.swing.GroupLayout folderPanelLayout = new javax.swing.GroupLayout(folderPanel);
        folderPanel.setLayout(folderPanelLayout);
        folderPanelLayout.setHorizontalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        folderPanelLayout.setVerticalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(folderPanel);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftArrow.jpeg"))); // NOI18N
        btnBack.setToolTipText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        fileStatusPanel.setBackground(new java.awt.Color(255, 255, 255));
        fileStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        fileStatusPanel.setMaximumSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout fileStatusPanelLayout = new javax.swing.GroupLayout(fileStatusPanel);
        fileStatusPanel.setLayout(fileStatusPanelLayout);
        fileStatusPanelLayout.setHorizontalGroup(
            fileStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );
        fileStatusPanelLayout.setVerticalGroup(
            fileStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(fileStatusPanel);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2.jpg"))); // NOI18N
        btnRefresh.setToolTipText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h3.jpg"))); // NOI18N
        btnHome.setToolTipText("Home");
        btnHome.setDisabledSelectedIcon(null);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProgressIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(lblAddressBar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAddressBar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)))
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddressBar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProgressIndicator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilePathActionPerformed

    private void txtAddressBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressBarActionPerformed

    private void btnCreateFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFolderActionPerformed
       try
       {
       folder=JOptionPane.showInputDialog("Enter Folder Name to Create:");
     
        if(folder!=null)
        {
           tempFile=new File(currentDir.pathName+"/"+folder);
            i=ClientWindow.client.createDirectory(tempFile);
            if(i==5)
            {
                //Once folder is created then add content to the cuurent path of ClientWindow.currentDir
                //then display the contents
                currentDir=ClientWindow.client.receiveList();
                display(currentDir);
              }
            else
                JOptionPane.showMessageDialog(null,"Sorry, Can't create.","Error",JOptionPane.ERROR_MESSAGE);
        }
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,"Sorry, Can't create folder.","Error",JOptionPane.ERROR_MESSAGE);
       }// TODO add your handling code here:
    }//GEN-LAST:event_btnCreateFolderActionPerformed

    private void btnDeleteFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFolderActionPerformed
        try
       {
        folder=JOptionPane.showInputDialog("Enter Folder Name to Delete:");
        if(folder!=null)
        {
           tempFile=new File(currentDir.pathName+"/"+folder);
            i=ClientWindow.client.deleteDirectory(tempFile);
            if(i==5)
            {
                //Once folder is created then add content to the cuurent path of ClientWindow.currentDir
                //then display the contents
                currentDir=ClientWindow.client.receiveList();
                 display(currentDir);
               
             }
            else
                JOptionPane.showMessageDialog(null,"Sorry, Unable to delete folder.","Error",JOptionPane.ERROR_MESSAGE);
        }
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteFolderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try
        {
        folder=txtAddressBar.getText();
        String d=folder.substring(0, folder.lastIndexOf('/'));
        currentDir=ClientWindow.client.changeDirectory(d);
        
        display(currentDir);
  
        }catch(Exception e)
        {
               //  JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try
        {
        int s=fileChooser.showDialog(LoggedInPanel.this,"Select");
         FileInfo f;
        if(s==JFileChooser.APPROVE_OPTION)
        {
            s=JOptionPane.showConfirmDialog(panel,"Do you really want to continue?");
            if(s==0)
            {
              tempFile=fileChooser.getSelectedFile();     
              ClientWindow.client.out.writeObject(new Command(26));
              i=(int)(r.nextFloat()*10000);//i for port no.
              f=new FileInfo(tempFile.getName(),tempFile.length(),currentDir.pathName,i,tempFile.isFile());
              ClientWindow.client.out.writeObject(f);
              t[tCount]=new ClientTransreceiver(tempFile,f,i,false);
              fileStatusPanel.add(t[tCount]);
              fileStatusPanel.updateUI();
              tCount++;
            }
           //panel=new ProgressPanel();
           //fileStatusPanel.add(panel);
           //fileStatusPanel.updateUI();
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try
        {
        ClientWindow.client.out.writeObject(new Command(30));
        currentDir=(Path)ClientWindow.client.in.readObject();
        display(currentDir);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try
        {
            ClientWindow.client.out.writeObject(new Command(31));
            currentDir=(Path)ClientWindow.client.in.readObject();
            display(currentDir);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        try{
            
            folder = txtFilePath.getText();
            if(!folder.equals(""))
            {
            FileInfo f=ClientWindow.client.dirPath.dc.find(folder);
            int y=JOptionPane.showConfirmDialog(LoggedInPanel.this,"Do you want to download "+ f.name +"?" );
            if(y==0)
            {
                y=fileChooser.showSaveDialog(LoggedInPanel.this);
                
                if(y==JFileChooser.APPROVE_OPTION)
                {
                    i=(int)(r.nextFloat()*10000);                  
                    FileInfo f2=new FileInfo(f);
                    f2.port=i;
                    f2.dir=currentDir.pathName;
                ClientWindow.client.out.writeObject(new Command(25));
                ClientWindow.client.out.writeObject(f2);
                f.dir=fileChooser.getSelectedFile().getPath();
                ClientWindow.client.out.writeObject(f.dir);
                t[tCount]=new ClientTransreceiver(f,i,true);
                fileStatusPanel.add(t[tCount]);
                fileStatusPanel.updateUI();
                tCount++;
                }
            }
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDownloadActionPerformed

    /* This method performs change directory operation*/
    public void mouseClicked(MouseEvent me)
    {
        try
        {          
        if(me.getClickCount()==1)
        {
        label.setForeground(Color.black);
         label=(JLabel)me.getSource();
         txtFilePath.setText(label.getText());
        label.setForeground(Color.red);
        }
        else  if(me.getClickCount()==2)
        {
      folder=label.getText();
      if(!folder.equals(""))
        {
      if(!folder.contains("."))
      {
       
      currentDir=ClientWindow.client.changeDirectory(currentDir.pathName+"/"+folder);
      display(currentDir);
      } 
        }
            }
      }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
        
    }
    public void mousePressed(MouseEvent me)
    {
        if(me.getClickCount()==1)
        {
         label.setForeground(Color.black);
        JLabel a=(JLabel)me.getSource();
        txtFilePath.setText(a.getText());
        a.setBackground(Color.red);
        
        }
    }
    public void mouseReleased(MouseEvent me)
    {
        if(me.getClickCount()==1)
        {
        JLabel a=(JLabel)me.getSource();
        txtFilePath.setText("");
        a.setBackground(Color.white);
        }
    }
    
    public void mouseExited(MouseEvent me)
    {
         
    }
    public void mouseEntered(MouseEvent me)
    {
        
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateFolder;
    private javax.swing.JButton btnDeleteFolder;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSend;
    public static javax.swing.JPanel fileStatusPanel;
    private javax.swing.JPanel folderPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAddressBar;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblProgressIndicator;
    private javax.swing.JTextField txtAddressBar;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}

