<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="bbsDetailTbl">
		<form action="BBSDetailController" method="post"
		name="bbsUpdateForm" onsubmit="return bbsUpdateCheck();">
		<tr>
		<!-- <td align="center"><input class="no" value='${bm.no }' type="hidden"> -->
			<td align="center"><input name="no" class="no" value='${bm.no }' readonly="readonly">
			</td>
			<td align="center"><input name="title" class="title" value='${bm.title }'>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<fmt:formatDate value="${bm.date }" type="both" dateStyle="long" timeStyle="short" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<textarea name="txt">${bm.txt }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button>수정</button>
		</form>
				<button onclick="deleteBBSMsg(${bm.no});">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>