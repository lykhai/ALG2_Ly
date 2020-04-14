package calendar;

public class Calendar {
	private int day;
	private int month;
	private int year;
	private int daysInMonth;

	public Calendar (int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || 
				month ==  8|| month == 10 || month == 12) {
			daysInMonth = 31;
		}
		else if (month == 2) {
			if (((year%4)==0) || ((year%100)==0) && ((year%400)==0)) {
				daysInMonth = 29;
			} else	daysInMonth = 28;
		}
		else	daysInMonth = 30;
	}
	
	public static int actualDay(int day, int month, int year) {
		int q = day;
		int m = month;
		int K = year%100;
		int J = year/100;
		if (m==1) {
			m = 13;
			K--;
		}
		else if(m==2) {
			m = 14;
			K--;
		}
		return ((((q+(13*(m+1)/5)+K+K/4+J/4+5*J))+5)%7)+1;
	}
	
	public String fCalendar() {
		int acDay = actualDay(day, month, year);
		int dayNum = 1;
		
		String calFormat = "Mo Tu We Th Fr Sa Su \n";
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (((j<acDay) && (acDay!=7)) && (i==0)) {
					calFormat += "   ";
				} else {
					if (dayNum < 10)	calFormat += Integer.toString(dayNum) + "  ";
					else	calFormat += Integer.toString(dayNum) + " ";
					dayNum++;
				}
				if (dayNum > daysInMonth)	return calFormat;
			}
			calFormat += "\n";
		}
		return calFormat;
	}
	public String nextMonth() {
		month++;
		if (month == 13) {
			month = 1;
		}
		return fCalendar();
	}
	public String prewMonth() {
		month--;
		if (month == 1) {
			month = 12;
		}
		return fCalendar();
	}
	public static boolean leapYear(int year) {
		if (((year%4)==0) || ((year%100)==0) && ((year%400)==0)) {
			return true;
		} else	return false;
	}
	public static int daysInYear(int year) {
		if (leapYear(year)) return 366;
		else	return 365;
	}
		
}
