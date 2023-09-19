<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="NBBGController" method="post"
	name="numbbForm" onsubmit="return nbbgCheck();">
		<table class="nbbTitle">
			<tr>
				<th class="nbbName">NumBaseball</th>
			</tr>
			<tr>
				<td id="resultTd" class="nbbTd">
				S : ${strike }<br>
				B :	${ball }<br>
				${result }</td>
			</tr>
			<tr>
				<td align="center" class="nbbTd">
				<input name="no" maxlength="3"
				placeholder="${param.no }" class="number"
				autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center" class="nbbTd">
					<button class="nbbBtn">확인</button>
			</tr>
		</table>
	</form>
</body>
</html>