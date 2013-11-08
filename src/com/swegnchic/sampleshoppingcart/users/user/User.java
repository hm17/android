package com.swegnchic.sampleshoppingcart.users.user;

public class User {
	private Name name;
	private Address address;
	private String type;
	private int id;
	private Phonenumber phonenumber;
	private String email;
	private String password;
	
	public User() {
		
	}
	
	public User(final String email, final String password) {
		setEmail(email);
		setPassword(password);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Phonenumber getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Phonenumber phonenumber) {
		this.phonenumber = phonenumber;
	}
}
