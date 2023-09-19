package com.yun.may25cydb.jstlf;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest req) {
		int a = 234234852;
		req.setAttribute("a", a);
		
		double b = 125.23448745;
		req.setAttribute("b", b);
		
		Date c = new Date();
		req.setAttribute("c", c);
		
		
		
	}
}
