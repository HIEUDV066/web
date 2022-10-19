<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of student</h1>
	<table border="1px">
		<tr>
		 	<th>ID</th>
		 	<th>Name</th>
		 	<th>Gender</th>
		 	<th>Age</th>
		 </tr>
		 <%
		 	List<Student> list=(List<Student>) request.getAttribute("data");
		 	for (Student i:list){
		 %>
		 <tr>
		 	<td><%= i.getId() %> </td>
		 	<td><%= i.getName()%> </td>		 	
		 	<td><%= i.getAge()%> </td>
		 </tr>
		 <% 
			
		 	}
		 %>
	</table>
</body>
</html>