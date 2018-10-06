package core;

import junit.framework.TestCase;

public class SimplisticPokerAcceptanceTest extends TestCase {
	public void testRF() {
		String          inputPaths        = "./src/main/resources/allSuitRF.txt";
		SimplisticPoker simplisticPoker   = new SimplisticPoker(inputPaths);
		Player          ai                = simplisticPoker.getAI();
		boolean         royalFlushAndHold = false;
		
		if(ai.getHand().isRoyalFlush() && ai.exchangeSize() == 0) {
			royalFlushAndHold = true;
		}
		assertEquals(true, royalFlushAndHold);
	}
	
	public void testSF() {
		String          inputPaths           = "./src/main/resources/SF.txt";
		SimplisticPoker simplisticPoker      = new SimplisticPoker(inputPaths);
		Player          ai                   = simplisticPoker.getAI();
		boolean         straightFlushAndHold = false;
		
		if(ai.getHand().isStraightFlush() && ai.exchangeSize() == 0) {
			straightFlushAndHold = true;
		}
		assertEquals(true, straightFlushAndHold);
	}
	
	public void testScore1() {
		String          inputPaths      = "./src/main/resources/bothRF.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore2() {
		String          inputPaths      = "./src/main/resources/bothSS.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore3() {
		String          inputPaths      = "./src/main/resources/bothFOK.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore4() {
		String          inputPaths      = "./src/main/resources/bothFHandTOK.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore6() {
		String          inputPaths      = "./src/main/resources/bothS.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore7() {
		String          inputPaths      = "./src/main/resources/bothTP.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore8() {
		String          inputPaths      = "./src/main/resources/bothP.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore9() {
		String          inputPaths      = "./src/main/resources/bothHC.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	public void testScore5() {
		String          inputPaths      = "./src/main/resources/bothF.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		
		assertEquals(true, simplisticPoker.aiWon());
	}
}
