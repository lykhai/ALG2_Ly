package bank;

public class Company extends Client{
	private String companyName;

	public Company(String companyName) {
		this.companyName = companyName;
	}
	public String getName() {
		return ("firma " + companyName);
	}
	
}
