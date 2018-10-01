package core;

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
		assertEquals(false, ai.wantsToExchange());
		System.out.println(ai.getExchangeCard());
		
		for(int i = 0; i < hand.length; i++) {
			Card[] tmp = hand;
			tmp[i]     = cardDeck.drawCard();
			ai.setHand(tmp);
			assertEquals(true, ai.wantsToExchange());
			System.out.println(ai.getExchangeCard());
		}
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
		
		testOneCardAway(ai, royalFlush, cardDeck);
		testOneCardAway(ai, straightFlush, cardDeck);
		testOneCardAway(ai, fullHouse, cardDeck);
		testOneCardAway(ai, flush, cardDeck);
		testOneCardAway(ai, straight, cardDeck);
	}
}
