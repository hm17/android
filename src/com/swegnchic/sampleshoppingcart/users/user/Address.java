package com.swegnchic.sampleshoppingcart.users.user;

public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	
	public Address() {}

	protected String getAddressLine1() {
		return addressLine1;
	}

	protected void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	protected String getAddressLine2() {
		return addressLine2;
	}

	protected void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getState() {
		return state;
	}

	protected void setState(String state) {
		this.state = state;
	}

	protected String getZip() {
		return zip;
	}

	protected void setZip(String zip) {
		this.zip = zip;
	}

}
