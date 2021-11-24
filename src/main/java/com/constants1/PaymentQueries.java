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
	
	
	
	//public static final String TRANSACTIONEMAIL_QUERY="SELECT * FROM TRANSACTION WHERE (sender=? AND transaction_type IS NOT NULL) OR (receiver=? AND transaction_type='Received') ORDER BY updated_at DESC";
	/*public static final String PROCEDURE_QUERY=
			"CREATE PROCEDURE `UPDATEANDINSERT`(IN `branch` VARCHAR(60), IN `year` INT) NOT "
			"DETERMINISTIC CONTAINS SQL SQL SECURITY DEFINER" 
			"BEGIN"
			"SELECT 
			   ( select sum(sales.amount) from sales 
			     where month (sales.date)= 11 and sales.branch = branch ) as Sales ,
			   ( select sum(expenses.amount) from expenses 
			     where month(expenses.date)= 11 and expenses.branch = branch ) as Expenses 
			   ;
			END
	*/

	// static final String CLEAR_QUERY="DELETE * FROM LOGIN WHERE email=?";

	//public static final String LOGOUTUPDATE_QUERY ="UPDATE LOGIN SET logout_time as CURRENT_TIMESTAMP ";
	
	//public static final String LOGOUTUPDATE_QUERY ="ALTER TABLE login ADD logout_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP";
}
//SELECT sender,receiver FROM TRANSACTION 






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
