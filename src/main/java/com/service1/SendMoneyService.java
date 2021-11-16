package com.service1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/SendMoneyService")
public class SendMoneyService extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public SendMoneyService() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//first we check the user is registered user??
		String result=getRequestBody(request); 
		JSONObject jsonObject=new JSONObject(result);
		
		PrintWriter resp=sendResponse(request, response);
		String email=(String) jsonObject.get("email");
		String phoneNumber=(String) jsonObject.get("phoneNumber");
		
	}

}
