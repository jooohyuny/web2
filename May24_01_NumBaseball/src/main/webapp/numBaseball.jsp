<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nbb.css">
<script type="text/javascript" src="js/may241Check.js"></script>
<script type="text/javascript" src="js/yunValidChecker.js"></script>
</head>
<body>
	<form action="HomeController" method="post"
	name="f" onsubmit="return check();">
		<table>
			<tr>
				<th>NumBaseball</th>
			</tr>
			<tr>
				<td id="resultTd">
				S : ${strike }<br>
				B :	${ball }<br>
				${result }</td>
			</tr>
			<tr>
				<td align="center">
				<input name="no" maxlength="3"
				placeholder="${param.no }"
				autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>확인</button>
			</tr>
		</table>
	</form>
</body>
</html>