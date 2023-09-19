<%@page import="com.yun.may222jm2.main.M3"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		M3 m3 = (M3) request.getAttribute("m333");
	%>
	<h1>v3</h1>
	<%= m3.getHab() %><hr>
	<%= m3.getCha() %><hr>
	<%= m3.getGob() %><hr>
	<%= m3.getMoks() %>
</body>
</html>