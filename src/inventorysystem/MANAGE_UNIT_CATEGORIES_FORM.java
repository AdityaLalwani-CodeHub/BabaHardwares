/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import CLASS.IDGenerator;
import CLASS.Myfunc;
import CLASS.Unit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aditya
 */
public class MANAGE_UNIT_CATEGORIES_FORM extends javax.swing.JFrame {
    ArrayList<Unit> list;
    /**
     * Creates new form MANAGE_UNIT_CATEGORIES_FORM
     */
    public MANAGE_UNIT_CATEGORIES_FORM() {
        initComponents();
        try {
            list = Myfunc.getUnitCategoryList();
        } catch (SQLException ex) {
            Logger.getLogger(MANAGE_UNIT_CATEGORIES_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Unable to Load UNIT categories in the table : " + ex.getMessage());
            this.dispose();
        }
        Show_Unit_Category_in_JTable();
    }
    
    private void Show_Unit_Category_in_JTable() {
        DefaultTableModel model = (DefaultTableModel)jTable_unit.getModel();
        // clear jtable content
        model.setRowCount(0);
        int noOfColumns = 2;        // number of columns in user table
        Object[] row = new Object[noOfColumns];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            model.addRow(row);
        }
    }
    
    // Check Input Fields
    public boolean checkInputs()
    {
        if(
              jTextField_name.getText().equals("")
                || jTextField_name.getText().equals("")
          ){
            return false;
        }
        else{
            try{
                //Float.parseFloat(txt_price.getText());
                // TODO check phone number and email
                return true;
            }catch(Exception ex)
            {
                return false;
            }
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
        jLabel_id = new javax.swing.JLabel();
        jLabel_id1 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_id = new javax.swing.JTextField();
        jButton_next = new javax.swing.JButton();
        jButton_previous = new javax.swing.JButton();
        jButton_insertNewCategory = new javax.swing.JButton();
        jButton_updateSelectedCategory = new javax.swing.JButton();
        jButton_deleteSelectedCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_unit = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MEASURING UNITS");
        setIconImage((new ImageIcon("img.jpg")).getImage());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_id.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id.setText("Name :");

        jLabel_id1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_id1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id1.setText("ID :");

        jTextField_id.setEditable(false);

        jButton_next.setText("Next");
        jButton_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nextActionPerformed(evt);
            }
        });

        jButton_previous.setText("Previous");
        jButton_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_previousActionPerformed(evt);
            }
        });

        jButton_insertNewCategory.setBackground(new java.awt.Color(0, 153, 0));
        jButton_insertNewCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_insertNewCategory.setForeground(new java.awt.Color(255, 255, 255));
        jButton_insertNewCategory.setText("Insert New Category");
        jButton_insertNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertNewCategoryActionPerformed(evt);
            }
        });

        jButton_updateSelectedCategory.setBackground(new java.awt.Color(0, 153, 204));
        jButton_updateSelectedCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_updateSelectedCategory.setForeground(new java.awt.Color(255, 255, 255));
        jButton_updateSelectedCategory.setText("Update Selected Category");
        jButton_updateSelectedCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateSelectedCategoryActionPerformed(evt);
            }
        });

        jButton_deleteSelectedCategory.setBackground(new java.awt.Color(255, 0, 102));
        jButton_deleteSelectedCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_deleteSelectedCategory.setForeground(new java.awt.Color(255, 255, 255));
        jButton_deleteSelectedCategory.setText("Delete Selected Category");
        jButton_deleteSelectedCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteSelectedCategoryActionPerformed(evt);
            }
        });

        jTable_unit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_unit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_unitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_unit);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton_insertNewCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton_next, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel_id)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton_updateSelectedCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_deleteSelectedCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_id))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_next)
                            .addComponent(jButton_previous))
                        .addGap(50, 50, 50)
                        .addComponent(jButton_insertNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_updateSelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_deleteSelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nextActionPerformed
        // TODO add your handling code here:
        int index = jTable_unit.getSelectedRow();
        //System.out.println(index);
        if(index >= 0 && index < (jTable_unit.getRowCount()-1))
        {
            index++;
            jTable_unit.setRowSelectionInterval(index, index);
            Unit category = list.get(index);

            jTextField_id.setText(category.getId());
            jTextField_name.setText(category.getName());
        }
    }//GEN-LAST:event_jButton_nextActionPerformed

    private void jButton_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_previousActionPerformed
        // TODO add your handling code here:
        int index = jTable_unit.getSelectedRow();
        System.out.println(index);
        if(index > 0 && index < jTable_unit.getRowCount())
        {
            index--;
            jTable_unit.setRowSelectionInterval(index, index);
            Unit category = list.get(index);

            jTextField_id.setText(category.getId());
            jTextField_name.setText(category.getName());
        }
    }//GEN-LAST:event_jButton_previousActionPerformed

    private void jButton_insertNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertNewCategoryActionPerformed
        // TODO add your handling code here:
        if(checkInputs())
        {
            Connection con = null;
            PreparedStatement ps = null;
            Savepoint savepoint1 = null;
            
            try {
                con = My_CNX.getConnection();
                //System.out.println("database connected");
                con.setAutoCommit(false);
                //set a Savepoint
                savepoint1 = con.setSavepoint("Savepoint1");
                
                ps = con.prepareStatement("INSERT INTO unit_category(id,Name)"
                    + "values(?,?) ");
                ps.setString(1, IDGenerator.getIDforUnitCategory());
                ps.setString(2, jTextField_name.getText());

                ps.executeUpdate();
                ps.close();
                con.commit();
                con.close();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"ADDING UNIT CATEGORY FAILED : " + ex.getMessage());
                try {
                    if(con != null) {
                        con.rollback(savepoint1);
                    }
                } catch (SQLException ex1) {
                    Logger.getLogger(MANAGE_ORDERS_FORM.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally
            {
                try { if(ps != null)  ps.close(); } catch(SQLException e){}
                try { if(con != null)  con.close(); } catch(SQLException e){}
                try {
                    list = Myfunc.getUnitCategoryList();
                    Show_Unit_Category_in_JTable();
                } catch (SQLException ex) {
                    Logger.getLogger(MANAGE_CUSTOMERS_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "UNIT Category List could Not Be Refreshed : " + ex.getMessage());
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_jButton_insertNewCategoryActionPerformed

    private void jButton_updateSelectedCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateSelectedCategoryActionPerformed
        // TODO add your handling code here:
        if(checkInputs())
        {
            int i = JOptionPane.showConfirmDialog(null, "UPDATING the UNIT! ARE YOU SURE??", "WARNING",JOptionPane.YES_NO_OPTION );
            if(i != 0) return;      //NO
            Connection con = null;
            PreparedStatement ps = null;
            Savepoint savepoint1 = null;
            
            try {
                con = My_CNX.getConnection();
                //System.out.println("database connected");
                //System.out.println("database connected");
                 con.setAutoCommit(false);
                //set a Savepoint
                savepoint1 = con.setSavepoint("Savepoint1");
                ps = con.prepareStatement("UPDATE unit_category SET Name = ? "
                    + " WHERE id = ?");
                ps.setString(1, jTextField_name.getText());
                ps.setString(2, jTextField_id.getText());
                ps.executeUpdate();
                ps.close();
                con.commit();
                con.close();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"UPDATING UNIT CATEGORY FAILED : " + ex.getMessage());
                try {
                    if(con != null) {
                        con.rollback(savepoint1);
                    }
                } catch (SQLException ex1) {
                    Logger.getLogger(MANAGE_ORDERS_FORM.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally
            {
                try { if(ps != null)  ps.close(); } catch(SQLException e){}
                try { if(con != null)  con.close(); } catch(SQLException e){}
                try {
                    list = Myfunc.getUnitCategoryList();
                    Show_Unit_Category_in_JTable();
                } catch (SQLException ex) {
                    Logger.getLogger(MANAGE_CUSTOMERS_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "UNIT Category List could Not Be Refreshed : " + ex.getMessage());
                    this.dispose();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "One Or More Field Are Empty");
        }
    }//GEN-LAST:event_jButton_updateSelectedCategoryActionPerformed

    private void jButton_deleteSelectedCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteSelectedCategoryActionPerformed
        // TODO add your handling code here:
        if(!jTextField_id.getText().equals(""))
        {
            int i = JOptionPane.showConfirmDialog(null, "DELETING the UNIT! ARE YOU SURE??", "WARNING",JOptionPane.YES_NO_OPTION );
            if(i != 0) return;      //NO
            Connection con = null;
            PreparedStatement ps = null;
            Savepoint savepoint1 = null;
            try {
                con = My_CNX.getConnection();
                con.setAutoCommit(false);
                //set a Savepoint
                savepoint1 = con.setSavepoint("Savepoint1");
                
                ps = con.prepareStatement("DELETE FROM unit_category WHERE id = ?");
                String id = jTextField_id.getText();
                ps.setString(1, id);
                ps.executeUpdate();
                ps.executeUpdate();
                ps.close();
                con.commit();
                con.close();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"DELETING UNIT CATEGORY FAILED : " + ex.getMessage());
                try {
                    if(con != null) {
                        con.rollback(savepoint1);
                    }
                } catch (SQLException ex1) {
                    Logger.getLogger(MANAGE_ORDERS_FORM.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally
            {
                try { if(ps != null)  ps.close(); } catch(SQLException e){}
                try { if(con != null)  con.close(); } catch(SQLException e){}
                try {
                    list = Myfunc.getUnitCategoryList();
                    Show_Unit_Category_in_JTable();
                } catch (SQLException ex) {
                    Logger.getLogger(MANAGE_CUSTOMERS_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "UNIT Category List could Not Be Refreshed : " + ex.getMessage());
                    this.dispose();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "UNIT Not Deleted : No Id To Delete");
        }
    }//GEN-LAST:event_jButton_deleteSelectedCategoryActionPerformed

    private void jTable_unitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_unitMouseClicked
        // TODO add your handling code here:
        int index = jTable_unit.getSelectedRow();
        Unit category = list.get(index);

        jTextField_id.setText(category.getId());
        jTextField_name.setText(category.getName());
    }//GEN-LAST:event_jTable_unitMouseClicked

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
            java.util.logging.Logger.getLogger(MANAGE_UNIT_CATEGORIES_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANAGE_UNIT_CATEGORIES_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANAGE_UNIT_CATEGORIES_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGE_UNIT_CATEGORIES_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANAGE_UNIT_CATEGORIES_FORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_deleteSelectedCategory;
    private javax.swing.JButton jButton_insertNewCategory;
    private javax.swing.JButton jButton_next;
    private javax.swing.JButton jButton_previous;
    private javax.swing.JButton jButton_updateSelectedCategory;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JLabel jLabel_id1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_unit;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
