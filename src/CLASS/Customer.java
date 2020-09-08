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
public class Customer {
    private String id;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private int OrderCount;
    private Float TotalOrderAmount;
    private Date LastOrderDate;
    private Float Balance;
    private Date AddDate;
    private String CustomerCategoryID;
    private Date LastSecondOrderDate;
    private String GSTIN;

/*    Customer(String cid, String cFirstName, String cLastName, String cPhone, String cEmail, int cOrderCount, float cTotalOrderAmount, Date cLastOrderDate, float cBalance, Date cAddDate, String cCustomerCategoryID, Date LastSecondOrderDate) {
        this.id = cid;
        this.FirstName = cFirstName;
        this.LastName = cLastName;
        this.Phone = cPhone;
        this.Email = cEmail;
        this.OrderCount = cOrderCount;
        this.TotalOrderAmount = cTotalOrderAmount;
        this.LastOrderDate = cLastOrderDate;
        this.Balance = cBalance;
        this.AddDate = cAddDate;
        this.CustomerCategoryID = cCustomerCategoryID;
        this.LastSecondOrderDate = LastSecondOrderDate;
        this.GSTIN = null;
    }*/
    
    Customer(String cid, String cFirstName, String cLastName, String cPhone, String cEmail, int cOrderCount, float cTotalOrderAmount, Date cLastOrderDate, float cBalance, Date cAddDate, String cCustomerCategoryID, Date LastSecondOrderDate, String GSTIN) {
        this.id = cid;
        this.FirstName = cFirstName;
        this.LastName = cLastName;
        this.Phone = cPhone;
        this.Email = cEmail;
        this.OrderCount = cOrderCount;
        this.TotalOrderAmount = cTotalOrderAmount;
        this.LastOrderDate = cLastOrderDate;
        this.Balance = cBalance;
        this.AddDate = cAddDate;
        this.CustomerCategoryID = cCustomerCategoryID;
        this.LastSecondOrderDate = LastSecondOrderDate;
        this.GSTIN = GSTIN;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }
    
    public int getOrderCount() {
        return OrderCount;
    }
    
    public float getTotalOrderAmount() {
        return TotalOrderAmount;
    }
    
    public Date getLastOrderDate() {
        return LastOrderDate;
    }
    
    public float getBalance() {
        return Balance;
    }
    
    public Date getAddDate() {
        return AddDate;
    }
    
    public String getCustomerCategoryID() {
        return CustomerCategoryID;
    }
    
    public Date getLastSecondOrderDate() {
        return LastSecondOrderDate;
    }
    
    public String getGSTIN() {
        return GSTIN;
    }
}
