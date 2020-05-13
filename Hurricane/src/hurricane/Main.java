package hurricane;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		HurricaneInterface dt = new DataEditor();
		Scanner sc = new Scanner(System.in);
		try {
			dt.loadData();
			System.out.println("naloadovano");
			
		} catch (Exception e) {
			System.out.println("Did not find any file."); 
		}
		
		System.out.println("Vypis hurikanu v obdobi: ");
		System.out.println(dt.dispHuricanes(sc.nextInt(), sc.nextInt()));
		
		System.out.println("Vypis udaju zadaneho hurikanu: ");
		System.out.println(dt.getHuricane(sc.next()));
		
		System.out.println("Hurikany serazeny dle jejich rychlosti: ");
		System.out.println(dt.sortBySpeed());
		
	}

}
