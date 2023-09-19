package com.yun.may242.nbb;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBBGameEngine {
	private static final NBBGameEngine NBGE = new NBBGameEngine();
	private NBBGameEngine() {
	}
	public static NBBGameEngine getNbge() {

		return NBGE;
	}

	private String gameAns;
	private int turn;
	

	public void pickAns() {
		int ga = new Random().nextInt(976)+12; // 12 ~ 987
		gameAns = String.format("%03d", ga); // 012 ~ 987
		if (gameAns.charAt(0) == gameAns.charAt(1) 
			|| gameAns.charAt(1) == gameAns.charAt(2)
			|| gameAns.charAt(2) == gameAns.charAt(0)) {
			pickAns();
		}
		System.out.println(gameAns);
		turn=0;
	}
	
	public void judge(HttpServletRequest req) {
		turn++;
		String userAns = req.getParameter("no");
		int strike=0;
		int ball=0;
		for (int i = 0; i<3;i++) {
			for(int j =0;j<3;j++) {
				if (userAns.charAt(i)== gameAns.charAt(j)) {
					if(i == j) {
						strike++;
					}else {
						ball++;
					}
					break;
				} 
			}
		}
		req.setAttribute("strike", strike);
		req.setAttribute("ball", ball);
		if (strike==3) {
			req.setAttribute("result", turn +"타자만에 삼진");
			pickAns();
		}
	}
}
