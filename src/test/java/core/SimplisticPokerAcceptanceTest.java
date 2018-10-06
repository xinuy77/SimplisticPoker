package core;

import junit.framework.TestCase;

public class SimplisticPokerAcceptanceTest extends TestCase {
	public void testRoyalFlush() {
		String          inputPaths        = "./src/main/resources/royalFlushInput.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		boolean         royalFlushAndHold = false;
		
		if(ai.getHand().isRoyalFlush() && ai.exchangeSize() == 0) {
			royalFlushAndHold = true;
		}
		assertEquals(true, royalFlushAndHold);
	}
	
	public void testScore1() {
		String          inputPaths        = "./src/main/resources/bothRF.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore2() {
		String          inputPaths        = "./src/main/resources/bothSS.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore3() {
		String          inputPaths        = "./src/main/resources/bothFOK.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore4() {
		String          inputPaths        = "./src/main/resources/bothFHandTOK.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
}
