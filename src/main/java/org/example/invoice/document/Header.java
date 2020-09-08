package main.java.org.example.invoice.document;

import org.json.simple.JSONObject;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import main.java.org.example.invoice.PDFPrinter;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.awt.Color;
import java.io.IOException;

public class Header {
    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String InvoiceDate;
	private String InvoiceTime;     //Expect json file generator program to calculate and give it
        private String GSTIN;
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String OrganisationName;
        private String LogoFilePath;
        private String Phone;
        private String Email;
        
    public Header(JSONObject jsonHeader) {
        if(jsonHeader.containsKey("invoiceDate")) {
            this.setInvoiceDate((String)jsonHeader.get("invoiceDate"));
        }
        if(jsonHeader.containsKey("invoiceTime")) {
            this.setInvoiceTime((String)jsonHeader.get("invoiceTime"));
        }
        if(jsonHeader.containsKey("GSTIN")) {
            this.setGSTIN((String)jsonHeader.get("GSTIN"));
        }
        if(jsonHeader.containsKey("OrganisationName")) {
            this.setOrganisationName((String)jsonHeader.get("OrganisationName"));
        }
        if(jsonHeader.containsKey("addressLine1")) {
            this.setaddressLine1((String)jsonHeader.get("addressLine1"));
        }
        if(jsonHeader.containsKey("addressLine2")) {
            this.setaddressLine2((String)jsonHeader.get("addressLine2"));
        }
        if(jsonHeader.containsKey("addressLine3")) {
            this.setaddressLine3((String)jsonHeader.get("addressLine3"));
        }
        if(jsonHeader.containsKey("LogoFilePath")) {
            this.setLogoFilePath((String)jsonHeader.get("LogoFilePath"));
        }
        if(jsonHeader.containsKey("Phone")) {
            this.setPhone((String)jsonHeader.get("Phone"));
        }
        if(jsonHeader.containsKey("Email")) {
            this.setEmail((String)jsonHeader.get("Email"));
        }
    }

    public void printPDF() throws IOException { 
        //JOptionPane.showMessageDialog(null,getClass().getResource("/images/logo.jpg").getFile().replace("file:","").replace("jar:","").replace("!","").substring(1));
    /*    ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        Image img = icon.getImage();

        BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.SCALE_SMOOTH);

        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        ImageIO.write(bi, "jpg", new File("img.jpg"));*/
    
    /*    File image = new File("img.jpg");
        
        
        try
        {
            if(!image.exists())
            {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.jpg"));
                Image img = icon.getImage();

                BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.SCALE_SMOOTH);

                Graphics2D g2 = bi.createGraphics();
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                ImageIO.write(bi, "jpg", new File("img.jpg"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem generating logo : " + ex.getMessage());
        }
    */
        PDImageXObject pdImage = PDImageXObject.createFromFile("img.jpg", Dimensions.pdfDocument);
        final float width = 60f;
        final float scale = width / pdImage.getWidth();
        Dimensions.contents.drawImage(pdImage, 50, 690, width, pdImage.getHeight()*scale);


        PDFont headerFont = PDType1Font.HELVETICA;
        PDFPrinter headerPrinter = new PDFPrinter(Dimensions.contents, headerFont, 16);
        headerPrinter.putText(120, 750, OrganisationName);
        
        int next_y_header = 739;
        PDFont font = PDType1Font.HELVETICA;
        PDFPrinter textPrinter = new PDFPrinter(Dimensions.contents, font, 10);
        if(!addressLine1.equals("") || !(addressLine1.toLowerCase().equals("null")) || !(addressLine1 != null) )
        {
            textPrinter.putText(120, next_y_header,addressLine1);
            next_y_header -= 11;
        }
        if(!addressLine2.equals("") || !(addressLine2.toLowerCase().equals("null")) || !(addressLine2 != null) )
        {
            textPrinter.putText(120, next_y_header,addressLine2);
            next_y_header -= 11;
        }
        if(!addressLine3.equals("") || !(addressLine3.toLowerCase().equals("null")) || !(addressLine3 != null) )
        {
            textPrinter.putText(120, next_y_header,addressLine3);
            next_y_header -= 11;
        }
        if(!Phone.equals("") || !(Phone.toLowerCase().equals("null")) || !(Phone != null)
             ||   !Email.equals("") || !(Email.toLowerCase().equals("null")) || !(Email != null))
        {
            textPrinter.putText(120,next_y_header,Phone + " " + Email);
            next_y_header -= 11;
        }
        if(!GSTIN.equals("") || !(GSTIN.toLowerCase().equals("null")) || !(GSTIN != null) )
        {
            textPrinter.putText(120, next_y_header,GSTIN);
        }
        Color color = new Color(200, 200, 200);
        PDFPrinter invoiceHeaderPrinter = new PDFPrinter(Dimensions.contents, font, 24, color);
        invoiceHeaderPrinter.putText(450, 740, "INVOICE");     

        textPrinter.putText(400, 710, "Invoice Date:");
        textPrinter.putText(400, 698, "Invoice Time:");
        textPrinter.putText(500, 710, InvoiceDate);
        textPrinter.putText(500, 698, InvoiceTime);
        
        Dimensions.contents.moveTo(Dimensions.x_left_margin_table, 690);
        Dimensions.contents.lineTo(Dimensions.x_left_margin_table + 565, 690);
    }

    private void setInvoiceDate(String InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    private void setInvoiceTime(String InvoiceTime) {
        this.InvoiceTime = InvoiceTime;
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

    private void setLogoFilePath(String LogoFilePath) {
        this.LogoFilePath = LogoFilePath;
    }

    private void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    private void setPhone(String Phone) {
        this.Phone = Phone;
    }

    private void setEmail(String Email) {
        this.Email = Email;
    }
}