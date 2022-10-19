<%@page import="model.phone"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add a new Phone</h1>
	<%
		if(request.getAttribute("phone")!= null){
			phone p= (phone) request.getAttribute("phone");
	%>	
	<form action="update" method="post">
		enter id:<input type="number" readonly name="id" value="<%= p.getId()%>"/><br/>
		enter name:<input type="text" name="name" value="<%= p.getName()%>" /><br/>
		enter describle:<input type="text" name="describle" value="<%= p.getDescrible()%>" /><br/>
		<input type="submit" value="SAVE"/><br/>
	</form>
	<%
		}
	%>
</body>
</html>