<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id=loginedTbl>
		<tr>
			<td align="center" rowspan="2" class= imgTd>
			<img src="imgg/${sessionScope.loginMember.photo }"></td>
			<td>${sessionScope.loginMember.id }
				${sessionScope.loginMember.name }</td>
		</tr>
		<tr>
			<td align="center">�������</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="MemberInfoController">ȸ������</a>
				<a href="LoginController">�α׾ƿ�</a>
			</td>
		</tr>
	</table>
</body>
</html>