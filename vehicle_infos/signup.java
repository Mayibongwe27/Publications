/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle_infos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author 215082627
 */
public class signup extends javax.swing.JFrame {//registration form
     Connection conn =null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    String gender; 
    String usertype;
    /**
     * Creates new form signin
     */
    public signup() {
        
        initComponents();
        conn = ConnectionUtil.connectdb();//instantiating connection class in every constructor
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        cpassword = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        email1 = new javax.swing.JTextField();
        surname1 = new javax.swing.JTextField();
        platenum1 = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        brand1 = new javax.swing.JTextField();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        Gender = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        admin = new javax.swing.JRadioButton();
        ordinary = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1380, 800));

        cpassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Vehicle Registration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("email");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Surname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Number Plate");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Car brand");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Confirm password");

        pass1.setText("jPasswordField1");

        pass2.setText("jPasswordField2");

        Gender.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Gender.setText("Gender");

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        male.setText("male");

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        female.setText("female");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Select user");

        buttonGroup2.add(admin);
        admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        admin.setText("admin");

        buttonGroup2.add(ordinary);
        ordinary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ordinary.setText("Ordinary ");

        javax.swing.GroupLayout cpasswordLayout = new javax.swing.GroupLayout(cpassword);
        cpassword.setLayout(cpasswordLayout);
        cpasswordLayout.setHorizontalGroup(
            cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpasswordLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cpasswordLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(677, 677, 677)
                        .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(pass1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(brand1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(email1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id1)
                            .addComponent(platenum1)
                            .addComponent(surname1))
                        .addGap(759, 759, 759))
                    .addGroup(cpasswordLayout.createSequentialGroup()
                        .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addGroup(cpasswordLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cpasswordLayout.createSequentialGroup()
                                        .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(383, 383, 383)
                                        .addComponent(male))
                                    .addGroup(cpasswordLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(352, 352, 352)
                                        .addComponent(admin)))))
                        .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cpasswordLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 921, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cpasswordLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ordinary)
                                    .addComponent(female))
                                .addGap(870, 870, 870))))))
        );
        cpasswordLayout.setVerticalGroup(
            cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpasswordLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(surname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platenum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cpasswordLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cpasswordLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(brand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Gender)
                    .addComponent(male)
                    .addComponent(female))
                .addGap(26, 26, 26)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(admin)
                    .addComponent(ordinary))
                .addGap(49, 49, 49)
                .addGroup(cpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(submit))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id1ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       Connection con=null;
       PreparedStatement ps=null;
         //obtaining values from textfields
        String email= email1.getText();
        String surname= surname1.getText();
        
        
        String passw1= String.valueOf(pass1.getPassword());
        String passw2 = String.valueOf(pass2.getPassword());
       
       // if (!Arrays.equals(passw1.getPassword(), passw2.getPassword())) {
         // JOptionPane.showMessageDialog(null, "Passwords do not match.", "Woops", JOptionPane.ERROR_MESSAGE);
       // } 
     
        if(!passw1.equals(passw2)) JOptionPane.showMessageDialog(null, "passwords are different");
        String plate= platenum1.getText();
        String id= id1.getText();
        String brand=brand1.getText();
        
        if(male.isSelected()){
         gender="Male";
        }
        if(female.isSelected()){
         gender="female";
        }
        
         if(admin.isSelected()){
         usertype="admin";
        }
        if(ordinary.isSelected()){
         usertype="ordinary";
        }
        
        //JOptionPane.showMessageDialog(null, "try insert");
        String sql = "INSERT INTO owners(email,surname,password,plate,idnum,brand,gender,usertype)values(?,?,?,?,?,?,?,?)";
         try {
            
                 ps =conn.prepareStatement(sql);
                 ps.setString(1,email);
                 ps.setString(2,surname);
                 ps.setString(3,passw1);
                 ps.setString(4,plate);
                 ps.setString(5,id);
                 ps.setString(6,brand);
                 ps.setString(7,gender);
                 ps.setString(8,usertype);
                 ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, "inserted successfully");
                 dispose();
                 viewInfo view= new viewInfo();
                 view.setVisible(true);
             }
             catch (Exception e){
                 e.printStackTrace();
             }
           
         
    }//GEN-LAST:event_submitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        email1.setText("");
        surname1.setText("");
        pass1.setText("");
        pass2.setText("");
        platenum1.setText("");
        id1.setText("");
        brand1.setText("");
        male.setText("");
        female.setText("");
        admin.setText("");
        ordinary.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gender;
    private javax.swing.JRadioButton admin;
    private javax.swing.JTextField brand1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel cpassword;
    private javax.swing.JTextField email1;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField id1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton ordinary;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField platenum1;
    private javax.swing.JButton submit;
    private javax.swing.JTextField surname1;
    // End of variables declaration//GEN-END:variables
}
