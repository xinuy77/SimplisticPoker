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
	
	public boolean hasTwoCorrectExchangeCard(Card[] hand, Card[] exchangeCard) { 
		int exchangeIndex_1 = util.getCardIndex(hand, exchangeCard[0]);
		int exchangeIndex_2 = util.getCardIndex(hand, exchangeCard[1]);
		
		if(util.countCardArr(exchangeCard) == 2) {
			if(util.containsCardInArr(exchangeCard, hand[exchangeIndex_1]) && 
			   util.containsCardInArr(exchangeCard, hand[exchangeIndex_2])) {
				return true;
			}
		}
		return false;
	}
	
	public void testStrategy3() { 
		Card[] hand_1 = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("H", "7"), new Card("S", "K")}; // CCCHK 3 card same suit
		Card[] hand_2 = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("C", "7"), new Card("C", "K")}; // CCCCC all card same suit
		Card[] hand_3 = {new Card("C", "10"), new Card("S", "2"), new Card("C", "5"), new Card("H", "7"), new Card("C", "K")}; // CSCHC 3 card same suit
		Card[] hand_4 = {new Card("H", "10"), new Card("S", "2"), new Card("C", "5"), new Card("C", "7"), new Card("C", "K")}; // HSCCC 3 card same suit
		Player ai     = new Player(hand_1, true);
		
		assertEquals(true, ai.wantsToExchange());
		Card[] exchangeCard_1 = ai.getExchangeCardArr();
 		boolean hasCorrectExchangeCard = hasTwoCorrectExchangeCard(hand_1, exchangeCard_1);
		assertEquals(true, hasCorrectExchangeCard);
		
		ai.resetExchange();
		ai.setHand(hand_2);
		assertEquals(false, ai.wantsToExchange());
		
		ai.resetExchange();
		ai.setHand(hand_3);
		assertEquals(true, ai.wantsToExchange());
		Card[] exchangeCard_2  = ai.getExchangeCardArr();
		hasCorrectExchangeCard = hasTwoCorrectExchangeCard(hand_3, exchangeCard_2);
		assertEquals(true, hasCorrectExchangeCard);
		
		ai.resetExchange();
		ai.setHand(hand_4);
		assertEquals(true, ai.wantsToExchange());
		Card[] exchangeCard_3  = ai.getExchangeCardArr();
		hasCorrectExchangeCard = hasTwoCorrectExchangeCard(hand_4, exchangeCard_3);
		assertEquals(true, hasCorrectExchangeCard);
	}
	
	// (x, x+1, x+2, x+3, x+4)
	public void testStrategy5() {
		Card[]            hand_1        = {new Card("C", "2"), new Card("H", "3"), new Card("D", "4"), new Card("H", "8"), new Card("S", "10")}; // CCCHK 3 card same suit
		ArrayList<Card[]> permutedHands = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards       = permutedHands.get(i);
			Card[]  exchangeCard        = null;
			Player  ai                  = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			exchangeCard = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasTwoCorrectExchangeCard(permutedCards, exchangeCard);
			assertEquals(true, hasExchangeCard);
		}
		
	}
}
