package main.java.org.example.invoice;

import java.awt.Desktop;
import java.awt.HeadlessException;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import java.io.*;
import main.java.org.example.invoice.document.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import main.java.org.example.invoice.document.Invoice;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class App 
{
    public App()
    {
        PDDocument pdfDocument = new PDDocument();
    	try {
	    	JSONObject jsonDocument = 
	    		(JSONObject)JSONValue.parse(new FileReader(new File("receipt.json")));
               
	    	//Invoice invoice = new Invoice(jsonDocument);

/*
            "first": "季",
            "last": "睿杰"
*/

            PDPage pdfPage = new PDPage();
            pdfDocument.addPage(pdfPage);
            //PDPageContentStream contents = new PDPageContentStream(pdfDocument, pdfPage);
            Dimensions.contents = new PDPageContentStream(pdfDocument, pdfPage);
            Dimensions.pdfDocument = pdfDocument;
            Invoice invoice = new Invoice(jsonDocument);
            //invoice.printPDF(contents);            
            invoice.printPDF();
            
            String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            //System.out.println(path);
            path += "/BABA_HARDWARES";
            path += "/RECEIPTS";
            path += "/" + invoice.getCustomerID();
            path += "/" + invoice.getOrderID();
            
            Path path1 = Paths.get(path);
            //if directory exists?
            if (!Files.exists(path1)) {
                try {
                    Files.createDirectories(path1);
                } catch (IOException e) {
                    //fail to create directory
                    JOptionPane.showMessageDialog(null,"Could not save the Receipt : " + e.getMessage());
                }
            }
            
            String filePath = path + "/" + invoice.generateInvoiceID() + ".pdf";
            pdfDocument.save(filePath);
            
            
            try {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(new File(filePath));       //"./target/single-invoice.pdf"
                } else {
                    JOptionPane.showMessageDialog(null, "PDF Open is not supported");
                    //System.out.println("Open is not supported");
                }
            } catch (IOException exp) {
                JOptionPane.showMessageDialog(null,"Problem Opening PDF : " + exp);
            }
           /* SwingController controller = new SwingController();
            SwingViewBuilder factory = new SwingViewBuilder(controller); 
            JPanel viewerComponentPanel = factory.buildViewerPanel();
            // optional open a document
            controller.openDocument("./target/single-invoice.pdf");*/
    	} catch (HeadlessException | IOException e) {
    		e.printStackTrace();
        } finally {
            try {
                pdfDocument.close();    
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    
    public static void main( String[] args )
    {
        App a = new App();
    }
}
