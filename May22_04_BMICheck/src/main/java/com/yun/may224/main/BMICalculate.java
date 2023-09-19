package com.yun.may224.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BMICalculate {
	public static void Calculator(HttpServletRequest request) {
		try {
			MultipartRequest mr = new MultipartRequest(request, request.getSession().getServletContext().getRealPath("img"),
					10485760,"euc-kr",new DefaultFileRenamePolicy());
			
			String n = mr.getParameter("n");
			double h = Double.parseDouble(mr.getParameter("h"));
			double w = Double.parseDouble(mr.getParameter("w"));
			String p = URLEncoder.encode(mr.getFilesystemName("p"),"euc-kr").replace("+", " ");
			double bmi = w/(h*h);
			String result = "쌉며루치";
			if(bmi>= 35) {
				result = "고도 비만";
			}else if(bmi>=30) {
				result = "중도 비만";
			}else if(bmi>=25) {
				result = "경도 비만";
			}else if(bmi>=23) {
				result = "과체중";
			}else if(bmi>=18.5) {
				result = "평균";
			}
		
			BMIResult g = new BMIResult(n, h, w, p, bmi, result);
			request.setAttribute("g", g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
