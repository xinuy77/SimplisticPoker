package core;

public class Evaluator {
	private final int royalFlush    = 9;
	private final int straightFlush = 8;
	private final int fourOfAKind   = 7;
	private final int fullHouse     = 6;
	private final int flush         = 5;
	private final int straight      = 4;
	private final int threeOfAKind  = 3;
	private final int twoPair       = 2;
	private final int pair          = 1;
	private final int highCard      = 0;
	
	public boolean firstHandWins(Hand hand_1, Hand hand_2) {
		int handResult_1 = handResultToInt(hand_1);
		int handResult_2 = handResultToInt(hand_2);
		
		if(handResult_1 < handResult_2) {
			return false;
		}
		
		if(handResult_1 > handResult_2) {
			return true;
		}
		
		if(handResult_1 == royalFlush) {
			if(firstRoyalFlushWins(hand_1, hand_2)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean firstRoyalFlushWins(Hand hand_1, Hand hand_2) {
		Card firstHandCard  = hand_1.getCard(0);
		Card secondHandCard = hand_2.getCard(0);
		
		if(firstHandCard.toIntSuit() > secondHandCard.toIntSuit()) {
			return true;
		}
		return false;
	}
	
	private int handResultToInt(Hand hand) {
		if(hand.isRoyalFlush()) {
			return royalFlush;
		}
		else if(hand.isStraightFlush()) {
			return straightFlush;
		}
		else if(hand.isFourOfAKind()) {
			return fourOfAKind;
		}
		else if(hand.isFullHouse()) {
			return fullHouse;
		}
		else if(hand.isFlush()) {
			return flush;
		}
		else if(hand.isStraight()) {
			return straight;
		}
		return -1;
	}
}
