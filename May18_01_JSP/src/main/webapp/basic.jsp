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
		<h1>Ȧ��</h1>
	<%		
		}else{
	%>
		<h1>¦��</h1>
	<% 		
		}
	%>
	<!-- 
		JSP(Java Servlet Page)
			�۾����� : HTML���̽��� Java�ҽ� �߰��ϴ� ����
			�������� : ��Ĺ�� .jsp -> Servlet���� �ٲ㼭 ������
			=> ����� Servlet(�۾��ϱ� �������� ��)
	 -->
</body>
</html>