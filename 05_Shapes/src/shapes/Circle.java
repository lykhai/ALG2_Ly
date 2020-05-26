package shapes;

public class Circle extends Shape{
	
	private double r;

	public Circle(double r) {
		this.r = r;
	}
	
	//TODO udelat pomoci tovarni metody 
	/*
	public Circle(double d) {
		this.r = d/2;
	}	*/
	
	public double getR() {
		return r;
	}
	@Override
	public String toString() {
		return "Circle{" + "r=" + r + '}';
	}
	
	public double area() {
		return Math.PI*r*r;
	}

}
