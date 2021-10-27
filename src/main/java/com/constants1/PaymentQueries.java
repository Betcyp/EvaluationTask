package com.constants1;

public class PaymentQueries {
	
	public static final String REGISTER_QUERY="INSERT INTO REGISTER(firstName,lastName,phoneNumber,email,password) VALUES (?, ?, ?, ?, ?)";
	
	public static final String EMAIL_QUERY="SELECT * FROM REGISTER WHERE email=?";
	
	public static final String PHONE_QUERY="SELECT * FROM REGISTER WHERE phoneNumber=?";
	
	public static final String LOGIN_QUERY="INSERT * FROM LOGIN WHERE email=? and password=?";
	
	public static final String PASSWORD_QUERY="SELECT * FROM REGISTER WHERE password=?";
}
