<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Tiêu đề</title>
	<base href = "${pageContext.servletContext.contextPath }/">
</head>
<body>
	<h3>THÔNG TIN</h3>
	<ul>
		<li>HỌ VÀ TÊN: ${user.fullName}</li>
		<li>SỐ ĐIỆN THOẠI: ${user.phone}</li>
		<li>ĐỊA CHỈ: ${user.idAddress.addressName}</li>
		<li>NGÀY: ${date}</li>
		<li>QUỐC TỊCH: ${user.nationality}</li>
	</ul>
</body>
</html>