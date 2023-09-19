<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo(){
		var qqInput = document.getElementById("qq");
		var wwInput = document.getElementById("ww");
		// GET방식 요청
		location.href = "second.jsp?q="+qqInput.value +"&w="+wwInput.value;
	}
</script>
</head>
<body>
<%
	// request(수동이동)
	// first -> second로 이동
	// 1) <a></a>
	//		text부분 누르면
	//		GET방식 요청
	// 2) JavaScript
	//		다양한 이벤트
	//		GET방식 요청
	// 3) <form> + <button>
	//		버튼 누르면 GET/POST방식 요청
	//
%>
	<h1>first</h1>
	<a href= "second.jsp?q=10&w=20">second로</a>
	<hr>
	<input id="qq"><br>
	<input id="ww"><br>
	<span ondblclick="gogo();">second로</span>
	<hr>
	<form action="second.jsp">
		<input name="q"><br>
		<input name="w"><br>
		<button>second로</button>
	</form>
</body>
</html>