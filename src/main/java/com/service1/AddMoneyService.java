package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bussiness1.UserDetails;
import com.constants1.CommonConstants;


@WebServlet("/AddMoneyService")
public class AddMoneyService extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject obj;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		HttpSession session=sessionValidation(request, response);
    		String result=getRequestBody(request); 
    		JSONObject jsonObject=new JSONObject(result);
			String myEmail=(String) session.getAttribute("email");
			Double money=Double.valueOf ( (String) jsonObject.get("addMoney"));
			PrintWriter resp =sendResponse(request, response);
					
		
			try {
				obj = UserDetails.getBalance(myEmail);
			
				double currentBalance=obj.getDouble("account balance");
				double total=currentBalance + money;
			
				UserDetails.balanceUpdate(total,myEmail);
				resp.print("{\"status\":\"Successfully Deposited!!\"}");
				
				String from=myEmail;
				String to=myEmail;
				String transactionType=CommonConstants.TRANSACTION_DEPO;
				UserDetails.transactionDatabase(from,to,transactionType,money);
				
			} 
			catch (Exception e) {
				resp.print("{\"status\":\"Something went wrong!!..\"}");
			}
				}
}



   