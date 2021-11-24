package com.bussiness1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.constants1.PaymentQueries;
import com.databases1.DbConnect;

public class UserDetails {
	
	static Logger log = Logger.getLogger(UserDetails.class);
	
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
	
	public static void loginDatabase(String myEmail, String myPass, String mySessionId) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;

		try {
			connection=DbConnect.getInstance().getConnection();
			ps=connection.prepareStatement(PaymentQueries.LOGIN_QUERY);
			ps.setString(1,myEmail);
            ps.setString(2,myPass);
            ps.setString(3,mySessionId);
            ps.executeUpdate();
		}
		finally {
			ps.close();
			connection.close();
		}
		 
	}
     public static boolean emailPassExists(String email, String password) throws SQLException  {
    	 Connection connection = null;
    	 PreparedStatement ps = null; 
    	 ResultSet rs = null;
    	 boolean exists = false;
    	 try {
    	 	connection=DbConnect.getInstance().getConnection();
    	 	ps=connection.prepareStatement(PaymentQueries.EMAILPASS_QUERY);
    	 	ps.setString(1,email);
    	 	ps.setString(2,password);
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
	public static void balanceDatabase(String email1,double accountBalance) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;
        
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.BALANCE_QUERY);
        	ps.setString(1, email1);
        	ps.setDouble(2,accountBalance);
        	ps.executeUpdate();
        	
        }
        finally {
        	ps.close();
			connection.close();
        }
        
	}
	public static void balanceUpdate(double total,String myEmail ) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;
        
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.BALANCEUPDATE_QUERY);
        	ps.setDouble(1, total);
        	ps.setString(2,myEmail);
        	ps.executeUpdate();
        	
        }
        finally {
        	ps.close();
			connection.close();
        }
        
        
		
	}
	public static boolean checkEmail(String myEmail) throws SQLException {
		 Connection connection = null;
	   	 PreparedStatement ps = null; 
	   	 ResultSet rs = null;
	   	 boolean emailExists= false;
	   	 try {
	   	 	connection=DbConnect.getInstance().getConnection();
	   	 	ps=connection.prepareStatement(PaymentQueries.ACCOUNTEMAIL_QUERY);
	   	 	ps.setString(1,myEmail);
	   	 	rs=ps.executeQuery();
	   	 	if(rs.next()) 
	   	      {
	   	 		emailExists=true;
	   	      }
		}
	   	finally {
    	 	ps.close();
    	 	rs.close();
    	 	connection.close();
    	 }
		return emailExists;
	}


	public static JSONObject getBalance(String myEmail) throws SQLException {
		 Connection connection = null;
	   	 PreparedStatement ps = null; 
	   	 ResultSet rs = null;
	   
	   	 try {
	   	 	connection=DbConnect.getInstance().getConnection();
	   	 	ps=connection.prepareStatement(PaymentQueries.ACCOUNTEMAIL_QUERY);
	   	 	ps.setString(1, myEmail);
	   	 	rs=ps.executeQuery();
	   	 	JSONObject jsonObject=new JSONObject();
	   	 	while(rs.next()) 
	   	      {
	   	 		jsonObject.put("account balance",rs.getDouble("account_balance"));
	   	 		//Double account=rs.getDouble("account_balance"); 
	   	      }
			return jsonObject;
		}
	   	finally {
   	 	ps.close();
   	 	rs.close();
   	 	connection.close();
	   	}
		
	}

	public static void transactionDatabase(String from, String to, String transactionType, Double money) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;
        
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.TRANSACTION_QUERY);
        	ps.setString(1, from);
        	ps.setString(2,to);
        	ps.setString(3,transactionType);
        	ps.setDouble(4, money);
        	ps.executeUpdate();
        	
        }
        finally {
        	ps.close();
			connection.close();
        }
        
		
	}


	/*public static boolean emailExists(String receiverEmail) throws SQLException {
		Connection connection = null;
	   	 PreparedStatement ps = null; 
	   	 ResultSet rs = null;
	   	 boolean eExists= false;
	   	 try {
	   	 	connection=DbConnect.getInstance().getConnection();
	   	 	ps=connection.prepareStatement(PaymentQueries.EMAIL_QUERY);
	   	 	ps.setString(1,receiverEmail);
	   	 	rs=ps.executeQuery();
	   	 	if(rs.next()) 
	   	      {
	   	 		eExists=true;
	   	      }
		}
	   	finally {
   	 	ps.close();
   	 	rs.close();
   	 	connection.close();
   	 }
		return eExists;
	}
*/

	public static JSONObject getTransactionDetails(String myEmail,String email) throws SQLException {
		Connection connection = null;
	   	 PreparedStatement ps = null; 
	   	 ResultSet rs = null;
	   
	   	 try {
	   		//email=myEmail;
	   	 	connection=DbConnect.getInstance().getConnection();
	   	 	ps=connection.prepareStatement(PaymentQueries.TRANSACTIONEMAIL_QUERY);
	   	 	ps.setString(1, myEmail);
	   	 	ps.setString(2, email);
	   	 	rs=ps.executeQuery();
	   	 	JSONObject jsonObject=new JSONObject();
	   	 	JSONArray array=new JSONArray();
	   	 	while(rs.next()) 
	   	      {
	   	 		JSONObject record=new JSONObject(); 
	   	 		record.put("sender",rs.getString("sender"));
	   	 		record.put("receiver",rs.getString("receiver"));
	   	 		record.put("transaction type",rs.getString("transaction_type"));
	   	 		record.put("amount",rs.getDouble("amount"));
	   	 		record.put("time",rs.getString("updated_at"));
	   	 		array.put(record);
	   	 	
	   	      }
	   	 	if(array.isEmpty()) {
	   	 		return null;
	   	 	}
	   	 	else{
	   	 		jsonObject.put("Transaction details", array);
	   	 		return jsonObject;
	   	 	}
	   	      
		}
	   	finally {
  	 	ps.close();
  	 	rs.close();
  	 	connection.close();
	   	}
	}
	/*public static void loginDatabase1(String email) throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;

		try {
			connection=DbConnect.getInstance().getConnection();
			ps=connection.prepareStatement(PaymentQueries.CLEAR_QUERY);
			ps.setString(1,email);
            //ps.setString(2,myPass);
           // ps.setString(3,mySessionId);
            ps.executeUpdate();
		}
		finally {
			ps.close();
			connection.close();
		}
		
	}*/
	/*public static void logOutTimeUpdate() throws SQLException {
		Connection connection = null;
        PreparedStatement ps = null;
        
        try {
        	connection=DbConnect.getInstance().getConnection();
        	ps=connection.prepareStatement(PaymentQueries.LOGOUTUPDATE_QUERY);
        	//ps.setString(1,myEmail);
        	ps.executeUpdate();
        	
        }
        finally {
        	ps.close();
			connection.close();
        }
		
	}*/
}
