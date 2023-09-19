package com.yun.may25ctdb.num;

public class CalcResult {
	private double hab;
	private double cha;
	private double gob;
	private double moks;
	private String xhol;
	private String yhol;
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}
	public CalcResult(double hab, double cha, double gob, double moks, String xhol, String yhol) {
		super();
		this.hab = hab;
		this.cha = cha;
		this.gob = gob;
		this.moks = moks;
		this.xhol = xhol;
		this.yhol = yhol;
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
	public String getXhol() {
		return xhol;
	}
	public void setXhol(String xhol) {
		this.xhol = xhol;
	}
	public String getYhol() {
		return yhol;
	}
	public void setYhol(String yhol) {
		this.yhol = yhol;
	}
	
}
