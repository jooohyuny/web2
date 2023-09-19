<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�׷��� ����� �ǽð� AI���񽺸� Ȱ���� cross-platform ������ �缺����</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<script type="text/javascript" src="js/kwonValidChecker.js"></script>
<script type="text/javascript" src="js/gbraucpCheck.js"></script>
<script type="text/javascript" src="js/gbraucpMove.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center" id="siteMenuArea">
				<table>
					<tr>
						<td align="center"><a href="SNSController">SNS</a></td>
						<td align="center"><a href="">?</a></td>
						<td align="center"><a href="">?</a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitle">
					<tr>
						<td>
							<a href="HomeController">�׷��� ����� �ǽð� AI���񽺸� Ȱ���� cross-platform ������ �缺���� ī��</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td align="center">
				<jsp:include page="${loginPage }"></jsp:include>
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




