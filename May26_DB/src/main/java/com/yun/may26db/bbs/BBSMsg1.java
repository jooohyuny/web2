package com.yun.may26db.bbs;

import java.util.Date;

public class BBSMsg1 {
	private int no;
	private String title;
	private String txt;
	private Date date;
	
	public BBSMsg1() {
		// TODO Auto-generated constructor stub
	}

	public BBSMsg1(int no, String title, String txt, Date date) {
		super();
		this.no = no;
		this.title = title;
		this.txt = txt;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
