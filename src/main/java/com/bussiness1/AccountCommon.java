package com.bussiness1;

public class AccountCommon {
	double accountBalance;
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public double addMoney(double amount) {
		accountBalance = getAccountBalance() + amount;
		return accountBalance;
		
	}
	
	public void sendMoney(double amount) {
		accountBalance = getAccountBalance()- amount;
		/*if(amount <= accountBalance) {
			accountBalance = accountBalance - amount;
		}
		else {
			
		}*/
	}
	
}
