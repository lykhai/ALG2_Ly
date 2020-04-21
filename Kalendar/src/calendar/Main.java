package calendar;

public class Main {

	public static void main(String[] args) {
		System.out.println(Calendar.actualDay(1,1,2020));
		Calendar c = new Calendar(1,1,2020);
		System.out.println(c.fCalendar());
		System.out.println(c.daysInYear(2020));
		
	}

}
