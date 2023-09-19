package com.yun.ywp.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.ywp.main.TokenGenerator;
import com.yun.ywp.member.MemberDAO;

@WebServlet("/SNSController")
public class SNSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(MemberDAO.getMdao().isLogined(request)) {
//			request.setAttribute("contentPage", "sns/sns.jsp");
//		} else {
//			request.setAttribute("contentPage", "home.jsp");
//		}
		MemberDAO.getMdao().isLogined(request);
		TokenGenerator.generate(request);
		SNSDAO.getSdao().get(1, request);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
