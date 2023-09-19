<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" name="loginForm" method="post"
		onsubmit="return loginCheck();">
		<table id="loginTbl">
			<tr>
				<td align="center"><input name="id" placeholder="id"
					maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input name="pw" type="password"
					maxlength="10" placeholder="pw"></td>
			</tr>
			<tr>
				<td align="center">
					<button>로그인</button> <a href="JoinController"> 회원가입 </a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>