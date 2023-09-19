package com.kwon.gbraucp.sns;

import java.util.Date;

public class SNSReply {
	private int no;
	private int gsNo;
	private String writer;
	private String txt;
	private Date date;

	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(int no, int gsNo, String writer, String txt, Date date) {
		super();
		this.no = no;
		this.gsNo = gsNo;
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

	public int getGsNo() {
		return gsNo;
	}

	public void setGsNo(int gsNo) {
		this.gsNo = gsNo;
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
