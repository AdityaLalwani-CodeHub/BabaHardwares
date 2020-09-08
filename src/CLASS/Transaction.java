/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Aditya
 */
public class Transaction {
    private String id;
    private String OrderID;
    private float Amount;
    private String TransactionModeID;
    
    private Date date;
    private Time time;
    private boolean direction;  // true if forward..flow out
                                // false if flow in
    
    /*public Product(int pid, String pname, float pprice, String pAddDate, byte[] pimg)
    {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.addDate = pAddDate;
        this.picture = pimg;
    }*/

    public Transaction(String id, String OrderID, float Amount, String TransactionModeID,Date date,Time time,boolean direction) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.id = id;
       this.OrderID = OrderID;
       this.Amount = Amount;
       this.TransactionModeID = TransactionModeID;
       this.date = date;
       this.time = time;
       this.direction = direction;
    }
    
    /*
    public Transaction(String id, String OrderID, float Amount, String TransactionModeID,Date date,Time time) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.id = id;
       this.OrderID = OrderID;
       this.Amount = Amount;
       this.TransactionModeID = TransactionModeID;
       this.date = date;
       this.time = time;
       this.direction = true;
    }*/
    
    public String getId()
    {
        return id;
    }
    
    public String getOrderID()
    {
        return OrderID;
    }
    
    public float getAmount()
    {
        return Amount;
    }
    
    public String getTransactionModeID()
    {
        return TransactionModeID;
    }
    
    public Date getdate()
    {
        return  date;
    }
    
     public boolean getdirection()
    {
        return direction;
    }
    
    public Time gettime()
    {
        return time;
    }
}
