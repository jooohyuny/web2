<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�̴� ������Ʈ</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<script type="text/javascript" src="js/yunValidChecker.js"></script>
<script type="text/javascript" src="js/ywpCheck.js"></script>
<script type="text/javascript" src="js/ywpMove.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td>
				<table id="siteTitle">
					<tr>
						<th align="center"><a href="HomeController"> Mini Project
						</a></th>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteMenu">
					<tr>
						<td align="center"><a href="SNSController">�Խ���</a></td>
						<td align="center"><a href="CWController">���̿���</a></td>
						<td align="center"><a href="">�޴�</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<table id="siteLoginArea">
					<tr>
						<td align="center"><jsp:include page="${loginPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
			<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<div id="resultDiv">${result }</div>
</body>
</html>