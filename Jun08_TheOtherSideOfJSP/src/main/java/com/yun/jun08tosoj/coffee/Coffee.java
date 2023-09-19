package com.yun.jun08tosoj.coffee;

public class Coffee {
	private String cName;
	private int cPrice;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String cName, int cPrice) {
		super();
		this.cName = cName;
		this.cPrice = cPrice;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	
	
}
