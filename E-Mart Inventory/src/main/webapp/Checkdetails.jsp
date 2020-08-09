<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="Dashboard.css">
    <style type="text/css">
        
        .col-3      {background-color: #9999ff;
            position: absolute;
            width: 240px;
            height:100%;
            color: red;
            /*min-height: calc(100vh-50px);*/
        }
        
        .nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    color: #fff;
    background-color: #000;
}
    .nav-link 
    {
        color: #000;
        margin-left: 10px;
    }
    .col-9
    {
        /*position: absolute;*/
        color:red;
        margin-left: 250px;
        text-align: center;
    }



    </style>

</head>
<body>
<div class="row">
  <div class="col-3 ">
    <div class=" nav flex-column nav-pills" id="colv-pills-tab" role="tablist" aria-orientation="vertical">
      <br><a class="nav-link" id="v-pills-home-tab" data-toggle="pill p-2" href="Home.html" role="tab" aria-controls="v-pills-home p-2" aria-selected="true">Home</a><br>
      <!-- <a class="nav-link active black" id="v-pills-Upload File-tab" data-toggle="pill p-2" href="UploadDetails.html" role="tab" aria-controls="v-pills-Upload File" aria-selected="true">Upload File</a><br>-->
      <a class="nav-link disabled" id="v-pills-Check Details-tab" data-toggle="pill p-2" href="Checkdetails.jsp" role="tab" aria-controls="v-pills-Check Details" aria-selected="true">Check Details</a><br>
      <a class="nav-link" id="v-pills-View Details-tab" data-toggle="pill p-2" href="Viewdetails.jsp" role="tab" aria-controls="v-pills-View Details" aria-selected="true">View Details</a><br>
    </div>
  </div>
  
</div>
<div class=checktable>
<table>
<%
try{

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjai","root","password");

    String query="select ID,VendorCode,ProdCategory,ProdDesc,Count,Cost,Currency,ProdExpiryDate from products where checkstatus='N' ";
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery(query);
    %>
    <form action="CheckUpdateServ" method="post">
    <table border=1 align=center style="text-align:center" class="table table-hover table-dark">
      <thead>
          <tr>
             <th scope="col">ID</th>
             <th scope="col">vendorcode</th>
             <th scope="col">prodcategory</th>
             <th scope="col">proddesc</th>
             <th scope="col">count</th>
             <th scope="col">cost</th> 
             <th scope="col">currency</th>
             <th scope="col">prodexpirydate</th>
             <th scope="col">check status</th>
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getString("ID") %></td>
                <td><%=rs.getString("vendorcode") %></td>
                <td><%=rs.getString("prodcategory") %></td>
                <td><%=rs.getString("proddesc") %></td>
                <td><%=rs.getString("count") %></td>
                <td><%=rs.getString("cost") %></td>
                <td><%=rs.getString("currency") %></td>
                <td><%=rs.getString("prodexpirydate") %></td>
                <td><div class="form-check">
                <input type="hidden" name="checkid" value=0>
    <input type="checkbox" class="form-check-input" name="checkid" value="1" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div></td>
            </tr>
            <%}%>
           </tbody>
           
        </table>
       <div class="sendinvoice">
        <input type="submit" value="Confirm the details?">
        </form><br>
         </div>
    <%}
catch(Exception e)
{
    e.printStackTrace();
    }
%>

</body>
</html>