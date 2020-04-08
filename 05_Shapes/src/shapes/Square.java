package shapes;

public class Square extends Rectangle{ //each square is rectangle
	private double a;
	
	public Square (double a) {
		super(a, a);
	}
	
	@Override
	public String toString() {
		return "Square [a=" + a + "]";
	}

	public static void main(String[] args) {
		Square s = new Square(4);
		System.out.println(s.area());
		System.out.println(s);
	}
}
