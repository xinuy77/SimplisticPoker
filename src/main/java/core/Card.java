package core;

public class Card {
	private String suit;
	private String rank;
	private Util   util       = new Util();
	private final int spade   = 4;
	private final int heart   = 3;
	private final int diamond = 2;
	private final int clubs   = 1;
 	
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
	
	public boolean greaterRankThan(Card card) {
		int curRank    = util.toIntRank(rank);
		int targetRank = util.toIntRank(card.getRank());
		
		if(curRank > targetRank) {
			return true;
		}
		return false;
	}
	
	public boolean greaterSuitThan(Card card) {
		int curSuit    = toIntSuit();
		int targetSuit = card.toIntSuit();
		
		if(curSuit > targetSuit) {
			return true;
		}
		return false;
	}
	
	public boolean equalRank(Card card) {
		String targetRank = card.getRank();
		
		if(targetRank.equals(rank)) {
			return true;
		}
		return false;
	}
	
	public int toIntSuit() {
		if(suit.equals(util.spade)) {
			return spade;
		}
		else if(suit.equals(util.heart)) {
			return heart;
		}
		else if(suit.equals(util.diamond)) {
			return diamond;
		}
		else if(suit.equals(util.club)){
			return clubs;
		}
		return -1;
	}
	
}
