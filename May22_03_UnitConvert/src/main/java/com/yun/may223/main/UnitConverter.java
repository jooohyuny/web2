package com.yun.may223.main;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class UnitConverter {
	public static void convert(HttpServletRequest request) {

		double n = Double.parseDouble(request.getParameter("transNum"));
		String w = request.getParameter("what");

		HashMap<String, String[]> hm = new HashMap<>();
		hm.put("len", new String[] { "cm", "inch" });
		hm.put("size", new String[] { "㎥", "평" });
		hm.put("temp", new String[] { "°C", "°F" });
		hm.put("spd", new String[] { "km/h", "mi/h" });

		double result = n * 0621371;
		if (w.equals("len")) {
			result = n * 0.393701;
		} else if (w.equals("size")) {
			result = n * 0.3025;
		} else if (w.equals("temp")) {
			result = (n * (9 / 5)) + 32;
		}
		
		UCResult ucr = new UCResult(n, hm.get(w)[0], result, hm.get(w)[1], w);
		
		request.setAttribute("ucr",ucr);
	}
}
