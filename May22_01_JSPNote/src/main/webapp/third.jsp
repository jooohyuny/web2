<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>공사중</h1>
	<%
	String qq = request.getParameter("q");
	int qqq = Integer.parseInt(qq);
	int www = Integer.parseInt(request.getParameter("w"));
	
	//Object ee = request.getAttribute("e");
	//Integer eee = (Integer) ee;
	//int eeee = eee.intValue();
	int eeee = (Integer) request.getAttribute("e");
	
	Date ffff = (Date) request.getAttribute("f");
	%>
	
	q는 <%=qqq %>, w는 <%=www %><br>
	e는 <%=eeee %>, f는 <%=ffff %>
</body>
</html>