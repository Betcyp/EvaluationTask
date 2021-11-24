package com.bussiness1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
	protected boolean checking(HttpServletRequest request, HttpServletResponse response, double money, double currentBalance, String email) throws ServletException, IOException {
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
