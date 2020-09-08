/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import inventorysystem.My_CNX;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditya
 */
public class Myfunc {
    
    public static String getUnitCategoryID(String unitName) throws Exception
    {
        if(unitName.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM unit_category WHERE Name = \'" + unitName + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            //System.out.println("here1");
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
           // System.out.println("here2");
            if(rs.next())
            {
                str = rs.getString("id");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Unit Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }

        return str;
    }
    
    public static String getProductCategoryID(String categoryName) throws Exception
    {
         if(categoryName.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM product_category WHERE Name = \'" + categoryName + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            con = My_CNX.getConnection();
            //System.out.println("here1");
            st = con.createStatement();
            rs = st.executeQuery(query);
           // System.out.println("here2");
           
            if(rs.next())
            {
                str = rs.getString("id");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Product Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }    
        return str;
    }
    
    public static String getProductCategoryName(String categoryID) throws Exception
    {
        if(categoryID.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM product_category WHERE id = \'" + categoryID + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            con = My_CNX.getConnection();
            //System.out.println("here1");
            st = con.createStatement();
            rs = st.executeQuery(query);
           // System.out.println("here2");
            
            if(rs.next())
            {
                str = rs.getString("Name");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Product Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }        
        return str;
    }
    
    public static String getCustomerCategoryName(String categoryID) throws Exception
    {
        if(categoryID.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM customer_category WHERE id = \'" + categoryID + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            con = My_CNX.getConnection();
            //System.out.println("here1");
            st = con.createStatement();
            rs = st.executeQuery(query);
           // System.out.println("here2");
            
            if(rs.next())
            {
                str = rs.getString("Name");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Customer Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }          
        return str;
    }
    
    public static String getUnitCategoryName(String unitID) throws Exception
    {
        if(unitID.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM unit_category WHERE id = \'" + unitID + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            con = My_CNX.getConnection();
            //System.out.println("here1");
            st = con.createStatement();
            rs = st.executeQuery(query);
           // System.out.println("here2");
            
            if(rs.next())
            {
                str = rs.getString("Name");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Unit Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }     
        return str;
    }
    
    public static ArrayList<Product> getProductList() throws SQLException
    {
            ArrayList<Product> productList  = null;
            Connection con = null;
            String query = "SELECT * FROM product_table";
            
            Statement st = null;
            ResultSet rs = null;
            
        try {
            productList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            Product product;
            while(rs.next())
            {
                product = new Product(rs.getString("id"),rs.getString("Name"),rs.getString("SubType"),rs.getString("CategoryID"),rs.getString("Description"),rs.getDate("AddDate"),rs.getString("UnitCategoryID"),rs.getBytes("picture"));
                productList.add(product);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return productList; 
                
    }
    
    public static ArrayList<Customer> getCustomerList() throws SQLException
    {
        ArrayList<Customer> customerList  = null;
        Connection con = null;
        String query = "SELECT * FROM customer_table";

        Statement st = null;
        ResultSet rs = null;
        
            
        try {
            customerList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Customer customer;
            
            while(rs.next())
            {
                customer = new Customer(rs.getString("id"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Phone"),rs.getString("Email"),Integer.parseInt(rs.getString("OrderCount")),Float.parseFloat(rs.getString("TotalOrderAmount")),rs.getDate("LastOrderDate"),Float.parseFloat(rs.getString("Balance")),rs.getDate("AddDate"),rs.getString("CustomerCategoryID"),rs.getDate("LastSecondOrderDate"),rs.getString("GSTIN"));
                customerList.add(customer);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return customerList; 
                
    }
    
    public static ArrayList<Product_detail> getProductDetailList(Product product) throws SQLException
    {
        if(product.getId().toLowerCase().equals("n/a")) return null;
        ArrayList<Product_detail> productList  = null;
        Connection con = null;
        String query = "SELECT * FROM product_detail WHERE ProductID = \'" + product.getId() + "\'";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            productList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product_detail detail;
            
            while(rs.next())
            {
                detail = new Product_detail(rs.getString("id"),rs.getString("ProductID"),Float.parseFloat(rs.getString("UnitSize")),Float.parseFloat(rs.getString("UnitPrice")),Float.parseFloat(rs.getString("Quantity")),Float.parseFloat(rs.getString("CostPrice")));
                productList.add(detail);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return productList; 
    }
    
    public static Product getProduct(String productID,boolean generateIfNotFound) throws Exception
    {
        if(productID.toLowerCase().equals("n/a"))
        {
            return new Product(productID,"N/A","","N/A","N/A",getCurrentDate(),"N/A",null);
        }
        Connection con = null;
        String query = "SELECT * FROM product_table WHERE id = \'" + productID + "\'";

        Statement st = null;
        ResultSet rs = null;
        Product product = null;    
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            
            if(rs.next())
            {
                product = new Product(rs.getString("id"),rs.getString("Name"),rs.getString("SubType"),rs.getString("CategoryID"),rs.getString("Description"),rs.getDate("AddDate"),rs.getString("UnitCategoryID"),rs.getBytes("picture"));
            }
            else
            {
                if(generateIfNotFound == true)
                {
                    product = new Product(productID,"N/A","","N/A","N/A",getCurrentDate(),"N/A",null);
                }
                else
                throw new Exception("Product ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    int i = JOptionPane.showConfirmDialog(null,"This Product is NOT available.Do you still want to CONTINUE?\n(Recommended : YES, ONLY FOR RECEIPT GENERATION)", "ALERT! PRODUCT NOT FOUND", JOptionPane.YES_NO_OPTION);
            if(i == 0)
            {
                product = new Product(productID,"N/A","","N/A","N/A",getCurrentDate(),"N/A",null);
            }
            else*/
                throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        } 
        return product;
    }
    
    public static Category getProductCategory(String categoryID,boolean generateIfNotFound) throws Exception
    {
        if(categoryID.toLowerCase().equals("n/a"))
        {
            return new Category("N/A","N/A"); 
        }
        Connection con = null;
        String query = "SELECT * FROM product_category WHERE id = \'" + categoryID + "\'";

        Statement st = null;
        ResultSet rs = null;
        Category category = null;
        
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next())
            {
                category = new Category(rs.getString("id"),rs.getString("Name")); 
            }
            else
            {
                if(generateIfNotFound == true)
                {
                    return new Category("N/A","N/A"); 
                }
                else
                throw new Exception("Product Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return category;
    }
    
    public static String[] getAllProductCategoryNames() throws SQLException
    {
        Connection con = null;
        String query = "SELECT * FROM product_category";
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<String> categoryList = new ArrayList<>();
        
        try {
            categoryList = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                categoryList.add(rs.getString("Name"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            categoryList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        if(categoryList == null)    return null;
        String[] list =  new String[categoryList.size()];
        int i = 0;
        for(String str : categoryList)
        {
            list[i++] = str;
        }
        return list; 
    }
    
    public static String[] getAllCustomerCategoryNames() throws SQLException
    {
        Connection con = null;
        String query = "SELECT * FROM customer_category";
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<String> categoryList = null;
        
        try {
            categoryList = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                categoryList.add(rs.getString("Name"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            categoryList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }        
        if(categoryList == null)    return null;
        String[] list =  new String[categoryList.size()];
        int i = 0;
        for(String str : categoryList)
        {
            list[i++] = str;
        }
        return list; 
    }
    
    public static String[] getAllTransactionModes() throws SQLException
    {
        Connection con = null;
        String query = "SELECT * FROM transaction_modes";
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<String> categoryList = null;
        
        try {
            categoryList = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                categoryList.add(rs.getString("Name"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            categoryList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        if(categoryList == null)    return null;
        String[] list =  new String[categoryList.size()];
        int i = 0;
        for(String str : categoryList)
        {
            list[i++] = str;
        }
        return list; 
    }
    
    public static String[] getAllUnits() throws SQLException
    {
        Connection con = null;
        String query = "SELECT * FROM unit_category";
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<String> categoryList = null;
        
        try {
            categoryList = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                categoryList.add(rs.getString("Name"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            categoryList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        if(categoryList == null)    return null;
        String[] list =  new String[categoryList.size()];
        int i = 0;
        for(String str : categoryList)
        {
            list[i++] = str;
        }
        return list; 
    }
    
    /*
    public static Connection deleteProductDetail_by_ProductID(String ProductID, boolean autoCommit) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
         try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("DELETE FROM product_detail WHERE ProductID = \'" + ProductID + "\'");
                ps.executeUpdate();
                /*
                    NO NEED FOR if(autoCommit == true)      con.commit();
                    bcoz if it's autocommit..then it will commit automatically
                    and if autoCommit is false..then caller function would handle it..
                */
        /*        ps.close();
                if(autoCommit == true)
                {
                    //System.out.println("autoCommit is true");
                    con.close();
                }
        /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
    /*        } catch (SQLException ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }*/
    
    public static Connection deleteProductDetail_by_ProductDetailID(String ProductDetailID, boolean autoCommit) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
         try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("DELETE FROM product_detail WHERE id = \'" + ProductDetailID + "\'");
                ps.executeUpdate();
                
                ps.close();
                if(autoCommit == true)
                {
                    //System.out.println("autoCommit is true");
                    con.close();
                }
                /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
            } catch (SQLException ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }
    
    public static Product_detail getProductDetail_by_ProductDetailID(String ProductDetailID,boolean generateIfNotFound) throws SQLException
    {
        //System.out.println("myfunc : " + ProductDetailID);
        if(ProductDetailID.toLowerCase().equals("n/a"))
        {
            return new Product_detail(ProductDetailID,"N/A",0,0,0,0);
        }
        Connection con = null;
        Product_detail pd = null;
        String query = "SELECT * FROM product_detail WHERE id = \'" + ProductDetailID + "\'";
        Statement st = null;
        ResultSet rs = null;
        
         try {
                con = My_CNX.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next())
                {
                    pd = new Product_detail(rs.getString("id"),rs.getString("ProductID"),Float.parseFloat(rs.getString("UnitSize")),Float.parseFloat(rs.getString("UnitPrice")),Float.parseFloat(rs.getString("Quantity")),Float.parseFloat(rs.getString("CostPrice")));
                }
                else
                {
                    /*int i = JOptionPane.showConfirmDialog(null,"This Product Unit is NOT available.Do you still want to CONTINUE?\n(Recommended : YES, ONLY FOR RECEIPT GENERATION)", "ALERT! PRODUCT UNIT NOT FOUND", JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        pd = new Product_detail(ProductDetailID,"N/A",0,0,0,0);
                    }*/
                    if(generateIfNotFound == true)
                    {
                        pd = new Product_detail(ProductDetailID,"N/A",0,0,0,0);
                    }
                }
                rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
         return pd;
    }
    
    public static Date getCurrentDate()
    {
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
    
    public static Time getCurrentTime()
    {
        long millis=System.currentTimeMillis();  
        java.sql.Time time = new java.sql.Time(millis);
        return time;
    }

    public static ArrayList<Category> getProductCategoryList() throws SQLException {
        ArrayList<Category> catList  = null;
        Connection con = null;
        String query = "SELECT * FROM product_category";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            catList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Category category;
            
            while(rs.next())
            {
                category = new Category(rs.getString("id"),rs.getString("Name"));
                catList.add(category);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            catList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return catList; 
    }

    public static ArrayList<Unit> getUnitCategoryList() throws SQLException {
        
        ArrayList<Unit> catList  = null;
        Connection con = null;
        String query = "SELECT * FROM unit_category";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            
            catList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Unit category;
            
            while(rs.next())
            {
                category = new Unit(rs.getString("id"),rs.getString("Name"));
                catList.add(category);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            catList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return catList; 
    }

    public static ArrayList<CustomerCategory> getCustomerCategoryList() throws SQLException {
        ArrayList<CustomerCategory> catList  = null;
        Connection con = null;
        String query = "SELECT * FROM customer_category";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            catList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            CustomerCategory category;
            
            while(rs.next())
            {
                category = new CustomerCategory(rs.getString("id"),rs.getString("Name"));
                catList.add(category);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            catList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return catList; 
    }

    public static String getCustomerCategoryID(String categoryName) throws Exception {
        if(categoryName.toLowerCase().equals("n/a"))  return "N/A";
        Connection con = null;
        String query = "SELECT * FROM customer_category WHERE Name = \'" + categoryName + "\'";
        
        Statement st = null;
        ResultSet rs = null;
        String str = null;
        
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next())
                str = rs.getString("id");
            else
            {
                throw new Exception("Customer Category ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }        
        return str;
    }
    
    
    public static ArrayList<Product> getProductsInCategory_by_CategoryID(String categoryID) throws SQLException
    {
        ArrayList<Product> productList  = null;
        Connection con = null;
        String query = "SELECT * FROM product_table WHERE CategoryID = \'" + categoryID + "\'";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            productList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while(rs.next())
            {
                product = new Product(rs.getString("id"),rs.getString("Name"),rs.getString("SubType"),rs.getString("CategoryID"),rs.getString("Description"),rs.getDate("AddDate"),rs.getString("UnitCategoryID"),rs.getBytes("picture"));
                productList.add(product);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            productList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return productList; 
    }
    
    public static ArrayList<Product> getProductsInCategory_by_CategoryName(String categoryName) throws Exception
    {
        return getProductsInCategory_by_CategoryID(getProductCategoryID(categoryName));
    }

    public static Connection UpdateQuantityInDatabase(String ProductDetailID, float PurchasedQty, boolean autoCommit) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("UPDATE product_detail SET Quantity = ? "
                + " WHERE id = ?" );
                float AvailableQty = getQuantityInDatabase(ProductDetailID);
                ps.setFloat(1, AvailableQty - PurchasedQty);
                ps.setString(2, ProductDetailID);
                ps.executeUpdate();
                
                ps.close();
                /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
            } catch (Exception ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }

    public static float getQuantityInDatabase(String ProductDetailID) throws Exception {
        Connection con = null;
        String query = "SELECT * FROM product_detail WHERE id = \'" + ProductDetailID + "\'";

        Statement st = null;
        ResultSet rs = null;
        float qty = 0;
        
        try {
            con = My_CNX.getConnection();
             st = con.createStatement();
             rs = st.executeQuery(query);

             if(rs.next())
             {
                 qty = rs.getFloat("Quantity");
                // JOptionPane.showMessageDialog(null,"Myfunc : getQuantityInDatabase : SUCCESSFUL");
             }
             else
            {
                
                //throw new Exception("Product Detail ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null,"Myfunc : getQuantityInDatabase : " + ex.getMessage());
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return qty;
    }

    public static ArrayList<Order> getOrderList() throws SQLException {
        ArrayList<Order> orderList  = null;
        Connection con = null;
        String query = "SELECT * FROM order_table";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            orderList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while(rs.next())
            {
                order = new Order(rs.getString("id"),rs.getString("CustomerID"),rs.getDate("OrderDate"),rs.getFloat("OrderAmount"),rs.getFloat("OverallDiscountPrice"),rs.getFloat("OverallTax"),rs.getFloat("Balance"));
                orderList.add(order);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            orderList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return orderList; 
    }

    public static Customer getCustomerByID(String customerID,boolean generateIfNotFound) throws Exception {
        if(customerID.toLowerCase().equals("general"))
        {
            return new Customer("GENERAL","GENERAL","","###",null,0,0,null,0,getCurrentDate(),"N/A",null,null);
        }
        Connection con = null;
        String query = "SELECT * FROM customer_table WHERE id = \'" + customerID + "\'";

        Statement st = null;
        ResultSet rs = null;
        Customer customer = null;    
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next())
            {
                customer = new Customer(rs.getString("id"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Phone"),rs.getString("Email"),Integer.parseInt(rs.getString("OrderCount")),Float.parseFloat(rs.getString("TotalOrderAmount")),rs.getDate("LastOrderDate"),Float.parseFloat(rs.getString("Balance")),rs.getDate("AddDate"),rs.getString("CustomerCategoryID"),rs.getDate("LastSecondOrderDate"),rs.getString("GSTIN"));
            }
            else
            {
                if(generateIfNotFound == true)
                {
                    customer = new Customer("GENERAL","GENERAL","","###",null,0,0,null,0,getCurrentDate(),"N/A",null,null);
                }
                else
                throw new Exception("Customer ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    int i = JOptionPane.showConfirmDialog(null,"Do you want the customer to be considered as \"GENERAL\" ","CUSTOMER NOT FOUND", JOptionPane.YES_NO_OPTION);
            if(i == 0)
            {
                customer = new Customer("GENERAL","GENERAL","","###",null,0,0,null,0,getCurrentDate(),"N/A",null,null);
            }
            else*/
                throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return customer;
    }

    public static Order getOrderByID(String OrderID) throws Exception {
        Connection con = null;
        String query = "SELECT * FROM order_table WHERE id = \'" + OrderID + "\'";

        Statement st = null;
        ResultSet rs = null;
        Order order = null;    
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next())
            {
                order = new Order(rs.getString("id"),rs.getString("CustomerID"),rs.getDate("OrderDate"),rs.getFloat("OrderAmount"),rs.getFloat("OverallDiscountPrice"),rs.getFloat("OverallTax"),rs.getFloat("Balance"));
            }
            else
            {
            /*    rs.close();
                st.close();
                con.close();*/
                throw new Exception("Order ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return order;
    }

    public static ArrayList<Order_detail> getOrderDetailList_by_OrderID(String OrderID) throws SQLException {
        ArrayList<Order_detail> odList  = null;
        Connection con = null;
        String query = "SELECT * FROM order_detail WHERE OrderID = \'" + OrderID + "\'";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            odList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order_detail od;
            
            while(rs.next())
            {
                od = new Order_detail(rs.getString("id"),rs.getString("OrderID"),rs.getString("ProductDetailID"),rs.getFloat("UnitPrice"),rs.getFloat("PurchasedQty"),rs.getFloat("ProductDiscountPrice"),rs.getFloat("ProductTax"));
                odList.add(od);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            odList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return odList; 
    }

    public static Product getProduct_by_ProductDetailID(String productDetailID,boolean generateIfNotFound) throws Exception {
        if(productDetailID.toLowerCase().equals("n/a"))
        {
           return new Product("N/A","N/A","","N/A","N/A",getCurrentDate(),"N/A",null);
        }
        Connection con = null;
        Product pd = null;
        String query = "SELECT * FROM product_detail WHERE id = \'" + productDetailID + "\'";
        Statement st = null;
        ResultSet rs = null;
        
         try {
                con = My_CNX.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next())
                {
                    pd = getProduct(rs.getString("productID"),generateIfNotFound);
                }
                else
            {
                if(generateIfNotFound == true)
                {
                    pd = new Product("N/A","N/A","","N/A","N/A",getCurrentDate(),"N/A",null);
                }
                else
                throw new Exception("Product ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
         return pd;
    }

    public static Connection addOrderForCustomer(String customerID, float total,float orderBalance, Date date,boolean autoCommit) throws Exception {
        Customer customer = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
                customer = getCustomerByID(customerID,false);
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("UPDATE customer_table SET Balance = ? "
                + " , OrderCount = ? , TotalOrderAmount = ? , LastOrderDate = ? , LastSecondOrderDate = ?"
                + " WHERE id = ?" );
                ps.setFloat(1, customer.getBalance() + orderBalance);
                ps.setInt(2, customer.getOrderCount() + 1);
                ps.setFloat(3, customer.getTotalOrderAmount() + total);
                ps.setDate(4, date);
                ps.setDate(5, customer.getAddDate());   // old date as second order
                ps.setString(6, customerID);
                ps.executeUpdate();
                
                //con.commit();
                ps.close();
                if(autoCommit == true)
                    con.close();    // ye bhi commit kar hi dega..kya kar lenge!
                /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
            } catch (SQLException ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }

    public static Connection addQuantityInDatabase(String productDetailID, float purchasedQty, boolean autoCommit) throws Exception {
        if(productDetailID.toLowerCase().equals("n/a"))
        {
            return null;
        }
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("UPDATE product_detail SET Quantity = ? "
                + " WHERE id = ?" );
                float AvailableQty = Myfunc.getQuantityInDatabase(productDetailID);
                //JOptionPane.showMessageDialog(null,"PRODUCT DETAIL ID : " + productDetailID + "\tPURCHASED QTY : " +  purchasedQty + "\tAVAILABLE QTY : " + AvailableQty);
                ps.setFloat(1, AvailableQty + purchasedQty);
                ps.setString(2, productDetailID);
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Data UPDATED");
                //NO NEED TO COMMIT..It's caller's issue
                ps.close();
                if(autoCommit == true)
                    con.close();    // if autoCommit is false..then con.close() will commit acc. to ORACLE..
                                    // so let the caller function close the connection explicity.
               /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
                //JOptionPane.showMessageDialog(null,"Myfunc : addQuantityInDatabase : SUCCESSFUL");
            } catch (Exception ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                //JOptionPane.showMessageDialog(null,"Myfunc : addQuantityInDatabase : " + ex.getMessage());
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }

    public static Connection deleteOrder_by_OrderID(String OrderID, boolean autoCommit) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("DELETE FROM order_table WHERE id = \'" + OrderID + "\'");
                ps.executeUpdate();
                
                //NO NEED TO COMMIT..It's caller's issue
                ps.close();
                if(autoCommit == true)
                    con.close();
               /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
            } catch (SQLException ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }

    public static Connection subtractOrderForCustomer(String customerID, float amount,float orderBalance, boolean autoCommit) throws Exception {
        //OrderBalance or paidAmount?
        Customer customer = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
                customer = getCustomerByID(customerID,true);
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                ps = con.prepareStatement("UPDATE customer_table SET Balance = ? "
                + " , OrderCount = ? , TotalOrderAmount = ? , LastOrderDate = ?"
                + " WHERE id = ?" );
                ps.setFloat(1, customer.getBalance() - orderBalance);
                ps.setInt(2 , customer.getOrderCount() - 1);
                ps.setFloat(3, customer.getTotalOrderAmount() - amount);
                ps.setDate(4, customer.getLastSecondOrderDate());
                ps.setString(5, customerID);
                ps.executeUpdate();
                
                /*
                    NO NEED FOR if(autoCommit == true)      con.commit();
                    bcoz if it's autocommit..then it will commit automatically
                    and if autoCommit is false..then caller function would handle it..
                */
                ps.close();
                if(autoCommit == true)
                    con.close();
                /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
               // JOptionPane.showMessageDialog(null,"Myfunc : subtractOrderForCustomer : SUCCESSFUL");
            } catch (Exception ex) {
                //System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
               // JOptionPane.showMessageDialog(null,"Myfunc : subtractOrderForCustomer : " + ex.getMessage());
                throw ex;
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    }

    public static ArrayList<Transaction_mode> getTransactionModesList() throws SQLException {
        ArrayList<Transaction_mode> List  = null;
        Connection con = null;
        String query = "SELECT * FROM transaction_modes";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            List  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Transaction_mode tm;
            
            while(rs.next())
            {
                tm = new Transaction_mode(rs.getString("id"),rs.getString("Name"));
                List.add(tm);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            List = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return List; 
    }

    public static Transaction getTransactionByID(String transactionID) throws Exception {
        Connection con = null;
        String query = "SELECT * FROM transaction_table WHERE id = \'" + transactionID + "\'";

        Statement st = null;
        ResultSet rs = null;
        Transaction transaction = null;
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next())
            {
                transaction = new Transaction(rs.getString("id"),rs.getString("OrderID"),rs.getFloat("Amount"),rs.getString("TransactionModeID"),rs.getDate("Date"),rs.getTime("Time"),rs.getBoolean("Direction"));
            }
            else
            {
            /*    rs.close();
                st.close();
                con.close();*/
                throw new Exception("Transaction ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return transaction;
    }

    public static ArrayList<Transaction> getAllTransactionsForOrder(String OrderID) throws SQLException {
        ArrayList<Transaction> List  = null;
        Connection con = null;
        String query = "SELECT * FROM transaction_table WHERE orderID = \'" + OrderID + "\'";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            List  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Transaction transaction;
            
            while(rs.next())
            {
                transaction = new Transaction(rs.getString("id"),rs.getString("OrderID"),rs.getFloat("Amount"),rs.getString("TransactionModeID"),rs.getDate("Date"),rs.getTime("Time"),rs.getBoolean("Direction"));
                List.add(transaction);
            }
           rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            List = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return List; 
    }
    
    public static String getTransactionModeNameByID(String transactionModeID) throws Exception
    {
        Connection con = null;
        String query = "SELECT * FROM transaction_modes WHERE id = \'" + transactionModeID + "\'";

        Statement st = null;
        ResultSet rs = null;
        String name = null;
        
        try {
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next())
            {
                name = rs.getString("Name");
            }
            else
            {
                rs.close();
                st.close();
                con.close();
                throw new Exception("Transaction Mode ID Not FOUND!");
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return name;
    }

    public static String AmountInWords(float amount)
    {
        String str = "";
        int amt = (int)Math.round(amount);
        int hund = (amt % 100);
        amt = (amt / 100);
        if(amt > 0)
        {
            int thousand = (amt % 10);
            amt = (amt / 10);
            str = recursive(amt,1) + " " + getName(thousand,1);
            /*str += getName(thousand,1);     //hundred
            amt = (amt / 10);
            while(amt > 0)
            {
                int num = (amt % 100);
                amt = (amt / 100);
                str += getName(num,index++);
            }
            */
        }
        str = str + " " + getName(hund,0);     //nothing..one two..
        return str;
    }
    
    private static String recursive(int amt,int index)
    {
        if(amt == 0)    return "";
        int num = (amt % 100);
        amt = (amt / 100);
        return recursive(amt,index+1) + " " + getName(num,index+1);
    }

    private static String getName(int amt, int i) {
        String FirstString = "",SecondString = "";
        if(amt == 0)    return "";
        if(amt < 20)
        {
            switch(amt)
            {
                case 1 : FirstString = "One"; break;
                case 2 : FirstString = "Two"; break;
                case 3 : FirstString = "Three"; break;
                case 4 : FirstString = "Four"; break;
                case 5 : FirstString = "Five"; break;
                case 6 : FirstString = "Six"; break;
                case 7 : FirstString = "Seven"; break;
                case 8 : FirstString = "Eight"; break;
                case 9 : FirstString = "Nine"; break;
                case 10 : FirstString = "Ten"; break;
                case 11 : FirstString = "Eleven"; break;
                case 12 : FirstString = "Twelve"; break;
                case 13 : FirstString = "Thirteen"; break;
                case 14 : FirstString = "Fourteen"; break;
                case 15 : FirstString = "Fifteen"; break;
                case 16 : FirstString = "Sixteen"; break;
                case 17 : FirstString = "Seventeen"; break;
                case 18 : FirstString = "Eighteen"; break;
                case 19 : FirstString = "Nineteen"; break;
            }
        }
        else
        {
            int tens = amt / 10;
            switch(tens)
            {
                case 2 : FirstString = "Twenty "; break;
                case 3 : FirstString = "Thirty "; break;
                case 4 : FirstString = "Fourty "; break;
                case 5 : FirstString = "Fifty "; break;
                case 6 : FirstString = "Sixty "; break;
                case 7 : FirstString = "Seventy "; break;
                case 8 : FirstString = "Eighty "; break;
                case 9 : FirstString = "Ninety "; break;
            }
            int ones = (amt % 10);
            switch(ones)
            {
                case 0 : break;
                case 1 : FirstString += "One"; break;
                case 2 : FirstString += "Two"; break;
                case 3 : FirstString += "Three"; break;
                case 4 : FirstString += "Four"; break;
                case 5 : FirstString += "Five"; break;
                case 6 : FirstString += "Six"; break;
                case 7 : FirstString += "Seven"; break;
                case 8 : FirstString += "Eight"; break;
                case 9 : FirstString += "Nine"; break;
            }
        }
        
        switch(i)
        {
            case 0 : break;
            case 1 : SecondString = "Hundred"; break;
            case 2 : SecondString = "Thousand"; break;
            case 3 : SecondString = "Lakh"; break;
            case 4 : SecondString = "Crore"; break;
        }
        return FirstString + " " + SecondString;
        
    }
    
     public static Connection deleteProduct_by_ProductID(String productID, boolean autoCommit) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = My_CNX.getConnection();
                con.setAutoCommit(autoCommit);
                // You don't need savepoint here? Will caller function handle that?
                ps = con.prepareStatement("DELETE FROM product_table WHERE id = \'" + productID + "\'");
                ps.executeUpdate();
                
                /*
                you don't need to delete anything from the product_detail table
                 bcoz they reference the product_table using foriegn key
                constraint "CASCADE ON DELETE"
                so you need to just delete order from the product_table..rest the database will do
            */
                
                //NO NEED TO COMMIT..It's caller's issue
                ps.close();
                if(autoCommit == true)
                {
                    //System.out.println("autoCommit is true");
                    con.close();
                }
                /*        else
                {
                    System.out.println("returning the connection");
                    return con;
                } */    // let caller close the connection
                //JOptionPane.showMessageDialog(null, "Product is being Updated");
            } catch (SQLException ex) {
               // System.out.println("You caught exception in deleteProduct");
                Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
                //JOptionPane.showMessageDialog(null, "Previous Data Not Deleted");
            }
        finally
        {
            //System.out.println("You Do come here even after return!!!");        //cool
            try { if(ps != null)  ps.close(); } catch(SQLException e){}
            try { if(autoCommit == true && con != null)  con.close(); } catch(SQLException e){}
        }
        return con;
    } 
     
     public static ArrayList<Product_detail> getProductDetailList_by_ProductID(String productID) throws SQLException
    {
        ArrayList<Product_detail> productList  = null;
        Connection con = null;
        String query = "SELECT * FROM product_detail WHERE ProductID = \'" + productID + "\'";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            productList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product_detail detail;
            
            while(rs.next())
            {
                detail = new Product_detail(rs.getString("id"),rs.getString("ProductID"),Float.parseFloat(rs.getString("UnitSize")),Float.parseFloat(rs.getString("UnitPrice")),Float.parseFloat(rs.getString("Quantity")),Float.parseFloat(rs.getString("CostPrice")));
                productList.add(detail);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return productList; 
    }
     
     public static ArrayList<C_Users> getUserList() throws SQLException
    {
        ArrayList<C_Users> userList  = null;
        Connection con = null;
        String query = "SELECT * FROM users";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            userList  = new ArrayList<C_Users>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            C_Users user;
            
            while(rs.next())
            {
                user = new C_Users(rs.getString("id"),rs.getString("fullname"),rs.getString("username"),rs.getString("password"),rs.getString("phone"),rs.getString("email"),rs.getBytes("picture"));
                userList.add(user);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            userList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return userList; 
                
    }

    public static ArrayList<Product> getProductListWithString(String search) throws SQLException {
        ArrayList<Product> productList  = null;
        Connection con = null;
        String query = "SELECT * FROM product_table";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            productList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while(rs.next())
            {
                product = new Product(rs.getString("id"),rs.getString("Name"),rs.getString("SubType"),rs.getString("CategoryID"),rs.getString("Description"),rs.getDate("AddDate"),rs.getString("UnitCategoryID"),rs.getBytes("picture"));
                if(product.getName().toLowerCase().contains(search) || product.getSubType().toLowerCase().contains(search)
                        || product.getDescription().toLowerCase().contains(search)
                        || getProductCategory(product.getCategoryID(),false).getName().toLowerCase().contains(search)
                        || product.getId().toLowerCase().contains(search)
                        || product.getAddDate().toString().contains(search))
                productList.add(product);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            productList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        
        return productList;
    }

    public static ArrayList<Order> getOrderListWithString(String search) throws SQLException {
        ArrayList<Order> orderList  = null;
        Connection con = null;
        String query = "SELECT * FROM order_table";

        Statement st = null;
        ResultSet rs = null;
            
        try {
            orderList  = new ArrayList<>();
            con = My_CNX.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Order order;
            
            while(rs.next())
            {
                order = new Order(rs.getString("id"),rs.getString("CustomerID"),rs.getDate("OrderDate"),rs.getFloat("OrderAmount"),rs.getFloat("OverallDiscountPrice"),rs.getFloat("OverallTax"),rs.getFloat("Balance"));
                if(order.getID().toLowerCase().contains(search) || order.getCustomerID().toLowerCase().contains(search)
                        || order.getOrderDate().toString().contains(search))
                orderList.add(order);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Myfunc.class.getName()).log(Level.SEVERE, null, ex);
        /*    if(rs != null)  rs.close();
            if(st != null)  st.close();
            if(con != null)  con.close();*/
            throw ex;
        } catch(Exception ex)
        {
            orderList = null;
        }
        finally
        {
            try { if(rs != null)  rs.close(); } catch(SQLException e){}
            try { if(st != null)  st.close(); } catch(SQLException e){}
            try { if(con != null)  con.close(); } catch(SQLException e){}
        }
        return orderList;
    }
}
