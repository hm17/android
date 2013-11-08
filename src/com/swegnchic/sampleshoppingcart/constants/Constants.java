package com.swegnchic.sampleshoppingcart.constants;

public class Constants {
	
	/** Screens **/
	public static enum Screens { REGISTER, STUDIO, CUSTOMER };

	/** Database Constants **/
	public static final String DATABASE_NAME="datastorage";
	public static final int    DATABASE_VERSION = 2;
	public static final String TABLE_NAME="classes";
	public static final String CLASS_NAME="name";
	public static final String DESCRIPTION_NAME="description";
	public static final String START_NAME="start";
	public static final String KEY_ID="_id";
	
	
	/** User Table Constants**/
	public static final String USER_TABLE_NAME="users";
	public static final String EMAIL_NAME="email";
	public static final String PASSWORD_NAME="password";
	
}
