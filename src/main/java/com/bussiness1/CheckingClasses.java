package com.bussiness1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.constants1.CommonConstants;
import com.service1.BaseResponse;

/**
 * Servlet implementation class CheckingClasses
 */
@WebServlet("/CheckingClasses")
public class CheckingClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	static Logger log = Logger.getLogger(CheckingClasses.class); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/*protected boolean checking(HttpServletRequest request, HttpServletResponse response, double money, double currentBalance, String email) throws ServletException, IOException {
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
	}	*/	
	
	
	/*protected void checkingEmailSend(HttpServletRequest request, HttpServletResponse response, double money, double currentBalance, double currentBalanceOfReceiver, String myEmail, String email) throws ServletException, IOException {
		
		PrintWriter resp =sendResponse(request, response);
		try {
		boolean receiverEmailCheck = false;
		receiverEmailCheck=UserDetails.emailExists(email);
		if(receiverEmailCheck != false) {
			if(money <= currentBalance) {
				double total=currentBalance - money;                                                                                                                                                                                                                                 
				double totalOfReceiver=currentBalanceOfReceiver + money;
				UserDetails.balanceUpdate(total,myEmail);
				UserDetails.balanceUpdate(totalOfReceiver,email);
				resp.print("{\"status\":\"Successfully Sended!!\"}");
				
				String from=myEmail;
				String to=email;
				String transactionType=CommonConstants.TRANSACTION_SEND;
				UserDetails.transactionDatabase(from,to,transactionType,money);
				
				
				String from1=myEmail;
				String to1=email;
				String transactionType1=CommonConstants.TRANSACTION_RECEIVED;
				UserDetails.transactionDatabase(from1,to1,transactionType1,money);
			}
			else {
				resp.print("{\"status\":\"Transaction cancelled due to insufficient balance\"}");
				}
			}
		else {
			resp.print("{\"status\":\"Not a Registered User!!..\"}");
			}
		}
		catch(Exception e) {
			resp.print("{\"status\":\"Something went wrong!!..\"}");
		}
	}*/

}
