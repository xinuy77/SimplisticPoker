package core;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	 public void testStrategy1() {
	        CardDeck cardDeck     = new CardDeck();
	        Card[]   straight     = cardDeck.getStraight();
	        Card[]   royalFlush   = cardDeck.getRoyalFlush();
	        Card[]   highCard     = cardDeck.getHighCard();
	        Card[]   threeOfAKind = cardDeck.getThreeOfAKind();
	        Boolean  isAi         = true;
	        Player   ai           = new Player(isAi);

	        ai.setHand(straight);
	        assertEquals(false, ai.wantsToExchange());

	        ai.setHand(royalFlush);
	        assertEquals(false, ai.wantsToExchange());

	        ai.setHand(threeOfAKind);
	        assertEquals(true, ai.wantsToExchange());

	        ai.setHand(highCard);
	        assertEquals(true, ai.wantsToExchange());
	    }
}
