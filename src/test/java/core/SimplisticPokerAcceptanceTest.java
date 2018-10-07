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
	
	public void testFOK() {
		String          inputPaths           = "./src/main/resources/FOK.txt";
		SimplisticPoker simplisticPoker      = new SimplisticPoker(inputPaths);
		Player          ai                   = simplisticPoker.getAI();
		boolean         fourOfAKindAndHold   = false;
		
		if(ai.getHand().isFourOfAKind() && ai.exchangeSize() == 0) {
			fourOfAKindAndHold = true;
		}
		assertEquals(true, fourOfAKindAndHold);
	}
	
	public void testFH() {
		String          inputPaths      = "./src/main/resources/FH.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		boolean         FHAndHold       = false;
		
		if(ai.getHand().isFullHouse() && ai.exchangeSize() == 0) {
			FHAndHold = true;
		}
		assertEquals(true, FHAndHold);
	}
	
	public void testS() {
		String          inputPaths      = "./src/main/resources/S.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		boolean         SAndHold        = false;
		
		if(ai.getHand().isStraight() && ai.exchangeSize() == 0) {
			SAndHold = true;
		}
		assertEquals(true, SAndHold);
	}
	
	public void testF() {
		String          inputPaths      = "./src/main/resources/F.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPaths);
		Player          ai              = simplisticPoker.getAI();
		boolean         FAndHold        = false;
		
		if(ai.getHand().isFlush() && ai.exchangeSize() == 0) {
			FAndHold = true;
		}
		assertEquals(true, FAndHold);
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
	
	public void testOneCardAwayRF_AT() {
		String          inputPaths               = "./src/main/resources/oneCardRF.txt";
		SimplisticPoker simplisticPoker          = new SimplisticPoker(inputPaths);
		Player          ai                       = simplisticPoker.getAI();
		boolean         detectsAndExchangedCard  = false;
		
		if(ai.exchanged() && ai.exchangeSize() == 1) {
			detectsAndExchangedCard = true;
		}
		assertEquals(true, detectsAndExchangedCard);
	}
	
	public void testOneCardAwaySF_AT() {
		String          inputPaths               = "./src/main/resources/oneCardSF.txt";
		SimplisticPoker simplisticPoker          = new SimplisticPoker(inputPaths);
		Player          ai                       = simplisticPoker.getAI();
		boolean         detectsAndExchangedCard  = false;
		
		if(ai.exchanged() && ai.exchangeSize() == 1) {
			detectsAndExchangedCard = true;
		}
		assertEquals(true, detectsAndExchangedCard);
	}
	
	public void testOneCardAwayF_AT() {
		String          inputPaths               = "./src/main/resources/oneCardF.txt";
		SimplisticPoker simplisticPoker          = new SimplisticPoker(inputPaths);
		Player          ai                       = simplisticPoker.getAI();
		boolean         detectsAndExchangedCard  = false;
		
		if(ai.exchanged() && ai.exchangeSize() == 1) {
			detectsAndExchangedCard = true;
		}
		assertEquals(true, detectsAndExchangedCard);
	}
	
	public void testOneCardAwayS_AT() {
		String          inputPaths               = "./src/main/resources/oneCardS.txt";
		SimplisticPoker simplisticPoker          = new SimplisticPoker(inputPaths);
		Player          ai                       = simplisticPoker.getAI();
		boolean         detectsAndExchangedCard  = false;
		
		if(ai.exchanged() && ai.exchangeSize() == 1 || ai.exchangeSize() == 2) {
			detectsAndExchangedCard = true;
		}
		assertEquals(true, detectsAndExchangedCard);
	}
}
