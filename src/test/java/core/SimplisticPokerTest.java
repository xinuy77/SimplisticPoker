package core;



import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	
	private final String cardPath         = "./src/main/resources/card.txt";
	private Util util                     = new Util();
	
	public void testStrategy1() {
		CardDeck cardDeck     = new CardDeck(cardPath);
		Card[]   straight     = cardDeck.drawStraight();
		Card[]   royalFlush   = cardDeck.drawRoyalFlush();
		Card[]   highCard     = cardDeck.drawHighCard();
		Card[]   threeOfAKind = cardDeck.drawThreeOfAKind();
		Boolean  isAi         = true;
		Player   ai           = new Player(null, isAi);
		
		ai.setHand(straight);
		assertEquals(false, ai.wantsToExchange());
		
		ai.setHand(royalFlush);
		assertEquals(false, ai.wantsToExchange());
		
		ai.setHand(threeOfAKind);
		assertEquals(true, ai.wantsToExchange());
		
		ai.setHand(highCard);
		assertEquals(true, ai.wantsToExchange());
	}
	
	public void testOneCardAwayRFStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("C", "10"), new Card("C", "J"), new Card("C", "Q"), new Card("C", "K"), new Card("C", "A")};
		Player   ai       = new Player(hand_1, true);
		int      counter  = 0;
		// test when hand is RF
		assertEquals(false, ai.wantsToExchange());
		cardDeck.removeCardFromDeck(hand_1);
		
		// test all hand (10, J, Q, K, A) when card in 1 away from RF
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			assertEquals(true, ai.wantsToExchange());
			assertEquals(true, newCard.equals(ai.getExchangeCardArr()[0]));
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testOneCardAwaySStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "2"), new Card("C", "3"), new Card("S", "4"), new Card("D", "5"), new Card("C", "6")};
		Player   ai       = new Player(hand_1, true);
		int counter       = 0;
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		assertEquals(false, ai.wantsToExchange());
		
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			assertEquals(true, ai.wantsToExchange());
			assertEquals(true, ai.containsInExchangeOnlyOneCardArr(newCard));
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testOneCardAwaySFStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "2"), new Card("H", "3"), new Card("H", "4"), new Card("H", "5"), new Card("H", "6")};
		Player   ai       = new Player(hand_1, true);
		int      counter  = 0;
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			assertEquals(true, ai.wantsToExchange());
			assertEquals(true, ai.containsInExchangeOnlyOneCardArr(newCard));
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testOneCardAwayFHStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "10"), new Card("D", "10"), new Card("C", "10"), new Card("S", "9"), new Card("H", "9")};
		Player   ai       = new Player(hand_1, true);
		int      counter  = 0;

		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			assertEquals(true, ai.wantsToExchange());
			boolean newCardIsExchangeCard = newCard.equals(ai.getExchangeCardArr()[0]);
			if(newCardIsExchangeCard == false) {
				if(ai.getHand().getPairCounter().containsValue(3)) {
					newCardIsExchangeCard = true;
				}
			}
			assertEquals(true, newCardIsExchangeCard);
			ai.resetExchange();
			counter++;
		}
	}
	
	public void testOneCardAwayFStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("C", "7"), new Card("C", "K")};
		Player   ai       = new Player(hand_1, true);
		int      counter  = 0;
		
		cardDeck.removeCardFromDeck(hand_1);
		assertEquals(false, ai.wantsToExchange());
		
		while(counter < 5) {
			Card[]  tmpHand_1   = hand_1.clone();
			Card    newCard     = cardDeck.drawCard();
			boolean newCardIsExchangeCard;
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			assertEquals(true, ai.wantsToExchange());
			newCardIsExchangeCard = newCard.equals(ai.getExchangeCardArr()[0]);
			assertEquals(true, newCardIsExchangeCard);
			ai.resetExchange();
			counter++;
		}	
	}
	
	private String generatePermutation(Card[] arr, int index){
		String permutation = "";
	    if(index >= arr.length - 1) { 
	        return Arrays.toString(arr);
	    }
	    for(int i = index; i < arr.length; i++){ 
	        Card t       = arr[index];
	        arr[index]   = arr[i];
	        arr[i]       = t;  
	        permutation += generatePermutation(arr, index + 1);
	        t            = arr[index];
	        arr[index]   = arr[i];
	        arr[i]       = t;
	    }
	    return permutation;
	}
	
	public ArrayList<Card[]> getPermutation(Card[] arr) {
		String            permutation    = generatePermutation(arr,0);
		                  permutation    = permutation.replace(",", "").replace("[","");
		String[]          permutationArr = permutation.split("]");
		ArrayList<Card[]> permutedHands  = new ArrayList<Card[]>();
		
		for(int i = 0; i < permutationArr.length; i++) {
			String[] permutedCardString = permutationArr[i].split("\\s+");
			Card[]   permutedCard       = new Card[5];
			for(int j = 0; j < permutedCardString.length; j++) {
				permutedCard[j] = util.convertStringCardToCardObject(permutedCardString[j]);
			}
			permutedHands.add(permutedCard);
		}
		return permutedHands;
	}
	
	public boolean hasNCorrectExchangeCard(Card[] exchangeCard, Card[] correctExchangeCard) { 
		int exchangeCardCount = util.countCardArr(exchangeCard);
		int counter           = 0;
		if(exchangeCardCount != correctExchangeCard.length) {
			return false;
		}
		for(int i = 0; i < correctExchangeCard.length; i++) {
			if(util.containsCardInArr(exchangeCard, correctExchangeCard[i])) {
				counter++;
			}
		}
		if(counter != correctExchangeCard.length) {
			return false;
		}
		return true;
	}
	
	public void testStrategy3() { 
		Card[]            hand_1              = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("H", "7"), new Card("S", "K")}; // CCCHK 3 card same suit
		Card[]            hand_2              = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("C", "7"), new Card("C", "K")}; // CCCCC all card same suit
		Card[]            correctExchangeCard = {new Card("H", "7"), new Card("S", "K")};
		Player            ai                  = new Player(hand_1, true);
		ArrayList<Card[]> permutedHands       = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
			ai.setHand(permutedHand);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard           = ai.getExchangeCardArr();
	 		boolean hasCorrectExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchangeCard);
	        assertEquals(true, hasCorrectExchangeCard);
			ai.resetExchange();
		}
		
		ai.setHand(hand_2);
		assertEquals(false, ai.wantsToExchange());
	}

	// (x, x+1, x+2, x+3, x+4)
	public void testStrategy5() {
		Card[]            correctExchange = {new Card("H", "8"), new Card("S", "10")};
		Card[]            hand_1          = {new Card("C", "2"), new Card("H", "3"), new Card("D", "4"), correctExchange[0], correctExchange[1]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	// strategy 6 would never be called -> always one card away from full house, same as strategy 4
	public void testStrategy6() {
		Card[]            correctExchange     = {new Card("D", "6")};
		Card[]            hand_1              = {new Card("C", "2"), new Card("H", "2"), correctExchange[0], new Card("H", "10"), new Card("S", "10")}; 
		ArrayList<Card[]> permutedHands       = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	public void testStrategy7() {
		Card[]            correctExchange = {new Card("D", "5"), new Card("H", "8"), new Card("S", "J")};
		Card[]            hand_1          = {new Card("C", "2"), new Card("H", "2"), correctExchange[0], correctExchange[1], correctExchange[2]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	public void testStrategy8() {
		Card[]            correctExchange = {new Card("D", "10"), new Card("H", "8"), new Card("C", "5")};
		Card[]            hand            = {new Card("C", "A"), new Card("S", "Q"), correctExchange[0], correctExchange[1], correctExchange[2]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
}
