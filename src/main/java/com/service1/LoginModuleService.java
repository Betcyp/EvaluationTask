package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.bussiness1.UserDetails;


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
		String password=(String) jsonObject.get("password");
		
		PrintWriter resp =sendResponse(request, response);
		boolean enter = false;
		
		try {
			enter=UserDetails.emailPassExists(email, password);
		} catch (SQLException e) {
			log.error(e);
		}
	
		if(enter != false) {
		
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(5*60);

			session.setAttribute("email", email);
			session.setAttribute("password", password);
			
			Cookie ck  =new Cookie("email",email);
		    response.addCookie(ck);
		    
			String mySessionId=session.getId();
			
		    String myEmail=(String) session.getAttribute("email");
		    String myPass=(String) session.getAttribute("password");
		    
			try {
				UserDetails.loginDatabase(myEmail, myPass, mySessionId);
				resp.print("");
			} catch (SQLException e) {
				log.error(e);
			}
			
		}
		else {
			resp.print("{\"status\":\"invalid credentials\"}");
		}
      }

}
