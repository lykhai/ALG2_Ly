package shapes;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Circle c1 = new Circle(1);
		Circle c2 = new Circle(2);
		Rectangle r1 = new Rectangle(2, 3);
		Square s1 = new Square(3);
		
		double areaAll = c1.area() + c2.area() + r1.area() + s1.area();
		
		//arraylist - dynamicke pole .. samo se stara aby nepreteklo
		ArrayList<Object> shapes = new ArrayList();
		shapes.add(c1);
		shapes.add(c2);
		shapes.add(r1);
		shapes.add(s1);
		
		//neni to idealni ..
		double areaAll1 = 0;
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Circle) {
				areaAll1 += ((Circle)shapes.get(i)).area();
			} else if (shapes.get(i) instanceof Rectangle){
				areaAll1 += ((Rectangle)shapes.get(i)).area();
			}
		}
		//System.out.println(areaAll1);
		
		ArrayList<Shape> shapes1 = new ArrayList();
		shapes1.add(c1);
		shapes1.add(c2);
		shapes1.add(r1);
		shapes1.add(s1);
		
		double areaAll2 = 0;
		for (Shape s:shapes1) {
			areaAll2 += s.area();	//polymorfizmus
		}
		System.out.println(areaAll2);
		
		//polymorfizmus  .. nvm kt metoda area() se mi zavola
		//overloading metody .. v teto metode se už namapuje,
		//kt. konstruktor? se ma zavolat
	}

}
//TODO (kvuli procviceni .. neni uplne nutne)
//dokoncit ulohy GeometrickeObjekty.pdf
//TODO Banka za pomoci objektu atd. ..
