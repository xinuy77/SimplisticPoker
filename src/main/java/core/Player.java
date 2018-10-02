package core;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private boolean isAi;
	private Card[]  hand;
	private ArrayList<Integer> exchangeIndex = new ArrayList<Integer>();
	private Util    util                     = new Util();
	
	public static void main(String[] args) {
		String cardPath   = "./src/main/resources/card.txt";
		CardDeck cardDeck = new CardDeck(cardPath);
		Card first        = new Card("D", "10");
		Card second       = new Card("H", "Q");
		Card third        = new Card("C", "K");
		Card forth        = new Card("S", "8");
		Card fifth        = new Card("D", "9");
		Card[] hand       = {first, second, third, forth, fifth};
		boolean isAi      = true;
		Player player     = new Player(hand, isAi);
		System.out.println("isStraightFlush:" + player.isStraightFlush());
		System.out.println("isRoyalFlush:" + player.isRoyalFlush());
		System.out.println("isFourofAKind:" + player.isFourOfAKind());
		System.out.println("isFullHouse:" + player.isFullHouse());
		System.out.println("isFlush:" + player.isFlush());
		System.out.println("isStraight:" + player.isStraight());
		System.out.println("isOneCardAwayRF:" + player.isOneCardAwayFromRoyalFlush());
		System.out.println("isOneCardAwaySF:" + player.isOneCardAwayFromStraightFlush());
		System.out.println("has four rank in sequence:" + player.hasNRankInSequence(4));
		System.out.println("has three rank in sequence:" + player.hasNRankInSequence(3));
		System.out.println("is One card away from full house:" + player.isOneCardAwayFromFullHouse());
		System.out.println("Here is card which ai want to exchange: " + player.toStringExchangeCard());
		System.out.println("wants to exchange: " + player.wantsToExchange());
	}
	
	public ArrayList<Integer> getExchangeIndex() {
		return exchangeIndex;
	}
	
	public Player(Card[] hand, boolean isAi) {
		this.hand = util.sortCard(hand);
		this.isAi = isAi;
		for(int i = 0; i < hand.length; i++) {
			System.out.println(hand[i].toString());
		}
	}
	
	public boolean isAi() {
		return isAi;
	}
	
	public void setHand(Card[] card) {
		hand = util.sortCard(card);
	}
	
	public String toStringExchangeCard() {
		String result = "";
		for(int i = 0; i < exchangeIndex.size(); i++) {
			result += hand[exchangeIndex.get(i)].toString();
		}
		return result;
	}
	
	private boolean isOneCardAwayFromFullHouse() {
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
	
	private boolean isOneCardAwayFromStraightFlush() {
		HashMap<String, Integer> sameSuitCount = getSuitCount();
		String                   targetRank;
		int                      unExpectedIndex;
		if(isStraightFlush()) {
			return false;
		}
		if(sameSuitCount.containsValue(4)) {
			targetRank = util.getKeyByValue(sameSuitCount, 4);
			for(int i = 0; i < hand.length; i++) {
				if(!hand[i].getSuit().equals(targetRank)) {
					exchangeIndex.add(i);
					return true;
				}
			}
		}
		else if(sameSuitCount.containsValue(5)) {
			unExpectedIndex = hasNRankInSequence(3);
			if(unExpectedIndex == 4) {
				exchangeIndex.add(4);
				return true;
			}
			if(unExpectedIndex != -1) {
				exchangeIndex.add(0);
				return true;
			}
			unExpectedIndex = hasNRankInSequence(4);
			if(unExpectedIndex == 1) {
				exchangeIndex.add(0);
				return true;
			}
			if(unExpectedIndex == 4) {
				exchangeIndex.add(4);
				return true;
			}
		}
		return false;
	}
	
	private int hasNRankInSequence(int n) {
		int     changedRank       = 0;
		String  targetRank        = hand[0].getRank();
		String  curRank           = null;
		int     unexpectedIndex   = -1;
		int     sameRankCounter[] = {0, 0, 0, 0, 0};
		int     sameRankIndex     = 0;
		for(int i = 0; i < hand.length; i++) {
			curRank = hand[i].getRank();
			if(!targetRank.equals(curRank)) {
				if(changedRank > 2) {
					return -1;
				}
				unexpectedIndex                  = i;
				changedRank                     += 1 ;
				targetRank                       = curRank;
				sameRankCounter[++sameRankIndex] = 1;
			}
			else {
				sameRankCounter[sameRankIndex]++;
			}
			targetRank = util.incrementRank(targetRank);
		}
		for(int i = 0; i < sameRankCounter.length; i++) {
			if(sameRankCounter[i] == n) {
				return unexpectedIndex;
			}
		}
		return -1;
	}
	
	private int isOneCardAwayFromRoyalFlush() {
		int n             = 4;
		int containsCount = 0;
		if(isRoyalFlush()) {
			return -1;
		}
		if(handHasSameSuit(n) || handHasSameSuit()) {
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
		if(containsCount == n || containsCount == 5) {
			exchangeIndex.add(0);
			return 0;
		}
		return -1;
	}
	
	private boolean isOneCardAway() {
		/*
		if(isOneCardAwayFromRoyalFlush() /*||
		   isOneCardAwayFromStraightFlush() ||
		   isCardAwayFromFullHouse()     ||
		   isCardAwayFromFlush()         ||
		   isCardAwayFromStraight()) {
			return true;
		}*/
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
	//	Card[]  hand          = util.sortCard(this.hand);
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
	
	private HashMap<String, Integer> getSuitCount() {
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
	private boolean handHasSameSuit(int n) {
		HashMap<String, Integer> sameSuitCount = getSuitCount();

		if(sameSuitCount.containsValue(n)) {
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
