<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>테이블</h1>
	<table border= "1">
	 <c:forEach var="s" items = "${ssnack }">
	 	<tr>
	 		<td>${s.sName }</td>
	 		<td>${s.sPrice }</td>
	 	</tr>
	 </c:forEach>
	</table>
</body>
</html>