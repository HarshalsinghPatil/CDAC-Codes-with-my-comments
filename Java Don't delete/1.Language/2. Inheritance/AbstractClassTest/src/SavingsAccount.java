package edu.met.banking;

final class SavingsAccount extends Account {

	//a field declared with final modifier cannot be re-assigned (constant)
	final static double MIN_BAL = 5000;

	SavingsAccount() {
		balance = MIN_BAL;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(balance - amount < MIN_BAL)//1000-700=300<500
			throw new InsufficientFundsException();
		balance -= amount;
	}
}

