<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="BBSWriteController" method="post"
	name="bbsWriteForm" onsubmit="return bbsWriteCheck();">
		<table id = "bbsWriteTbl">
			<tr>
				<td align="center">
				<br>
				<input maxlength="80"
				name="title" placeholder="제목"
					autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center">
				<textarea  name="txt" maxlength="280"
				autocomplete="off" placeholder="내용을 입력하세요"></textarea>
				</td>			
			</tr>
			<tr>
				<td align="center">
					<button>저장</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>