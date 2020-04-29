package elevens;

import java.util.ArrayList;

public class CardDeck {
	

	public static ArrayList<Card> list = new ArrayList<Card>();

	public static int ranks = 13;
	public static int suits = 4;
	
	//temporary 
	public static String o;
	public static int val = 0;
	
	public ArrayList<Card> getList(){
		return list;
	}
	
	
	public static void deck() {
		for (int i = 0; i < suits; i++) {
			for (int j = 1; j < ranks+1; j++) {
				list.add(new Card(i, j));
			}
		}
	}
	
	public static void shuffle() {
		int n = list.size();
		int rand;
		Card temp;
		for (int i = n-1; i > 0 ; i--) {
			
			rand = (int)(Math.random()*n);
			temp = list.get(i);
			list.set(i, list.get(rand));
			list.set(rand, temp);
		}
	}
	
//	public static String dispDeck() {
//		o = "";
//		for (int i = 0; i < suits; i++) {
//			for (int j = 1; j < ranks+1; j++) {
//				
//				switch (i) {
//					case 0:	o += "♥";	break;
//					case 1:	o += "♦";	break;
//					case 2:	o += "♣";	break;
//					case 3:	o += "♠";	break;
//				}
//				if (j == 1) o += "A";
//				else if (j == 11) o += "J";
//				else if (j == 12) o += "Q";
//				else if (j == 13) o += "K";
//				else {
//					o += Integer.toString(j);
//				}
//				o += " ";
//			}
//			o += "\n";
//		}
//		return o;
//	}s
	
	public static void dispDeck() {
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			o = "";
			temp++;
			switch (list.get(i).getSymbol()) {
				case 0:	o += "♥";	break;
				case 1:	o += "♦";	break;
				case 2:	o += "♣";	break;
				case 3:	o += "♠";	break;
			}
			val = list.get(i).getValue();
			if (val == 1) o += "A";
			else if (val == 11) o += "J";
			else if (val == 12) o += "Q";
			else if (val == 13) o += "K";
			else {
				o += Integer.toString(val);
			}
			if (temp == 14) {
				System.out.println();
				temp = 1;
			}
			System.out.print(o + "\t");
			
		}

	}

    
    
}
