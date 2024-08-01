<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userlogin</title>
</head>
<body>

<form action="ulogin" method="post">
Email:<input type="email" name="usermail">
Password:<input type="text" name="userpassword">
<input type="submit">

<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>



</body>
</html>