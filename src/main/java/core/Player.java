package core;

public class Player {
	private boolean isAi;
	private Card[]  hand;
	private final String jack  = "J";
	private final String queen = "Q";
	private final String king  = "K";
	private final String ace   = "A";
	
	public static void main(String[] args) {
		String cardPath   = "./src/main/resources/card.txt";
		CardDeck cardDeck = new CardDeck(cardPath);
		Card first        = new Card("D", "J");
		Card second       = new Card("C", "2");
		Card third        = new Card("S", "K");
		Card forth        = new Card("H", "A");
		Card fifth        = new Card("D", "10");
		Card[] hand       = {first, second, third, forth, fifth};
		boolean isAi      = true;
		Player player     = new Player(hand, isAi);
		System.out.println("isStraightFlush:" + player.isStraightFlush());
		System.out.println("isRoyalFlush:" + player.isRoyalFlush());
		System.out.println("isFourofAKind:" + player.isFourOfAKind());
		System.out.println("isFullHouse:" + player.isFullHouse());
		System.out.println("isFlush:" + player.isFlush());
		System.out.println("isStraight:" + player.isStraight());
		System.out.println("wants to exchange: " + player.wantsToExchange());
	}
	
	public Player(Card[] hand, boolean isAi) {
		this.hand = hand;
		this.isAi = isAi;
	}
	
	
	public void setHand(Card[] card) {
		hand = card;
	}
	
	public boolean wantsToExchange() {
		if(isStraightOrBetter()) {
			return false;
		}
		return true;
	}
	
	private boolean isFullHouse() {
		Card[]  hand          = sortCard(this.hand);
		int     matchCount    = 0;
		int     matchedNum    = 0;
		boolean changedTarget = false;
		String  targetRank    = hand[0].getRank();
			
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(targetRank)) {
				matchCount++;
			}
			else if(changedTarget) {
				return false;
			}
			else {
				changedTarget = true;
				matchedNum    = matchCount;
				matchCount    = 1;
				targetRank    = hand[i].getRank();
			}
		}
		if(matchCount != 2 || matchedNum != 3) {
			if(matchCount != 3 || matchedNum != 2) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isFourOfAKind() {
		if(hasFourSameRank()) {
			return true;
		}
		return false;
	}
	
	private boolean hasFourSameRank() {
		Card[] hand           = sortCard(this.hand);
		String targetRank     = hand[0].getRank();
		boolean changedTarget = false;
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(targetRank)) {
				continue;
			}
			else if(changedTarget) {
				return false;
			}
			else {
				changedTarget = true;
			}
		}
		return true;
	}
	
	private boolean isStraight() {
		if(!handHasSameSuit() && handIsSequence()) {
			return true;
		}
		return false;
	}
	
	private boolean isFlush() {
		if(handHasSameSuit() && !handIsSequence()) {
			return true;
		}
		return false;
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
		else if(rank.equals("10")) {
			nextRank = jack;
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
		System.out.println(rank);
		if(rank.equals("A")) {
			return 14;
		}
		if(rank.equals("K")) {
			return 13;
		}
		if(rank.equals("Q")) {
			return 12;
		}
		if(rank.equals("J")) {
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
		if(toIntRank(card_1.getRank()) > toIntRank(card_2.getRank())) {
			return true;
		}
		return false;
	}
	
	private boolean handHasThisRank(String rank) {
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(rank)) {
				return true;
			}
		}
		return false;
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
