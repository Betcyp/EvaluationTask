package com.bussiness1;

public class AccountCommon {
	//double accountBalance;
	
	public double getAccountBalance() {
		double accountBalance;
		return accountBalance;
	}

	public double addMoney(double amount) {
		double accountBalance1;
		accountBalance1 = getAccountBalance() + amount;

		return accountBalance1;
		
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
