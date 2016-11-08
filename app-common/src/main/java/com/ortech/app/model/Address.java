package com.ortech.app.model;

public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String houseNumber;
	private String streetName;
	private String streetEnding;
	private String city;
	private String state;
	private String zip;
	private HomeType homeType;
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetEnding() {
		return streetEnding;
	}
	public void setStreetEnding(String streetEnding) {
		this.streetEnding = streetEnding;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public HomeType getHomeType() {
		return homeType;
	}
	public void setHomeType(HomeType homeType) {
		this.homeType = homeType;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", streetName=" + streetName + ", streetEnding=" + streetEnding
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", homeType=" + homeType + "]";
	}
}
