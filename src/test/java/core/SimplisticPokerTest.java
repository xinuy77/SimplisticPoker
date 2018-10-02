package core;

import java.util.Arrays;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	
	private final String cardPath = "./src/main/resources/card.txt";
	
	public void testStrategy1() {
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
	
	private void testOneCardAway(Player ai, Card[] hand, CardDeck cardDeck) {
		ai.setHand(hand);
		cardDeck.removeCardFromDeck(hand);
		assertEquals(false, ai.wantsToExchange());
		
		/*
		//for(int i = 0; i < hand.length; i++) {
			Card[] tmp = hand;
			tmp[i]     = cardDeck.drawCard();
			System.out.println(Arrays.toString(hand));
			ai.setHand(tmp);
			assertEquals(true, ai.wantsToExchange());
			System.out.println(ai.toStringExchangeCard());
			ai.resetExchange();
	//	}*/
		hand[3] = cardDeck.drawCard();//cardDeck.drawCard();
		while(hand[3].getRank() == "7") {
			hand[3] = cardDeck.drawCard();
		}
		System.out.println("line 54");
		System.out.println(Arrays.toString(hand));
		System.out.println("line 56");
		ai.setHand(hand);
		System.out.println("line 58");
		assertEquals(true, ai.wantsToExchange());
		System.out.println("line 60");
		System.out.println(ai.toStringExchangeCard());
		ai.resetExchange();
	}
	
	
	public void testStrategy2() {
	//	else if AIP is one card away from a RoyalFlush,aStraightFlush,aFullHouse,aFlush,oraStraight,it exchanges that card
		CardDeck cardDeck      = new CardDeck(cardPath);
		Card[]   royalFlush    = cardDeck.drawRoyalFlush();
		Card[]   straightFlush = cardDeck.drawStraightFlush();
		Card[]   fullHouse     = cardDeck.drawFullHouse();
		Card[]   flush         = cardDeck.drawFlush();
		Card[]   straight      = cardDeck.drawStraight();
		Boolean  isAi          = true;   
		Player   ai            = new Player(null, isAi);
		
		System.out.println("Testing Royal Flush");
		testOneCardAway(ai, royalFlush, cardDeck);
		
		System.out.println("Testing Straight Flush");
		testOneCardAway(ai, straightFlush, cardDeck);
		System.out.println("Testing Full House");
		testOneCardAway(ai, fullHouse, cardDeck);
		System.out.println("Testing Flush");
		testOneCardAway(ai, flush, cardDeck);
		System.out.println("Testing Straight");
		testOneCardAway(ai, straight, cardDeck);
	}
}
