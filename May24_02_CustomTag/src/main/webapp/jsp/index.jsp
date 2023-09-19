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
			<td id="siteTitle" align="left" valign="middle">축구 국가대표</td>
		</tr>
		<tr>
			<td id="siteMenu" align="center" valign="middle">
			<a href="HomeController">홈</a>
			<a href="TestController">테스트</a>
			<a href="NewpageController">페이지</a>
			<a href="CalcController">계산하기</a>
			
			</td>
		</tr>
		<tr>
			<td id="siteCountry">
			<a href="https://www.kfa.or.kr/national/?act=nt_man">
			<img alt="못찾으면" src="css/kfa.png">대한민국</a> 
			<a href="">잉글랜드</a> 
			<a href="">브라질</a> 
			<a href="">이탈리아</a>
			<a href="">스페인</a> 
			<a href="">포르투갈</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent" align="center" valign="middle">내용
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>