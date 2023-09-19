package com.yun.may242.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculate(HttpServletRequest req) {
		double x = Double.parseDouble(req.getParameter("x"));
		double y = Double.parseDouble(req.getParameter("y"));
		double a = x + y;
		double b = x - y;
		double c = x * y;
		double d = x / y;
		
		req.setAttribute("result", new CalcResult(a, c, b, d));
	}
	
}

