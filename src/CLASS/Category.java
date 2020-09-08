/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import inventorysystem.My_CNX;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aditya
 */
public class Category {     //change name to ProductCategory
    
    private String id;
    private String name;

    Category(String cid, String cname) {
        this.id = cid;
        this.name = cname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
