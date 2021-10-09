package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.bussiness.UserDetails;

/**
 * Servlet implementation class RegisterModule
 */
@WebServlet("/Register")
public class RegisterModuleService extends BaseServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(RegisterModuleService.class);
    
	public RegisterModuleService() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		
		String resp=sendResponse(request, response);
		//String email=(String) jsonObject.get("email");
		//JSONObject jsonObject=new JSONObject(email);
		//UserDetails.userEmailExists(email);
		
		try {
			String firstName=(String) jsonObject.get("firstName");
			String lastName=(String) jsonObject.get("lastName");
			String phoneNumber=(String) jsonObject.get("phoneNumber");
			String email=(String) jsonObject.get("email");
			String password=(String) jsonObject.get("password");
			UserDetails.registerDatabase(firstName,lastName,phoneNumber,email,password);
			
		}
		catch(Exception e) {
			log.error(e);
			
		}
   }
	
         
}


