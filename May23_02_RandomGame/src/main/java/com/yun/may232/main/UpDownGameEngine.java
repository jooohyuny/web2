package com.yun.may232.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class UpDownGameEngine {
	private int gameAns;
	private int turn;
	
	private static final UpDownGameEngine UDGE = new UpDownGameEngine();
	private UpDownGameEngine() {
	}
	public static UpDownGameEngine getUdge() {
		return UDGE;
	}

	public void pickAns() {
		turn = 0;
		gameAns = new Random().nextInt(10000) + 1;
		System.out.println(gameAns);
	}

	public void judge(HttpServletRequest req) {
		turn++;
		int no = Integer.parseInt(req.getParameter("no"));
		
		if (gameAns == no) {
			req.setAttribute("result", turn +"턴만에 정답");
			pickAns();
		} else if (gameAns < no) {
			req.setAttribute("result", "DOWN");
		} else {
			req.setAttribute("result", "UP");
		}
	}
}
