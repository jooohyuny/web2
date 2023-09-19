<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		// .jsp에서 java소스 없애자
		//		값 받기	: EL
		//		나머지	: CustomTag
		// CustomTag
		//		jsp표준액션태그 : 기본 사용가능
		//		사제커스텀태그 : 외부 .jar파일 넣고
		//			JSTL(JSP Standard Tag Library)
		//				core - for/if
		//				formatting
		//				functions
		//				?
		//				?
		//				뭔가 만든거는 attribute취급
	%>
	
	<c:if test="${param.xx > 5 }">
		<h1>5보다 큼</h1>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${oeResult == '짝수' }">
			<h1>${param.xx}= ${oeResult.xhol }</h1>	
		</c:when>
		<c:when test="${oeResult == '짜악수' }">
			<h1>없</h1>	
		</c:when>
		<c:otherwise>
			<h3>${param.xx}= ${oeResult.xhol }</h3>	
		</c:otherwise>
	</c:choose>
	<hr>
	<c:choose>
		<c:when test="${oeResult == '짝수' }">
			<h1>${param.yy}= ${oeResult.yhol }</h1>	
		</c:when>
		<c:when test="${oeResult == '짜악수' }">
			<h1>없</h1>	
		</c:when>
		<c:otherwise>
			<h3>${param.yy}= ${oeResult.yhol }</h3>	
		</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="2" end="20" step="3">
		<h2>${i }</h2>
	</c:forEach>
	
	<c:forEach var = "m" items = "${menus }"> 
		${m.name } : ${m.price }<br>
	</c:forEach>
	
	${oeResult.hab }<br>
	${oeResult.cha }<br>
	${oeResult.gob }<br>
	${oeResult.moks }<br>
	${param.xx}= ${oeResult.xhol }<br>
	${param.yy}= ${oeResult.yhol }<br>
</body>
</html>