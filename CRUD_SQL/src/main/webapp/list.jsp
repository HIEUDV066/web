
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript">
		function doDelete(id){
			if(confirm("are you sure to delete phone with id="+id+" ?")){
				window.location="delete?id="+id;
			}
		}
	</script>

</head>
<body>
	<h1>List of phone</h1>
	<h3><a href="new.jsp">Addnew</a></h3>
	<table border="1px">
		<tr>
			<th>ID</th>
			<th>name</th>
			<th>Describle</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${requestScope.data}" var="i">
		<tr>
			<td>${i.id }</td>
			<td>${i.name }</td>
			<td>${i.describle }</td>
			<td>
				<a href="#" onclick="doDelete('${i.id }')">Delete</a>&nbsp;&nbsp;&nbsp;
				<a href="update?id=${i.id }">Update</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>