<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="ud.css">
</head>
<body>
	<form action="HomeController">
		<table>
			<tr>
				<th>UpDown</th>
			</tr>
			<tr>
				<td align="center">
				<input name="no" maxlength="5" 
				placeholder="${param.no }"
				autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>확인</button>
			</tr>
			<tr>
				<td align="center" id="resultTd">${result }</td>
			</tr>
		</table>
	</form>
</body>
</html>