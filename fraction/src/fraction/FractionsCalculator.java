package fraction;

public class FractionsCalculator {
	
	//math operations
	public static Fraction addition(Fraction a, Fraction b) {
		int numerator = a.getNumerator()*b.getDenominator() +
						a.getDenominator()*b.getNumerator();
		
		int denominator = a.getDenominator()*b.getDenominator();
		return new Fraction(numerator, denominator);
	}
	public static Fraction subtraction(Fraction a, Fraction b) {
		int numerator = a.getNumerator()*b.getDenominator() -
						(a.getDenominator()*b.getNumerator());
		int denominator = a.getDenominator()*b.getDenominator();
		return new Fraction(numerator, denominator);
	}
	public static Fraction multiplication(Fraction a, Fraction b) {
		int numerator = (a.getNumerator() * b.getNumerator());
		int denominator = (a.getDenominator() * b.getDenominator());
		return new Fraction(numerator, denominator);
	}
	public static Fraction division(Fraction a, Fraction b) {
		int numerator = (a.getNumerator() * b.getDenominator());
		int denominator = (a.getDenominator() * b.getNumerator());
		return new Fraction(numerator, denominator);
	}
}