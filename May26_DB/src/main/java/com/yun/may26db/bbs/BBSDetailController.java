package com.yun.may26db.bbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBSDetailController")
public class BBSDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 상세페이지 데이터 챙기고
		if (BBSDAO.getBdao().getDetail(request)) {
			request.setAttribute("cp", "bbs/detail.jsp");
		} else {
			BBSDAO.getBdao().get(1, request);
			request.setAttribute("cp", "bbs/bbs.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (BBSDAO.getBdao().update(request)) {
			BBSDAO.getBdao().getDetail(request);
			request.setAttribute("cp", "bbs/detail.jsp");
		} else {
			BBSDAO.getBdao().get(1, request);
			request.setAttribute("cp", "bbs/bbs.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
