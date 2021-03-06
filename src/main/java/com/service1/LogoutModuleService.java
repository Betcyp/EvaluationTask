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

import com.bussiness1.UserDetails;


@WebServlet("/LogoutModuleService")
public class LogoutModuleService extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessions=sessionValidation(request, response);
		String myEmail=(String) sessions.getAttribute("email");
		PrintWriter resp =sendResponse(request, response);
		
		if(sessions != null){
			sessions.invalidate();
    		resp.print("{\"status\":\"You are Successfully Logged out!!\"}");
    	}
    	
	}

}
