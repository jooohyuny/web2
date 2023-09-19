package com.yun.may26db.dr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DRDetailController")
public class DRDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		if (DRDAO.getDrdao().getDetail(no,request)) {
			request.setAttribute("cp", "dr/detail.jsp");
		} else {
			DRDAO.getDrdao().get(1, request);
			request.setAttribute("cp", "dr/dr.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(DRDAO.getDrdao().update(request)) {
			//DRDAO.getDrdao().getDetail(request);
			request.setAttribute("cp", "dr/detail.jsp");
		} else {
			DRDAO.getDrdao().get(1, request);
			request.setAttribute("cp", "dr/dr.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
