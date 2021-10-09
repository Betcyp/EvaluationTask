package com.bussiness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.constants.PaymentQueries;
import com.databases.DbConnect;


public class UserDetails {
	
	static Logger log = Logger.getLogger(UserDetails.class);
	
	public static boolean userEmailExists(String email) throws SQLException {
		
		Connection connection = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        boolean emailExists = false;
		try {
			connection=DbConnect.getInstance().getConnection();
			ps=connection.prepareStatement(PaymentQueries.EMAIL_QUERY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) 
	         {
				emailExists = true;
				//log.error("user already registered");
	         }
			return emailExists;
		}	
		finally {
			rs.close();
			ps.close();
			connection.close();
		}
	
	}
	
	public static String registerDatabase(String firstName, String lastName, String phoneNumber, String email, String password) throws SQLException{
		        
		Connection connection = null;
        PreparedStatement ps = null; 
        try {
        	ps=connection.prepareStatement(PaymentQueries.REGISTER_QUERY);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, phoneNumber);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.executeUpdate();		
		}
		finally {
			ps.close();
			connection.close();
		}
		return null;
	}
	
	public static JSONObject loginDatabase(String email, String pass) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null; 

		try {
			connection=DbConnect.getInstance().getConnection();
			ps=connection.prepareStatement(PaymentQueries.LOGIN_QUERY);
			ps.setString(1,email);
            ps.setString(2,pass);
            ResultSet rs =ps.executeQuery();
            JSONObject jsonObject=new JSONObject();
			while(rs.next()) {
				jsonObject.put("email",rs.getString("email"));
				jsonObject.put("password",rs.getInt("password"));
			}
			return jsonObject;
		}
		finally {
			ps.close();
			connection.close();
		}    
	}
	
}
