package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bussiness1.UserDetails;


@WebServlet("/ViewTransactionHistory")
public class ViewTransactionHistory extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewTransactionHistory() {
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
					resp.print(UserDetails.getTransactionDetails(myEmail));
				} catch (SQLException e) {
					log.error(e);
				}
		}
		else {
			resp.print("{\"status\":\"No transactions have been yet\"}");
		}		
	}

}
