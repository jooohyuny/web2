<%@page import="java.util.ArrayList"%>
<%@page import="com.yun.may231.main.Dog"%>
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
		// .jsp(V) : 웹디자이너 - 프로그래밍쪽 하는 사람이 아님
		// 	=> .jsp에서 java소스 없애자
		//	웹디자이너가 하기에 자바는 어려우니
		//	자바보다 쉬운
		// .jsp에 java소스 쓸 일이 뭐가
		//		1) 값 받기 - EL
		//		2) 만약에 구구단이었으면 for문이나 아니면 if문 쓸 상황이 생길수도..
		//		3) 출력방식
		//		...
		
		//	EL(Expression Language)
		//		값 받을 때 Java대신 사용가능한
		//		Java아님, tomcat이 Java로 바꿔줌 -> .jsp에서만 가능
		//		연산자 사용가능
		//		형변환 자동
		//		값 없으면 없는거
		//		import없어도 됨
		//		${???}
		//		req param	: ${param.파라메터명} // 파라메터명이 뭔지 찾아보고 생각해라 - 기본
		//		req attr	
		//			기본형급 : ${어트리뷰트명} 
		//			객체급 : 	${어트리뷰트명.멤버변수명} : 사실은 getter쓰는거
		//			ArrayList<객체> : ${어트리뷰트명[인덱스].멤버변수명}
		
		String j11 = request.getParameter("j1");
		int agee = (Integer) request.getAttribute("age");
		Dog dd = (Dog) request.getAttribute("d");
		ArrayList<Dog> dogs = (ArrayList<Dog>) request.getAttribute("dogs");
	%>
	생일 : <%= j11 %><br>
	나이 : <%= agee %><br>
	<%=dd %><br>
	<%=dd.getName() %>,<%=dd.getAge() %><br>
	<%=dogs %><br>
	<%
		for(Dog ddd: dogs){
	%>
		<%=ddd.getName() %>,<%=ddd.getAge() %><br>
	<% 		
		}
	%>
	<hr>
	생일 : ${param.j1 }<br>
	나이 : ${age }<br>
	${age+10 }<br>
	${d.name }, ${d.age }<br>
	${dogs}<br>
	${dogs[0]}<br>
	${dogs[0].name},${dogs[0].age }<br>
	${dogs[1].name},${dogs[1].age }<br>
	${dogs[2].name},${dogs[2].age }<br>
	${dogs[3].name},${dogs[3].age }<br>
</body>
</html>