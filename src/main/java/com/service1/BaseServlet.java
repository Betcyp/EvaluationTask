package com.service1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.bussiness1.RegisterUser;
import com.google.gson.Gson;


@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(BaseServlet.class);   
	Gson gson = new Gson();
    public BaseServlet() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected String getRequestBody(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		String result= null;
		try {
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null)
		      sb.append(line);
		} 
		catch (Exception e) { 
			 log.error(e);
			
		}
		result=sb.toString();
		return result;
		
	}
	protected PrintWriter sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		PrintWriter resp=null;
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    resp = out;
		return resp;
		
		/*String result=getRequestBody(request); 
		RegisterUser reg = new RegisterUser(result);
        String registerJson = this.gson.toJson(reg);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(registerJson);
		return out; */
	    
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response,int c) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		  if (session == null)
		  {
			  log.info("No session is available");
			  c=1;
			//  session = request.getSession();
		  }
		  else {
			  log.info("already session is created");
			  c=2;
		  }
		  
		  /*HttpSession session = request.getSession(false);
		  if (session != null)
		  {
			 return session;
		  }
		  else {
			  return null;
		  }
	
	}*/
	protected HttpSession sessionValidation(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email") == null){
			log.info("please login");
		}
		else {
		 String myEmail = (String) session.getAttribute("email");
		}
		
		String email = null;
		String sessionID = null;
		
		Cookie[] cks = request.getCookies();
		if(cks !=null){
			for(Cookie cookie : cks){
				if(cookie.getName().equals("email")) email= cookie.getValue();
				if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
		}
		return session;
		
	}
}
