package com.yun.ywp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			MemberDAO.getMdao().splitAddr(request);
			request.setAttribute("contentPage", "member/info.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			MemberDAO.getMdao().update(request);
			MemberDAO.getMdao().splitAddr(request);
			request.setAttribute("contentPage", "member/info.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
