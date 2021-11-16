package com.bussiness1;

import java.sql.Date;

public class LoginUser {
	private String email;
	private String password;
	private String sessionId;
	private Date createdAt;
	private Date updatedAt;
	private Date loginTime;
	private Date logoutTime;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	
}
/*/*JSONObject jsonObject=new JSONObject();
while(rs.next()) {
jsonObject.put("email",rs.getString("email"));
jsonObject.put("password",rs.getInt("password"));
jsonObject.put("sessionId",rs.getInt("sessionId"));
jsonObject.put("loginTime",rs.getInt("loginTime"));
jsonObject.put("logoutTime",rs.getInt("logoutTime"));
}
return jsonObject;*/