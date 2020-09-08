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
public class C_Users {
    private String id;
    private String fullname;
    private String username;
    private String password;
    private String phone;
    private String email;
    private byte[] picture;

    public C_Users(String uid, String ufullname, String uusername, String upassword, String uphone, String uemail, byte[] uimage) {
        this.id = uid;
        this.fullname = ufullname;
        this.username = uusername;
        this.password = upassword;
        this.phone = uphone;
        this.email = uemail;
        this.picture = uimage;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getFullName()
    {
        return fullname;
    }
    
    public String getUserName()
    {
        return username;
    }
    
    public String getPassword()
    {
        return  password;
    }
    
    public String getPhone()
    {
        return  phone;
    }
    
    public String getEmail()
    {
        return  email;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
    
}
