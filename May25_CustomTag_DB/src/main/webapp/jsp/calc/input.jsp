<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="NumJudgeController" name="numForm1" onsubmit="return numCheck();">
		x : <input name="xx" class="numInput" autofocus="autofocus"
		placeholder="x"><br>
		y : <input name="yy" class="numInput"placeholder="y"><br>
		<button class="numBtn">계산</button>
	</form>
</body>
</html>