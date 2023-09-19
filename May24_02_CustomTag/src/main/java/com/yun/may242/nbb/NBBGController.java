package com.yun.may242.nbb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/NBBGController")
public class NBBGController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NBBGameEngine.getNbge().pickAns();
		request.setAttribute("contentPage", "numBaseball.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NBBGameEngine.getNbge().judge(request);
		request.setAttribute("contentPage", "numBaseball.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
