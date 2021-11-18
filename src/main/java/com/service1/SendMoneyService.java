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


@WebServlet("/SendMoneyService")
public class SendMoneyService extends BaseServlet {
	private static final long serialVersionUID = 1L;
    JSONObject obj;
    public SendMoneyService() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=sessionValidation(request);
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		String myEmail=(String) session.getAttribute("email");
		String receiverEmail=(String) jsonObject.get("email");
		PrintWriter resp =sendResponse(request, response);
				
		boolean check = false;
		try {
			check=UserDetails.checkEmail(myEmail);
			} catch (SQLException e) {
				log.error(e);
			}
			if(check!=false) {
					
				try {
					obj = UserDetails.getBalance(myEmail);
					} catch (SQLException e1) {
						log.error(e1);
					}
					
				double currentBalance=obj.getDouble("account balance");
				//log.info(currentBalance);
				boolean receiverEmailCheck = false;
				try {
					receiverEmailCheck=UserDetails.emailExists(receiverEmail);
				} catch (SQLException e1) {
					log.error(e1);
				}
				if(receiverEmailCheck != false) {
					double money=10;
					
					if(money <= currentBalance) {
						double total=currentBalance-money;
						try {
							resp.print(UserDetails.addAndSendResponse(total,myEmail));
							String from=myEmail;
							String to=receiverEmail;
							String transactionType="Send";
							UserDetails.transactionDatabase(from,to,transactionType,money);
						} catch (SQLException e) {
							log.error(e);
						}
					}
					else {
						resp.print("{\"status\":\"Trnsaction cancelled due to insufficient balance\"}");
					}
				}
				else {
					resp.print("{\"status\":\"Not a Registered User!!..Please register!!\"}");
				}
			}
	}
}
