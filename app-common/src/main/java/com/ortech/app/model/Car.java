package com.ortech.app.model;


public class Car extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Insurance insurance;
	private String color;

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
