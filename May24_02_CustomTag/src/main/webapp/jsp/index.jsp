<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/calc.css">
<link rel="stylesheet" href="css/nbb.css">
<script type="text/javascript" src="js/yunValidChecker.js"></script>
<script type="text/javascript" src="js/may242check.js"></script>
<script type="text/javascript" src="js/may241check.js"></script>
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitle" align="left" valign="middle">�౸ ������ǥ</td>
		</tr>
		<tr>
			<td id="siteMenu" align="center" valign="middle">
			<a href="HomeController">Ȩ</a>
			<a href="TestController">�׽�Ʈ</a>
			<a href="NewpageController">������</a>
			<a href="CalcController">����ϱ�</a>
			
			</td>
		</tr>
		<tr>
			<td id="siteCountry">
			<a href="https://www.kfa.or.kr/national/?act=nt_man">
			<img alt="��ã����" src="css/kfa.png">���ѹα�</a> 
			<a href="">�ױ۷���</a> 
			<a href="">�����</a> 
			<a href="">��Ż����</a>
			<a href="">������</a> 
			<a href="">��������</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center" valign="middle">����
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>