package core;

public class Player {
	private boolean isAi;
	private Card[]  hand;
	private final String jack  = "J";
	private final String queen = "Q";
	private final String king  = "K";
	private final String ace   = "A";
	
	public Player(Card[] hand, boolean isAi) {
		this.hand = hand;
		this.isAi = isAi;
	}
	
	
	public void setHand(Card[] card) {
		hand = card;
	}
	
	public boolean wantsToExchange() {
		boolean wantsToChange = null;
		if(isStraightOrBetter()) {
			wantsToChange = false;
		}
		return wantsToChange;
	}
	
	private boolean isStraightOrBetter() {
		if(isRoyalFlush()    || 
		   isStraightFlush() || 
		   isFourOfAKind()   ||
		   isFullHouse()     ||
		   isFlush()         ||
		   isStraight()) {
			return true;
		}
		return false;
	}
	
	private boolean isStraightFlush() {
		if(handHasSameSuit() && handIsSequence()) {
			return true;
		}
		return false;
	}
	
	private boolean isRoyalFlush() {
		if(handHasSameSuit()) {
			if(handHasThisRank("A") &&
			   handHasThisRank("K") &&
			   handHasThisRank("Q") &&
			   handHasThisRank("J") &&
			   handHasThisRank("10")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean handIsSequence() {
		Card[] hand = sortCard(this.hand);
		String rank = hand[0].getRank();
		
		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getRank().equals(rank)) {
				return false;
			}
			rank = incrementRank(rank);
		}
		
		return true;
	}
	
	private String incrementRank(String rank) {
		String nextRank = "";
		if(rank.equals(ace)) {
			nextRank = "2";
		}
		else if(rank.equals(jack)) {
			nextRank = queen;
		}
		else if(rank.equals(queen)) {
			nextRank = king;
		}
		else if(rank.equals(king)) {
			nextRank = ace;
		}
		else {
			nextRank = "" + (Integer.parseInt(rank) + 1);
		}
		
		return nextRank;
	}
	
	private int toIntRank(String rank) {
		if(rank == "A") {
			return 1;
		}
		if(rank == "K") {
			return 13;
		}
		if(rank == "Q") {
			return 12;
		}
		if(rank == "J") {
			return 11;
		}
		return Integer.parseInt(rank);
	}
	
	private String toStringRank(int rank) {
		if(rank == 1) {
			return "A";
		}
		if(rank == 13) {
			return "K";
		}
		if(rank == 12) {
			return "Q";
		}
		if(rank == 11) {
			return "J";
		}
		return "" + rank;
	}
	
	private Card[] sortCard(Card[] arr) {
		int n = arr.length; 
    	for (int i=1; i<n; ++i) { 
            Card key = arr[i]; 
            int  j   = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && isGreaterThan(arr[j], key)) { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    	return arr;
	}
	
	private boolean isGreaterThan(Card card_1, Card card_2) {
		if(toIntRank(card_1.getRank()) > toIntRank(card_2)) {
			return true;
		}
		return false;
	}
	
	private boolean handHasThisRank(String rank) {
		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getRank().equals(rank)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean handHasSameSuit() {
		String suit = hand[0].getSuit();
		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean handContains(Card card) {
		String rank = card.getRank();
		String suit = card.getSuit();
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(rank) &&
			   hand[i].getSuit().equals(suit)) {
				return true;
			}
		}
		return false;
	}
}
