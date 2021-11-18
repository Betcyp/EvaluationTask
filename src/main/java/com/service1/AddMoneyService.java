package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bussiness1.AccountCommon;
import com.bussiness1.UserDetails;


@WebServlet("/AddMoneyService")
public class AddMoneyService extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject obj;
    public AddMoneyService() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		HttpSession session=sessionValidation(request);
			String myEmail=(String) session.getAttribute("email");
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
					double money=100;
					double total=currentBalance+money;
					try {
						resp.print(UserDetails.addAndSendResponse(total,myEmail));
						String from=myEmail;
						String to=myEmail;
						String transactionType="Deposited";
						UserDetails.transactionDatabase(from,to,transactionType,money);
						} catch (SQLException e) {
							log.error(e);}
									
						/*try {
							UserDetails.getBalance(myEmail);
							} catch (SQLException e) {
								log.error(e);
							}*/
			
							
					}
						
	}
 }


   