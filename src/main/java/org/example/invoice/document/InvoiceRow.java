package main.java.org.example.invoice.document;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.simple.JSONObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.java.org.example.invoice.PDFPrinter;
import java.awt.Color;
import java.io.IOException;

public class InvoiceRow {
	private String ProductDetailID;
	private String ProductName;
        //private String SubType;
        private String UnitSize;
        private String UnitPrice;
	private String Quantity;
	private String Discount;
        private String Amount; //Expect the json file creator program to calculate Amount.

    public InvoiceRow(JSONObject jsonInvoiceRow) {
        if(jsonInvoiceRow.containsKey("ProductDetailID")) {
            this.setProductDetailID((String)jsonInvoiceRow.get("ProductDetailID"));
        }
        if(jsonInvoiceRow.containsKey("Name")) {
            this.setProductName((String)jsonInvoiceRow.get("Name"));
        }
       /* if(jsonInvoiceRow.containsKey("SubType")) {
            this.setSubType((String)jsonInvoiceRow.get("SubType"));
        }*/
        if(jsonInvoiceRow.containsKey("UnitSize")) {
            this.setUnitSize((String)jsonInvoiceRow.get("UnitSize"));
        }
        if(jsonInvoiceRow.containsKey("UnitPrice")) {
            this.setUnitPrice((String)jsonInvoiceRow.get("UnitPrice"));
        }
        if(jsonInvoiceRow.containsKey("Quantity")) {
            this.setQuantity((String)jsonInvoiceRow.get("Quantity"));
        }
        if(jsonInvoiceRow.containsKey("Discount")) {
            this.setDiscount((String)jsonInvoiceRow.get("Discount"));
        }
        if(jsonInvoiceRow.containsKey("Amount")) {
            this.setAmount((String)jsonInvoiceRow.get("Amount"));
        }
    }

 /*   public BigDecimal addTotal(BigDecimal totalCost) {
    	return totalCost.add(this.getTotal());
    }*/

    public void printPDF(int rowY) throws IOException {        
        Color strokeColor = new Color(100, 100, 100);
        Dimensions.contents.setStrokingColor(strokeColor);
        
        PDFont font = PDType1Font.HELVETICA;
        PDFPrinter textPrinter = new PDFPrinter(Dimensions.contents, font, 8);
        textPrinter.putText(Dimensions.getStartXCol1_pdTable()+2, rowY+7, ProductDetailID);
        textPrinter.putText(Dimensions.getStartXCol2_pdTable(), rowY+7, ProductName);
        textPrinter.putText(Dimensions.getStartXCol3_pdTable(), rowY+7, UnitSize);
        textPrinter.putText(Dimensions.getStartXCol4_pdTable(), rowY+7, UnitPrice);
        textPrinter.putText(Dimensions.getStartXCol5_pdTable(), rowY+7, Quantity);
        textPrinter.putText(Dimensions.getStartXCol6_pdTable(), rowY+7, Discount);
        textPrinter.putText(Dimensions.getStartXCol7_pdTable(), rowY+7, Amount);
    }

 /*   public String getTotalString() {
    	BigDecimal printTotal = getTotal();
    	printTotal.setScale(2, RoundingMode.HALF_EVEN);
    	return printTotal.toString();
   	}

    public String getPriceString() {
    	BigDecimal printPrice = getPrice();
    	printPrice.setScale(2, RoundingMode.HALF_EVEN);
    	return printPrice.toString();
   	}

    public String getQuantityString() {
    	return Double.toString(quantity);
   	}


    public BigDecimal getTotal() {
    	return this.price.multiply(new BigDecimal(quantity)); 
    }

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductNumber() {
		return this.productNumber;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductDescription() {
		return this.productDescription;
	}
	public void setQuantity(String quantity) {		
		this.quantity = Double.parseDouble(quantity.replace(",", "."));
	}	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getQuantity() {
		return this.quantity;
	}
	public void setPrice(double price) {
		this.price = new BigDecimal(price);
	}
	public void setPrice(String price) {		
		this.price = new BigDecimal(price.replace(",", "."));
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return this.price;
	}
*/
    private void setProductDetailID(String ProductDetailID) {
        this.ProductDetailID = ProductDetailID;
    }

    private void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
/*
    private void setSubType(String SubType) {
        this.SubType = SubType;
    }
*/
    private void setUnitSize(String UnitSize) {
        this.UnitSize = UnitSize;
    }

    private void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    private void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    private void setAmount(String Amount) {
        this.Amount = Amount;
    }

    private void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
}