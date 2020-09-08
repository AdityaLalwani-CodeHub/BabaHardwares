/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Aditya
 */
public class MANAGE_COMPANY_DETAILS_FORM extends javax.swing.JFrame {
    private String JSONFilePath;
    private boolean generate;
    File json;
    /**
     * Creates new form MANAGE_COMPANY_DETAILS_FORM
     */
    public MANAGE_COMPANY_DETAILS_FORM() {
        try {
            initComponents();
            generate = false;
            JSONFilePath = getClass().getResource("/JSON/company.json").getPath().substring(6).replace("!", "");
            //System.out.println(getClass().getResource("/JSON/company.json").getFile());
        //    JSONObject jsonDocument =
         //           (JSONObject)JSONValue.parse(new FileReader(new File(getClass().getResource("/JSON/company.json").toURI())));
      /*   File curDir = new File(".");
         File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
            {
                System.out.println(f.getName());
                JOptionPane.showMessageDialog(null,f.getName());
            }
            if(f.isFile()){
                System.out.println(f.getName());
                JOptionPane.showMessageDialog(null,f.getName());
            }
        } */
    //     JSONObject jsonDocument =
    //                (JSONObject)JSONValue.parse(new FileReader(getClass().getResource("/images/company.json").getFile()));
         
            //JOptionPane.showMessageDialog(null,"URI : " + getClass().getResource("/JSON/company.json").toURI());
            
            json = new File("company.json");
            try
            {
                if(!json.exists())
                {
                    json.createNewFile();
                    try (FileWriter writer = new FileWriter(json)) {
                        writer.write("{}");
                    }
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null,"Problem getting details " + ex.getMessage());
                generate = true;
            }
            JSONObject jsonDocument =
                    (JSONObject)JSONValue.parse(new FileReader(json));
            if(jsonDocument.containsKey("OrganisationName")) {
			this.setOrganisationName((String)jsonDocument.get("OrganisationName"));
		}
        if(jsonDocument.containsKey("addressLine1")) {
			this.setaddressLine1((String)jsonDocument.get("addressLine1"));
		}
        if(jsonDocument.containsKey("addressLine2")) {
			this.setaddressLine2((String)jsonDocument.get("addressLine2"));
		}
        if(jsonDocument.containsKey("addressLine3")) {
			this.setaddressLine3((String)jsonDocument.get("addressLine3"));
		}
        if(jsonDocument.containsKey("Phone")) {
			this.setPhone((String)jsonDocument.get("Phone"));
		}
        if(jsonDocument.containsKey("Email")) {
			this.setEmail((String)jsonDocument.get("Email"));
		}
        if(jsonDocument.containsKey("GSTIN")) {
			this.setGSTIN((String)jsonDocument.get("GSTIN"));
		}
            generateJSONFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MANAGE_COMPANY_DETAILS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Could not open details : " + ex.getMessage());
        }
    }
    
     private void setOrganisationName(String OrganisationName) {
        jTextField_companyName.setText(OrganisationName);
    }

    private void setaddressLine1(String addressLine1) {
        jTextField_addressline1.setText(addressLine1);
    }

    private void setaddressLine2(String addressLine2) {
       jTextField_addressline2.setText(addressLine2);
    }

    private void setaddressLine3(String addressLine3) {
        jTextField_addressline3.setText(addressLine3);
    }

    private void setPhone(String Phone) {
        jTextField_phone.setText(Phone);
    }

    private void setEmail(String Email) {
        jTextField_email.setText(Email);
    }

    private void setGSTIN(String GSTIN) {
        jTextField_GSTIN.setText(GSTIN);
    }
    
    private void generateJSONFile() {
        JSONObject objectList = new JSONObject();
        
        objectList.put("OrganisationName", jTextField_companyName.getText());
        objectList.put("addressLine1", jTextField_addressline1.getText());
        objectList.put("addressLine2", jTextField_addressline2.getText());
        objectList.put("addressLine3", jTextField_addressline3.getText());
        objectList.put("Phone", jTextField_phone.getText());
        objectList.put("Email", jTextField_email.getText());
        objectList.put("GSTIN", jTextField_GSTIN.getText());
        
        if(generate)
        {
            json = new File("company.json");
            try
            {
                if(!json.exists())
                {
                    json.createNewFile();
                    FileWriter writer = new FileWriter(json);
                    writer.write("{}");
                    writer.close();
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Problem saving details " + ex.getMessage());
                this.dispose();
            }
        }
        //Write JSON file
        try (FileWriter file = new FileWriter(json)) {
 
            file.write(objectList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_companyName = new javax.swing.JTextField();
        jTextField_addressline1 = new javax.swing.JTextField();
        jTextField_addressline2 = new javax.swing.JTextField();
        jTextField_addressline3 = new javax.swing.JTextField();
        jTextField_phone = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_GSTIN = new javax.swing.JTextField();
        jButton_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPANY DETAILS");
        setIconImage((new ImageIcon("img.jpg")).getImage());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COMPANY NAME :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADDRESS :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LINE 1 :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("LINE 2 :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("LINE 3 :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PHONE : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("EMAIL :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("GSTIN :");

        jButton_save.setBackground(new java.awt.Color(0, 102, 255));
        jButton_save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_save.setForeground(new java.awt.Color(255, 255, 255));
        jButton_save.setText("SAVE");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_addressline1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_addressline2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_addressline3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_GSTIN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_addressline1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_addressline2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_addressline3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_GSTIN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        // TODO add your handling code here:
        generateJSONFile();
        JOptionPane.showMessageDialog(null,"COMPANY DETAILS UPDATED!");
        this.dispose();
    }//GEN-LAST:event_jButton_saveActionPerformed

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
            java.util.logging.Logger.getLogger(MANAGE_COMPANY_DETAILS_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANAGE_COMPANY_DETAILS_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANAGE_COMPANY_DETAILS_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGE_COMPANY_DETAILS_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANAGE_COMPANY_DETAILS_FORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_GSTIN;
    private javax.swing.JTextField jTextField_addressline1;
    private javax.swing.JTextField jTextField_addressline2;
    private javax.swing.JTextField jTextField_addressline3;
    private javax.swing.JTextField jTextField_companyName;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_phone;
    // End of variables declaration//GEN-END:variables

    
}
