package Databasejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import checker.Barcode;
public class BarcodeDB {
	
   
	public String UpdateDBUpload()
	{
		try
		{
			String x="";
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");
            String query="select ID from products where barcode is NULL ";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {	
            	x=rs.getString("ID");
            	Barcode b=new Barcode();
                b.generateEAN13BarcodeImage(x);
                String q="update products set barcode = load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/temp.png') where ID=?";
        		PreparedStatement p1=con.prepareStatement(q);
        		p1.setString(1,x);
        		p1.executeUpdate();
            }
            return "Success";
		}
		 catch (Exception ex) {
         	System.out.println("failed"+ ex);
         	return "failed";
	}
	
	}
	
		
		
		
	}


