package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hand {
	private Card[] hand;
	private Util   util = new Util();
	
	public Hand(Card[] hand) {
		setHand(hand);
	}

	public Card[] getHand() {
		return this.hand;
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
		//Card[] hand           = util.sortCard(this.hand);
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
}
