package com.yun.ywp.cyworld;

import java.util.Date;

public class CWMsg {
	private int no;
	private String txt;
	private Date date;
	private String writer;
	private String photo;
	
	public CWMsg() {
		// TODO Auto-generated constructor stub
	}

	public CWMsg(int no, String txt, Date date, String writer, String photo) {
		super();
		this.no = no;
		this.txt = txt;
		this.date = date;
		this.writer = writer;
		this.photo = photo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
