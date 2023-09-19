<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CalcController" name="calcForm" method="post" onsubmit="return calcCheck();">
		x : <input name="x" class="calcInput" autofocus="autofocus"
		placeholder="x"><br>
		y : <input name="y" class="calcInput"placeholder="y"><br>
		<button class="calcBtn">계산</button>
	</form>
</body>
</html>