
import javax.swing.Icon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samsung
 */
public class StatusPanel extends javax.swing.JPanel {
    
    public StatusPanel() {
        initComponents();
    
    }

    void setPanel(Icon i,String fn,int s,String msg)
    {
        iconLabel.setIcon(i);
        name.setText(fn);
        size.setText(s +" bytes");
        status.setText(msg);
    }
    
    void setPanel(String fn,int s,String msg)
    {  
        name.setText(fn);
        size.setText(s +" bytes");
        status.setText(msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right.png"))); // NOI18N

        jLabel2.setText("File     :");

        jLabel1.setText("Size    :");

        jLabel3.setText("Status :");

        name.setText("jlabel4");

        size.setText("jLabel5");

        status.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(size, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(size)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status)
                    .addComponent(jLabel3))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel name;
    private javax.swing.JLabel size;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
