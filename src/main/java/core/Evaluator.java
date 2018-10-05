package core;

import java.util.HashMap;
import java.util.Map;

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
			if(firstTwoPairWins(hand_1, hand_2)) {
				return true;
			}
		}
		if(handResult_1 == pair) {
			if(firstOnePairWins(hand_1, hand_2)) {
				return true;
			}
		}
		if(handResult_1 == highCard) {
			if(firstHighCardWins(hand_1, hand_2)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean firstHighCardWins(Hand hand_1, Hand hand_2) {
		Card   card_1    = hand_1.getCard(4);
		Card   card_2    = hand_2.getCard(4);
		
		if(card_1.greaterRankThan(card_2)) {
			return true;
		}
		if(card_1.equalRank(card_2)) {
			if(card_1.greaterSuitThan(card_2)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean firstOnePairWins(Hand hand_1, Hand hand_2) {
		HashMap<String, Integer> pairCounter_1 = hand_1.getPairCounter();
		HashMap<String, Integer> pairCounter_2 = hand_2.getPairCounter();
		String rank_1                          = util.getKeyByValue(pairCounter_1, 2);
		String rank_2                          = util.getKeyByValue(pairCounter_2, 2);
		int    intRank_1                       = util.toIntRank(rank_1);
		int    intRank_2                       = util.toIntRank(rank_2);
		
		if(intRank_1 > intRank_2) {
			return true;
		}
		else if(intRank_1 == intRank_2) {
			String highestSuit_1 = getHighestSuitInPair(hand_1, rank_1);
			String highestSuit_2 = getHighestSuitInPair(hand_2, rank_2);
			if(util.toIntSuit(highestSuit_1) > util.toIntSuit(highestSuit_2)) {
				return true;
			}
		}
			
		return false;
	}
	
	private boolean firstTwoPairWins(Hand hand_1, Hand hand_2) {
		HashMap<String, Integer> pairCounter_1      = hand_1.getPairCounter();
		HashMap<String, Integer> pairCounter_2      = hand_2.getPairCounter();
		String                   firstHandPairRank  = getHighestRankInTwoPair(pairCounter_1);
		String                   secondHandPairRank = getHighestRankInTwoPair(pairCounter_2);
		int                      firstPairRank      = util.toIntRank(firstHandPairRank);
		int                      secondPairRank     = util.toIntRank(secondHandPairRank);

		if(firstPairRank > secondPairRank) {
			return true;
		}
		else if(firstPairRank == secondPairRank) {
			String firstPairSuit  = getHighestSuitInPair(hand_1, firstHandPairRank);
			String secondPairSuit = getHighestSuitInPair(hand_2, secondHandPairRank);
			
			if(util.toIntSuit(firstPairSuit) > util.toIntSuit(secondPairSuit)) {
				return true;
			}
		}
		return false;
	}
	
	private String getHighestRankInTwoPair(HashMap<String, Integer> pairCounter) {
		String highestRank = null;
		
		for(Map.Entry<String, Integer> pair: pairCounter.entrySet()) {
			if(pair.getValue() != 2) {
				continue;
			}
			String curRank = pair.getKey();
			if(highestRank == null) {
				highestRank = curRank;
				continue;
			}
			if(util.toIntRank(highestRank) < util.toIntSuit(curRank)) {
				highestRank = curRank;
			}
		}
		return highestRank;
	}
	
	private String getHighestSuitInPair(Hand hand, String highestPairRank) {
		String highestSuit = null;
		
		for(int i = 0; i < hand.length(); i++) {
			Card   curCard = hand.getCard(i);
			String curRank = curCard.getRank();
			String curSuit = curCard.getSuit();
			if(!curRank.equals(highestPairRank)) {
				continue;
			}
			if(highestSuit == null || util.toIntSuit(highestSuit) < util.toIntSuit(curSuit)) {
				highestSuit = curSuit;
			}
		}
		
		return highestSuit;
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
		else if(hand.isTwoPair()) {
			return twoPair;
		}
		else if(hand.isOnePair()) {
			return pair;
		}
		else if(hand.isHighCard()) {
			return highCard;
		}
		return -1;
	}
}
