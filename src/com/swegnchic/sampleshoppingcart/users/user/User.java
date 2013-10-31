package com.swegnchic.sampleshoppingcart.users.user;

public class User {
	private Name name;
	private Address address;
	private String type;
	private int id;
	private Phonenumber phonenumber;
	
	public User() {}

	protected Name getName() {
		return name;
	}

	protected void setName(Name name) {
		this.name = name;
	}

	protected Address getAddress() {
		return address;
	}

	protected void setAddress(Address address) {
		this.address = address;
	}

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected Phonenumber getPhonenumber() {
		return phonenumber;
	}

	protected void setPhonenumber(Phonenumber phonenumber) {
		this.phonenumber = phonenumber;
	}
}
