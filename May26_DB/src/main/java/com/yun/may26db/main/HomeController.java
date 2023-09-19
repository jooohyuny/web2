package com.yun.may26db.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.may26db.bbs.BBSDAO;
import com.yun.may26db.dr.DRDAO;

// 톰캣키면 -> C들 만들어서 -> 이벤트 루프 -> ...
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 사실상 톰캣 켰을때랑 같은
	public HomeController() {
		BBSDAO.getBdao().setAllMsgCount();
		DRDAO.getDrdao().setAllFileCount();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
