/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//NOTE - generate receipt
package CLASS;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.java.org.example.invoice.App;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Aditya
 */
public class Generate_Receipt {
    private Order order;
    private String OrderID;
    private ArrayList<Order_detail> orderDetailList;
    private Customer customer;
    private String OrganisationName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String Phone;
    private String Email;
    private String GSTIN;
    private String LogoFilePath;
    private String JSONFilePath;
    private ArrayList<Transaction> transactionList;
    private float SubTotal;
    private File json;
    private boolean generate; 
    
    public Generate_Receipt(String OrderID)
    {
        try {
            initialise(OrderID);
            generateJSONFile();         //generates JSON
            App app = new App();        //Goes to App.java in main.java.org.example.invoice and generates PDF from that JSON
        } catch (Exception ex) {
            Logger.getLogger(Generate_Receipt.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problem in Generating the Receipt : " + ex.getMessage());
            
        }
    }
    
    private void initialise(String OrderID) throws Exception
    {
        this.OrderID = OrderID;
        order = Myfunc.getOrderByID(OrderID);
        orderDetailList = Myfunc.getOrderDetailList_by_OrderID(OrderID);
        customer = Myfunc.getCustomerByID(order.getCustomerID(),true);
        transactionList = Myfunc.getAllTransactionsForOrder(OrderID);
        SubTotal = 0;
        
        /*
        OrganisationName = "Baba Hardwares";
        addressLine1 = "Near Saraswati Vidya Mandir";
        addressLine2 = "Khamla Road";
        addressLine3 = "Nagpur - 440025";*/
        LogoFilePath = getClass().getResource("/images/logo.jpg").getPath().substring(6).replace("!", "");
        JSONFilePath = getClass().getResource("/JSON/receipt.json").getPath().substring(6).replace("!", "");
        
        json = new File("receipt.json");
        try
        {
            if(!json.exists())
            {
                json.createNewFile();
                try (FileWriter writer = new FileWriter(json)) {
                    writer.write("{}");
                }
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Problem generating receipt before : " + ex.getMessage());
            generate = true;
        }
        
        JSONObject jsonDocument = 
	    		(JSONObject)JSONValue.parse(new FileReader(new File("company.json")));
        if(jsonDocument.containsKey("OrganisationName")) {
			this.setOrganisationName((String)jsonDocument.get("OrganisationName"));
		}
        if(jsonDocument.containsKey("addressLine1")) {
			this.setaddressLine1((String)jsonDocument.get("addressLine1"));
		}
        if(jsonDocument.containsKey("addressLine2")) {
			this.setaddressLine2((String)jsonDocument.get("addressLine2"));
		}
        if(jsonDocument.containsKey("addressLine3")) {
			this.setaddressLine3((String)jsonDocument.get("addressLine3"));
		}
        if(jsonDocument.containsKey("Phone")) {
			this.setPhone((String)jsonDocument.get("Phone"));
		}
        if(jsonDocument.containsKey("Email")) {
			this.setEmail((String)jsonDocument.get("Email"));
		}
        if(jsonDocument.containsKey("GSTIN")) {
			this.setGSTIN((String)jsonDocument.get("GSTIN"));
		}
    }
    
    private JSONObject getJsonObjectFromDocument(JSONObject doc, String key) {
		if(doc.containsKey(key)) {
			Object simpleObject = doc.get(key);
			if(simpleObject instanceof JSONObject) {
				return (JSONObject)simpleObject;
			}
		}
		return null;
	}
    
    private void generateJSONFile() throws Exception
    {
        JSONObject objectList = new JSONObject();
        
        
        /****************Invoice Header*********************/
        JSONObject invoiceHeader = new JSONObject();
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);
        java.sql.Time time = new java.sql.Time(millis);
        invoiceHeader.put("invoiceDate", date.toString());
        invoiceHeader.put("invoiceTime", time.toString());
        invoiceHeader.put("OrganisationName", OrganisationName);
        invoiceHeader.put("addressLine1", addressLine1);
        invoiceHeader.put("addressLine2", addressLine2);
        invoiceHeader.put("addressLine3", addressLine3);
        invoiceHeader.put("Phone", Phone);
        invoiceHeader.put("Email", Email);
        invoiceHeader.put("GSTIN", GSTIN);
        invoiceHeader.put("LogoFilePath", LogoFilePath);
        objectList.put("invoiceHeader", invoiceHeader);     //add
        /*****************************************************/
        
        
        
        /****************Order Details*********************/
        JSONObject OrderDetails = new JSONObject();
        OrderDetails.put("OrderID", OrderID);
        OrderDetails.put("OrderDate", order.getOrderDate().toString());
        objectList.put("OrderDetails", OrderDetails);     //add
        /********************************************************/
        
        
        
        /****************Customer Details************************/
        JSONObject CustomerDetails = new JSONObject();
        CustomerDetails.put("CustomerID", customer.getId());
        CustomerDetails.put("CustomerName", customer.getFirstName() + " " + customer.getLastName());
        CustomerDetails.put("CustomerCategory", Myfunc.getCustomerCategoryName(customer.getCustomerCategoryID()));
        CustomerDetails.put("Phone", customer.getPhone());
        CustomerDetails.put("GSTIN", customer.getGSTIN());
        objectList.put("CustomerDetails", CustomerDetails);     //add
        /*********************************************************/
        
        
        
        /******************Transaction Data***********************/
        JSONArray TransactionData = new JSONArray();
        for(Transaction tranObject : transactionList)
        {
            JSONObject transaction1 = new JSONObject();
            transaction1.put("transactionID", tranObject.getId());
            transaction1.put("date", tranObject.getdate().toString());
            transaction1.put("time", tranObject.gettime().toString());
            transaction1.put("paidAmount", Float.toString(tranObject.getAmount()));
            transaction1.put("transactionMode", Myfunc.getTransactionModeNameByID(tranObject.getTransactionModeID()));
            transaction1.put("status", (tranObject.getdirection() ? "PAID" : "RETURNED") );
            TransactionData.add(transaction1);
        }
        objectList.put("TransactionData",TransactionData);      //add
        /********************************************************/
        
        
        /****************Product Details(Invoice Rows)********************/
        JSONArray invoiceRows = new JSONArray();
        for(Order_detail od : orderDetailList)
        {
            JSONObject odObject = new JSONObject();
            Product product = Myfunc.getProduct_by_ProductDetailID(od.getproductDetailID(),true);
            Product_detail productDetail = Myfunc.getProductDetail_by_ProductDetailID(od.getproductDetailID(),true);
            odObject.put("ProductDetailID", od.getproductDetailID());
            odObject.put("Name", product.getName() + " " + product.getSubType());
            //odObject.put("SubType", product.getSubType());
            odObject.put("UnitSize", Float.toString(productDetail.getUnitSize()) + " " + Myfunc.getUnitCategoryName(product.getUnitCategoryID()));
            odObject.put("UnitPrice", Float.toString(od.getunitPrice()));   //NOTE : It's NOT productDetail.getUnitPrice()!
            odObject.put("Quantity", Float.toString(od.getpurchasedQty()));
            odObject.put("Discount", Float.toString(od.getproductDiscountPrice()));
            float Amount = (od.getunitPrice() - od.getproductDiscountPrice())*(od.getpurchasedQty());
            odObject.put("Amount", Float.toString(Amount));
            SubTotal += Amount;
            invoiceRows.add(odObject);
        }
        objectList.put("invoiceRows",invoiceRows);      //add
        /****************************************************************/
        
        
        /****************SubTotal*********************/
        objectList.put("SubTotal", Float.toString(SubTotal));     //add
        /********************************************************/
        
        
        /****************Overall Discount*********************/
        objectList.put("OverallDiscount", Float.toString(order.getOverallDiscountPrice()));     //add
        /********************************************************/
        
        
        /***********************Balance*************************/
        objectList.put("Balance", Float.toString(order.getBalance()));     //add
        /********************************************************/
        
        
        /***********************Total*************************/
        objectList.put("Total", Float.toString(order.getOrderAmount()));     //add
        /********************************************************/
        
        /***********************AmountInWords*************************/
        objectList.put("AmountInWords", Myfunc.AmountInWords(order.getOrderAmount()));     //add
        /********************************************************/
        
        
        if(generate)
        {
            json = new File("receipt.json");
            try
            {
                if(!json.exists())
                {
                    json.createNewFile();
                    FileWriter writer = new FileWriter(json);
                    writer.write("{}");
                    writer.close();
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Problem generating receipt : " + ex.getMessage());
                return;
                //this.dispose();
            }
        }
        //Write JSON file
        try (FileWriter file = new FileWriter(json)) {
 
            file.write(objectList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setOrganisationName(String OrganisationName) {
        this.OrganisationName = OrganisationName;
    }

    private void setaddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    private void setaddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    private void setaddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    private void setPhone(String Phone) {
        this.Phone = Phone;
    }

    private void setEmail(String Email) {
        this.Email = Email;
    }

    private void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }
}
