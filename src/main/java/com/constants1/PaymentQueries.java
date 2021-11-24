package com.constants1;

public class PaymentQueries {
	
	public static final String REGISTER_QUERY="INSERT INTO REGISTER(firstName,lastName,phoneNumber,email,password) VALUES (?, ?, ?, ?, ?)";
	
	public static final String EMAILPASS_QUERY="SELECT * FROM REGISTER WHERE email=? AND password=?";
	
	public static final String PHONE_QUERY="SELECT * FROM REGISTER WHERE phoneNumber=?";
	
	public static final String LOGIN_QUERY="INSERT INTO LOGIN(email,password,session_id) VALUES (?, ?, ?)";
	
	public static final String EMAIL_QUERY="SELECT * FROM REGISTER WHERE email=?";
	
	public static final String BALANCE_QUERY="INSERT INTO BALANCE(email,account_balance) VALUES (?, ?)";
	
	public static final String ACCOUNTEMAIL_QUERY="SELECT * FROM BALANCE WHERE email=?";
	
	public static final String BALANCEUPDATE_QUERY = "UPDATE BALANCE SET account_balance=? WHERE email=? ";
	
	public static final String TRANSACTION_QUERY="INSERT INTO TRANSACTION(sender,receiver,transaction_type,amount) VALUES (?, ?, ?, ?)";
	
	//public static final String TRANSACTIONEMAIL_QUERY="SELECT * FROM TRANSACTION WHERE sender=? OR receiver=? ORDER BY updated_at DESC";
	
	public static final String TRANSACTIONEMAIL_QUERY="SELECT * FROM TRANSACTION WHERE (sender=? AND (transaction_type = 'Send' OR transaction_type = 'Deposited')) OR (receiver=? AND transaction_type='Received') ORDER BY updated_at DESC";

}
	








/*public static final String SAMPLE = "CREATE PROCEDURE samplep (IN email VARCHAR(45)) "
			+"BEGIN "
			+ "INSERT INTO REGISTER(firstName,lastName,phoneNumber,email,password) VALUES (?, ?, ?, ?, ?)"
			+ "END"*/

    		
