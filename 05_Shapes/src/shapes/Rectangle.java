package shapes;

public class Rectangle extends Shape{
	//data
	private double a;
	protected double b;
	
	public Rectangle(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	
	@Override
	public String toString() {
		return "Rectangle [a=" + a + ", b=" + b + "]";
	}
	public double area() {
		return a*b;
	}
	

}
