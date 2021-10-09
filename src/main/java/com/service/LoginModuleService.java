package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bussiness.LoginUser;
import com.bussiness.UserDetails;


@WebServlet("/LoginModuleService")
public class LoginModuleService extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginModuleService() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		
		
		String email=(String) jsonObject.get("email");
		String pass=(String) jsonObject.get("password");
        
        if(pass.equals("..")){  
            out.print("Welcome, "+email);  
            HttpSession session=request.getSession();  
            session.setAttribute("email",email);  
        }
        else{  
            out.print("..");
      UserDetails.loginDatabase(email, pass);
        
        
	}

}
