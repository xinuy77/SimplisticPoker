package core;

import java.util.HashMap;

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
	private Util  util              = new Util();
	
	public boolean firstHandWins(Hand hand_1, Hand hand_2) {
		int handResult_1 = handResultToInt(hand_1);
		int handResult_2 = handResultToInt(hand_2);
		System.out.println("handReesut1 : "+ handResult_1);
		System.out.println("result 2:" + handResult_2);
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
		if(handResult_1 == straightFlush) {
			if(firstStraightFlushWins(hand_1, hand_2)) {
				return true;
			}
		}
		if(handResult_1 == fourOfAKind) {
			if(firstNPletWins(hand_1, hand_2, 4)) {
				return true;
			}
		}
		if(handResult_1 == fullHouse || handResult_1 == threeOfAKind) {
			if(firstNPletWins(hand_1, hand_2, 3)) {
				return true;
			}
		}
		if(handResult_1 == flush) {
			if(firstFlushWins(hand_1, hand_2)) {
				return true;
			}
		}
		if(handResult_1 == straight) {
			if(firstStraightWins(hand_1, hand_2)) {
				return true;
			}
		}
		if(handResult_1 == twoPair) {
			/*if(firstTwoPairWins(hand_1, hand_2)) {
				return true;
			}*/
		}
		
		return false;
	}
	
	private boolean firstStraightWins(Hand hand_1, Hand hand_2) {
		Card firstHandCard  = hand_1.getCard(4);
		Card secondHandCard = hand_2.getCard(4);
		
		if(firstHandCard.greaterRankThan(secondHandCard)) {
			return true;
		}
		if(firstHandCard.equalRank(secondHandCard)) {
			if(firstHandCard.greaterSuitThan(secondHandCard)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean firstFlushWins(Hand hand_1, Hand hand_2) {
		Card firstHandCard  = hand_1.getCard(4);
		Card secondHandCard = hand_2.getCard(4);
		
		if(hand_1.isEqualRankHand(hand_2)) {
			if(firstHandCard.greaterSuitThan(secondHandCard)) {
				return true;
			}
		}
		if(firstHandCard.greaterRankThan(secondHandCard)) {
			return true;
		}
		return false;
	}
	
	private boolean firstNPletWins(Hand hand_1, Hand hand_2, int n) {
		HashMap<String, Integer> firstHandPairs           = hand_1.getPairCounter();
		HashMap<String, Integer> secondHandPairs          = hand_2.getPairCounter();
		String                   firstHandQuadrupletRank  = util.getKeyByValue(firstHandPairs, n);
		String                   secondHandQuadrupletRank = util.getKeyByValue(secondHandPairs, n);
		
		if(util.toIntRank(firstHandQuadrupletRank) > util.toIntRank(secondHandQuadrupletRank)) {
			return true;
		}
		return false;
	}
	
	private boolean firstStraightFlushWins(Hand hand_1, Hand hand_2) {
		Card firstHandCard  = hand_1.getCard(4);
		Card secondHandCard = hand_2.getCard(4);
		
		if(firstHandCard.greaterRankThan(secondHandCard)) {
			return true;
		}
		// here
		if(firstHandCard.equalRank(secondHandCard)) {
			if(firstHandCard.greaterSuitThan(secondHandCard)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean firstRoyalFlushWins(Hand hand_1, Hand hand_2) {
		Card firstHandCard  = hand_1.getCard(0);
		Card secondHandCard = hand_2.getCard(0);
		
		if(firstHandCard.greaterSuitThan(secondHandCard)) {
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
		else if(hand.isThreeOfAKind()) {
			return threeOfAKind;
		}
		return -1;
	}
}
