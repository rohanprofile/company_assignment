<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="display" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Patient Details</td>
				<td><input type="email" name="email" /></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
	<c:forEach var="item" items="${requestScope.list}">
		<h4>${item.name} ${item.registraionNo} ${item.dob} ${item.address} ${item.contactNo} ${item.bloodGroup} <a href="display?email=${item.email}">view</a>&nbsp<a href="delete?email=${item.email}">delete</a></h4>
	</c:forEach>
</body>
</html>