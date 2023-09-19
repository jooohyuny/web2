<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="JoinController"
		method="post" enctype="multipart/form-data"
		name="joinForm"	onsubmit="return joinCheck();">
		<table id="joinTbl">
			<tr>
				<th>ȸ������</th>
			</tr>
			<tr>
				<td align="center">
					<input name="id" placeholder="id"
						maxlength="10"
						autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pw" placeholder="pw" 
						maxlength="10"
						type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="pwChk" placeholder="pwȮ��" 
						maxlength="10"
						type="password">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="name" maxlength="10" placeholder="�̸�" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					�������<br>
					<select name="y">
						<c:forEach var="y" begin="${cy - 80 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select>��&nbsp;&nbsp;&nbsp;
					<select name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>��&nbsp;&nbsp;
					<select name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>��
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="addr1" placeholder="�����ȣ" autocomplete="off"><br>
					<input name="addr2" placeholder="�ּ�" autocomplete="off"><br>
					<input name="addr3" placeholder="���ּ�" autocomplete="off" maxlength="30"><br>
				</td>			
			</tr>
			<tr>
				<td>
					����<br>
					<input name="photo" type="file"><br>
				</td>			
			</tr>
			<tr>
				<td align="center">
					<button>����</button>
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>




