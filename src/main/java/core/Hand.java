package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hand {
	private Card[] hand;
	private Util   util = new Util();
	
	public Hand(Card[] hand) {
		setHand(hand);
	}

	public Card[] getHand() {
		return this.hand;
	}
	
	public Card getCard(int i) {
		return hand[i];
	}

	public void setHand(Card[] hand) {
		this.hand = util.sortCard(hand);
	}
	
	public boolean handIsSequence() {
		//Card[] hand = util.sortCard(this.hand);
		String rank = hand[0].getRank();

		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getRank().equals(rank)) {
				return false;
			}
			rank = util.incrementRank(rank);
		}
		
		return true;
	}
	
	public boolean handHasThisRank(String rank) {
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(rank)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean handHasSameSuit() {
		String suit = hand[0].getSuit();
		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}
	
	public String toStringHand() {
		return Arrays.toString(hand);
	}
	
	public HashMap<String, Integer> getSuitCount() {
		HashMap<String, Integer> sameSuitCount = new HashMap<String, Integer>();
		sameSuitCount.put(util.club, 0);
		sameSuitCount.put(util.heart, 0);
		sameSuitCount.put(util.diamond, 0);
		sameSuitCount.put(util.spade, 0);
		
		for(int i = 0; i < hand.length; i++) {
			int counter;
			if(hand[i].getSuit().equals(util.club)) {
				counter = sameSuitCount.get(util.club) + 1;
				sameSuitCount.put(util.club, counter);
			}
			else if(hand[i].getSuit().equals(util.heart)) {
				counter = sameSuitCount.get(util.heart) + 1;
				sameSuitCount.put(util.heart, counter);
			}
			else if(hand[i].getSuit().equals(util.diamond)) {
				counter = sameSuitCount.get(util.diamond) + 1;
				sameSuitCount.put(util.diamond, counter);
			}
			else {
				counter = sameSuitCount.get(util.spade) + 1;
				sameSuitCount.put(util.spade, counter);
			}
		}
		return sameSuitCount;
	}
	
	// return true if hand has n same suit
	public boolean handHasSameSuit(int n) {
		HashMap<String, Integer> sameSuitCount = getSuitCount();

		if(sameSuitCount.containsValue(n)) {
			return true;
		}
		return false;
	}
	
	public boolean hasFourSameRank() {
		HashMap<String, Integer> pairCounter = getPairCounter();
		if(pairCounter.containsValue(4) && pairCounter.containsValue(1)) {
			return true;
		}
		return false;
	}
	
	public int[] getIndexOfThreeLowestCard() {
		int[]  threeLowestCardIndex = new int[3];
		int    size                 = 0;
		Card[] hand                 = getHand().clone();

		for(int i = 0; i < hand.length; i++) {
			Card    suspiciousCard = hand[i];
			boolean wasCleanCard   = false;
			if(size == 3) {
				break;
			}
			for(int j = 0; j < hand.length; j++) {
				if(hand[j] == null) {
					continue;
				}
				if(suspiciousCard.greaterRankThan(hand[j])) {
					wasCleanCard = true;
					break;
				}
			}
			if(!wasCleanCard) {
				hand[i]                      = null;
				threeLowestCardIndex[size++] = i;
			} 
			
		}
		return threeLowestCardIndex;
	}
	
	public HashMap<String, Integer> getPairCounter() {
		HashMap<String, Integer> pairCounter = new HashMap<String, Integer>();
		String curRank                       = null;
		int    curCounter                    = 0;
		for(int i = 0; i < hand.length; i++) {
			curRank = hand[i].getRank();
			if(pairCounter.containsKey(curRank)) {
				curCounter = pairCounter.get(curRank);
				pairCounter.put(curRank, ++curCounter);
			}
			else {
				pairCounter.put(curRank, 1);
			}
		}
		return pairCounter;
	}
	
	public ArrayList<Integer> getCardIndexNotSameSuit(String suit) {
		ArrayList<Integer> notSameSuit = new ArrayList<Integer>();
		for(int i = 0; i < hand.length; i++) {
			if(!hand[i].getSuit().equals(suit)) {
				notSameSuit.add(i);
			}
		}
		return notSameSuit;
	}
	
	public int[] getSequenceCounter() {
		int[] sequenceCount    = {1, 1, 1, 1, 1};
		int   curSequenceIndex = 0;
		String targetRank   = util.incrementRank(hand[0].getRank());
		for(int i = 1; i < hand.length; i++) {
			String tmpRank = hand[i].getRank();
			if(tmpRank.equals(targetRank)) {
				sequenceCount[curSequenceIndex] = sequenceCount[curSequenceIndex] + 1;
			}
			else {
				curSequenceIndex = i;
				targetRank       = hand[i].getRank();
			}
			targetRank = util.incrementRank(targetRank);
		}
		return sequenceCount;
	}
	
	public boolean isFullHouse() {
	//	Card[]  hand          = util.sortCard(this.hand);
		int     matchCount    = 0;
		int     matchedNum    = 0;
		boolean changedTarget = false;
		Card[]  hand          = this.hand;
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
		
	public boolean isFourOfAKind() {
		if(hasFourSameRank()) {
			return true;
		}
		return false;
	}
	
	public boolean isThreeOfAKind() {
		HashMap<String, Integer> pairCounter = getPairCounter();
		if(pairCounter.containsValue(3) && !pairCounter.containsValue(2)) {
			return true;
		}
		return false;
	}
	
	
	public boolean isStraight() {
		if(!handHasSameSuit() && handIsSequence()) {
			return true;
		}
		return false;
	}
	
	public boolean isFlush() {
		if(handHasSameSuit() && !handIsSequence()) {
			return true;
		}
		return false;
	}
	
	public boolean isRoyalFlush() {
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
	
	public boolean isStraightFlush() {
		if(handHasSameSuit() && handIsSequence()) {
			return true;
		}
		return false;
	}
	
	public boolean isTwoPair() {
		HashMap<String, Integer> pairCounter = getPairCounter();
		int                      counter     = 0;
		
		if(!pairCounter.containsValue(2) && !pairCounter.containsValue(1)) {
			return false;
		}
		for(Map.Entry<String, Integer> pair: pairCounter.entrySet()) {
			if(pair.getValue() == 2) {
				counter++;
			}
		}
		if(counter != 2) {
			return false;
		}
		return true;
	}
	
	public boolean isOnePair() {
		HashMap<String, Integer> pairCounter = getPairCounter();
		int                      counter     = 0;
		if(!pairCounter.containsValue(2) && !pairCounter.containsValue(1)) {
			return false;
		}
		for(Map.Entry<String, Integer> pair: pairCounter.entrySet()) {
			if(pair.getValue() == 1) {
				counter++;
			}
		}
		if(counter != 3) {
			return false;
		}
		return true;
	}
	
	public boolean isHighCard() {
		HashMap<String, Integer> pairCounter = getPairCounter();
		int                      counter     = 0;
		if(pairCounter.containsValue(5) ||
	       pairCounter.containsValue(4) ||
	       pairCounter.containsValue(3) ||
	       pairCounter.containsValue(2)) {
			return false;
		}
		return true;
	}
	
	public int length() {
		return hand.length;
	}
	
	public boolean isEqualRankHand(Hand hand) {
		for(int i = 0; i < this.hand.length; i++) {
			if(!this.hand[i].equalRank(hand.getCard(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Hand hand) {
		int counter = 0;
		for(int i = 0; i < this.hand.length; i++) {
			if(this.hand[i].equals(hand.getCard(i))) {
				counter++;
			}
		}
		if(counter == 5) {
			return true;
		}
		return false;
	}
	
	public String getOneSuitOfRank(String rank) {
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(rank)) {
				return hand[i].getSuit();
			}
		}
		
		return null;
	}
}
