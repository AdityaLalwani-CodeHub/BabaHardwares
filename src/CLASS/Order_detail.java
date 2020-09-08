/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

/**
 *
 * @author Aditya
 */
public class Order_detail {
    private String id;
    private String orderID;
    private String productDetailID;
    private float unitPrice;
    private float purchasedQty;
    private float productDiscountPrice;
    private float productTax;

    Order_detail(String id, String orderID, String productDetailID, float unitPrice, float purchasedQty, float productDiscountPrice, float productTax) {
        this.id = id;
        this.orderID = orderID;
        this.productDetailID = productDetailID;
        this.unitPrice = unitPrice;
        this.purchasedQty = purchasedQty;
        this.productDiscountPrice = productDiscountPrice;
        this.productTax = productTax;
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getorderID()
    {
        return orderID;
    }
    
    public String getproductDetailID()
    {
        return productDetailID;
    }
    
     public float getunitPrice()
    {
        return unitPrice;
    }
     
     public float getpurchasedQty()
    {
        return purchasedQty;
    }
     
     public float getproductDiscountPrice()
    {
        return productDiscountPrice;
    }
     
      public float getproductTaxe()
    {
        return productTax;
    }
}
