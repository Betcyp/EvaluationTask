package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bussiness1.UserDetails;
import com.constants1.CommonConstants;


@WebServlet("/SendMoneyService")
public class SendMoneyService extends BaseServlet {
	private static final long serialVersionUID = 1L;
    JSONObject obj;
	JSONObject obj1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=sessionValidation(request, response);
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		String myEmail=(String) session.getAttribute("email");
		String email=(String) jsonObject.get("email");
		Double money=Double.valueOf ( (String) jsonObject.get("sendMoney"));
		
		PrintWriter resp =sendResponse(request, response);
				

		try {
			obj = UserDetails.getBalance(myEmail);
			obj1 = UserDetails.getBalance(email);
			double currentBalance=obj.getDouble("account balance");
			double currentBalanceOfReceiver=obj1.getDouble("account balance");
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
	
		}
}

