package com.service1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		PrintWriter resp =sendResponse(request, response);
		String email=(String) jsonObject.get("email");
		String password=(String) jsonObject.get("password");
		boolean enter = false;
		
		try {
			enter=UserDetails.emailExists(email, password);
		} catch (SQLException e) {
			log.error(e);
		}
	
		if(enter != false) {
			HttpSession session=request.getSession();
			//Date createdAt = new Date(session.getCreatedAt());
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			session.setMaxInactiveInterval(5*60);
			
			String myEmail=(String) session.getAttribute("email");
			String myPass=(String) session.getAttribute("password");
			
		}
		else {
			//invalid credentials
			resp.print("{\"status\":\"invalid credentials\"}");
		}
        
      //UserDetails.loginDatabase(email, password);
		/*HttpSession session = request.getSession();
        
        PrintWriter writer = response.getWriter();
        writer.println("Session_id: " + session.getSessionId());
        writer.println("Created_at: " + session.getCreatedAt());
        writer. println("updated_at: " + session.getUpdatedAt());*/
        
        
	}

}
