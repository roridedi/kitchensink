package com.ortech.app.model;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Address address;
	private Insurance insurance;
	private Integer numberOfAccudents;
	private boolean isMarried;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Integer getNumberOfAccudents() {
		return numberOfAccudents;
	}
	public void setNumberOfAccudents(Integer numberOfAccudents) {
		this.numberOfAccudents = numberOfAccudents;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", insurance="
				+ insurance + ", numberOfAccudents=" + numberOfAccudents + ", isMarried=" + isMarried + "]";
	}
}
