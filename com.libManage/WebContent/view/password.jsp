<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

HttpSession httpSession=request.getSession();
if(httpSession.getAttribute("data")==null){
	response.sendRedirect("forgot.html");
} %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Step 2 ${data}</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="icon" href="images/icon.jpg"/>
	<link rel="stylesheet" href="../css/password.css"/>
	<script src="../js/password.js"></script>
</head>
<body onload="open()">

<div class="form-popup" id="myForm">
  <form   id="test" action="../Password" class="form-container" method="post" >
    <h1>Step 2</h1>

    <label for="email"><b>Father's/Mother's Name</b></label>
    <input type="text" placeholder="Enter Father's/Mother's Name" name="fm_name" required/>

    <label for="psw"><b>Unique Id</b></label>
    <input type="text" placeholder="Enter Unique Id" name="uid" required/>

    <button type="submit" class="btn">Get Password</button>
    <button type="button" class="btn cancel" onclick="closeForm('POST')">Close</button>
  </form>
</div>

</body>
</html>