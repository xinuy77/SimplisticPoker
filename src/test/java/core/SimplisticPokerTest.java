package core;

import java.util.Arrays;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	
	private final String cardPath = "./src/main/resources/card.txt";
	
/*	public void testStrategy1() {
		System.out.println("Executing test strategy 1");
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
		System.out.println("Executing test strategy 1 done");
	}
	*/
	
	public void testOneCardAwayRoyalFlush() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("C", "10"), new Card("C", "J"), new Card("C", "Q"), new Card("C", "K"), new Card("C", "A")};
		Player   ai       = new Player(hand_1, true);
		
		// test when hand is RF
		assertEquals(false, ai.wantsToExchange());
		
		cardDeck.removeCardFromDeck(hand_1);
		int counter = 0;
		
		// test all hand (10, J, Q, K, A) when card in 1 away from RF
		while(counter < 5) {
			Card[] tmpHand_1 = hand_1.clone();
			Card   newCard   = cardDeck.drawCard();
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
	/*
	public boolean canMakeSequence() {
		
	}*/
	
	public void testOneCardAwayStraight() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "2"), new Card("C", "3"), new Card("S", "4"), new Card("D", "5"), new Card("C", "6")};
		Player   ai       = new Player(hand_1, true);
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		int counter = 0;
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1 = hand_1.clone();
			Card   newCard   = cardDeck.drawCard();
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
	
	public void testOneCardAwayStraightFlush() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "2"), new Card("H", "3"), new Card("H", "4"), new Card("H", "5"), new Card("H", "6")};
		Player   ai       = new Player(hand_1, true);
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		int counter = 0;
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1 = hand_1.clone();
			Card   newCard   = cardDeck.drawCard();
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
	
	public void testOneCardAwayFullHouse() {
		CardDeck cardDeck = new CardDeck(cardPath);
		Card[]   hand_1   = {new Card("H", "10"), new Card("D", "10"), new Card("C", "10"), new Card("S", "9"), new Card("H", "9")};
		Player   ai       = new Player(hand_1, true);
		cardDeck.removeCardFromDeck(hand_1);
		// test when hand is S
		int counter = 0;
		assertEquals(false, ai.wantsToExchange());
		while(counter < 5) {
			Card[] tmpHand_1 = hand_1.clone();
			Card   newCard   = cardDeck.drawCard();
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
			System.out.println(newCardIsExchangeCard);
			assertEquals(true, newCardIsExchangeCard);
			ai.resetExchange();
			counter++;
		}	
	}
	
	public void testStrategy2() {
		System.out.println("--Testing Royal Flush--");
		testOneCardAwayRoyalFlush();
		System.out.println("--Testing Royal Flush Done--");
		System.out.println("--Testing Straight--");
		testOneCardAwayStraight();
		System.out.println("--Testing Straight Done--");
		System.out.println("--Testing Straight Flush--");
		testOneCardAwayStraightFlush();
		System.out.println("--Testing Straight Flush Done--");
		System.out.println("--Testing FullHouse--");
		testOneCardAwayFullHouse();
		System.out.println("--Testing FullHouse Done--");
		/*
		System.out.println("Testing Straight Flush");
		testOneCardAway(ai, straightFlush, cardDeck);
		System.out.println("Testing Full House");
		testOneCardAway(ai, fullHouse, cardDeck);
		System.out.println("Testing Flush");
		testOneCardAway(ai, flush, cardDeck);
		System.out.println("Testing Straight");
		testOneCardAway(ai, straight, cardDeck);*/
	}
}
