/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.sql.Date;

/**
 *
 * @author Aditya
 */
public class Order {
    private String id;
    private String CustomerID;
    private Date OrderDate;
    private float OrderAmount;
    private float OverallDiscountPrice;
    private float OverallTax;
    private float Balance;

    Order(String id, String CustomerID, Date OrderDate, float OrderAmount, float OverallDiscountPrice, float OverallTax, float Balance) {
        this.id = id;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.OrderAmount = OrderAmount;
        this.OverallDiscountPrice = OverallDiscountPrice;
        this.OverallTax = OverallTax;
        this.Balance = Balance;
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getCustomerID()
    {
        return CustomerID;
    }
    
    public Date getOrderDate()
    {
        return OrderDate;
    }
    
    public float getOrderAmount()
    {
        return OrderAmount;
    }
    
    public float getOverallDiscountPrice()
    {
        return OverallDiscountPrice;
    }
    
    public float getBalance()
    {
        return Balance;
    }
}
