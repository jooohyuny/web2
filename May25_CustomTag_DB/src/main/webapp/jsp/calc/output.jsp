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
		// .jsp���� java�ҽ� ������
		//		�� �ޱ�	: EL
		//		������	: CustomTag
		// CustomTag
		//		jspǥ�ؾ׼��±� : �⺻ ��밡��
		//		����Ŀ�����±� : �ܺ� .jar���� �ְ�
		//			JSTL(JSP Standard Tag Library)
		//				core - for/if
		//				formatting
		//				functions
		//				?
		//				?
		//				���� ����Ŵ� attribute���
	%>
	
	<c:if test="${param.xx > 5 }">
		<h1>5���� ŭ</h1>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${oeResult == '¦��' }">
			<h1>${param.xx}= ${oeResult.xhol }</h1>	
		</c:when>
		<c:when test="${oeResult == '¥�Ǽ�' }">
			<h1>��</h1>	
		</c:when>
		<c:otherwise>
			<h3>${param.xx}= ${oeResult.xhol }</h3>	
		</c:otherwise>
	</c:choose>
	<hr>
	<c:choose>
		<c:when test="${oeResult == '¦��' }">
			<h1>${param.yy}= ${oeResult.yhol }</h1>	
		</c:when>
		<c:when test="${oeResult == '¥�Ǽ�' }">
			<h1>��</h1>	
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