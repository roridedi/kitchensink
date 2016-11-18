package com.ortech.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Car extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JoinColumn(name = "carId")
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
