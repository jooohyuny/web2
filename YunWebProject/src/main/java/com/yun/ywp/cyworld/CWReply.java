package com.yun.ywp.cyworld;

import java.util.Date;

public class CWReply {
	private int no;
	private int ycwNo;
	private String writer;
	private String txt;
	private Date date;
	
	public CWReply() {
		// TODO Auto-generated constructor stub
	}

	public CWReply(int no, int ycwNo, String writer, String txt, Date date) {
		super();
		this.no = no;
		this.ycwNo = ycwNo;
		this.writer = writer;
		this.txt = txt;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getYcwNo() {
		return ycwNo;
	}

	public void setYcwNo(int ycwNo) {
		this.ycwNo = ycwNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
