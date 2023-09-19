package com.yun.may222jm2.main;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.startup.SetAllPropertiesRule;

// Model
//		실제 계산
//		Java : back-end개발자(+ 고객)
public class M2 {

	public static void calculate(HttpServletRequest request) {
		double xxx = Double.parseDouble(request.getParameter("x"));
		double yyy = Double.parseDouble(request.getParameter("y"));
		double a = xxx + yyy;
		double b = xxx - yyy;
		double c = xxx * yyy;
		double d = xxx / yyy;
//		request.setAttribute(null, request);

		M3 m3 = new M3(a, b, c, d);
		request.setAttribute("m333", m3);
	}
}
