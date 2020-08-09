package Databasejdbc;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class UploadFileDB {
    public static final String SAMPLE_CSV_FILE_PATH = "d:\\vir\\temp.csv";

	   public String fileupload() {
	        try {
	            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
	            CSVReader csvReader = new CSVReader(reader);
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");
	                String query="insert ignore into products values(?,?,?,?,?,?,?,?,'N',NULL,'N','N')";
	                PreparedStatement pstmt=con.prepareStatement(query);
	                String[] nextRecord;
	                nextRecord=csvReader.readNext();
	                while ((nextRecord = csvReader.readNext()) != null) {
	                	pstmt.setString(1,nextRecord[0]);
	                	pstmt.setString(2,nextRecord[1]);
	                	pstmt.setString(3,nextRecord[2]);
	                	pstmt.setString(4,nextRecord[3]);
	                	pstmt.setString(5,nextRecord[4]);
	                	pstmt.setString(6,nextRecord[5]);
	                	pstmt.setString(7,nextRecord[6]);
	                	pstmt.setString(8,nextRecord[7]);
	                	pstmt.executeUpdate();
	            	
	                System.out.println("Name : " + nextRecord[0]);
	                System.out.println("Email : " + nextRecord[1]);
	                System.out.println("Phone : " + nextRecord[2]);
	                System.out.println("Country : " + nextRecord[3]);
	                System.out.println("==========================");
	            }

                con.setAutoCommit(true);
                con.close();
	            return "SUCCESS";
	        
	    }
	        catch(Exception ex){
	            return  "Exception------------------------>  "+ex;
	        
	}}}


