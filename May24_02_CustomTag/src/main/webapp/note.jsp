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
	// .jsp에 java소스 쓸 일이 뭐가 있나?
	//		1) 값 받기 : EL
	//		2) (거의 없겠지만) for/if
	//		3) 출력형식지정

	//	CustomTag
	//		기존에 java소스로 하던거를 DOM객체형태로
	//		DOM객체형태 -> java소스로 바꿔서 실행
	//		-> .jsp에서만
	//		<접두어:xxx>
	//
	// 		jsp표준액션태그(정품)
	//			jsp환경에서 기본적으로 사용가능한
	//			접두어가 jsp
	// 		커스텀태그(사제품느낌)
	//			외부 .jar넣고 쓰는거

	//	redirect - x
	//	forward
	//	include
	
	// request.getRequestDispatcher("note2.jsp").forward(request, response);
	// include - 위치조절불가 -> 무조건 제일 위에표시
	// request.getRequestDispatcher("note2.jsp").include(request, response);
	
	
	// css는 주제별로 정리
	// js(유효성검사)는 기능별로 정리한다 - may242check 와 같이 프로젝트 별로 정리
	//		1)어차피 함수 하나뿐
	//		2) javascript front-end
	//			유효성검사
	//			...
	
%>
	<h1>필기</h1>
	<!-- note2.jsp소스 여기 넣기 -->
	<jsp:include page="note2.jsp"></jsp:include>
</body>
</html>