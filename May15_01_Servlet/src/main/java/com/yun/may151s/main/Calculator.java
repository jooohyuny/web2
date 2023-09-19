package com.yun.may151s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 인터넷 주소 체계
	//		프로토콜://주소:포트번호/폴더/.../파일명?변수명=값&변수명=값&...
	//										-> 사용자가 서버측에 데이터를 보낼때
	//										-> request 
	//			protocol - 통신방식(http or https)
	//			포트번호 80이 웹서버 기본이라서 생략가능
	//			폴더명 ROOT는 생략
	//			파일명 index.html은 생략가능
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// request.getParameter("param변수명");
		response.setCharacterEncoding("euc-kr");
		String c = request.getParameter("colorrr");
		String aa = request.getParameter("a");
		int a = Integer.parseInt(aa);
		int b = Integer.parseInt(request.getParameter("b"));
		
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("<style type=\"text/css\">");
	    pw.print("table{float:left;}");
	    pw.printf("body { color: %s;}", c);
	    pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table border=\"1\">");
		pw.printf("<tr><td>%d + %d = %d</td></tr>", a, b, a + b);
		pw.printf("<tr><td>%d - %d = %d</td></tr>", a, b, a - b);
		pw.printf("<tr><td>%d * %d = %d</td></tr>", a, b, a * b);
		pw.printf("<tr><td>%d / %d = %d</td></tr>", a, b, a / b);
		pw.print("</table>");
	
		pw.print("</body></html>");
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
