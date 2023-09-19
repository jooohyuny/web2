package com.yun.may25ctdb.num;

import java.awt.Menu;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculate(HttpServletRequest req) {
		double x = Double.parseDouble(req.getParameter("xx"));
		double y = Double.parseDouble(req.getParameter("yy"));
		double a = x + y;
		double b = x - y;
		double c = x * y;
		double d = x / y;
		
		String xhol = (x%2==0)?"x는 짝수":"x는 홀수";
		String yhol = (y%2==0)?"y는 짝수":"y는 홀수";
		
		req.setAttribute("oeResult", new CalcResult(a, c, b, d, xhol, yhol));
		
		
		
//		ArrayList<Menu> menus = new ArrayList<>();
//		menus.add(new Menu("야채김밥",5000));
//		menus.add(new Menu("야채김밥",5000));
//		menus.add(new Menu("야채김밥",5000));
		
	}
}
