<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Khai báo</title>
</head>
<body>
	<h1>DECLARATION MANAGER</h1>
	
	<hr>
	
	<table border="1" style="width: 100%">
		<tr>
			<th>ID</th>	
			<th>Họ và tên</th>		
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Phương tiện</th>
			<th>Ngày</th>
			<th>Sửa</th>
		</tr>
	
		
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.id}</td>
				<td>${s.personalId.fullName}</td>
				<td>${s.phone}</td>
				<td>${s.personalId.idAddress.addressName}</td>
				<td>${s.nameVehicle}</td>
				<td>${s.date}</td>				
				<td><a href="edit-declaration.htm?id=${s.id }">Sửa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>