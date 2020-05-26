package fraction;

public class myMain {

	public static void main(String[] args) {	
		/*
		Fraction frac = new Fraction(140, 15);
		System.out.println("Citatel = " + frac.getNumerator());
		System.out.println("Jmenovatel = " + frac.getDenominator());
		System.out.println(frac.toString());
		System.out.println("Nejvetsi spol. delitel je " + frac.greatestCommonDivisor());*/
		
		Fraction f1 = new Fraction(4, 9);
		Fraction f2 = new Fraction(7, 3);
		
		Fraction addition = FractionsCalculator.addition(f1, f2);
		addition.greatestCommonDivisor();
		System.out.println(addition.toString());
		
		Fraction subtraction = FractionsCalculator.subtraction(f1, f2);
		subtraction.greatestCommonDivisor();
		System.out.println(subtraction.toString());
		
		Fraction multiplication = FractionsCalculator.multiplication(f1, f2);
		multiplication.greatestCommonDivisor();
		System.out.println(multiplication.toString());
		
		Fraction division = FractionsCalculator.division(f1, f2);
		division.greatestCommonDivisor();
		System.out.println(division.toString());
		
	}	
}
