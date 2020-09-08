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
public class Transaction_mode {
    private String id;
    private String name;

    Transaction_mode(String cid, String cname) {
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
