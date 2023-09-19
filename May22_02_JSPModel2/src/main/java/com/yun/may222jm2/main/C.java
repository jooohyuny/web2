package com.yun.may222jm2.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller
//		상황판단해서 M/V를 소환하는 흐름제어
//		사이트 전체의 진입점
//		GET/POST구분가능한 Servlet
//		PL급 back-end개발자

@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 이 사이트에 처음 접속할때 Post방식 쓰는 사람은 없을것
	// get방식으로 접속할 것(주소 직접 타이핑 or <a>눌러서)
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// RequestDispatcher rd = request.getRequestDispatcher("v1.html");
   		// rd.forward(request, response);
   		request.getRequestDispatcher("v1.html").forward(request, response);
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 계산
		M2.calculate(request);
		request.getRequestDispatcher("v3.jsp").forward(request, response);
		
	}

}
