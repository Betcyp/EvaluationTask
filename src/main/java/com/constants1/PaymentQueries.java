package com.constants1;

public class PaymentQueries {
	
	public static final String REGISTER_QUERY="INSERT INTO REGISTER(firstName,lastName,phoneNumber,email,password) VALUES (?, ?, ?, ?, ?)";
	
	public static final String EMAIL_QUERY="SELECT * FROM REGISTER WHERE email=?";
	
	public static final String PHONE_QUERY="SELECT * FROM REGISTER WHERE phoneNumber=?";
	
	public static final String LOGIN_QUERY="INSERT INTO LOGIN(email,password,session_id) VALUES (?, ?, ?)";
	
	public static final String PASSWORD_QUERY="SELECT * FROM REGISTER WHERE password=?";
	
	public static final String BALANCE_QUERY="INSERT INTO BALANCE(email,account_balance) VALUES (?, ?)";
	
	public static final String ACCOUNTEMAIL_QUERY="SELECT * FROM BALANCE WHERE email=?";
}
/*HttpSession session=request.getSession();
session.setMaxInactiveInterval(5*60);

//Date createdAt = new Date(session.getCreatedAt());
session.setAttribute("email", email);
session.setAttribute("password", password);
Cookie ck1  =new Cookie("email",email);
//Cookie ck2  =new Cookie("password",password);
//String mySessionId=session.getId();

ck1.setMaxAge(30*60);
response.addCookie(ck1);
//response.addCookie(ck2);
//String myEmail=(String) session.getAttribute("email");
//String myPass=(String) session.getAttribute("password");*/
