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
public class Product {
    private String id;
    private String name;
    private String subType;
    private String categoryID;
    private String description;
    private Date addDate;
    private String unitCategoryID;
    private byte[] picture;
    
    /*public Product(int pid, String pname, float pprice, String pAddDate, byte[] pimg)
    {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.addDate = pAddDate;
        this.picture = pimg;
    }*/

    public Product(String pid, String pname, String psubType, String pcategoryID, String pdescription, Date paddDate, String punitCategoryID, byte[] ppicture) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.id = pid;
       this.name = pname;
       this.subType = psubType;
       this.categoryID = pcategoryID;
       this.description = pdescription;
       this.addDate = paddDate;
       this.unitCategoryID = punitCategoryID;
       this.picture = ppicture;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getSubType()
    {
        return subType;
    }
    
    public String getCategoryID()
    {
        return categoryID;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Date getAddDate()
    {
        return  addDate;
    }
    
     public String getUnitCategoryID()
    {
        return unitCategoryID;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
}
