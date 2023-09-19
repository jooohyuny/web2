<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${a }</h1>
	<hr>
	<fmt:formatNumber value="${a }" type="number"/>
	<hr>
	<!-- 
		3자리마다,
		국가설정에 맞는 통화기호
	 -->
	<fmt:formatNumber value="${a }" type="currency" currencySymbol="\\"/>
	<hr>
	<h1>${b }</h1>
	<hr>
	<fmt:formatNumber value="${b }" type="percent"/>	
	<hr>
	<!-- 
		# : 있으면 있고 없으면 없고
		0 : 있든 말든 자리 채워
	 -->
	<fmt:formatNumber value="${b }" pattern="#.000"/>	
	<hr>
	
	${c }
	<hr>
	<fmt:formatDate value="${c }" type="date" dateStyle="long"/><br>
	<fmt:formatDate value="${c }" type="date" dateStyle="short"/>
	<hr>
	<fmt:formatDate value="${c }" type="time" timeStyle="long"/><br>
	<fmt:formatDate value="${c }" type="time" timeStyle="short"/>
	<hr>
	<fmt:formatDate value="${c }" type="both" dateStyle="long" timeStyle="short"/>
	
</body>
</html>