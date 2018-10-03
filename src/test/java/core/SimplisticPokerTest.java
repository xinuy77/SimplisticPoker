package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	
	private final String cardPath         = "./src/main/resources/card.txt";
	private Util util                     = new Util();
	private static ArrayList<Card[]> handPermute = new ArrayList<Card[]>();
	
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
			System.out.println("Testing One Card Away RF: " + Arrays.toString(tmpHand_1));
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
		int counter        = 0;
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
			System.out.println("Testing One Card Away S: " + Arrays.toString(tmpHand_1));
			System.out.println("Should exchange: " + newCard);
			assertEquals(true, ai.wantsToExchange());
			System.out.println("Wants to exchange: " + ai.toStringExchangeOnlyOneCard());
			assertEquals(true, ai.containsInExchangeOnlyOneCardArr(newCard));
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testOneCardAwaySFStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "2"), new Card("H", "3"), new Card("H", "4"), new Card("H", "5"), new Card("H", "6")};
		Player   ai       = new Player(hand_1, true);
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		int counter = 0;
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			System.out.println("Testing One Card Away SF: " + Arrays.toString(tmpHand_1));
			System.out.println("Should exchange: " + newCard);
			assertEquals(true, ai.wantsToExchange());
			System.out.println("wants to exchange: " + ai.toStringExchangeCard());
			System.out.println("Wants to exchange only one: " + ai.toStringExchangeOnlyOneCard());
			assertEquals(true, ai.containsInExchangeOnlyOneCardArr(newCard));
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testOneCardAwayFHStrategy2() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "10"), new Card("D", "10"), new Card("C", "10"), new Card("S", "9"), new Card("H", "9")};
		Player   ai       = new Player(hand_1, true);
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		int counter = 0;
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1   = hand_1.clone();
			Card   newCard     = cardDeck.drawCard();
			tmpHand_1[counter] = newCard;
			ai.setHand(tmpHand_1);
			if(ai.isStraightOrBetter()) {
				continue;
			}
			System.out.println("Testing One Card Away FH: " + Arrays.toString(tmpHand_1));
			System.out.println("Should exchange: " + newCard);
			assertEquals(true, ai.wantsToExchange());
			System.out.println("wants to exchange: " + ai.toStringExchangeCard());
			System.out.println("Wants to exchange only one: " + ai.toStringExchangeOnlyOneCard());
			System.out.println("ai. " + ai.getExchangeCardArr()[0]);
			System.out.println("nC: " + newCard);
			System.out.println(newCard.equals(ai.getExchangeCardArr()[0]));
			boolean newCardIsExchangeCard = newCard.equals(ai.getExchangeCardArr()[0]);
			if(newCardIsExchangeCard == false) {
				if(ai.getPairCounter().containsValue(3)) {
					newCardIsExchangeCard = true;
				}
			}
			System.out.println(newCardIsExchangeCard);
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
			System.out.println("Current Hand " + Arrays.toString(tmpHand_1));
			System.out.println("Should exchange: " + newCard);
			assertEquals(true, ai.wantsToExchange());
			System.out.println("wants to exchange: " + ai.toStringExchangeCard());
			System.out.println("Wants to exchange only one: " + ai.toStringExchangeOnlyOneCard());
			System.out.println(newCard.equals(ai.getExchangeCardArr()[0]));
			newCardIsExchangeCard = newCard.equals(ai.getExchangeCardArr()[0]);
			assertEquals(true, newCardIsExchangeCard);
			ai.resetExchange();
			counter++;
		}	
	}
	/*
	private String generatePermutation(Card[] arr, int index){
		ArrayList<Card[]> permutes = new ArrayList<Card[]>();
		String permutation = "";
	    if(index >= arr.length - 1) { 
	    	permutes.add(arr);
	        return Arrays.toString(arr);
	    }
	    for(int i = index; i < arr.length; i++){ 
	        Card t     = arr[index];
	        arr[index] = arr[i];
	        arr[i]     = t;  
	        //ArrayList<Card[]> previousRec = generatePermutation(arr, index+1);
	        permutation += generatePermutation(arr, index + 1);
	        /*for(int j = 0; j < previousRec.size(); j++) {
	        	permutes.add(previousRec.get(j));
	        }*/
	 /*       t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;
	    }
	    return permutation;
	}
	
	public String getPermutation(Card[] arr) {
		//ArrayList<Card[]> permutation = generatePermutation(arr, 0);
		String permutation = generatePermutation(arr,0);
		//for(int i = 0; i < permutation.size(); i++) {
			System.out.println("permutes:" + permutation);//Arrays.toString(permutation.get(i)));
	//	}
		return permutation;
	}*/
	
	public boolean hasTwoCorrectExchangeCard(Card[] hand, Card[] exchangeCard) { 
		int exchangeIndex_1 = util.getCardIndex(hand, exchangeCard[0]);
		int exchangeIndex_2 = util.getCardIndex(hand, exchangeCard[1]);
		
		if(exchangeCard.length == 2) {
			System.out.println(Arrays.toString(hand));
			System.out.println(exchangeIndex_1);
			System.out.println(hand[exchangeIndex_2]);
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
}
