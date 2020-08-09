package Databasejdbc;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 

import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.Table;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DistributorInvoice {
	public String generateDistInvoice()
	{
		try
		{
			String q="Y";
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");

            String query="select ID,VendorCode,ProdCategory,prodDesc,Count,Cost,Currency from products where checkstatus = 'Y'; ";
            //PreparedStatement pstmt=con.prepareStatement(query);
            //pstmt.setString(1,q);
           // PrintWriter out = response.getWriter();
            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

		String dest = "d:/vir/addingTable.pdf";   
	      PdfWriter writer = new PdfWriter(dest);       
	         
	      // Creating a PdfDocument object      
	      PdfDocument pdf = new PdfDocument(writer);                  
	      
	       // Creating a Document object        
	      Document doc = new Document(pdf);                       
	         
	      // Creating a table       
	      float [] pointColumnWidths = {150F, 150F, 150F,150F,150F,150F,150F};   
	      Table table = new Table(pointColumnWidths); 
	      table.addCell(new Cell().add("ID"));
	      table.addCell(new Cell().add("Vendor Code"));
	      table.addCell(new Cell().add("Product Category"));
	      table.addCell(new Cell().add("Product Description"));
	      table.addCell(new Cell().add("Count"));
	      table.addCell(new Cell().add("Cost"));
	      table.addCell(new Cell().add("Currency"));
	      /*if(rs.next())
	      {
	      table.addCell(new Cell().add(rs.getString("ID")));
	      table.addCell(new Cell().add("hi"));
	      }
	      else
	    	  System.out.println("empty");*/
	     while(rs.next())
	      {
	    	  table.addCell(new Cell().add(rs.getString("ID")));
	    	  table.addCell(new Cell().add(rs.getString("VendorCode")));
	    	  table.addCell(new Cell().add(rs.getString("ProdCategory")));
	    	  table.addCell(new Cell().add(rs.getString("ProdDesc")));
	    	  table.addCell(new Cell().add(rs.getString("Count")));
	    	  table.addCell(new Cell().add(rs.getString("Cost")));
	    	  table.addCell(new Cell().add(rs.getString("Currency")));
	      }
	      doc.add(table); 
	      doc.close();
	      con.setAutoCommit(true);
	      con.close();
	      System.out.println("Table created successfully..");   
	      return("Success");
	      
	}
		catch(Exception ex){
            return  "Exception------------------------>  "+ex;

}}}
