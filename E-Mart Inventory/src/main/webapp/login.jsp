<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>"E-Mart Login"</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- <link rel="stylesheet" href="login.css"> -->
<style type="text/css">
body
{
	margin:0;
	padding:0;

}
.material-icons
{	
	text-align: center;
	width:100%;
	font-size: 35px;
	color: black;
}
.box
{
	position:absolute;
	top:50%;
	left:50%;
	transform: translate(-50%,-50%);
	 margin-bottom: 30px; 
	border-style: solid;
	border-color: #fff;
	padding-top:20px;
	 padding-bottom: 40px; 
	padding-left: 40px;
	padding-right: 40px; 
	background-color: #ffff;

	box-sizing: border-box;
	box-shadow: 0 15px 25px rgba(0,0,0,0.5);
        border-radius: 10px;
}
.box 	input
{
	margin-top: 7px;
}
.inpbox
{
	margin-bottom:50px;

}
.inpbox input[type='text']::placeholder
    {   
        text-align: center;      
    }
 .inpbox input[type='password']::placeholder
    {
    	text-align: center;
    }
    .inpbox input
    {
    	border-color:  #e6e6e6;
    	background-color:  #e6e6e6;
    	border-style: solid;
    	border-radius: 4px;
    	width: 200px;
    	
    }
.box input[type="submit"]
{
	background-color: #00BFFF;
	border-color: #00BFFF;
	text-align: center;
	width:100px;
	margin:7px 50%;
	position:absolute;
	left:-50px;
	border-radius: 4px;
	color: #fff;
	font-family:inherit;
	/*font-size: 10px;*/
	margin-top: 15px;
}
.fp{
	position:absolute;
	top:83%;
	left:50%;
	transform: translate(-50%,-50%);
	 margin-bottom: 20px; 
	border-style: solid;
	border-color: 	 #ececf9;
	padding-top:10px;
	 padding-bottom: 20px; 
	padding-bottom: 5px;  
	/*padding-left: 68px;*/
	/*padding-right: 70px; */
	background-color: 	 #ececf9;
	border-radius:1px 1px 10px 10px;
	width: 285px;
	margin-top: 20px;
	
	text-align: center;
}
.fp a
{
	color:#00ace6;		
	text-decoration: none;
}

</style>
</head>
<body>
	
<div class="box">
	<div class="material-icons md-48">account_circle</div>
	<form action="Login" method="post">
		<div class="inpbox">
	<input type="text" placeholder="login"  name="uname"><br>
	<input type="password" placeholder="password" name="pass"  ><br>
	<%
if(request.getAttribute("output")!=null)
	out.println(request.getAttribute("output"));
%><br>
	<input type="submit" value="LOG IN">
	
<div class="fp">
	<a href="forgotpw.html">Forgot Password?</a>
</div>
</div>

</form>


</div>
</body>
</html>