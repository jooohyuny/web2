<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>May26</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/bbs.css">
<script type="text/javascript" src="js/may26check.js"></script>
<script type="text/javascript" src="js/yunValidChecker.js"></script>
<script type="text/javascript" src="js/may26move.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td>
				<table>
					<tr><td id="siteTitle" 
					align="left" valign="middle">May26</td></tr>
				</table>
			</td>
		<tr>
			<td id="siteMenu" align="left" valign="middle">
			<a href="HomeController">홈</a>
			<a href="BBSController">게시판</a>
			<a href="DRController">자료실</a>
			<a href="BBSController">게시판</a>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td><jsp:include page="${cp }"></jsp:include>
		</tr>
	</table>
	<div id = "resultArea">${result }</div>
</body>
</html>