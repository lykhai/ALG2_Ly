package elevens;


public class Card {
	
    private int symbol; //suit
    private int value;  //rank
    private String card;   //A-1, J,Q,K-0 //byte

    public Card(int symbol, int value) {
        this.symbol = symbol;
        this.value = value;
        setCards();
    }

	public int getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
    
    public String setCards() {
    	int val = 0;
		card = "";
		switch (getSymbol()) {
			case 0:	card += "♥";	break;
			case 1:	card += "♦";	break;
			case 2:	card += "♣";	break;
			case 3:	card += "♠";	break;
		}
		val = getValue();
		if (val == 1) card += "A";
		else if (val == 11) card += "J";
		else if (val == 12) card += "Q";
		else if (val == 13) card += "K";
		else {
			card += Integer.toString(val);
		}
		return card;
		
    }
}

