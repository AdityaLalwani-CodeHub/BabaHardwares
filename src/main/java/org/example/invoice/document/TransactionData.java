package main.java.org.example.invoice.document;

//import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.json.simple.JSONObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.awt.Color;
import main.java.org.example.invoice.PDFPrinter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

public class TransactionData {
        private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String transactionID;
	private String date;
        private String time;
	private String paidAmount;
        private String transactionMode;
        private String status;

    public TransactionData(JSONObject jsonShippingData) {
        if(jsonShippingData.containsKey("transactionID")) {
            this.setTransactionID((String)jsonShippingData.get("transactionID"));
        }
        if(jsonShippingData.containsKey("date")) {
            this.setdate((String)jsonShippingData.get("date"));
        }
        if(jsonShippingData.containsKey("time")) {
            this.settime((String)jsonShippingData.get("time"));
        }
        if(jsonShippingData.containsKey("paidAmount")) {
            this.setpaidAmount((String)jsonShippingData.get("paidAmount"));
        }
        if(jsonShippingData.containsKey("transactionMode")) {
            this.settransactionMode((String)jsonShippingData.get("transactionMode"));
        }
        if(jsonShippingData.containsKey("status")) {
            this.setstatus((String)jsonShippingData.get("status"));
        }
    }


    /*public void printPDF(PDPageContentStream contents) throws IOException {        
        
        Color fillColor = new Color(230, 230, 230);
        Color strokeColor = new Color(100, 100, 100);
        contents.setStrokingColor(strokeColor);
        contents.setNonStrokingColor(fillColor);
        contents.addRect(50, 570, 520, 20);
        contents.fillAndStroke();
        contents.addRect(50, 550, 520, 20);
        contents.stroke();

        final int headerY = 577;
        PDFont font = PDType1Font.HELVETICA;
        PDFPrinter headerPrinter = new PDFPrinter(contents, font, 12);
        headerPrinter.putText(60, headerY, "Ship. number");
        headerPrinter.putText(160, headerY, "Sales Rep.");
        headerPrinter.putText(280, headerY, "Ship date");
        headerPrinter.putText(340, headerY, "Ship via");
        headerPrinter.putText(450, headerY, "Terms");
        headerPrinter.putText(510, headerY, "Due date");

        final int textY = 557;
        PDFPrinter textPrinter = new PDFPrinter(contents, font, 8);
        textPrinter.putText(60, textY, this.getShipNumber());
        textPrinter.putText(160, textY, this.getSalesRep());
        textPrinter.putText(280, textY, this.getShipDateString());
        textPrinter.putText(340, textY, this.getShipVia());
        textPrinter.putText(450, textY, this.getTerms());
        textPrinter.putText(510, textY, this.getDueDateString());
    }*/
    
    public void printPDF(int rowY) throws IOException {        
        Color strokeColor = new Color(100, 100, 100);
        Dimensions.contents.setStrokingColor(strokeColor);
        
        PDFont font = PDType1Font.HELVETICA;
        PDFPrinter textPrinter = new PDFPrinter(Dimensions.contents, font, 8);
        textPrinter.putText(Dimensions.getStartXCol1_trTable() + 2, rowY+7, transactionID);
        textPrinter.putText(Dimensions.getStartXCol2_trTable(), rowY+7, date);
        textPrinter.putText(Dimensions.getStartXCol3_trTable(), rowY+7, time);
        textPrinter.putText(Dimensions.getStartXCol4_trTable(), rowY+7, paidAmount); //putText or putTextToTheRight???
        textPrinter.putText(Dimensions.getStartXCol5_trTable(), rowY+7, transactionMode);
        textPrinter.putText(Dimensions.getStartXCol6_trTable(), rowY+7, status);
    }

    private void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    private void setdate(String date) {
        this.date = date;
    }

    private void settime(String time) {
        this.time = time;
    }

    private void setpaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    private void settransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    private void setstatus(String status) {
        this.status = status;
    }

}