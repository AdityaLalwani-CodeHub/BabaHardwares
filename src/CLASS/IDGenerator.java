/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 *
 * @author Aditya
 */
public class IDGenerator {
    
    
    private static String generateID()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:A");   // A- milliseconds od day  ... n - nanosecond
        LocalDateTime now = LocalDateTime.now();
        String str = dtf.format(now);
        //System.out.println(str);
        String numberOnly= str.replaceAll("[^0-9]", "");
        //System.out.println(numberOnly);
        return numberOnly;
    }
    
    public static String getIDforCustomer()
    {
        return "CUST" + generateID();
    }
    
    public static String getIDforProduct()
    {
        return "PROD" + generateID();
    }
    
    public static String getIDforUser()
    {
        return "USER" + generateID();
    }
    
    public static String getIDforProductDetail()
    {
        return "PRDT" + generateID();
    }
    
    public static String getIDforProductCategory()
    {
        return "PRCT" + generateID();
    }
    
   /* public static void main(String []args)
    {
        String str = generateID();
    }*/

    public static String getIDforUnitCategory() {
        
        return "UNIT" + generateID();
    }

    public static String getIDforCustomerCategory() {
        return "CUCT" + generateID();
    }
    
    public static String getIDforOrder() {
        return "ORDR" + generateID();
    }

    public static String getIDforOrderDetail() {
        return "ORDT" + generateID();
    }
    
    public static String getIDforTransaction() {
        return "TRAN" + generateID();
    }

    public static String getIDforInvoice() {
        return "INVC" + generateID();
    }

    public static String getIDforTransactionModes() {
        return "TRMO" + generateID();
    }
}
