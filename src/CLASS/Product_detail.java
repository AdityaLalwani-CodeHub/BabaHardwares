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
public class Product_detail {
    
    private String id;
    private String productID;
    private float unitSize;
    private float unitPrice;
    private float quantity;
    private float costPrice;

    public Product_detail(String pid, String pproductID, float punitSize, float punitPrice, float quantity, float pcostPrice) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.id = pid;
        this.productID = pproductID;
        this.unitPrice =  punitPrice;
        this.unitSize = punitSize;
        this.quantity = quantity;
        this.costPrice = pcostPrice;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getProductID()
    {
        return productID;
    }
    
    public float getUnitSize()
    {
        return unitSize;
    }
    
    public float getUnitPrice()
    {
        return unitPrice;
    }
    
    public float getQuantity()
    {
        return quantity;
    }
     
    public float getCostPrice()
    {
        return costPrice;
    }
}
