<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%! 
	private int getRandom(){
		Random r = new Random();
		return r.nextInt();
}
%>
</head>
<body>
	<% 
		int a = 10;
		int b = getRandom();
	%>
	<h1><%= a %></h1>
	<h1><%= b %></h1>
	<% 
		if (b % 2 == 1){
	%>
		<h1>홀수</h1>
	<%		
		}else{
	%>
		<h1>짝수</h1>
	<% 		
		}
	%>
	<!-- 
		JSP(Java Servlet Page)
			작업형태 : HTML베이스에 Java소스 추가하는 형태
			실행형태 : 톰캣이 .jsp -> Servlet으로 바꿔서 실행함
			=> 사실은 Servlet(작업하기 편해졌을 뿐)
	 -->
</body>
</html>