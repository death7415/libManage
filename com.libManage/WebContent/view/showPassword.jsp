<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.ArrayList"%>
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
} 

@SuppressWarnings("unchecked")
ArrayList<String> alist=(ArrayList<String>)httpSession.getAttribute("array");


%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Info</title>
</head>
<body onload="func()">

			<%if(alist.isEmpty()){
			out.println("<h2>Invalid Entered Data,Please check your data<br></br>1. Either invalid Username or Email.<br></br>2. Either Invalid Father's/Mother's Name.<br></br>3. Either Invalid Unique Id.<h2><br></br><p>*redirecting you in 15 sec..</p>");
			httpSession.removeAttribute("data");
			httpSession.removeAttribute("array");
			httpSession.invalidate();
			
			}
			
			else{
				out.println("<h5>User Name :'"+alist.get(0)+"'<br></br>Password :'"+alist.get(1)+"'</h5><br></br><p>*redirecting you in 15 sec..</p>");
				httpSession.removeAttribute("data");
				httpSession.removeAttribute("array");
				httpSession.invalidate();
			}
			
			%>
<script>
function func(){
	 setTimeout(function(){ location.replace("../index.html")}, 15000);
}
</script>
</body>

</html>