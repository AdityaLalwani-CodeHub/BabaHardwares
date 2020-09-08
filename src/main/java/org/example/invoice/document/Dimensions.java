/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.org.example.invoice.document;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

/**
 *
 * @author Aditya
 */
public class Dimensions {
    public static PDDocument pdfDocument;
    public static PDPageContentStream contents;
    public static int x_left_margin_table = 25;
    public static int table_width = 560;    //For both..transaction_table and product_table
    public static int cell_height = 20;
    
    public static int pdTable_col1_width = 140;
    public static int pdTable_col2_width = 90;
    public static int pdTable_col3_width = 75;
    public static int pdTable_col4_width = 60;
    public static int pdTable_col5_width = 60;
    public static int pdTable_col6_width = 60;
    public static int pdTable_col7_width = 80;
    
    public static int trTable_col1_width = 140;
    public static int trTable_col2_width = 70;
    public static int trTable_col3_width = 70;
    public static int trTable_col4_width = 90;
    public static int trTable_col5_width = 110;
    public static int trTable_col6_width = 85;
    
    public static int y_top_margin_trTable = 600;
    public static int y_bottom_margin = 50;
    private static int initialNextY;       //After Header
    private static int nextY;
    
    public static int gap_Y_Header_Customer = 10;
    public static int gap_Y_Customer_TrTable = 20;
    public static int gap_Y_TrTable_PdTable = 10;
    public static int gap_Y_PdTable_Summary = 10;   //Summary -> SubTotal,overall Discount , Total , Balance , AmountInWords,Terms and condition
    
    public static void initialiseNextY()
    {
        initialNextY = nextY = 670;
    }
    
    
    public static boolean newPageRequired(int nextSize) {
		if(nextY < y_bottom_margin)
                    return true;
                if(nextY < nextSize)
                    return true;
                return false;
    }
    
    public static void setNextY(int y) throws IOException
    {
        nextY = y;
        if(y < y_bottom_margin)
        {
            contents.close();
            PDPage pdfPage = new PDPage();
            pdfDocument.addPage(pdfPage);		
            contents = new PDPageContentStream(pdfDocument, pdfPage);
            Invoice.header.printPDF();
            nextY = initialNextY;
        }
    }
    
    public static int getNextY()
    {
        return nextY;
    }
    
    public static void resetNextY()
    {
        nextY = initialNextY;
    }
    
    public static int getStartXCol1_pdTable()
    {
        return x_left_margin_table;
    }
    
    public static int getStartXCol2_pdTable()
    {
        return getStartXCol1_pdTable() + pdTable_col1_width;
    }
    
    public static int getStartXCol3_pdTable()
    {
        return getStartXCol2_pdTable() + pdTable_col2_width;
    }
    
    public static int getStartXCol4_pdTable()
    {
        return getStartXCol3_pdTable() + pdTable_col3_width;
    }
    
    public static int getStartXCol5_pdTable()
    {
        return getStartXCol4_pdTable() + pdTable_col4_width;
    }
    
    public static int getStartXCol6_pdTable()
    {
        return getStartXCol5_pdTable() + pdTable_col5_width;
    }
    
    public static int getStartXCol7_pdTable()
    {
        return getStartXCol6_pdTable() + pdTable_col6_width;
    }
    
    public static int getStartXCol1_trTable()
    {
        return x_left_margin_table;
    }
    
    public static int getStartXCol2_trTable()
    {
        return getStartXCol1_trTable() + trTable_col1_width;
    }
    
    public static int getStartXCol3_trTable()
    {
        return getStartXCol2_trTable() + trTable_col2_width;
    }
    
    public static int getStartXCol4_trTable()
    {
        return getStartXCol3_trTable() + trTable_col3_width;
    }
    
    public static int getStartXCol5_trTable()
    {
        return getStartXCol4_trTable() + trTable_col4_width;
    }
    
    public static int getStartXCol6_trTable()
    {
        return getStartXCol5_trTable() + trTable_col5_width;
    }
}
