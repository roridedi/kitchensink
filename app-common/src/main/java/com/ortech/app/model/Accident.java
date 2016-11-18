package com.ortech.app.model;

import javax.persistence.Entity;

@Entity
public class Accident extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Address address;
	private AccidentType accidentType;
	private Integer numberOfPassengers;
	private boolean isRaining;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AccidentType getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public boolean isRaining() {
		return isRaining;
	}

	public void setRaining(boolean isRaining) {
		this.isRaining = isRaining;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
