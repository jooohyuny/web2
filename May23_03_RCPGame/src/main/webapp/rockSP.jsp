<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="rsp.css">
</head>
<body>
	<table>
		<tr>
			<th>����������</th>
		</tr>
		<tr><td align="center" class="subTitle" colspan="3">��</td></tr>
		<tr><td align="center" colspan="3"></tr>
		<td align="center" class="subTitle"><a
			href="HomeController?hand=1"> <img src="img/h1.png">
		</a></td>

		<td align="center" class="subTitle"><a
			href="HomeController?hand=2"> <img src="img/h2.png">
		</a></td>
		<td align="center" class="subTitle"><a
			href="HomeController?hand=3"> <img src="img/h3.png">
		</a></td>
		<tr><td align="center" colspan="3"></tr>
		<tr><td align="center" class="subTitle" colspan="3">���</td></tr>
		<tr>
			<td align="center" class="subTitle">����</td>
			<td align="center" class="subTitle"></td>
			<td align="center" class="subTitle">��</td>
		</tr>
		<tr>
		<td align="center" class="subTitle">
			<img src="${uh }">
		</td>
			<td align="center" class="subTitle">vs</td>
		<td align="center" class="subTitle">
			<img src="${ch }">
		</td>
		</tr>
		<tr>
			<td align="center" class="result" colspan="3">${result }</td>
		</tr>
		<tr>
			<td align="center" class="result" colspan="3">${wdl }</td>
		</tr>
	</table>
</body>
</html>