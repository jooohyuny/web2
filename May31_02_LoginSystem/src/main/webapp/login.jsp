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
	// 쿠키에 한글 쓰면 안됐었음
	//		ㅋ -> %2A로 바꿔야 가능했었음
	// 개발자들이 귀찮아서 ID에 한글 못쓰게했었는데
	// -> 관성
%>
	<form action="LoginController" method="post">
		id : <input name="id" value='${cookie.lastLoginedID.value }'
		autocomplete="off" autofocus="autofocus"><p>
		pw : <input name="pw" type="password"><p>
		<button>로그인</button>
	</form>
</body>
</html>