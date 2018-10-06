package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Player {
	private boolean isAi;
	private boolean exchanged                       =false;
	private Hand    hand;
	private ArrayList<Integer> exchangeIndex        = new ArrayList<Integer>();
	private ArrayList<Integer> exchangeOnlyOneIndex = new ArrayList<Integer>();
	private Util    util                            = new Util();
	
	public Player(Card[] hand, boolean isAi) {
		if(hand != null) {
			this.hand = new Hand(hand);
		}
		this.isAi = isAi;
	}
	
	public boolean exchanged() {
		return exchanged;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public int exchangeSize() {
		return exchangeIndex.size() + exchangeOnlyOneIndex.size();
	}
	
	public void exchange(Card[] exchangeCard, Card[] newCard) {
		Card[] hand       = this.hand.getHand();
		int    newCardPos = 0;
		
		for(int j = 0; j < exchangeCard.length; j++) {
			if(exchangeCard[j] == null) {
				continue;
			}
			for(int i = 0; i < hand.length; i++) {
				if(exchangeCard[j].equals(hand[i])) {
					hand[i] = newCard[newCardPos++];
				}
			}
		}
		exchanged = true;
		this.hand.setHand(hand);
	}
	
	public String toStringExchangeOnlyOneCard() {
		String result = "";
		Card[] hand   = this.hand.getHand();
		for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
			result += hand[exchangeOnlyOneIndex.get(i)] + " ";
		}
		return result;
	}
	
	public Card[] getExchangeOnlyOneCardArr() {
		Card[] exchangeCard = new Card[5];
		Card[] hand         = this.hand.getHand();
		for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
			exchangeCard[i] = hand[exchangeOnlyOneIndex.get(i)];
		}
		return exchangeCard;
	}
	
	public boolean containsInExchangeOnlyOneCardArr(Card card) {
		Card[] hand = this.hand.getHand();
		for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
			if(card.equals(hand[exchangeOnlyOneIndex.get(i)])) {
				return true;
			}
		}
		return false;
	}
	
	public Card[] getExchangeCardArr() {
		Card[] hand         = this.hand.getHand();
		Card[] exchangeCard = new Card[5];
		for(int i = 0; i < exchangeIndex.size(); i++) {
			exchangeCard[i] = hand[exchangeIndex.get(i)];
		}
		exchangeCard = util.cleanNullCard(exchangeCard);
		return exchangeCard;
	}
	
	public ArrayList<Integer> getExchangeIndex() {
		return exchangeIndex;
	}
	
	public void resetExchange() {
		exchangeIndex.clear();
		exchangeOnlyOneIndex.clear();
	}
	
	public boolean isAi() {
		return isAi;
	}
	
	public void setHand(Card[] card) {
		this.hand = new Hand(card);
	}
	
	public String toStringExchangeCard() {
		String result = "";
		Card[] hand   = this.hand.getHand();
		for(int i = 0; i < exchangeIndex.size(); i++) {
			result += hand[exchangeIndex.get(i)].toString() + " ";
		}
		return result;
	}
	
	private boolean isOneCardAwayFromFlush() {
		Card[] hand = this.hand.getHand();
		if(this.hand.isFlush()) {
			return false;
		}
		HashMap<String, Integer> sameSuitCount = this.hand.getSuitCount();
		if(sameSuitCount.containsValue(4)) {
			String exchangeSuit = util.getKeyByValue(sameSuitCount, 1);
			for(int i = 0; i < hand.length; i++) {
				String tmpSuit = hand[i].getSuit();
				if(tmpSuit.equals(exchangeSuit)) {
					exchangeIndex.add(i);
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isOneCardAwayFromFullHouse() {
		Card[] hand                          = this.hand.getHand();
		HashMap<String, Integer> pairCounter = new HashMap<String, Integer>();
		String curRank                       = null;
		String exchangeRank                  = null;
		int    curCounter                    = 0;
		
		if(this.hand.isFullHouse()) {
			return false;
		}
		
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
		if(pairCounter.containsValue(3) && pairCounter.containsValue(1)) {
			exchangeRank = util.getKeyByValue(pairCounter, 1);
		}
		else if(pairCounter.containsValue(2)) {
			String twoPairRank = util.getKeyByValue(pairCounter, 2);
			pairCounter.remove(twoPairRank);
			if(pairCounter.containsValue(2)) {
				exchangeRank = util.getKeyByValue(pairCounter, 1);
			}
		}
		if(exchangeRank != null) {
			for(int i = 0; i < hand.length; i++) {
				if(hand[i].getRank().equals(exchangeRank)) {
					exchangeIndex.add(i);
					return true;
				}
			}
		}
		return false;
	}
	
	private ArrayList<Integer>	getOneCardAwaySequenceIndex() {
		ArrayList<Integer> suspiciousIndex = new ArrayList<Integer>();
		Card[]             hand            = this.hand.getHand();
		for(int i = 0; i < hand.length; i++) {
			int    suspiciousRankIndex = i;
			Card   suspiciousCard      = hand[i];
			Card[] fourCard            = new Card[4];
			hand[i] = null;
			int    counter             = 0;
			for(int j = 0; j < hand.length; j++) {
				if(hand[j] != null) {
					fourCard[counter++] = hand[j];
				}
			}
			int     inSequenceCounter = 0;
			boolean doubleIncremented = false;
			for(int j = 0; j < fourCard.length; j++) {
				if(j == 3) {
					break;
				}
				String curRank            = fourCard[j].getRank();
				String incrementedCurRank = util.incrementRank(curRank);
				String nextRank           = fourCard[j+1].getRank();
				if(incrementedCurRank.equals(nextRank)) {
					inSequenceCounter++;
					continue;
				}
				else if(util.incrementRank(incrementedCurRank).equals(nextRank) && !doubleIncremented) {
					inSequenceCounter++;
					doubleIncremented = true;
					continue;
				}
			}
			if(inSequenceCounter == 3) {
				suspiciousIndex.add(suspiciousRankIndex);
			}
			hand[i] = suspiciousCard;
		}
		return suspiciousIndex;
	}
	
	private boolean isOneCardAwayFromStraight() {
		if(hand.isStraight()) {
			return false;
		}
		ArrayList<Integer> oneCardAwaySequenceIndex = getOneCardAwaySequenceIndex();
		if(oneCardAwaySequenceIndex.size() != 0) {
			exchangeOnlyOneIndex.addAll(oneCardAwaySequenceIndex);
			return true;
		}
		return false;
	}
	
	private boolean isOneCardAwayFromStraightFlush() {
		Card[]                   hand          = this.hand.getHand();
		HashMap<String, Integer> sameSuitCount = this.hand.getSuitCount();
		String                   targetSuit    = null;
		int                      differentSuitIndex = -1;
		if(this.hand.isStraightFlush()) {
			return false;
		}
		if(sameSuitCount.containsValue(4)) {
			targetSuit = util.getKeyByValue(sameSuitCount, 4);
			for(int i = 0; i < hand.length; i++) {
				if(!hand[i].getSuit().equals(targetSuit)) {
					differentSuitIndex = i;
					break;
				}
			}
		}
		if(sameSuitCount.containsValue(5) || sameSuitCount.containsValue(4)) {
			if(isOneCardAwayFromStraight()) {
				for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
					if(hand[exchangeOnlyOneIndex.get(i)].getSuit().equals(targetSuit)) {
						exchangeOnlyOneIndex.remove(i);
					}
				}
				return true;
			}
			else if(differentSuitIndex != -1 && util.intArrayContains(this.hand.getSequenceCounter(), 5)) {
				exchangeIndex.add(differentSuitIndex);
				return true;
			}
		}
		return false;
	}
	
	private boolean isOneCardAwayFromRoyalFlush() {
		int n               = 4;
		int containsCount   = 0;
		int suspiciousIndex = -1;
		if(hand.isRoyalFlush()) {
			return false;
		}
		HashMap<String, Integer> suitCount = hand.getSuitCount();
		if(suitCount.containsValue(4)) {
			Card[] hand = this.hand.getHand();
			String suit = util.getKeyByValue(suitCount, 1);
			for(int i = 0; i < hand.length; i++) {
				if(hand[i].getSuit().equals(suit)) {
					suspiciousIndex = i;
					break;
				}
			}
		}
		if(this.hand.handHasSameSuit(n) || this.hand.handHasSameSuit()) {
			if(this.hand.handHasThisRank(util.ace)) {
				containsCount++;
			}
			if(this.hand.handHasThisRank(util.king)) {
				containsCount++;
			}
			if(this.hand.handHasThisRank(util.queen)) {
				containsCount++;
			}
			if(this.hand.handHasThisRank(util.jack)) {
				containsCount++;
			}
			if(this.hand.handHasThisRank("10")) {
				containsCount++;
			}
		}	
		if(containsCount == n || containsCount == 5) {
			if(suspiciousIndex != -1) {
				exchangeIndex.add(suspiciousIndex);
			}
			else {
				exchangeIndex.add(0);
			}
			return true;
		}
		return false;
	}
	
	private boolean isOneCardAway() {
		if(isOneCardAwayFromRoyalFlush()) {
			return true;
		}
		else if(isOneCardAwayFromStraightFlush()) {
			return true;
		}
		else if(isOneCardAwayFromFullHouse()) {
			return true;
		}
		else if(isOneCardAwayFromFlush()) {
			return true;
		}
		else if(isOneCardAwayFromStraight()) {
			return true;
		}
		return false;
	}
	
	private boolean hasThreeSameSuit() {
		HashMap<String, Integer> suitCount   = hand.getSuitCount();
		int                      numSameSuit = 3;
		if(suitCount.containsValue(numSameSuit)) {
			String majoritySuit  = util.getKeyByValue(suitCount, numSameSuit);
			exchangeIndex        = hand.getCardIndexNotSameSuit(majoritySuit);
			return true;
		}
		return false;
	}
	
	private boolean hasThreeCardInSequence() {
		int[]  sequenceCounter           = hand.getSequenceCounter();
		int    firstIndexOfThreeSequence = util.getIndexOfValueInIntArr(sequenceCounter, 3);
		Card[] hand                      = this.hand.getHand();
		
		if(firstIndexOfThreeSequence == -1) {
			return false;
		}
		for(int i = 0; i < hand.length; i++) {
			if(i < firstIndexOfThreeSequence || i > firstIndexOfThreeSequence+2) {
				exchangeIndex.add(i);
			}
		}
		return true;
	}
	
	public boolean hasOnePair() {
		HashMap<String, Integer> pairCounter = hand.getPairCounter();
		int                      pairs       = 2;
		
		if(!pairCounter.containsValue(pairs)) {
			return false;
		}
		int noPairCount = 0;
		for(Map.Entry<String, Integer> pairCount : pairCounter.entrySet()) {
			if(pairCount.getValue() == 1) {
				noPairCount++;
			}
		}
		if(noPairCount != 3) {
			return false;
		}
		String pairedRank = util.getKeyByValue(pairCounter, pairs);
		Card[] hand       = this.hand.getHand();
		for(int i = 0; i < hand.length; i++) {
			if(hand[i].getRank().equals(pairedRank)) {
				continue;
			}
			exchangeIndex.add(i);
		}
		return true;
	}
	
	private void keepTwoHighestCard() {
		int[]  indexOfThreeLowestCard = hand.getIndexOfThreeLowestCard();
		
		for(int i = 0; i < indexOfThreeLowestCard.length; i++) {
			exchangeIndex.add(indexOfThreeLowestCard[i]);
		}
	}
	
	public boolean wantsToExchange() {
		if(isStraightOrBetter()) {
			return false;
		}
		else if(isOneCardAway()) {
			return true;
		}
		else if(hasThreeSameSuit()) {
			return true;
		}
		else if(hasThreeCardInSequence()) {
			return true;
		}
		else if(hasOnePair()) {
			return true;
		}
		else {
			keepTwoHighestCard();
		}
		return true;
	}
	
	public boolean isStraightOrBetter() {
		if(hand.isRoyalFlush()) {
			return true;
		}
		else if(hand.isStraightFlush()) {
			return true;
		}
		else if(hand.isFourOfAKind()) {
			return true;
		}
		else if(hand.isFullHouse()) {
			return true;
		}
		else if(hand.isFlush()) {
			return true;
		}
		else if(hand.isStraight()) {
			return true;
		}
		
		return false;
	}
}
