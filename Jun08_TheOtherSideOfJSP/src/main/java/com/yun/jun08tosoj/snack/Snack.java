package com.yun.jun08tosoj.snack;

public class Snack {
	private String sName;
	private int sPrice;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String sName, int sPrice) {
		super();
		this.sName = sName;
		this.sPrice = sPrice;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	
}
