package main.java.org.example.invoice.document;

import CLASS.IDGenerator;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.java.org.example.invoice.PDFPrinter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.awt.Color;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.io.IOException;

public class Invoice {
	public static Header header = null;
	private PrintCustomer CustomerDetails = null;
	private PrintOrder OrderDetails = null;
	private List<InvoiceRow> rows = new ArrayList<InvoiceRow>();
	//private TransactionData shipData = null;
        private List<TransactionData> rowsTransaction = new ArrayList<TransactionData>();
	private String notes;

	private int maxRowSize = 23;
	private int maxPageWithSummation = 16;
	private int breakPoint = 12;
        
        private int maxRowSizeTransaction = 7;
	private int maxPageWithSummationTransaction = 5;    //initally table me kitne rows present hone chahiye
	private int breakPointTransaction = 3;
        
        private float OverallDiscount;
        private float Balance;
        private float Total;
        private float SubTotal;
        private String AmountInWords;
        //private PDDocument pdfDocument;

	public Invoice(JSONObject doc) {
	/*	this.header = new Header(getJsonObjectFromDocument(doc, "invoiceHeader"));
		this.billTo = new PrintOrder(getJsonObjectFromDocument(doc, "billTo"));

		if(doc.containsKey("shipTo")) {
			JSONObject shipToObj = (JSONObject)doc.get("shipTo");
			if(shipToObj.containsKey("sameAsBilling") && ((Boolean)shipToObj.get("sameAsBilling")) == true) {
				this.shipTo = this.billTo;
			}
		}

		if(this.shipTo == null) {
			this.shipTo = new PrintOrder(getJsonObjectFromDocument(doc, "shipTo"));	
		}		
		this.shipData = new TransactionData(getJsonObjectFromDocument(doc, "shippingData"));
		if(doc.containsKey("invoiceRows")) {
			Object simpleInvoiceRowsObject = doc.get("invoiceRows");
			if(simpleInvoiceRowsObject instanceof JSONArray) {
				for(Object simpleInvRowObj : ((JSONArray)simpleInvoiceRowsObject)) {
					if(simpleInvRowObj instanceof JSONObject) {
						addRow(new InvoiceRow((JSONObject)simpleInvRowObj));
					}
				}
			}
		}		
		if(doc.containsKey("notes")) {
			this.setNotes((String)doc.get("notes"));
		}
        */
                //this.pdfDocument = pdfDocument;
                Dimensions.initialiseNextY();
                header = new Header(getJsonObjectFromDocument(doc, "invoiceHeader"));
		this.OrderDetails = new PrintOrder(getJsonObjectFromDocument(doc, "OrderDetails"));
                this.CustomerDetails = new PrintCustomer(getJsonObjectFromDocument(doc, "CustomerDetails"));
		/*if(doc.containsKey("shipTo")) {
			JSONObject shipToObj = (JSONObject)doc.get("shipTo");
			if(shipToObj.containsKey("sameAsBilling") && ((Boolean)shipToObj.get("sameAsBilling")) == true) {
				this.shipTo = this.billTo;
			}
		}

                //What is this?
		if(this.shipTo == null) {
			this.shipTo = new PrintOrder(getJsonObjectFromDocument(doc, "shipTo"));	
		}	*/	
		//this.shipData = new TransactionData(getJsonObjectFromDocument(doc, "shippingData"));
                if(doc.containsKey("TransactionData")) {
			Object simpleInvoiceRowsObject = doc.get("TransactionData");
			if(simpleInvoiceRowsObject instanceof JSONArray) {
				for(Object simpleInvRowObj : ((JSONArray)simpleInvoiceRowsObject)) {
					if(simpleInvRowObj instanceof JSONObject) {
						addRowTransaction(new TransactionData((JSONObject)simpleInvRowObj));
					}
				}
			}
		}	
		if(doc.containsKey("invoiceRows")) {
			Object simpleInvoiceRowsObject = doc.get("invoiceRows");
			if(simpleInvoiceRowsObject instanceof JSONArray) {
				for(Object simpleInvRowObj : ((JSONArray)simpleInvoiceRowsObject)) {
					if(simpleInvRowObj instanceof JSONObject) {
						addRow(new InvoiceRow((JSONObject)simpleInvRowObj));
					}
				}
			}
		}		
	/*	if(doc.containsKey("notes")) {
			this.setNotes((String)doc.get("notes"));
		}*/
                if(doc.containsKey("OverallDiscount")) {
			this.setOverallDiscount((String)doc.get("OverallDiscount"));
		}
                if(doc.containsKey("Balance")) {
			this.setBalance((String)doc.get("Balance"));
		}
                if(doc.containsKey("Total")) {
			this.setTotal((String)doc.get("Total"));
		}
                if(doc.containsKey("SubTotal")) {
			this.setSubTotal((String)doc.get("SubTotal"));
		}
                if(doc.containsKey("AmountInWords")) {
			this.setAmountInWords((String)doc.get("AmountInWords"));
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

        /*
	private PDPageContentStream newPage(PDDocument pdfDocument, PDPageContentStream contents, int rowY, int numRows) throws IOException {
		contents.close();
		PDPage pdfPage = new PDPage();
		pdfDocument.addPage(pdfPage);		
		contents = new PDPageContentStream(pdfDocument, pdfPage);
		this.header.printPDF(pdfDocument, contents);
		printRowHeader(contents, rowY);
                Dimensions.setNextY(rowY - 21);
		printRowBackGround(contents, numRows);		
		return contents;
	}*/
        
        

        // Only check y_page_bottom_margin > 50...
	private boolean newPageRequired(int numPrintedRows, int rowsLeft) {
		if(numPrintedRows >= this.maxRowSize) return true;
		if(this.maxPageWithSummation < rowsLeft && rowsLeft < this.maxRowSize) {
			if(numPrintedRows >= this.breakPoint) return true;
		}
		return false;
	}

	public void printPDF() throws IOException {
	/*	this.header.printPDF(pdfDocument, contents);
		this.shipTo.printPDF(contents, false);
		this.billTo.printPDF(contents, true);
		this.shipData.printPDF(contents);

		int rowY = 520;
		int numPrintedRows = 0;
                
                //rowsLeft - kitne products print karna bacha hai
		int rowsLeft = rows.size();     // rows - initially kitne products hai
                // initially saare products print karne k liye bache hai
                
		printRowHeader(contents, rowY);
		printRowBackGround(contents, rowY-21, 
			rowsLeft < this.maxPageWithSummation ? this.maxPageWithSummation : this.maxRowSize
			);

		BigDecimal totalCost = BigDecimal.ZERO;
		for (InvoiceRow invoiceRow : rows) {	
			numPrintedRows++;
			rowY -= 20;
			invoiceRow.printPDF(contents, rowY);
			totalCost = invoiceRow.addTotal(totalCost);
			if(newPageRequired(numPrintedRows, rowsLeft)) {
				rowsLeft -= numPrintedRows;
				numPrintedRows = 0;
				maxRowSize = 30;
				maxPageWithSummation = 23;
				breakPoint = 18;
				rowY = 660;
				contents = newPage(pdfDocument, contents, rowY,
					rowsLeft < this.maxPageWithSummation ? this.maxPageWithSummation : this.maxRowSize
					);

			}
		}		
            */
/*
		First page with summation 16 rows
		First page without summation 24 rows
		Next page with summation 23 rows
		Next page without summation 31 rows

		16-24 = 12		
		24-31 = 18
*/
	/*	printSummery(contents, totalCost);
		printFooter(contents);
		contents.close();
                */
        
                //Edited
                this.header.printPDF();
		this.OrderDetails.printPDF();
                this.CustomerDetails.printPDF();
		//this.shipData.printPDF(contents);
                
                //rowsLeft - kitne products print karna bacha hai
		int rowsLeft = rows.size();     // rows - initially kitne products hai
                // initially saare products print karne k liye bache hai
                int rowsLeftTransaction = rowsTransaction.size();
                
                int rowYTransaction = Dimensions.getNextY() - Dimensions.gap_Y_Customer_TrTable;//550; //570;
                int numPrintedRowsTransaction = 0;
                
                Dimensions.setNextY(rowYTransaction);
                 //it's rowY-21..(NOT rowY-20) bcoz..1 pixel is used for border
                printRowHeaderTransaction(rowYTransaction);
                Dimensions.setNextY(rowYTransaction-(Dimensions.cell_height+1));
	/*	printRowBackGroundTransaction(contents, rowYTransaction-(Dimensions.cell_height+1), 
			rowsLeftTransaction < this.maxPageWithSummationTransaction ? this.maxPageWithSummationTransaction : this.maxRowSizeTransaction
			);*/
                printRowBackGroundTransaction(rowsTransaction);
        /*        for (TransactionData transaction : rowsTransaction) {	
			numPrintedRowsTransaction++;
			rowYTransaction -= Dimensions.cell_height;*/
                        /*
                            Here you don't need to set the Dimensions.setNextY(...)
                            bcoz you are writing the "data"..so you go back(towards top)
                            to print data...
                            the nextY was already set when printing the row Background
                        */
	//		transaction.printPDF(rowYTransaction);
		/*	if(newPageRequired(numPrintedRowsTransaction, rowsLeftTransaction)) {
				rowsLeftTransaction -= numPrintedRowsTransaction;
				numPrintedRowsTransaction = 0;
				maxRowSizeTransaction = 7;
				maxPageWithSummationTransaction = 5;
				breakPointTransaction = 3;
				rowYTransaction = 660;
				contents = newPage(pdfDocument, contents, rowYTransaction,
					rowsLeftTransaction < this.maxPageWithSummationTransaction ? this.maxPageWithSummationTransaction : this.maxRowSizeTransaction
					);

			}*/
	//	}	
                
                /*
                NOTE : Origin(0,0) is the Lower left CORNER of the PAGE
                So..
                X - coor. -> distance from the bottom of the page
                Y - coor. -> distance from the Left of the page
                i.e. The whole page is THE FIRST QUADRANT
                */
                
                /*
                    rowY -> Y coor. of the product_detail table
                    rowYTransaction -> Y coor. of the transaction table
                    20 -> Height of the Header of Transaction table
                    ********************(20*rowsLeftTransaction)**********************
                        20 -> Height of each row of Transaction table
                        rowsLeftTransaction -> Expected Number of rows in the Transaction table,probably
                    ******************************************************************
                    10 -> Height(Space) between transaction Table and the product_detail table
                */
                //int rowY = rowYTransaction - Dimensions.cell_height - (Dimensions.cell_height*rowsLeftTransaction) - 10;
                Dimensions.setNextY(Dimensions.getNextY() - Dimensions.cell_height - Dimensions.gap_Y_TrTable_PdTable);
                int rowY = Dimensions.getNextY();
		int numPrintedRows = 0;
                
		printRowHeader(rowY);
	/*	printRowBackGround(contents, rowY-(Dimensions.cell_height+1), 
			rowsLeft < this.maxPageWithSummation ? this.maxPageWithSummation : this.maxRowSize
			);*/
                Dimensions.setNextY(rowY-(Dimensions.cell_height+1));
                printRowBackGround(rows);
               
		//BigDecimal totalCost = BigDecimal.ZERO;
		/*for (InvoiceRow invoiceRow : rows) {	
			numPrintedRows++;
			rowY -= Dimensions.cell_height;
			invoiceRow.printPDF(rowY);
			//totalCost = invoiceRow.addTotal(totalCost);
			/*if(newPageRequired(numPrintedRows, rowsLeft)) {
				rowsLeft -= numPrintedRows;
				numPrintedRows = 0;
				maxRowSize = 30;
				maxPageWithSummation = 23;
				breakPoint = 18;
				rowY = 660;     //You need to CHANGE this According to rowYTransaction 
				contents = newPage(pdfDocument, contents, rowY,
					rowsLeft < this.maxPageWithSummation ? this.maxPageWithSummation : this.maxRowSize
					);

			}*/
		//}		
                printSummery();
		//printFooter(contents);
		Dimensions.contents.close();
	}

	public void printSummery() throws IOException {
        Color strokeColor = new Color(100, 100, 100);
        Dimensions.contents.setStrokingColor(strokeColor);
        Color fillColor = new Color(240, 240, 240);
        Dimensions.contents.setNonStrokingColor(fillColor);        

        PDFPrinter summeryLabelPrinter = new PDFPrinter(Dimensions.contents, PDType1Font.HELVETICA_BOLD, 12);
        PDFPrinter summeryValuePrinter = new PDFPrinter(Dimensions.contents, PDType1Font.HELVETICA, 12);

    	/*BigDecimal subTotal = totalCost.multiply(new BigDecimal(0.8f));
    	BigDecimal vatValue = totalCost.multiply(new BigDecimal(0.2f));
    	subTotal = subTotal.setScale(2, RoundingMode.HALF_EVEN);    	
    	vatValue = vatValue.setScale(2, RoundingMode.HALF_EVEN);
    	totalCost = totalCost.setScale(2, RoundingMode.HALF_EVEN);*/
        
        Dimensions.setNextY(Dimensions.getNextY() - Dimensions.gap_Y_PdTable_Summary);       //balance k baad

    	int summeryStartY = Dimensions.getNextY() - Dimensions.gap_Y_PdTable_Summary; //Dimensions.y_bottom_margin_pdTable - 10;    //Try to make it relative

	summeryLabelPrinter.putText(395, summeryStartY - 14, "SubTotal");
        Dimensions.contents.addRect(450, summeryStartY-17, 140, 16);
        Dimensions.contents.stroke();
        summeryValuePrinter.putTextToTheRight(575, summeryStartY-13, "Rs." + Float.toString(SubTotal) + "/-");

	summeryLabelPrinter.putText(350, summeryStartY - 44, "Overall Discount");
        Dimensions.contents.addRect(450, summeryStartY - 30 - 17, 140, 16);
        Dimensions.contents.stroke();
        summeryValuePrinter.putTextToTheRight(575, summeryStartY - 30 - 13, "Rs." + Float.toString(OverallDiscount) + "/-");

	summeryLabelPrinter.putText(417, summeryStartY - 74, "Total");
        Dimensions.contents.addRect(450, summeryStartY - 60 - 17, 140, 16);
        Dimensions.contents.stroke();
        summeryValuePrinter.putTextToTheRight(575, summeryStartY - 60 - 13, "Rs." + Float.toString(Total) + "/-");
        
        summeryLabelPrinter.putText(400, summeryStartY - 104, "Balance");
        Dimensions.contents.addRect(450, summeryStartY - 90 - 17, 140, 16);
        Dimensions.contents.stroke();
        summeryValuePrinter.putTextToTheRight(575, summeryStartY - 90 - 13, "Rs." + Float.toString(Balance) + "/-");
        
        String FirstString = "", SecondString = "";
        int splitIndex = spiltTheAmount(AmountInWords);
        FirstString = AmountInWords.substring(0, splitIndex);
        SecondString = " " + AmountInWords.substring(splitIndex);
        //System.out.println(AmountInWords.length());
        //System.out.println(FirstString);
        //System.out.println(FirstString.length());
        //System.out.println(SecondString);
        //System.out.println(SecondString.length());
        summeryLabelPrinter.putText(Dimensions.x_left_margin_table, summeryStartY - 14, "Amount In Words :");
        Dimensions.contents.addRect(Dimensions.x_left_margin_table, summeryStartY - 40 - 15, 320, 35);
        Dimensions.contents.stroke();
        summeryValuePrinter.putText(Dimensions.x_left_margin_table, summeryStartY - 32, FirstString);
        summeryValuePrinter.putText(Dimensions.x_left_margin_table, summeryStartY - 48, SecondString);
        //TODO add subtotal and AmountInWords
	}

        private int spiltTheAmount(String str) {
            int length = str.length();
            if(length < 50)
            {
                return length;
            }
            int lengthTillNow = 0;
            String[] words = str.split(" ");
            boolean flag = true;
            //String FirstString = "", SecondString = "";
            for(String string : words)
            {
                int wordLength = string.length();
                if((lengthTillNow + wordLength) < 50)       //(50 - 1)...1 for space
                {
                    //FirstString = FirstString + " " + string;
                    lengthTillNow += (wordLength + 1);
                }
                else
                {
                    //SecondString = SecondString + " " + string;
                    return lengthTillNow;
                }
            }
            return length;
        }
	public void printRowBackGroundTransaction(List<TransactionData> rowsTransaction) throws IOException {

	boolean odd = true;
        //for(int i=0; i<numRows; i++) {
        for(TransactionData transaction : rowsTransaction) {
            Color strokeColor = new Color(100, 100, 100);
            Dimensions.contents.setStrokingColor(strokeColor);
            Color fillColor = new Color(240, 240, 240);
            Dimensions.contents.setNonStrokingColor(fillColor);
                int rowY = Dimensions.getNextY();
	        if(odd) {
		        Dimensions.contents.addRect(Dimensions.getStartXCol1_trTable() + 1, rowY, Dimensions.getStartXCol6_trTable() + Dimensions.trTable_col6_width - Dimensions.getStartXCol1_trTable(), Dimensions.cell_height);
		        Dimensions.contents.fill();
	        }
                transaction.printPDF(rowY);
        	Dimensions.contents.moveTo(Dimensions.getStartXCol1_trTable(), rowY);
        	Dimensions.contents.lineTo(Dimensions.getStartXCol1_trTable(), rowY + Dimensions.cell_height);
        	Dimensions.contents.moveTo(Dimensions.getStartXCol6_trTable() + Dimensions.trTable_col6_width, rowY);
        	Dimensions.contents.lineTo(Dimensions.getStartXCol6_trTable() + Dimensions.trTable_col6_width, rowY + Dimensions.cell_height);
        	Dimensions.contents.stroke();
			rowY -= Dimensions.cell_height;
                        //transaction.printPDF(rowY);
                        Dimensions.setNextY(rowY);
			odd = !odd;
        }
        Dimensions.setNextY(Dimensions.getNextY() + Dimensions.cell_height);
    	Dimensions.contents.moveTo(Dimensions.getStartXCol1_trTable(), Dimensions.getNextY());
    	Dimensions.contents.lineTo(Dimensions.getStartXCol6_trTable() + Dimensions.trTable_col6_width, Dimensions.getNextY());
    	Dimensions.contents.stroke();
	}
        
        public void printRowBackGround(List<InvoiceRow> rows) throws IOException {
 
        //NOTE here you don't add Rectangle(like the header rectangle)...hence no use of contents.addRect(..) for the whole table
        //Create only horizontal and vertical lines
	boolean odd = true;
        //for(int i=0; i<numRows; i++) {
        for(InvoiceRow invoiceRow : rows) {
                Color strokeColor = new Color(100, 100, 100);
                Dimensions.contents.setStrokingColor(strokeColor);
                Color fillColor = new Color(240, 240, 240);
                Dimensions.contents.setNonStrokingColor(fillColor);
            
                int rowY = Dimensions.getNextY();
	        if(odd) {   //it's not that 'i' is odd..cool logic
                    //Note its NOT 520...bcoz 1 and 1 pixel is used for border line of the row...520-(1+1) = 518.
                    //So..it must be width and height as the 3rd and 4th coordinate
		        //contents.addRect(51, rowY, 518, 20);
                        //this contents.addRect(...) is not for whole table..it's just for even rows(odd ones)..
		        //contents.fill();
                    //just to fill the blue color..this whole if works
                    
                    Dimensions.contents.addRect(Dimensions.getStartXCol1_pdTable() + 1, rowY, Dimensions.getStartXCol7_pdTable() + Dimensions.pdTable_col7_width - Dimensions.getStartXCol1_pdTable() - 2, Dimensions.cell_height);
                    Dimensions.contents.fill();
	        }
                invoiceRow.printPDF(rowY);
                //creating border lines(only 2 vertical line) for that particular row...only at the LHS and RHS
                //LHS border
                //contents.moveTo(50, rowY);
        	//contents.lineTo(50, rowY+20);
        	Dimensions.contents.moveTo(Dimensions.getStartXCol1_pdTable(), rowY);
        	Dimensions.contents.lineTo(Dimensions.getStartXCol1_pdTable(), rowY + Dimensions.cell_height);
                
                //RHS border
        	//contents.moveTo(570, rowY);         //it's (50+520 = 570)
        	//contents.lineTo(570, rowY+20);
                //50 for starting x-coor. of table....520  is the width of the table..
                
                Dimensions.contents.moveTo(Dimensions.getStartXCol7_pdTable() + Dimensions.pdTable_col7_width, rowY);
                Dimensions.contents.lineTo(Dimensions.getStartXCol7_pdTable() + Dimensions.pdTable_col7_width, rowY + Dimensions.cell_height);
        	Dimensions.contents.stroke();
                
			//rowY -= 20;
                        rowY -= Dimensions.cell_height;
                        Dimensions.setNextY(rowY);
			odd = !odd;
                        
        }
        
        //creating one Horizontal line at the end of the table
    	//contents.moveTo(50, rowY+20);
    	//contents.lineTo(570, rowY+20);
        //Dimensions.setNextY(Dimensions.getNextY() + Dimensions.cell_height);
        Dimensions.contents.moveTo(Dimensions.getStartXCol1_pdTable(), Dimensions.getNextY() + Dimensions.cell_height);
    	Dimensions.contents.lineTo(Dimensions.getStartXCol7_pdTable() + Dimensions.pdTable_col7_width,Dimensions.getNextY() + Dimensions.cell_height);
    	Dimensions.contents.stroke();
        Dimensions.setNextY(Dimensions.getNextY() + Dimensions.cell_height);
	}
	
	public void printRowHeader(int headerY) throws IOException {
        Color fillColor = new Color(230, 230, 230);
        Color strokeColor = new Color(100, 100, 100);
        Dimensions.contents.setStrokingColor(strokeColor);
        Dimensions.contents.setNonStrokingColor(fillColor);
        //contents.addRect(50, headerY, 520, 20);     //confirm 570 or 520? Is it Widht of rectangle or the Y-Coordinate on RHS
        //it must be 520..as it is the width..3rd argument
        Dimensions.contents.addRect(Dimensions.x_left_margin_table, headerY, Dimensions.getStartXCol7_pdTable() + Dimensions.pdTable_col7_width - Dimensions.getStartXCol1_pdTable(), Dimensions.cell_height);
        Dimensions.contents.fillAndStroke();

        PDFont font = PDType1Font.HELVETICA;
        PDFPrinter headerPrinter = new PDFPrinter(Dimensions.contents, font, 12);
        headerPrinter.putText(Dimensions.getStartXCol1_pdTable() + 2, headerY+7, "Product Detail ID");
        headerPrinter.putText(Dimensions.getStartXCol2_pdTable(), headerY+7, "Product");
        headerPrinter.putText(Dimensions.getStartXCol3_pdTable(), headerY+7, "Unit Size");
        headerPrinter.putText(Dimensions.getStartXCol4_pdTable(), headerY+7, "Unit Price");
        headerPrinter.putText(Dimensions.getStartXCol5_pdTable(), headerY+7, "Quantity");
        headerPrinter.putText(Dimensions.getStartXCol6_pdTable(), headerY+7, "Discount");
        headerPrinter.putText(Dimensions.getStartXCol7_pdTable(), headerY+7, "Amount");
	}
        
        public void printRowHeaderTransaction(int headerY) throws IOException {
            Color fillColor = new Color(230, 230, 230);
            Color strokeColor = new Color(100, 100, 100);
            Dimensions.contents.setStrokingColor(strokeColor);
            Dimensions.contents.setNonStrokingColor(fillColor);
            //contents.addRect(50, headerY, 520, 20);
            Dimensions.contents.addRect(Dimensions.getStartXCol1_trTable(),headerY,Dimensions.getStartXCol6_trTable() + Dimensions.trTable_col6_width - Dimensions.getStartXCol1_trTable(),Dimensions.cell_height );
            Dimensions.contents.fillAndStroke();

            PDFont font = PDType1Font.HELVETICA;
            PDFPrinter headerPrinter = new PDFPrinter(Dimensions.contents, font, 12);
            headerPrinter.putText(Dimensions.getStartXCol1_trTable() + 2, headerY+7, "Transaction ID");
            headerPrinter.putText(Dimensions.getStartXCol2_trTable(), headerY+7, "Date");
            headerPrinter.putText(Dimensions.getStartXCol3_trTable(), headerY+7, "Time");
            headerPrinter.putText(Dimensions.getStartXCol4_trTable(), headerY+7, "Paid Amount");
            headerPrinter.putText(Dimensions.getStartXCol5_trTable(), headerY+7, "Transaction Mode");
            headerPrinter.putText(Dimensions.getStartXCol6_trTable(), headerY+7, "Status");
	}

	public void printFooter() throws IOException {
        Color strokeColor = new Color(100, 100, 100);
        Dimensions.contents.setStrokingColor(strokeColor);
        Dimensions.contents.addRect(50, 35, 370, 135);
        Dimensions.contents.stroke();

        PDFPrinter footerLabelPrinter = new PDFPrinter(Dimensions.contents, PDType1Font.HELVETICA_BOLD, 8);
        PDFPrinter footerValuePrinter = new PDFPrinter(Dimensions.contents, PDType1Font.HELVETICA, 8);
        footerLabelPrinter.putText(50, 172, "Notes");
        int rowY = 160;
        StringBuilder sb = new StringBuilder();
        for(String s : this.getNotes().split(" ")) {
        	if(footerValuePrinter.widthOfText(sb.toString() + " " + s) > 365) {
	        	if(rowY < 50) {
	        		sb.append("...");
		        	footerValuePrinter.putText(55, rowY, sb.toString());
		        	sb = new StringBuilder();
		        	break;
	        	}
	        	footerValuePrinter.putText(55, rowY, sb.toString());        	
	        	rowY -= 10;
	        	sb = new StringBuilder();
        	}        	
        	sb.append(s);
        	sb.append(" ");
        }
    	footerValuePrinter.putText(55, rowY, sb.toString());        	
	}

	public List<InvoiceRow> getRows() {
		return this.rows;
	}
    public void addRow(InvoiceRow row) {
        this.rows.add(row);
    }
    
    public void addRowTransaction(TransactionData row) {
        this.rowsTransaction.add(row);
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return this.notes;
    }

    private void setOverallDiscount(String OverallDiscount) {
        this.OverallDiscount = Float.parseFloat(OverallDiscount);
    }

    private void setBalance(String Balance) {
        this.Balance = Float.parseFloat(Balance);
    }

    private void setTotal(String Total) {
        this.Total = Float.parseFloat(Total);
    }

    private void setSubTotal(String SubTotal) {
        this.SubTotal = Float.parseFloat(SubTotal);
    }

    private void setAmountInWords(String AmountInWords) {
        this.AmountInWords = AmountInWords + "Rupees Only";
    }

    public String getOrderID() {
        return OrderDetails.getOrderID();
    }

    public String generateInvoiceID() {
        return IDGenerator.getIDforInvoice();
    }

    public String getCustomerID() {
        return CustomerDetails.getCustomerID();
    }

   
}