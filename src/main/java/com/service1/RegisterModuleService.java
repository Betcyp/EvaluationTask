package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.bussiness1.UserDetails;
/**
 * Servlet implementation class RegisterModule
 */
@WebServlet("/Register")
public class RegisterModuleService extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    
	public RegisterModuleService() {
        super();
    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		   
	 }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		
		PrintWriter resp=sendResponse(request, response);
		String phoneNumber=(String) jsonObject.get("phoneNumber");
		String email=(String) jsonObject.get("email");
		
		boolean check = false;
			try {
				check=UserDetails.userExists(phoneNumber,email);
			} 
		    catch (SQLException e) {
				log.error(e);
			}
		
		if(check != false)
		{
			resp.print("{\"status\":\"Phone number/email already registered try with different one\"}");
		}
		else {
			String firstName=(String) jsonObject.get("firstName");
			String lastName=(String) jsonObject.get("lastName");
			String phoneNumber1=(String) jsonObject.get("phoneNumber");
			String email1=(String) jsonObject.get("email");
			String pass=(String) jsonObject.get("password");
			if(pass.length()<8) {
				resp.print("{\"status\":\"Password must contain minimum of 8 characters and one special characters\"}");
				String password=(String) jsonObject.get("password");
			}
			else {
				String password=pass;
				try {
					UserDetails.registerDatabase(firstName,lastName,phoneNumber1,email1,password);
				} catch (SQLException e) {
					log.error(e);
				}
				resp.print("{\"status\":\"User successfully registered\"}");
				int accountBalance=0;
				try {
					UserDetails.balanceDatabase(email1,accountBalance);
				} catch (SQLException e) {
					log.error(e);
				}
			}
		}
	}
}		
	
	
         



