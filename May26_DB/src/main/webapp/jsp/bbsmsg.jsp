<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="bbsArea" border="1">
		<tr>
			<td id="bbsContent" align="right"><a href="BBSWriteController">�۾���
			</td>
		</tr>
		<tr>
			<td id="bbsTitle">�Խ���</td>
		</tr>
		<tr>
			<td>
				<table id="bbs">
					<tr>
						<th class="td1">��ȣ</th>
						<th class="td2">����</th>
						<th>��¥</th>
					</tr>
					<c:forEach var="m" items="${msgs }">
					<tr class="dataTr">
						<td align="center">${m.no}</td>
						<td>${m.title }</td>
						<td align="center">
						<fmt:formatDate value="${m.date }" type="date" dateStyle="short"/> 
						</td>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>