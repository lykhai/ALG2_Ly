package bank;

import java.util.ArrayList;

public abstract class Client extends Account{
	private ArrayList<Account> acc = new ArrayList<Account>();
	public void addAcc() {
		acc.add(new Account());
	}
	public void addAcc(int sum) {
		acc.add(new Account(sum));
	}
	public int totalBalance() {
		int sum = 0;
		for (int i = 0; i < acc.size(); i++) {
			sum += acc.get(i).getBalance();
		}
		return sum;
	}
	public abstract String getName();
}
