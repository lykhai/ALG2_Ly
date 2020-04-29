package elevens;


import java.util.ArrayList;


public class Board extends CardDeck{

	static int deal = 9;
	static Card[] board = new Card[deal];	
	static int temp1;
	static int temp2;
	static int temp3;
	
	
	public void dealCards() {
		for (int i = 0; i < deal; i++) {
			board[i] = list.get(i);
			list.remove(i);
		}
	}
	
	
	public boolean canContinue() {
		if (findJQK())	return true;
		for (int i = 0; i < board.length-1; i++) {
			for (int j = i+1; j < board.length; j++) {
				if ((board[i].getValue() + board[j].getValue()) == 11) {
					return true;
				}
			}
		}
		return false;
	}
	
		public boolean checkDeck() {
			if ((list.size()) == 0)	return false;
			return true;
		}
	
		public boolean findJQK() {
			boolean j = false;
			boolean q = false;
			boolean k = false;
			for (int i = 0; i < board.length; i++) {
				if (board[i].getValue() == 11)	j = true;
				if (board[i].getValue() == 12)	q = true;
				if (board[i].getValue() == 13)	k = true;
				if (j && q && k)	return true;
			}
			return false;
		}

		public void replaceCards(int c1, int c2) {
			
			list.remove(c1);
			list.remove(c2);
			
			board[c1] = list.get(0);
			board[c2] = list.get(1);
		}
		
		public void replaceCards(int c1, int c2, int c3) {
			
			list.remove(c1);
			list.remove(c2);
			list.remove(c3);
			
			board[c1] = list.get(0);
			board[c2] = list.get(1);
			board[c3] = list.get(2);
		}
		
		public boolean isEleven(int c1, int c2) {
			if ((board[c1].getValue() + board[c2].getValue()) == 11){
				return true;
			}
			return false;
		}
	
	public boolean select(int c1, int c2) {
		System.out.println(board[c1].setCards() + " " + board[c2].setCards());
//		System.out.println(board[c1].getValue() + " " + board[c2].getValue());
		if (isEleven(c1, c2)) {
			replaceCards(c1, c2);
			return true;
		}
		return false;
	}
	
	
			public boolean jqk() {
				if (temp1 != temp2) {
					if (temp2 != temp3) {
						if (temp3 !=temp1) {
							return true;
						}
					}
				}
				return false;
			}
	
	public boolean select(int c1, int c2, int c3) {
		temp1 = board[c1].getValue();
		temp2 = board[c2].getValue();
		temp3 = board[c3].getValue();
		
		if ((temp1 > 10) && (temp1 + temp2 + temp3 == 36)) {
			if (jqk()) {
				replaceCards(c1, c2, c3);
				return true;
			}
		}
		return false;
	}
	
	
	public String dispBoard() {		
		String o = "";
		int temp = 0;
		for (int i = 0; i < deal; i++) {
			o += board[i].setCards() + "\t";
			temp++;
			if (temp == 3) {
				o += "\n";
				temp = 0;
			}
		}
		return o;
	}
		

	
}
