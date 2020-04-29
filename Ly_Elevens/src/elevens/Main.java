package elevens;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board b = new Board();
		CardDeck cd = new CardDeck();
		
		cd.deck();
		cd.shuffle();
//		cd.dispDeck();
		
		b.dealCards();
		System.out.println(b.dispBoard());
		
		boolean gameRunning = true;
		boolean isEleven = false;
		while (gameRunning) {
			if (b.canContinue()) {
				System.out.println("\tA - vyber 2 karet\n\tB - vyebr 3 karet\n\tQ - konec");
				switch (sc.nextLine()) {
					
					case "a":	System.out.println("Vyber karet podle pozic od 0-8 (zleva doprava)");
								isEleven = b.select(sc.nextInt(), sc.nextInt());
								break;
					case "b":	System.out.println("Vyber karet podle pozic od 0-8 (zleva doprava)");
								isEleven = b.select(sc.nextInt(), sc.nextInt(), sc.nextInt());
								break;
					case "q":	gameRunning = false;
				}
				if (gameRunning) {
					if (isEleven)	System.out.println("\tWell done\n");
					else			System.out.println("\tNope.\n");
					System.out.println(b.dispBoard());
					sc.nextLine();
				} else	System.out.println("See you again.");
			} else {
				gameRunning = false;
				System.out.println("RIP, you lose.");
			}
		}
	}
	//NOT FINISHED
}
