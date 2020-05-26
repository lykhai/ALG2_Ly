package fraction;

public class Fraction {
	//data
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	
	//methods
	public void greatestCommonDivisor() {
		int a = getNumerator();
		if (a < 0)	a = -1*a;
		int b = getDenominator();
		int temp = 0;
		
		while(b > 0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		numerator = numerator/a;
		denominator = denominator/a;
	}
	
	@Override
	public String toString() {
		return getNumerator() + "/" + getDenominator();
	}

}

