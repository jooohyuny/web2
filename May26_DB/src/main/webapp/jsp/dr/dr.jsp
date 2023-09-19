<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DATA ROOM</title>
</head>
<body>
	<table id="bbsArea" border="1">
		<tr>
			<td id="bbsContent" align="left">
			<a href = "DRUploadController">���Ͽø���</a>
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
					<c:forEach var="f" items="${files }">
						<tr class="dataTr" onclick="goDRDetail(${f.no});">
							<td align="center">${f.no}</td>
							<td>${f.title }</td>
							<td align="center">
								<fmt:formatDate value="${f.date }" type="date" dateStyle="short" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
			<c:forEach var="p" begin="1" end="${pageCount }">
				<a href="DRPageController?page=${p }" class="bbsPageChanger">${p }</a>
			</c:forEach></td>
		</tr>
		<tr>
			<td align="center">�˻�</td>
		</tr>
		
	</table>
</body>
</html>