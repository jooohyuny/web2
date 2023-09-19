<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="DRUploadController" method="post"
	enctype="multipart/form-data"
	name="drUploadForm" onsubmit="return drUploadCheck();">
		<table id = "bbsWriteTbl">
			<tr>
				<td align="center">
				<br>
				<input maxlength="80"
					name="title" placeholder="제목"
					autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="file" type="file">
				</td>			
			</tr>
			<tr>
				<td align="center">
					<button>업로드</button><br><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>