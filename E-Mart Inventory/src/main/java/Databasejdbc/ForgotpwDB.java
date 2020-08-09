package Databasejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgotpwDB {
	
	public String checkdbemail(String mail)
	{
		try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");

            String query="select pass from login where email=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,mail);
            /*pstmt.setString(2,pass);*/
            ResultSet rs=pstmt.executeQuery();
            boolean check=false;
            String pass="";
            //boolean check1=false;
            if(rs.next()){
            	pass=rs.getString("pass");
            	check=true;
            }
            con.setAutoCommit(true);
            con.close();
            if(check)
            	return pass;
            else
            	return "fails";
		}
    catch(Exception ex){
         return  "Exception------------------------>  "+ex;
    }
}
	}
	
	


