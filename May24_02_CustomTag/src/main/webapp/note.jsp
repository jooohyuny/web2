<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	// .jsp�� java�ҽ� �� ���� ���� �ֳ�?
	//		1) �� �ޱ� : EL
	//		2) (���� ��������) for/if
	//		3) �����������

	//	CustomTag
	//		������ java�ҽ��� �ϴ��Ÿ� DOM��ü���·�
	//		DOM��ü���� -> java�ҽ��� �ٲ㼭 ����
	//		-> .jsp������
	//		<���ξ�:xxx>
	//
	// 		jspǥ�ؾ׼��±�(��ǰ)
	//			jspȯ�濡�� �⺻������ ��밡����
	//			���ξ jsp
	// 		Ŀ�����±�(����ǰ����)
	//			�ܺ� .jar�ְ� ���°�

	//	redirect - x
	//	forward
	//	include
	
	// request.getRequestDispatcher("note2.jsp").forward(request, response);
	// include - ��ġ�����Ұ� -> ������ ���� ����ǥ��
	// request.getRequestDispatcher("note2.jsp").include(request, response);
	
	
	// css�� �������� ����
	// js(��ȿ���˻�)�� ��ɺ��� �����Ѵ� - may242check �� ���� ������Ʈ ���� ����
	//		1)������ �Լ� �ϳ���
	//		2) javascript front-end
	//			��ȿ���˻�
	//			...
	
%>
	<h1>�ʱ�</h1>
	<!-- note2.jsp�ҽ� ���� �ֱ� -->
	<jsp:include page="note2.jsp"></jsp:include>
</body>
</html>