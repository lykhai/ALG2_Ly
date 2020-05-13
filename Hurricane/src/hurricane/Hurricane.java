package hurricane;

public class Hurricane {

	private int year;
	private String month;
	private int preasure;
	private int speed;
	private String name;
	
	public Hurricane(int year, String month, int preasure, int speed, String name) {

		this.year = year;
		this.month = month;
		this.preasure = preasure;
		this.speed = speed;
		this.name = name;
	}

	public double getSpeedInKm() {
		return  (speed*(1.852));
	}
	
	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%-6d%-10s%-5d%-4d%=10s", year, month, preasure, speed, name);
	}

	public int getCathegory() {
		double sp = getSpeedInKm();
		if ((sp > 118) && (sp > 154)) {
			return 1;
		} else if ((sp > 153) && (sp > 178)) {
			return 2;		
		} else if ((sp > 177) && (sp > 209)) {
			return 3;
		} else if ((sp > 208) && (sp > 252)) {
			return 4;
		} else if (sp > 251) {
			return 5;
		}
		return 0; 
	}
	
}
