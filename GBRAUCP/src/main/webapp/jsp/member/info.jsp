<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id="joinTbl">
	<form action="MemberInfoController"
		method="post" enctype="multipart/form-data"
		name="memberUpdateForm"	
		onsubmit="return memberUpdateCheck();">
			<tr>
				<th>
					${sessionScope.loginMember.id }
				</th>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="pw"
						value="${sessionScope.loginMember.pw }" 
						maxlength="10"
						type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" placeholder="pwȮ��" 
						value="${sessionScope.loginMember.pw }" 
						maxlength="10"
						type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="name" 
						value="${sessionScope.loginMember.name }" 
						maxlength="10" placeholder="�̸�" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					������� : 
					<span id="memberInfoBD"><fmt:formatDate value="${sessionScope.loginMember.birthday }" type="date" dateStyle="long"/></span>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" value="${addr1 }" placeholder="�����ȣ" autocomplete="off"><br>
					<input name="addr2" value="${addr2 }" placeholder="�ּ�" autocomplete="off"><br>
					<input name="addr3" value="${addr3 }" placeholder="���ּ�" autocomplete="off" maxlength="30"><br>
				</td>			
			</tr>
			<tr>
				<td>
					����<br>
					<img id="memberInfoImg" src="img/${sessionScope.loginMember.photo }">
					<input name="photo" type="file"><br>
				</td>			
			</tr>
			<tr>
				<td align="center">
					<button>����</button>
	</form>
					<button onclick="bye();">Ż��</button>
				</td>
			</tr>			
		</table>
</body>
</html>


