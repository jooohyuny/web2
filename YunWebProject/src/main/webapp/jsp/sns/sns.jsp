<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>SNS페이지 로그인접속</h1>
	<c:if test="${sessionScope.loginMember != null }">
		<form action="SNSWriteController" name="snsWriteForm"
			onsubmit="return snsWriteCheck();">
			<table id="snsWriteTbl">
				<tr>
					<td align="center">
					<input name="token" value='${token }'
						type="hidden">
						<table>
							<tr>
								<td align="center"><textarea name="txt" maxlength="250"
										autocomplete="off" placeholder="내용을 입력하세요(250자 이내)"></textarea>
								</td>
								<td align="center">
									<button>저장</button>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<div id="snsBlankArea"></div>
	</c:if>
	<form action="SNSSearchController">
	<table id="snsSearchArea">
		<tr>
			<td>
				<input name = "search" maxlength="30" autocomplete="off">
			</td>
			<td>
				<button>검색</button>
			</td>
		</tr>	
	</table>	
	</form>
	<c:forEach var="sm" items="${msgs }">
		<table class="aMsg">
			<tr>
				<td align="center" rowspan="3" class="td1">
				<img src="imgg/${sm.photo }">
				</td>
				<td class="td2">${sm.writer }</td>
			</tr>
			<tr>
				<td align="right" class="td3">
				<fmt:formatDate value="${sm.date }" type="both" dateStyle="long" timeStyle="short"/>
				</td>
			</tr>
			<tr>
				<td class="td4">${sm.txt }</td>
			</tr>
			<tr>
				<td class="td5">
				<c:forEach var="sr" items="${sm.replys }">
					<c:choose>
						<c:when test="${sessionScope.loginMember.id == sr.writer }">
							<span class="snsReplyWriter"
							ondblclick="deleteSNSReply(${sr.no});">${sr.writer }</span>
						</c:when>
						<c:otherwise>
							<span class = "snsReplyWriter">${sr.writer }</span>
						</c:otherwise>
					</c:choose>
					${sr.txt } -
					<fmt:formatDate value="${sr.date }" type="date" dateStyle="short"/><br>
				 </c:forEach>
				<c:if test="${sessionScope.loginMember != null }">
					<form action="SNSReplyWriteController"
						onsubmit="return snsReplyWriteCheck(this);">
						<input name="token" value= '${token }' type="hidden">
						<input name="ys_no" value= '${sm.no }' type="hidden">
						<span class="snsReplyWriter">${sessionScope.loginMember.id }</span>
						<input name="txt" maxlength="80" autocomplete="off">
						<button>쓰기</button>
					</form>
				</c:if>	
				</td>
			</tr>
			<c:if test="${sm.writer == sessionScope.loginMember.id }">
			<tr>
				<td align="right" colspan="2">
					<button onclick="updateSNSMsg(${sm.no}, '${sm.txt }');">수정</button>
					<button onclick="deleteSNSMsg(${sm.no});">삭제</button>
				</td>
			</tr>
			</c:if>
		</table>
	</c:forEach>
	<c:if test="${page != 1 }">
		<a href="SNSPageController?page=${page - 1 }" class="snsL">&lt;</a>
	</c:if>
	<c:if test="${page != pageCount }">
		<a href="SNSPageController?page=${page + 1 }" class="snsR">&gt;</a>
	</c:if>
</body>
</html>