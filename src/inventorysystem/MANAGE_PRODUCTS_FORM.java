/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import CLASS.Myfunc;
import CLASS.Product;
import CLASS.Product_detail;
import CLASS.TheModel;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aditya
 */
public class MANAGE_PRODUCTS_FORM extends javax.swing.JFrame {
    ArrayList<Product> pList;
    /**
     * Creates new form MANAGE_PRODUCTS_FORM
     */
    public MANAGE_PRODUCTS_FORM() {
        initComponents();
        try {
            pList = Myfunc.getProductList();
            Show_Products_In_JTable();
        } catch (Exception ex) {
            Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem Loading the Products List : " + ex.getMessage());
            this.dispose();
        }
    }

    private void Show_Products_In_JTable() throws Exception
    {
        DefaultTableModel model = (DefaultTableModel)jTable_products.getModel();
        // clear jtable content
        model.setRowCount(0);
        int noOfColumns = 7;        // number of columns in user table
        Object[] row = new Object[noOfColumns];
        for(int i = 0; i < pList.size(); i++)
        {
            row[0] = pList.get(i).getId();
            row[1] = pList.get(i).getName();
            row[2] = pList.get(i).getSubType();
           // System.out.println("ID => " + list.get(i).getCategoryID());
            String Category = pList.get(i).getCategoryID();
           // System.out.println("Name => " + Category);
            row[3] = Myfunc.getProductCategoryName(Category);
            row[4] = pList.get(i).getDescription();
            row[5] = pList.get(i).getAddDate();
            //row[6] = pList.get(i).getImage();
            model.addRow(row);
        }
    
    }
    
    /*
    private void Show_Products_In_JTable() throws Exception
    {
        String[] columnName = {"ID","Name","SubType","Category","Description","Add Date","Image"};
        Object[][] rows = new Object[pList.size()][7];
        for(int i = 0; i < pList.size(); i++){
            rows[i][0] = pList.get(i).getId();
            rows[i][1] = pList.get(i).getName();
            rows[i][2] = pList.get(i).getSubType();
            String Category = pList.get(i).getCategoryID();
           // System.out.println("Name => " + Category);
            rows[i][3] = Myfunc.getProductCategoryName(Category);
            rows[i][4] = pList.get(i).getDescription();
            rows[i][5] = pList.get(i).getAddDate();
            
            if(pList.get(i).getImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(pList.get(i).getImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][6] = image;
            }
            else{
                rows[i][6] = null;
            }
        }
        
        TheModel model = new TheModel(rows, columnName);
        jTable_products.setModel(model);
        jTable_products.setRowHeight(120);
        jTable_products.getColumnModel().getColumn(6).setPreferredWidth(150);
    }
    */
    
   /* private void Show_Products_In_JTable() throws Exception
    {
        DefaultTableModel model = (DefaultTableModel)jTable_products.getModel();
        // clear jtable content
        model.setRowCount(0);
        jTable_products.setRowHeight(120);
        jTable_products.getColumnModel().getColumn(6).setPreferredWidth(150);
        int noOfColumns = 7;        // number of columns in user table
        Object[] row = new Object[noOfColumns];
        for(int i = 0; i < pList.size(); i++)
        {
            row[0] = pList.get(i).getId();
            row[1] = pList.get(i).getName();
            row[2] = pList.get(i).getSubType();
           // System.out.println("ID => " + list.get(i).getCategoryID());
            String Category = pList.get(i).getCategoryID();
           // System.out.println("Name => " + Category);
            row[3] = Myfunc.getProductCategoryName(Category);
            row[4] = pList.get(i).getDescription();
            row[5] = pList.get(i).getAddDate();
            //row[6] = pList.get(i).getImage();
            if(pList.get(i).getImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(pList.get(i).getImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            row[6] = image;
            }
            else{
                row[6] = null;
            }
            
            model.addRow(row);
        }
        
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_products = new javax.swing.JTable();
        jTextField_search = new javax.swing.JTextField();
        jButton_search = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_addNewProduct = new javax.swing.JButton();
        jButton_editSelectedProduct = new javax.swing.JButton();
        jButton_removeSelectedProduct = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_product_detail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTS");
        setIconImage((new ImageIcon("img.jpg")).getImage());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "SubType", "Category", "Description", "AddDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_products.getTableHeader().setReorderingAllowed(false);
        jTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_products);

        jButton_search.setText("Search");
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jButton_refresh.setText("Refresh");
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        jButton_addNewProduct.setBackground(new java.awt.Color(0, 153, 102));
        jButton_addNewProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_addNewProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addNewProduct.setText("Add New Product");
        jButton_addNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addNewProductActionPerformed(evt);
            }
        });

        jButton_editSelectedProduct.setBackground(new java.awt.Color(0, 153, 204));
        jButton_editSelectedProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_editSelectedProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButton_editSelectedProduct.setText("Edit Selected Product");
        jButton_editSelectedProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editSelectedProductActionPerformed(evt);
            }
        });

        jButton_removeSelectedProduct.setBackground(new java.awt.Color(255, 0, 51));
        jButton_removeSelectedProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_removeSelectedProduct.setForeground(new java.awt.Color(255, 255, 255));
        jButton_removeSelectedProduct.setText("Remove Selected Product");
        jButton_removeSelectedProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeSelectedProductActionPerformed(evt);
            }
        });

        jTable_product_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unit Size", "Unit Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_product_detail.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_product_detail);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_editSelectedProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_removeSelectedProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jButton_addNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton_search, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_addNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_editSelectedProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_removeSelectedProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    
    private void Show_Product_Detail_in_JTable(Product product) throws SQLException, Exception
    {
        ArrayList<Product_detail> productList = Myfunc.getProductDetailList(product);
        DefaultTableModel model = (DefaultTableModel)jTable_product_detail.getModel();
        // clear jtable content
        model.setRowCount(0);
        int noOfColumns = 3;        // number of columns in user table
        Object[] row = new Object[noOfColumns];
       
        String unit = Myfunc.getUnitCategoryName(product.getUnitCategoryID());
        
        for(int i = 0; i < productList.size(); i++)
        {
            row[0] = productList.get(i).getUnitSize() + "  " + unit; // TODO add the units(kg,lt,etc) here
            row[1] = productList.get(i).getUnitPrice();
            row[2] = productList.get(i).getQuantity();
      
            model.addRow(row);
        }
    }
    
    private void jTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productsMouseClicked
        // TODO add your handling code here:
         int index = jTable_products.getSelectedRow();
         //ArrayList<Product> pList = Myfunc.getProductList();
         Product product = pList.get(index);
        try {
            Show_Product_Detail_in_JTable(product);
        } catch (Exception ex) {
            Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem loading the details of this Product : " + ex.getMessage());
            DefaultTableModel model = (DefaultTableModel)jTable_product_detail.getModel();
            // clear jtable content
            model.setRowCount(0);
        }

    }//GEN-LAST:event_jTable_productsMouseClicked

    private void jButton_addNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addNewProductActionPerformed

        Add_Product_Form pf = new Add_Product_Form();
        pf.setVisible(true);
        pf.pack();
        pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pf.setLocationRelativeTo(null);
        pf.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton_addNewProductActionPerformed

    private void jButton_editSelectedProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editSelectedProductActionPerformed
        int index = jTable_products.getSelectedRow();
        if(index >= 0)
        {
            Product product = pList.get(index);
            Edit_Product_Form pf = new Edit_Product_Form(product);
            pf.setVisible(true);
            pf.pack();
            pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pf.setLocationRelativeTo(null);
            pf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_jButton_editSelectedProductActionPerformed

    
    
    private void jButton_removeSelectedProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeSelectedProductActionPerformed
        // TODO add your handling code here:
        int index = jTable_product_detail.getSelectedRow();
        int indexPro = jTable_products.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable_products.getModel();
        String productID = model.getValueAt(indexPro, 0).toString();
        
        if(index < 0)
        {
            if(indexPro < 0)    return;
            int i = JOptionPane.showConfirmDialog(null, "DELETING the PRODUCT " + productID + "! ALL DETAILS WILL BE DELETED!  ARE YOU SURE??", "WARNING",JOptionPane.YES_NO_OPTION );
            if(i != 0) return;      //NO
            Connection con = null ,con1 = null;
            Savepoint savepoint = null;
            
            try
            {
                con = My_CNX.getConnection();
                con.setAutoCommit(false);
                savepoint = con.setSavepoint("savepoint1");
                con1 = Myfunc.deleteProduct_by_ProductID(productID, false);
                con1.commit();
                con1.close();
                con.commit();
                con.close();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"DELETING SELECTED PRODUCT FAILED : " + ex.getMessage());
                try {
                    if(con != null) {
                        con.rollback(savepoint);
                    }
                } catch (SQLException ex1) {
                    Logger.getLogger(MANAGE_ORDERS_FORM.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally
            {
                try { if(con1 != null)  con1.close(); } catch(SQLException e){}
                try { if(con != null)  con.close(); } catch(SQLException e){}
                try {
                    pList = Myfunc.getProductList();
                    Show_Products_In_JTable();
                } catch (Exception ex) {
                    Logger.getLogger(MANAGE_CUSTOMERS_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "PRODUCT List could Not Be Refreshed : " + ex.getMessage());
                }
            }
            return;
        }
            int i = JOptionPane.showConfirmDialog(null, "DELETING the PRODUCT UNIT! ARE YOU SURE", "WARNING",JOptionPane.YES_NO_OPTION );
            if(i != 0) return;      //NO
            Connection con = null ,con1 = null;
            Savepoint savepoint = null;
            ArrayList<Product_detail> pdList = null;
            Product_detail product_detail = null;
            try
            {
                pdList = Myfunc.getProductDetailList_by_ProductID(productID);
                product_detail = pdList.get(index);
                con = My_CNX.getConnection();
                con.setAutoCommit(false);
                savepoint = con.setSavepoint("savepoint1");
                con1 = Myfunc.deleteProductDetail_by_ProductDetailID(product_detail.getId(), false);
                con1.commit();
                con1.close();
                con.commit();
                con.close();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"DELETING SELECTED PRODUCT DETAIL FAILED : " + ex.getMessage());
                try {
                    if(con != null) {
                        con.rollback(savepoint);
                    }
                } catch (SQLException ex1) {
                    Logger.getLogger(MANAGE_ORDERS_FORM.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally
            {
                try { if(con1 != null)  con1.close(); } catch(SQLException e){}
                try { if(con != null)  con.close(); } catch(SQLException e){}
                try {
                    Show_Product_Detail_in_JTable(Myfunc.getProduct(productID,false));
                } catch (Exception ex) {
                    Logger.getLogger(MANAGE_CUSTOMERS_FORM.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "PRODUCT DETAIL List could Not Be Refreshed : " + ex.getMessage());
                }
            }    
    }//GEN-LAST:event_jButton_removeSelectedProductActionPerformed

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        jTextField_search.setText("");
        try {
            pList = Myfunc.getProductList();
            Show_Products_In_JTable();
        } catch (Exception ex) {
            Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "PRODUCT List could Not Be Refreshed : " + ex.getMessage());

        }
        DefaultTableModel model = (DefaultTableModel)jTable_product_detail.getModel();
        // clear jtable content
        model.setRowCount(0);
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        // TODO add your handling code here:
        String search = jTextField_search.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel)jTable_products.getModel();
        //TheModel model = (TheModel)jTable_products.getModel();
        DefaultTableModel pdModel = (DefaultTableModel)jTable_product_detail.getModel();
        try {
            pList = Myfunc.getProductListWithString(search);
            pdModel.setRowCount(0);
            model.setRowCount(0);
            if(pList.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"NO PRODUCT FOUND!");
            }
            else
            {
                Show_Products_In_JTable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"SEARCH NOT SUCCESSFUL :-<");
            pdModel.setRowCount(0);
            model.setRowCount(0);
        } catch (Exception ex) {
            Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"The List Could NOT BE Refreshed!");
        }
    }//GEN-LAST:event_jButton_searchActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGE_PRODUCTS_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MANAGE_PRODUCTS_FORM().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addNewProduct;
    private javax.swing.JButton jButton_editSelectedProduct;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_removeSelectedProduct;
    private javax.swing.JButton jButton_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_product_detail;
    private javax.swing.JTable jTable_products;
    private javax.swing.JTextField jTextField_search;
    // End of variables declaration//GEN-END:variables
}
