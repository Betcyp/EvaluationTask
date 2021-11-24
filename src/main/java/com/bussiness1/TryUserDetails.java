package com.bussiness1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.constants1.PaymentQueries;
import com.databases1.DbConnect;

public class TryUserDetails {
	public static boolean emailExists(String email) throws SQLException {
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
	         }
        }
        finally {
			ps.close();
			rs.close();
			connection.close();
		}
		return exists;  
		
	}
     public static boolean phoneEmailExists( String phoneNumber, String email) throws SQLException{
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
 				emailExists(email);
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
/*
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
				passExists(password);
	         }
        }
        finally {
			ps.close();
			rs.close();
			connection.close();
		}
		return exists;  
		
	}
     public static boolean passExists(String password) throws SQLException{
    	 Connection connection = null;
         PreparedStatement ps = null; 
         ResultSet rs = null;
         boolean exists = false;
         try {
         	connection=DbConnect.getInstance().getConnection();
         	ps=connection.prepareStatement(PaymentQueries.PASSWORD_QUERY);
			ps.setString(1,password);
			rs=ps.executeQuery();
			if(rs.next()) 
	         {
				exists = true;
	         }
		 }
         finally {
 			ps.close();
 			rs.close();
 			connection.close();
 		}
		return exists ;
		
     }

}
*/
/*
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
*/