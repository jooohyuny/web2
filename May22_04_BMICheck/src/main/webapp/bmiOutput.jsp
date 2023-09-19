<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/input.css">
<script type="text/javascript" src="JS/yunValidChecker.js"></script>
<script type="text/javascript" src="JS/bmiCheck.js"></script>
</head>
<body>
	
	
	<table>
		<tr>
			<th>${g.name }</th>
		</tr>
		<tr>
			<td align="center"><img src="img/${g.photo }"></td>
		</tr>
		<tr>
			<td align="center">
			키 : ${g.height *100}cm</td>
		</tr>
		<tr>
			<td align="center">
			몸무게 : ${g.weight }kg</td>
		</tr>
		<tr>
			<td align="center">
			${g.bmi }</td>
		</tr>
		<tr>
			<td align="center">
			${g.result }</td>
		</tr>
	</table>
</body>
</html>