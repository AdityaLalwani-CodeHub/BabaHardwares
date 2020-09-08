package main.java.org.example.invoice.document;

import org.json.simple.JSONObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.java.org.example.invoice.PDFPrinter;
import java.io.IOException;
import java.awt.Color;
import java.lang.StringBuilder;

public class PrintCustomer {
/*	private String title;
	private String first;
	private String last;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String zipCode;
	private String country;
*/
        private String CustomerID;
        private String CustomerName;
        private String CustomerCategory;
        private String Phone;
        private String GSTIN;
        
	public PrintCustomer(JSONObject jsonAddress) {
       /* if(jsonAddress.containsKey("name")) {
        	if(jsonAddress.get("name") instanceof JSONObject) {
        		JSONObject jsonName = (JSONObject) jsonAddress.get("name");
		        if(jsonName.containsKey("title")) {
		            this.setTitle((String)jsonName.get("title"));
		        }
		        if(jsonName.containsKey("first")) {
		            this.setFirst((String)jsonName.get("first"));
		        }
		        if(jsonName.containsKey("last")) {
		            this.setLast((String)jsonName.get("last"));
		        }        		
        	}
	    }
        if(jsonAddress.containsKey("address1")) {
            this.setAddress1((String)jsonAddress.get("address1"));
        }
        if(jsonAddress.containsKey("address2")) {
            this.setAddress2((String)jsonAddress.get("address2"));
        }
        if(jsonAddress.containsKey("address3")) {
            this.setAddress3((String)jsonAddress.get("address3"));
        }
        if(jsonAddress.containsKey("city")) {
            this.setCity((String)jsonAddress.get("city"));
        }*/
        if(jsonAddress.containsKey("CustomerCategory")) {
            this.setCustomerCategory((String)jsonAddress.get("CustomerCategory"));
        }
        if(jsonAddress.containsKey("CustomerID")) {
            this.setCustomerID((String)jsonAddress.get("CustomerID"));
        }
        if(jsonAddress.containsKey("CustomerName")) {
            this.setCustomerName((String)jsonAddress.get("CustomerName"));
        }
        if(jsonAddress.containsKey("Phone")) {
            this.setPhone((String)jsonAddress.get("Phone"));
        }
        if(jsonAddress.containsKey("GSTIN")) {
            this.setGSTIN((String)jsonAddress.get("GSTIN"));
        }
	}

	public void printPDF() throws IOException {
		PDFont font = PDType1Font.HELVETICA;
        Color color = new Color(80, 80, 80);

       // int x = rightSide ? 400 : 120;
        int x = 400;
        int y = Dimensions.getNextY();

        PDFPrinter headerPrinter = new PDFPrinter(Dimensions.contents, font, 10);
        //headerPrinter.putText(x, y, rightSide ? "Bill to:" : "Ship to:");
        headerPrinter.putText(x, y, "Customer Details :");
        y -= 12;
        PDFPrinter addressPrinter = new PDFPrinter(Dimensions.contents, font, 10, color);
        addressPrinter.putText(x, y, "ID : " + CustomerID);
        y -= 12;
        addressPrinter.putText(x, y, "Name : " +  CustomerName);
        y -= 12;
        addressPrinter.putText(x, y, "Phone : " + Phone);
        y -= 12;
        addressPrinter.putText(x, y, "GSTIN : " + GSTIN);
        y -= 12;
        addressPrinter.putText(x, y, "Category : " + CustomerCategory);
        y -= 12;
        Dimensions.setNextY(y);
        /*
        y -= 12;
        if (hasAddress2()) {
        	addressPrinter.putText(x, y, getAddress2());	
	        y -= 12;
        }        
        if (hasAddress3()) {
	        addressPrinter.putText(x, y, getAddress3());
	        y -= 12;
	    }
        addressPrinter.putText(x, y, getZipCode()+" "+getCity());
        y -= 12;
        addressPrinter.putText(x, y, getState()+", "+getCountry());
        */
    }

/*	public String getFullName() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTitle()).append(" ");
		sb.append(this.getFirst()).append(" ");
		sb.append(this.getLast());
		return sb.toString();
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getFirst() {
		return this.first;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getLast() {
		return this.last;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress1() {
		return this.address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress2() {
		return this.address2;
	}
	public boolean hasAddress2() {
		return this.address2 != null && !this.address2.isEmpty();
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress3() {
		return this.address3;
	}
	public boolean hasAddress3() {
		return this.address3 != null && !this.address3.isEmpty();
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getZipCode() {
		return this.zipCode;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return this.country;
	}
*/

    private void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    private void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    private void setCustomerCategory(String CustomerCategory) {
        this.CustomerCategory = CustomerCategory;
    }

    private void setPhone(String Phone) {
        this.Phone = Phone;
    }

    private void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    public String getCustomerID() {
        return this.CustomerID;
    }
}