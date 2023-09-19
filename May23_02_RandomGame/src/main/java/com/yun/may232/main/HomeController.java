package com.yun.may232.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpDownGameEngine udge = UpDownGameEngine.getUdge();
		
		if (!request.getParameterNames().hasMoreElements()) {
			udge.pickAns();
		} else {
			udge.judge(request);
		}
		request.getRequestDispatcher("upDown.jsp").forward(request, response);
	}
}