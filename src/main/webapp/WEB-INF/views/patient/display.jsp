<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Email Id</td>
			<td>${sessionScope.patient.email}</td>
		</tr>
		<tr>
			<td>Registration No</td>
			<td>${sessionScope.patient.registraionNo}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${sessionScope.patient.name}</td>
		</tr>
		<tr>
			<td>Date Of Birth</td>
			<td>${sessionScope.patient.dob}</td>
		</tr>
		<tr>
			<td>Contact No</td>
			<td>${sessionScope.patient.contactNo}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${sessionScope.patient.address}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${sessionScope.patient.bloodGroup}</td>
		</tr>
	</table>
</body>
</html>