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
	<table id="drDetailTbl">
		<form action="DRDetailController" method="post"
		enctype="multipart/form-data"
		name="drUpdateForm" onsubmit="return drUpdateCheck();">
		<tr>
			<td colspan="2" align="right">
			<fmt:formatDate value="${df.date }" type="both" dateStyle="long" timeStyle="short" />
			</td>
		</tr>
		<tr>
		<!-- <td align="center"><input class="no" value='${bm.no }' type="hidden"> -->
			<td align="center"><input name="no" class="no" value='${df.no }' readonly="readonly">
			</td>
			<td align="center"><input name="title" class="title" value='${df.title }'>
			</td>
		</tr>
		<tr>
			<td align="center">
			파일
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<a href="drFile/${df.file }">다운로드</a><hr>
			바꾸기 : <input name="file" type="file" >
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button>수정</button>
		</form>
				<button onclick="deleteDRFile(${df.no});">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>