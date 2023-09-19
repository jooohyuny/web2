package com.yun.ywp.cyworld;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.el.parser.Token;

import com.yun.ywp.main.TokenGenerator;
import com.yun.ywp.member.MemberDAO;

@WebServlet("/CWReplyWriteControlller")
public class CWReplyWriteControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			CWDAO.getCwdao().writeReply(request);
		}
		TokenGenerator.generate(request);
		CWDAO.getCwdao().get(request);
		request.setAttribute("contentPage", "cw/cw.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
