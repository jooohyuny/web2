package com.yun.ywp.sns;

import java.util.Date;

public class SNSReply {
	private int no;
	private int ysNo;
	private String writer;
	private String txt;
	private Date date;
	public SNSReply() {
		// TODO Auto-generated constructor stub
	}
	public SNSReply(int no, int ysNo, String writer, String txt, Date date) {
		super();
		this.no = no;
		this.ysNo = ysNo;
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
	public int getYsNo() {
		return ysNo;
	}
	public void setYsNo(int ysNo) {
		this.ysNo = ysNo;
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
