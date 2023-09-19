package com.yun.may224.main;

public class BMIResult {
	private String name;
	private double height;
	private double weight;
	private String photo;
	private double bmi;
	private String result;
	
	public BMIResult() {
		// TODO Auto-generated constructor stub
	}

	public BMIResult(String name, double height, double weight, String photo, double bmi, String result) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.photo = photo;
		this.bmi = bmi;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
