package com.bussiness1;

import java.math.BigDecimal;

public class BalanceUser {
	private String email;
	private BigDecimal accountBalance;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
