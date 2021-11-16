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
	int accountBalance;
    public AddMoneyService() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Cookie[] cks=request.getCookies();
		sessionValidation(request, response);
		if(cks != null) {
			for(Cookie cookie:cks) {
				if(cookie.getName().equals("JSESSIONID")) {
					log.info("JSESSIONID="+cookie.getValue());
					HttpSession session=request.getSession();
					//String mySessionId=session.getId();
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
						double v = ac.addMoney(100);
						resp.print(v);
						try {
							UserDetails.balanceDatabase(myEmail,v);
						} catch (SQLException e) {
							log.error(e);
						}
						
					}
				}
			}
		}
		
	}

}
