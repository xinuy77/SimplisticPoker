package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Player {
	private boolean isAi;
	private Card[]  hand;
	private ArrayList<Integer> exchangeIndex        = new ArrayList<Integer>();
	private ArrayList<Integer> exchangeOnlyOneIndex = new ArrayList<Integer>();
	private Util    util                            = new Util();
	
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
		System.out.println("Here is card which ai want to exchange: " + player.toStringExchangeCard());
		System.out.println("Here is card which ai want to exchange: " + player.toStringExchangeOnlyOneCard());
		//System.out.println("suspicious Sequence:" + player.getSuspiciousSequenceIndex().toString());
		System.out.println("Here is result of sequence counter: " + Arrays.toString(player.getSequenceCounter()));
		
		//System.out.println("wants to exchange: " + player.wantsToExchange());
	}
	
	public String toStringExchangeOnlyOneCard() {
		String result = "";
		for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
			result += hand[exchangeOnlyOneIndex.get(i)] + " ";
		}
		return result;
	}
	
	public Card[] getExchangeOnlyOneCardArr() {
		Card[] exchangeCard = new Card[5];
		for(int i = 0; i < exchangeIndex.size(); i++) {
			exchangeCard[i] = hand[exchangeOnlyOneIndex.get(i)];
		}
		return exchangeCard;
	}
	
	public boolean containsInExchangeOnlyOneCardArr(Card card) {
		for(int i = 0; i < exchangeOnlyOneIndex.size(); i++) {
			if(card.equals(hand[exchangeOnlyOneIndex.get(i)])) {
				return true;
			}
		}
		return false;
	}
	
	public Card[] getExchangeCardArr() {
		Card[] exchangeCard = new Card[5];
		for(int i = 0; i < exchangeIndex.size(); i++) {
			exchangeCard[i] = hand[exchangeIndex.get(i)];
		}
		return exchangeCard;
	}
	
	public ArrayList<Integer> getExchangeIndex() {
		return exchangeIndex;
	}
	
	public Player(Card[] hand, boolean isAi) {
		if(hand != null) {
			this.hand = util.sortCard(hand);
		}
		this.isAi = isAi;
	}
	
	public void resetExchange() {
		exchangeIndex.clear();
		exchangeOnlyOneIndex.clear();
	}
	
	public boolean isAi() {
		return isAi;
	}
	
	public void setHand(Card[] card) {
		this.hand = util.sortCard(card);
	}
	
	public String toStringExchangeCard() {
		String result = "";
		for(int i = 0; i < exchangeIndex.size(); i++) {
			result += hand[exchangeIndex.get(i)].toString();
		}
		return result;
	}
	
	private boolean isOneCardAwayFromFlush() {
		if(isFlush()) {
			return false;
		}
		HashMap<String, Integer> sameSuitCount = getSuitCount();
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
	
	private ArrayList<Integer>	getOneCardAwaySequenceIndex() {
		ArrayList<Integer> suspiciousIndex = new ArrayList<Integer>();
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
		HashMap<String, Integer> sameSuitCount = getSuitCount();
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
			else if(differentSuitIndex != -1 && util.intArrayContains(getSequenceCounter(), 5)) {
				exchangeIndex.add(differentSuitIndex);
				return true;
			}
		}
		return false;
	}
	
	public int[] getSequenceCounter() {
		int[] sequenceCount = {1, 1, 1, 1, 1};
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
	
	private boolean isOneCardAwayFromRoyalFlush() {
		int n               = 4;
		int containsCount   = 0;
		int suspiciousIndex = -1;
		if(isRoyalFlush()) {
			return false;
		}
		HashMap<String, Integer> suitCount = getSuitCount();
		if(suitCount.containsValue(4)) {
			String suit = util.getKeyByValue(suitCount, 1);
			for(int i = 0; i < hand.length; i++) {
				if(hand[i].getSuit().equals(suit)) {
					suspiciousIndex = i;
					break;
				}
			}
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
	
	public boolean wantsToExchange() {
		if(isStraightOrBetter()) {
			System.out.println("Was straight or better");
			return false;
		}
		else if(isOneCardAway()) {
			System.out.println("Was one card away");
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
	
	public String toStringHand() {
		return Arrays.toString(hand);
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
}
