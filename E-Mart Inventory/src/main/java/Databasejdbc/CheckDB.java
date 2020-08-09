package Databasejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CheckDB {
	public String dbcheck(int[] a,int n){

        try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");
                String query="select * from products where checkstatus='N' ";
                String q1="update products set checkstatus='Y',expired='N' where ID=?";
                String q2="update products set checkstatus='Y',expired='Y' where ID=?"; 
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                PreparedStatement p1=con.prepareStatement(q1);
                PreparedStatement p2=con.prepareStatement(q2);
                
                //rs.next();
                int i=0;
                while(rs.next())
                {
                	if(a[i]==1)
                	{
                		p1.setString(1,rs.getString(1));
                		int rows=p1.executeUpdate();
                	}
                	else
                	{
                		p2.setString(1, rs.getString(1));
                		int r=p2.executeUpdate();
                	}
                }
                con.setAutoCommit(true);
                con.close();
                return "success";
                
        
        
        }
        catch(Exception ex){
            return  "Exception------------------------>  "+ex;
        
	
	}}}