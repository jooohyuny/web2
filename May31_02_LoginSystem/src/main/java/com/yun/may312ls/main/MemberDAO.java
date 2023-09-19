package com.yun.may312ls.main;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	public static boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("m");
		return m != null;
	}
	
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("euc-kr");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			if(id.equals("test") && pw.equals("1234")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);
				
				Cookie c = new Cookie("lastLoginedID", id);
				c.setMaxAge(1*60*60*24);
				res.addCookie(c);
				// 로그인 정보가 사이트 어디서든 사용 가능해야
				// 20분 뒤 자동으로 없어져야
				// 로그인 정보 자체가 다양...
				// req param - front쪽... - x
				// req attr - 새로운 요청에서 값 못쓰게 되는 - x
				// ses attr
				// cookie - String만 되고, 보안적으로 문제...
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
