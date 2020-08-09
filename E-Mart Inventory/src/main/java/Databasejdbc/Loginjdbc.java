package Databasejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Loginjdbc {
	public String loginValidation(String uname,String pass){

        try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");

                String query="select uname from login where uname=? and pass=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1,uname);
                pstmt.setString(2,pass);
                ResultSet rs=pstmt.executeQuery();
                boolean check=false;
                boolean check1=false;
                if(rs.next()){
                	if((rs.getString("uname")).compareTo("maker")==0){
                    check=true;
                }
                else if((rs.getString("uname")).compareTo("checker")==0){
                  check1=true;
                }
                }
                con.setAutoCommit(true);
                con.close();
                if(check)
                   return "successMaker";
                   else if(check1)
                	   return "successChecker";
                   else
                	   return "failed";
        }
        catch(Exception ex){
             return  "Exception------------------------>  "+ex;
        }
    }
	
	
	

}
