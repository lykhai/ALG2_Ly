package bank;

public class Account {
	private int sum = 0;
	//private int money;

	public Account() {
		this.sum = 0;
	}
	public Account(int sum) {
		this.sum = sum;
	}
	public void addMoney(int money) {
		sum += money;
	}
	public void withdrawMoney(int money) {
		sum -= money;
	}
	public int getBalance() {
		return this.sum;
	}
	
}
