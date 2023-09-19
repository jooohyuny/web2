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
	String n = request.getParameter("n");
	int a = Integer.parseInt(request.getParameter("a"));
	String say = (a >= 20) ? "어서오고" : "나가!!!";
	%>

	<h1><%=n%>님</h1>
	<h2><%=say%></h2>

</body>
</html>