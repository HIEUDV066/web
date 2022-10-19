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
	<h3 style="color: red">${error}</h3>
	<form action="add">
		enter id:<input type="number" name="id"/><br/>
		enter name:<input type="text" name="name"/><br/>
		enter describle:<input type="text" name="describle"/><br/>
		<input type="submit" value="SAVE"/><br/>
	</form>
</body>
</html>