package com.constants;

public class PaymentQueries {
	
	public static final String REGISTER_QUERY="INSERT INTO REGISTER(firstName,lastName,phoneNumber,email,passsword) VALUES (?, ?, ?, ?, ?)";
	
	public static final String EMAIL_QUERY="SELECT * FROM REGISTER WHERE email=?" ;
	
	public static final String LOGIN_QUERY="SELECT * FROM REGISTER WHERE email=? and password=?";
	//"SELECT COUNT(*) FROM REGISTER WHERE email=?" ;
}
