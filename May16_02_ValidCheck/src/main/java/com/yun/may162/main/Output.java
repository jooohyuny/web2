package com.yun.may162.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 	서블릿 : 파일업로드해야하고, 계산해야하고 ...

// 	잘못입력해도 일단 서블릿까지 와서 try/if
// 		입력 유효성 검사까지 굳이 여기서 -> 아쉽ㅠ
//	잘못입력하면 아예 서블릿까지 오지도 않게 - valid
//		=> 입력유효성검사를 사용자쪽에서 하자
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		response.setCharacterEncoding("euc-kr");
		
		String path = request.getSession().getServletContext().getRealPath("photooo");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request,path,10* 1024 * 1024,"euc-kr",new DefaultFileRenamePolicy());
		
		String n = mr.getParameter("nameee");
		int a = Integer.parseInt(mr.getParameter("ageee"));
		String say = (a>=20)? "어서오세요":"나가!!!!";
		
		String p = URLEncoder.encode(mr.getFilesystemName("photooo"),"euc-kr").replace("+", " ");
		
		
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h1>이름 : %s</h1><br>", n);
		pw.printf("<h1>%s</h1><br>", say);
		pw.printf("<img src=\"photooo/%s\">", p);
		pw.print("</body></html>");
		} catch (Exception e) {
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<head><meta charset=\"euc-kr\">");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h1>나이...</h1><br>");
		pw.print("</body></html>");
		}
	}

}
