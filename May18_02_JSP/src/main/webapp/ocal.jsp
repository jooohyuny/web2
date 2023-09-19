<%@page import="java.util.StringTokenizer"%>
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
	String n = request.getParameter("num");
	// StringTokenizer st = new StringTokenizer(n,"\r\n");
	String[] n2 = n.split("\r\n");

	int sum = 0;
	for (String s : n2) {
		try{
			sum += Integer.parseInt(s);
		}catch(Exception e){
		}
	}	
	%>
	<%=n%>
	<h1>결과 : <%=sum%></h1>
</body>
</html>