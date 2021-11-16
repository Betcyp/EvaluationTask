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

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.bussiness1.UserDetails;
import com.bussiness1.AccountCommon;
@WebServlet("/BalanceService")
public class BalanceService extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    public BalanceService() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String result=getRequestBody(request); 
		
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
				AccountCommon ac = new AccountCommon();
				resp.print(ac.getAccountBalance());
			}
	}
}			


