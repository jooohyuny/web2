<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table id=infoTbl>
	<form action="MemberInfoController" method="post"
		name="memberUpdateForm"
		enctype="multipart/form-data"
		onsubmit="return memberUpdateCheck();">
			<tr>
				<th>���������� ����</th>
			</tr>
			<tr>
				<th>${sessionScope.loginMember.id}</th>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="pw"
					value="${sessionScope.loginMember.pw }"
					maxlength="10" type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" placeholder="pwȮ��"
					value="${sessionScope.loginMember.pw }"
					maxlength="10" type="password">
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
				<td align="center">
				<fmt:formatDate value="${sessionScope.loginMember.birthday }" type="date"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" value='${addr1 }' placeholder="�����ȣ" autocomplete="off"><br>
					<input name="addr2" value='${addr2 }' placeholder="�ּ�" autocomplete="off"> <br> 
					<input name="addr3" value='${addr3 }' placeholder="���ּ�" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td>
					����<br>
					<img alt="" src="imgg/${sessionScope.loginMember.photo }">
					<input name="photo" type="file"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>��������</button>
		</form>
					<button onclick="bye();">ȸ��Ż��</button>
				</td>
			</tr>
		</table>
</body>
</html>