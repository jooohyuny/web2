package com.yun.may311jspn.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ThirdM {
	public static void test(HttpServletRequest req) {
		String ee = req.getParameter("e");
		System.out.println(ee);
	
//		String qq = req.getParameter("q");
//		System.out.println(qq);
		
//		String www = (String) req.getAttribute("w");
//		System.out.println(www);
		
//		double fff = (Double) req.getSession().getAttribute("f");
//		System.out.println(fff);
		
		// 지금 만들어져있는 쿠키들
//		Cookie[] cookies = req.getCookies();
//		for (Cookie c : cookies) {
//			if(c.getName().equals("g")) {
//				System.out.println(c.getValue());
//			}
//		}
	}
}
