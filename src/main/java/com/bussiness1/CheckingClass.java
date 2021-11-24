package com.bussiness1;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CheckingClass {
	
	static Logger log = Logger.getLogger(CheckingClass.class);  
	public static boolean sendMoneyCheck(String email, double money, double currentBalance) {
		boolean receiverEmailCheck = false;
		try {
			receiverEmailCheck=UserDetails.emailExists(email);
			} catch (SQLException e1) {
				log.error(e1);
			}
			if(receiverEmailCheck != false) {
				if(money <= currentBalance) {
					double total=currentBalance - money;
				}
				else {
					
				}
			}
			return receiverEmailCheck;
}
}