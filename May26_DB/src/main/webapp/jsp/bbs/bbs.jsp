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
			<td id="bbsContent" align="right"><a href="BBSWriteController">글쓰기
			</td>
		</tr>
		<tr>
			<td id="bbsTitle">게시판</td>
		</tr>
		<tr>
			<td>
				<table id="bbs">
					<tr>
						<th class="td1">번호</th>
						<th class="td2">제목</th>
						<th>날짜</th>
					</tr>
					<c:forEach var="m" items="${msgs }">
						<tr class="dataTr" onclick="goBBSDetail(${m.no});">
							<td align="center">${m.no}</td>
							<td>${m.title }</td>
							<td align="center">
							<fmt:formatDate value="${m.date }" type="date" dateStyle="short" /></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
			<c:forEach var="p" begin="1" end="${pageCount }">
				<a href="BBSPageController?page=${p }" class="bbsPageChanger">${p }</a>
			</c:forEach></td>
		</tr>
		<tr>
			<td align="center">검색</td>
		</tr>
	</table>
</body>
</html>