package com.yun.may26db.dr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DRPageController")
public class DRPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		DRDAO.getDrdao().get(page, request);
		request.setAttribute("cp", "dr/dr.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
