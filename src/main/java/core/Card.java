package core;

public class Card {
	private String suit;
	private String rank;
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String toString() {
		return "" + suit + rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	public boolean equals(Card card) {
		String rank = card.getRank();
		String suit = card.getSuit();
		if(rank.equals(this.rank) && suit.equals(this.suit)) {
			return true;
		}
		return false;
	}
}
