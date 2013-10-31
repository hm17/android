package com.swegnchic.sampleshoppingcart.users.user;

public class Phonenumber {
	private String areaCode;
	private String phoneNumber;
	
	public Phonenumber(final String areaCode, final String phoneNumber) {
		setAreaCode(areaCode);
		setPhoneNumber(phoneNumber);
	}

	protected String getAreaCode() {
		return areaCode;
	}

	protected void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	protected String getPhoneNumber() {
		return phoneNumber;
	}

	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
