package core;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private boolean isAi;
	private Hand    hand;
	private ArrayList<Integer> exchangeIndex        = new ArrayList<Integer>();
	private ArrayList<Integer> exchangeOnlyOneIndex = new ArrayList<Integer>();
	private Util    util                            = new Util();
	/*
	public static void main(String[] args) {
		String cardPath   = "./src/main/resources/card.txt";
		CardDeck cardDeck = new CardDeck(cardPath);
		Card first        = new Card("H", "4");
		Card second       = new Card("H", "J");
		Card third        = new Card("H", "5");
		Card forth        = new Card("H", "6");
		Card fifth        = new Card("H", "7");
		Card[] hand       = {first, second, third, forth, fifth};
		boolean isAi      = true;
		Player player     = new Player(hand, isAi);
		System.out.println(player.toStringHand());
		System.out.println("isStraightFlush:" + player.isStraightFlush());
		System.out.println("isRoyalFlush:" + player.isRoyalFlush());
		System.out.println("isFourofAKind:" + player.isFourOfAKind());
		System.out.println("isFullHouse:" + player.isFullHouse());
		System.out.println("isFlush:" + player.isFlush());
		System.out.println("isStraight:" + player.isStraight());
		//System.out.println("isOneCardAwayRF:" + player.isOneCardAwayFromRoyalFlush());
		System.out.println("isOneCardAwaySF:" + player.isOneCardAwayFromStraightFlush());
		/*System.out.println("has four rank in sequence:" + player.hasNRankInSequence(4));
		System.out.println("has three rank in sequence:" + player.hasNRankInSequence(3));
		System.out.println("is One card away from full house:" + player.isOneCardAwayFromFullHouse());
		System.out.println("is One card away from flush:" + player.isOneCardAwayFromFlush());
		*///System.out.println("is One card away from straight:" + player.isOneCardAwayFromStraight());
		
	////	System.out.println("is One card away :" + player.isOneCardAway());
		//System.out.println("wants to exchange :" + player.wantsToExchange());
	/*	System.out.println("Here is card which ai want to exchange: " + player.toStringExchangeCard());
		System.out.println("Here is card which ai want to exchange: " + player.toStringExchangeOnlyOneCard());
		//System.out.println("suspicious Sequence:" + player.getSuspiciousSequenceIndex().toString());
		System.out.println("Here is result of sequence counter: " + Arrays.toString(player.getSequenceCounter()));
		
		//System.out.println("wants to exchange: " + player.wantsToExchange());
	}*/
	
	public Player(Card[] hand, boolean isAi) {
		if(hand != null) {
			this.hand = new Hand(hand);
		}
		this.isAi = isAi;
	}
	
	public Hand getHand() {
		return hand;
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
		for(int i = 0; i < exchangeIndex.size(); i++) {
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
			result += hand[exchangeIndex.get(i)].toString();
		}
		return result;
	}
	
	private boolean isOneCardAwayFromFlush() {
		Card[] hand = this.hand.getHand();
		if(isFlush()) {
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
		
		if(isFullHouse()) {
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
		if(isStraight()) {
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
		if(isStraightFlush()) {
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
		if(isRoyalFlush()) {
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
			System.out.println("was one card away from RF");
			return true;
		}
		else if(isOneCardAwayFromStraightFlush()) {
			System.out.println("was one card away from SF");
			return true;
		}
		else if(isOneCardAwayFromFullHouse()) {
			System.out.println("was one card away from FF");
			return true;
		}
		else if(isOneCardAwayFromFlush()) {
			System.out.println("was one card away from FFF");
			return true;
		}
		else if(isOneCardAwayFromStraight()) {
			System.out.println("was one card away from S");
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
	
	public boolean wantsToExchange() {
		if(isStraightOrBetter()) {
			System.out.println("Was straight or better");
			return false;
		}
		else if(isOneCardAway()) {
			System.out.println("Was one card away");
			return true;
		}
		else if(hasThreeSameSuit()) {
			return true;
		}
		return true;
	}
	
	private boolean isFullHouse() {
	//	Card[]  hand          = util.sortCard(this.hand);
		int     matchCount    = 0;
		int     matchedNum    = 0;
		boolean changedTarget = false;
		Card[]  hand          = this.hand.getHand();
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
		if(hand.hasFourSameRank()) {
			return true;
		}
		return false;
	}
	
	private boolean isStraight() {
		if(!hand.handHasSameSuit() && hand.handIsSequence()) {
			return true;
		}
		return false;
	}
	
	private boolean isFlush() {
		if(hand.handHasSameSuit() && !hand.handIsSequence()) {
			return true;
		}
		return false;
	}
	
	public boolean isStraightOrBetter() {
		if(isRoyalFlush()) {
			System.out.println("Was RF!");
			return true;
		}
		else if(isStraightFlush()) {
			System.out.println("Was SF!");
			return true;
		}
		else if(isFourOfAKind()) {
			System.out.println("Was FOK!");
			return true;
		}
		else if(isFullHouse()) {
			System.out.println("Was FH!");
			return true;
		}
		else if(isFlush()) {
			System.out.println("Was F!");
			return true;
		}
		else if(isStraight()) {
			System.out.println("Was S!");
			return true;
		}
		
		return false;
	}
	
	private boolean isStraightFlush() {
		if(hand.handHasSameSuit() && hand.handIsSequence()) {
			return true;
		}
		return false;
	}
	
	private boolean isRoyalFlush() {
		if(hand.handHasSameSuit()) {
			if(hand.handHasThisRank(util.ace) &&
		       hand.handHasThisRank(util.king) &&
		       hand.handHasThisRank(util.queen) &&
		       hand.handHasThisRank(util.jack) &&
		       hand.handHasThisRank("10")) {
				return true;
			}
		}
		return false;
	}
}
