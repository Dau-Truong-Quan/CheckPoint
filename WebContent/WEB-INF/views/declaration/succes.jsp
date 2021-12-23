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
		<li>HỌ VÀ TÊN: ${name}</li>
		<li>SỐ ĐIỆN THOẠI: ${phone}</li>
		<li>ĐỊA CHỈ: ${address}</li>
		<li>NGÀY: ${date}</li>
		<li>CMND/CCCD: ${IDCard}</li>
	</ul>
</body>
</html>