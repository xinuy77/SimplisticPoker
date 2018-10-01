package core;

public class Player {
	private boolean isAi;
	private Card[]  hand;
	private Card[]  exchange;
	private Util    util = new Util();
	
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
		System.out.println("isOneCardAwayRF:" + player.isCardAwayFromRoyalFlush());

		System.out.println("wants to exchange: " + player.wantsToExchange());
	}
	
	public Card[] getExchangeCard() {
		return exchange;
	}
	
	public Player(Card[] hand, boolean isAi) {
		this.hand = hand;
		this.isAi = isAi;
	}
	
	public boolean isAi() {
		return isAi;
	}
	
	public void setHand(Card[] card) {
		hand = card;
	}
	
	private Card getNonRoyalFlushCard() {
		for(int i = 0; )
	}
	
	private boolean isCardAwayFromRoyalFlush() {
		int n             = 4;
		int containsCount = 0;
		Card card;
		if(handHasSameSuit(n)) {
			if(handHasThisRank(util.ace)) {
				containsCount++;
			}
			if(handHasThisRank(util.king)) {
				containsCount++;
			}
			if(handHasThisRank(util.queen)) {
				containsCount++;
			}
			if(handHasThisRank(util.jack)) {
				containsCount++;
			}
			if(handHasThisRank("10")) {
				containsCount++;
			}
		}
		if(containsCount == n) {
			getNonRoyalFlushCard();
			return true;
		}
		return false;
	}
	
	private boolean isOneCardAway() {
		if(isCardAwayFromRoyalFlush()/*    ||
		   isCardAwayFromStraightFlush() ||
		   isCardAwayFromFullHouse()     ||
		   isCardAwayFromFlush()         ||
		   isCardAwayFromStraight()*/) {
			return true;
		}
		return false;
	}
	
	public boolean wantsToExchange() {
		if(isStraightOrBetter()) {
			return false;
		}
		else if(isOneCardAway()) {
			return true;
		}
		return true;
	}
	
	private boolean isFullHouse() {
		Card[]  hand          = util.sortCard(this.hand);
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
		Card[] hand           = util.sortCard(this.hand);
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
			if(handHasThisRank(util.ace) &&
			   handHasThisRank(util.king) &&
			   handHasThisRank(util.queen) &&
			   handHasThisRank(util.jack) &&
			   handHasThisRank("10")) {
				return true;
			}
		}
		return false;
	}
	
	private boolean handIsSequence() {
		Card[] hand = util.sortCard(this.hand);
		String rank = hand[0].getRank();

		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getRank().equals(rank)) {
				return false;
			}
			rank = util.incrementRank(rank);
		}
		
		return true;
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
	
	// return true if hand has n same suit
	private boolean handHasSameSuit(int n) {
		String suit      = hand[0].getSuit();
		int    sameCount = 0;
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getSuit().equals(suit)) {
				sameCount++;
			}
		}
		if(sameCount == n) {
			return true;
		}
		return false;
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
