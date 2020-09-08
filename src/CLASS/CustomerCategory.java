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
public class CustomerCategory {
    private String id;
    private String name;

    CustomerCategory(String cid, String cname) {
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
