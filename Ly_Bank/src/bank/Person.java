package bank;

public class Person extends Client{
	private String name;

	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		if (name.endsWith("ova")) {
			return ("Pani " + name);
		}
		return ("Pan " + name);
	}
	

}
