package com.yun.may172.main;

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
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("euc-kr");
    	
    	int x = Integer.parseInt(request.getParameter("x"));
    	int y = Integer.parseInt(request.getParameter("y"));

    	PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h1>%d + %d = %d</h1>", x, y, x + y);
		pw.printf("<h1>%d - %d = %d</h1>", x, y, x - y);
		pw.printf("<h1>%d * %d = %d</h1>", x, y, x * y);
		pw.printf("<h1>%d / %d = %d</h1>", x, y, x / y);
		
		pw.print("</body></html>");
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		int x = Integer.parseInt(request.getParameter("x"));
    	int y = Integer.parseInt(request.getParameter("y"));
		
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h1>%d + %d = %d</h1>", x, y, x + y);
		pw.printf("<h1>%d - %d = %d</h1>", x, y, x - y);
		pw.printf("<h1>%d * %d = %d</h1>", x, y, x * y);
		pw.printf("<h1>%d / %d = %d</h1>", x, y, x / y);
		pw.print("</body></html>");
	}

}
