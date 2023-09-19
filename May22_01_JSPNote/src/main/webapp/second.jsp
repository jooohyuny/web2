<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="java.util.Random"%>
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
	// request parameter
	// 	GET 방식 : 주소에 / POST 방식 : 내부적으로
	//	String
	//	request소속
	//	html/js에서 만들어진 값
	String qq = request.getParameter("q");
	int qqq = Integer.parseInt(qq);
	int www = Integer.parseInt(request.getParameter("w"));

	// request attribute
	//	Object
	//	request소속
	//	java에서 만들어진 값
	Random r = new Random();
	int eee = r.nextInt(10);
	request.setAttribute("e", eee);
	
	Date now = new Date();
	request.setAttribute("f", now);
	
	
	
	// second -> third자동이동
	// 1) redirect : 단순 공사중
	// response.sendRedirect("third.jsp");
	
	// 2) forward : 주력(값 전달이 되니)
	RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
	
	// 3) include : 위치조절불가(무조건 제일 위에)
	// rd.include(request, response);

%>
	<h1>second</h1>
	q는 <%=qqq %>, w는 <%=www %>
</body>
</html>