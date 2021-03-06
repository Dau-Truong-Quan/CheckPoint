<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liên hệ</title>
	<base href="/Checkpoint/">
	<style type="text/css">
		{
	margin: 0;
	padding: 0;
}

body {
	margin: 20px 0;
	background: #F5F5F5;
}

body, th, td, input, textarea {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #666666;
}

form {
}

fieldset {
}

input, textarea {
	font-weight: bold;
}

input.text {
	padding: 2px 5px;
	background: #F8FAEB;
	border-top: 1px solid #4D5719;
	border-left: 1px solid #4D5719;
	border-right: 1px solid #D6E48E;
	border-bottom: 1px solid #D6E48E;
}

input.button {
	background: #B8D03B;
	border-top: 1px solid #D6E48E;
	border-left: 1px solid #D6E48E;
	border-right: 1px solid #4D5719;
	border-bottom: 1px solid #4D5719;
	color: #FFFFFF;
}

h1, h2, h3 {
	margin-top: 1.5em;
	font-family: Georgia, "Times New Roman", Times, serif;
	color: #626456;
}

h1 {
	letter-spacing: -.075em;
	font-size: 3em;
}

h2 {
	letter-spacing: -.05em;
	font-size: 1.8em;
	font-weight: normal;
	color: #8D8E85;
}

h3 {
	font-size: 1em;
}

p, ul, ol {
	margin-top: 1.5em;
	line-height: 1.8em;
	font-size: 1.1em;
}

ul, ol {
	margin-left: 3em;
}

blockquote {
	margin-left: 3em;
	margin-right: 3em;
}

a {
	text-decoration: none;
	border-bottom: 1px dotted #B8D03B;
	color: #3C7BCF;
}

a:hover {
	border: none;
	background: #B8D03B;
	color: #FFFFFF;
}

h1 a, h2 a, h3 a {
	border: none;
	text-decoration: none;
	color: #626456;
}

h1 a:hover, h2 a:hover, h3 a:hover {
	background: none;
	border-bottom: 1px dotted #B8D03B;
	color: #B8D03B;
}

hr {
	display: none;
}

/* Wrapper */

#wrapper {
}

/* Header */

#header {
	width: 980px;
	height: 35px;
	margin: 0 auto;
}

#menu {
	float: left;
}

#menu ul {
	margin: 0;
	padding: 0;
	list-style: none;
	line-height: normal;
}

#menu li {
	float: left;
}

#menu a {
	display: block;
	float: left;
	height: 25px;
	margin-right: 1px;
	padding: 10px 20px 0 20px;
	background: #E9EED0;
	text-decoration: none;
	font-size: 1.1em;
	font-weight: bold;
	color: #8C8F7D;
}

#menu a:hover {
	background: #DDE6AB;
	color: #2C2E22;
}

#menu .current_page_item a {
	background: #B8D03B url(images/img01.gif) no-repeat;
	color: #FFFFFF;
}

#search {
	float: right;
	width: 260px;
	padding-top: 7px;
}

#search fieldset {
	border: none;
}

#search #s {
	width: 160px;
}

#search #x {
	width: 80px;
}

/* Logo */

#logo {
	width: 978px;
	margin: 0 auto;
	height: 122px;
	background: #FFFFFF url(images/img02.gif) repeat-x left bottom;
	border: 1px solid #B8D03B;
}

#logo h1, #logo h2 {
	float: left;
	margin: 0;
	padding: 0;
}

#logo h1 {
	padding: 30px 5px 0 20px;
}

#logo h2 {
	padding: 45px 0 0 0;
	font-style: italic;
}

#logo p {
	clear: left;
	margin: 0;
	padding: 0 0 0 20px;
	line-height: normal;
	font-size: 1.2em;
	font-weight: bold;
	color: #C2C5B1;
}

/* Page */

#page {
	height: 728px;
	width: 978px;
	margin: 0 auto;
	padding: 20px 0;
	background: #FFFFFF;
	border: 1px solid #B8D03B;
	border-top: none;
}

/* Content */

#content {
	float: left;
	width: 420px;
	padding: 0 24px 0 21px;
}

.post {
}

.post .title {
	margin: 0;
	font-weight: normal;
}

.post h1.title {
	font-size: 2.4em;
}

.post .entry {
	padding-bottom: 30px;
}

.post .meta {
	margin: 0;
	text-transform: uppercase;
	font-size: .8em;
	font-weight: bold;
	color: #CFCFCF;
}

.post .meta a {
	color: #CFCFCF;
}
	</style>
	
</head>
<body>
<title>CheckPoint</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="style.css" rel="stylesheet" type="text/css" media="screen">
	</head>
	<body>
	<div id="header">
	  <div id="menu">
	    <ul>
	      <li><a href="#">Trang chủ</a></li>
	      <li><a href="declaration-mgr.htm">Danh sách</a></li>
	      <li><a href="declaration.htm">Khai báo</a></li>      
	      <li class="current_page_item"><a href="mailer/form2.htm">Liên hệ</a></li>
	    </ul>
	  </div>
	  <div id="search">
	    <form id="searchform" method="get" action="#">
	      <fieldset>
	      <input id="s" type="text" name="s" value="" class="text">
	      <input id="x" type="submit" value="Search" class="button">
	      </fieldset>
	    </form>
	  </div>
	</div>
	<div id="logo">
	  <h1><a href="#">Check point</a></h1>
	</div>
	<div id="page">
  		<div id="content">
		    <div class="post">
		      <h1>Liên hệ</h1>
				${message }
	
				<form action="mailer/send.htm" method="post">
					<div>Gửi từ: </div> 	<p><input name="from" placeholder="From"></p>
					<div>Đến</div>		<p><input name="to" placeholder="tn2432000@gmail.com"></p>
					<div>Tiêu đề: </div>	<p><input name="subject" placeholder="Subject"></p>
					<div>Nội dung: </div>	<p><textarea name="body" placeholder="Body" rows="3" cols="30"></textarea></p>
					<button>Send</button>
				</form>
				<div>Hotline: 12345678</div>
		      <div class="entry"></div>
		    </div>
  		</div>
	</div>		
	
</body>
</html>