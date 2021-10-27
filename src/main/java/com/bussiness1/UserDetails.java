package com.bussiness1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.constants1.PaymentQueries;
import com.databases1.DbConnect;

public class UserDetails {
	
	static Logger log = Logger.getLogger(UserDetails.class);
	
	
	@SuppressWarnings("resource")
	public static boolean userExists(String phoneNumber,String email) throws SQLException {
		
		Connection connection = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        boolean exists = false;
        
		try {
			connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.PHONE_QUERY);
			ps.setString(1,phoneNumber);
			rs=ps.executeQuery();
			if(rs.next()) 
	         {
				exists = true;
			 }
			else {
				ps=connection.prepareStatement(PaymentQueries.EMAIL_QUERY);
				ps.setString(1,email);
				rs=ps.executeQuery();
				if(rs.next()) 
		         {
					exists = true;
				 }
			}
		}
		finally {
			ps.close();
			rs.close();
			connection.close();
		}
		return exists;
	}
	
	
	public static void registerDatabase(String firstName, String lastName, String phoneNumber1, String email1, String password) throws SQLException {
		        
		Connection connection = null;
        PreparedStatement ps = null; 
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.REGISTER_QUERY);
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,phoneNumber1);
			ps.setString(4,email1);
			ps.setString(5,password);
			ps.executeUpdate();		
		}
        finally {
			ps.close();
			connection.close();
		}
	}
	
	public static void loginDatabase(String email, String password) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

		try {
			connection=DbConnect.getInstance().getConnection();
			ps=connection.prepareStatement(PaymentQueries.LOGIN_QUERY);
			ps.setString(1,email);
            ps.setString(2,password);
            rs =ps.executeQuery();
            //JSONObject jsonObject=new JSONObject();
			//while(rs.next()) {
				//jsonObject.put("email",rs.getString("email"));
				//jsonObject.put("password",rs.getInt("password"));
			//}
			//return jsonObject;
		}
		finally {
			ps.close();
			rs.close();
			connection.close();
		}    
	}
	public static boolean emailExists(String email, String password) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        boolean exists = false;
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.EMAIL_QUERY);
			ps.setString(1,email);
			rs=ps.executeQuery();
			if(rs.next()) 
	         {
				exists = true;
				ps=connection.prepareStatement(PaymentQueries.PASSWORD_QUERY);
				ps.setString(1,password);
				rs=ps.executeQuery();
				if(rs.next()) 
		         {
					exists = true;
		         }
			 }
        }
        finally {
			ps.close();
			rs.close();
			connection.close();
		}
		return exists;  
		
	}
	
}
