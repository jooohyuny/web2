<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function goSecondV(){
		location.href ="SecondC?q=100"
	}
</script>
</head>
<body>
<% 
	// request
	// 1) <a href="요청주소">여기</a>
	//		여기를 누르면 요청주소쪽으로 GET방식 요청
	// 2) JavaScript의 location.href = "요청주소";
	//		???를 하면 요청주소쪽으로 GET방식 요청
	// 3) <form action="요청주소"> + <button>
	//		input에서 엔터 or 버튼 누르면 요청주소쪽으로 GET/POST방식 요청
	
	// ~~~~/파일명?변수명=값&변수명=값&...
%>
	<h1>firstV</h1>
	<a href="SecondC?q=10">secondV로</a>
	<hr>
	<span ondblclick="goSecondV();">secondV로</span>
	<hr>
	<form action="SecondC">
		<input name="q"><br>
		<button>secondV로</button>
	</form>	
</body>
</html>