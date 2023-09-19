package com.yun.may151s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		// 자동완성 아닌, 100%수작업
		// 왜 그렇게 써야하나
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<table style=\"float:left;\"border=\"1\">");
		pw.printf("<tr><th>%d단</th></tr>", dan);
		for (int i = 1; i <= 9; i++) {
			pw.printf("<tr><td>%d x %d = %d</td></tr>", dan, i, dan * i);
		}
		pw.print("</table>");
		pw.print("</body></html>");
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
