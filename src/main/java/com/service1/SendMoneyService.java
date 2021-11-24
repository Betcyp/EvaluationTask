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
	JSONObject objBal;
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
			objBal = UserDetails.getBalance(email);
			double currentBalance=obj.getDouble("account balance");
			double currentBalanceOfReceiver=objBal.getDouble("account balance");
			sendMoneyChecking(request, response, money, currentBalance, currentBalanceOfReceiver, myEmail, email);
		}
		catch(Exception e) {
				resp.print("{\"status\":\"Something went wrong!!..\"}");
			}
}
}

