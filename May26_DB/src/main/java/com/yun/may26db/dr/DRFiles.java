package com.yun.may26db.dr;

import java.util.Date;

public class DRFiles {
	private int no;
	private String title;
	private String file;
	private Date date;
	
	public DRFiles() {
		// TODO Auto-generated constructor stub
	}

	public DRFiles(int no, String title, String file, Date date) {
		super();
		this.no = no;
		this.title = title;
		this.file = file;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
