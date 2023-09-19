package com.yun.ywp.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.ywp.main.DateManager;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateManager.getCurYear(request);
		MemberDAO.getMdao().isLogined(request);
		request.setAttribute("contentPage", "member/join.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	// 가입성공 : 홈으로
	// 가입페이지로 - ?
	// 가입실패 : 홈으로
	// 가입페이지로
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.getMdao().join(request);
		MemberDAO.getMdao().isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
