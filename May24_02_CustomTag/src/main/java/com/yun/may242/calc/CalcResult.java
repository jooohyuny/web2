package com.yun.may242.calc;

public class CalcResult {
	private double hab;
	private double cha;
	private double gob;
	private double moks;
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}
	public CalcResult(double hab, double cha, double gob, double moks) {
		super();
		this.hab = hab;
		this.cha = cha;
		this.gob = gob;
		this.moks = moks;
	}
	public double getHab() {
		return hab;
	}
	public void setHab(double hab) {
		this.hab = hab;
	}
	public double getCha() {
		return cha;
	}
	public void setCha(double cha) {
		this.cha = cha;
	}
	public double getGob() {
		return gob;
	}
	public void setGob(double gob) {
		this.gob = gob;
	}
	public double getMoks() {
		return moks;
	}
	public void setMoks(double moks) {
		this.moks = moks;
	}
	
}
