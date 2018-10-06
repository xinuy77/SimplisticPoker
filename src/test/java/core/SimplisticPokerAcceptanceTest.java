package core;

import junit.framework.TestCase;

public class SimplisticPokerAcceptanceTest extends TestCase {
	public void testRoyalFlush() {
		String          inputPaths        = "";
		String          inputCard         = util.readInputCard(inputPaths);
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputCard);
		Player          ai                = simplisticPoker.getAI();
		boolean         royalFlushAndHold = false;
		
		if(ai.getHand().isRoyalFlush() && ai.exchangeSize() == 0) {
			royalFlushAndHold = true;
		}
		assertEquals(true, royalFlushAndHold);
	}
}
