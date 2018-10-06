package core;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class SimplisticPokerTest extends TestCase {
	
	private final String cardPath = "./src/main/resources/card.txt";
	private Util util             = new Util();
	
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
	
	public boolean hasNCorrectExchangeCard(Card[] exchangeCard, Card[] correctExchangeCard) { 
		int exchangeCardCount = util.countCardArr(exchangeCard);
		int counter           = 0;
		if(exchangeCardCount != correctExchangeCard.length) {
			return false;
		}
		for(int i = 0; i < correctExchangeCard.length; i++) {
			if(util.containsCardInArr(exchangeCard, correctExchangeCard[i])) {
				counter++;
			}
		}
		if(counter != correctExchangeCard.length) {
			return false;
		}
		return true;
	}
	
	public void testStrategy3() { 
		Card[]            hand_1              = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("H", "7"), new Card("S", "K")}; // CCCHK 3 card same suit
		Card[]            hand_2              = {new Card("C", "10"), new Card("C", "2"), new Card("C", "5"), new Card("C", "7"), new Card("C", "K")}; // CCCCC all card same suit
		Card[]            correctExchangeCard = {new Card("H", "7"), new Card("S", "K")};
		Player            ai                  = new Player(hand_1, true);
		ArrayList<Card[]> permutedHands       = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
			ai.setHand(permutedHand);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard           = ai.getExchangeCardArr();
	 		boolean hasCorrectExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchangeCard);
	        assertEquals(true, hasCorrectExchangeCard);
			ai.resetExchange();
		}
		
		ai.setHand(hand_2);
		assertEquals(false, ai.wantsToExchange());
	}

	// (x, x+1, x+2, x+3, x+4)
	public void testStrategy5() {
		Card[]            correctExchange = {new Card("H", "8"), new Card("S", "10")};
		Card[]            hand_1          = {new Card("C", "2"), new Card("H", "3"), new Card("D", "4"), correctExchange[0], correctExchange[1]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	// strategy 6 would never be called -> always one card away from full house, same as strategy 4
	public void testStrategy6() {
		Card[]            correctExchange     = {new Card("D", "6")};
		Card[]            hand_1              = {new Card("C", "2"), new Card("H", "2"), correctExchange[0], new Card("H", "10"), new Card("S", "10")}; 
		ArrayList<Card[]> permutedHands       = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	public void testStrategy7() {
		Card[]            correctExchange = {new Card("D", "5"), new Card("H", "8"), new Card("S", "J")};
		Card[]            hand_1          = {new Card("C", "2"), new Card("H", "2"), correctExchange[0], correctExchange[1], correctExchange[2]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand_1);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	public void testStrategy8() {
		Card[]            correctExchange = {new Card("D", "10"), new Card("H", "8"), new Card("C", "5")};
		Card[]            hand            = {new Card("C", "A"), new Card("S", "Q"), correctExchange[0], correctExchange[1], correctExchange[2]};
		ArrayList<Card[]> permutedHands   = getPermutation(hand);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[]  permutedCards = permutedHands.get(i);
			Player  ai            = new Player(permutedCards, true);
			assertEquals(true, ai.wantsToExchange());
			Card[]  exchangeCard    = ai.getExchangeCardArr();
			boolean hasExchangeCard = hasNCorrectExchangeCard(exchangeCard, correctExchange);
			assertEquals(true, hasExchangeCard);
		}
	}
	
	public void testScore1() {
		Card[]     royalFlush_1  = {new Card("S", "10"), new Card("S", "J"), new Card("S", "Q"), new Card("S", "K"), new Card("S", "A")};
		Card[]     royalFlush_2  = {new Card("C", "10"), new Card("C", "J"), new Card("C", "Q"), new Card("C", "K"), new Card("C", "A")};
		Hand       hand_1        = new Hand(royalFlush_1);
		Hand       hand_2        = new Hand(royalFlush_2);
		Evaluator  evaluate      = new Evaluator();
		boolean    firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
	}
	
	public void testScore2() {
		Card[]     straightFlush_1  = {new Card("H", "2"), new Card("H", "3"), new Card("H", "4"), new Card("H", "5"),  new Card("H", "6")};  // highest card
		Card[]     straightFlush_2  = {new Card("D", "K"), new Card("D", "Q"), new Card("D", "J"), new Card("D", "10"), new Card("D", "9")}; // highest card
		Card[]     straightFlush_3  = {new Card("C", "2"), new Card("C", "3"), new Card("C", "4"), new Card("C", "5"),  new Card("C", "6")};  // suit of highest card
		Card[]     straightFlush_4  = {new Card("S", "2"), new Card("S", "3"), new Card("S", "4"), new Card("S", "5"),  new Card("S", "6")};  //suit of highest card
		Hand       hand_1           = new Hand(straightFlush_1);
		Hand       hand_2           = new Hand(straightFlush_2);
		Hand       hand_3           = new Hand(straightFlush_3);
		Hand       hand_4           = new Hand(straightFlush_4);
		Evaluator  evaluate         = new Evaluator();
		boolean    firstHandWins    = evaluate.firstHandWins(hand_2, hand_1);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_4, hand_3);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore3() {
		Card[]     fourOfAKind_1  = {new Card("H", "A"), new Card("D", "A"), new Card("C", "A"), new Card("S", "A"),  new Card("D", "3")};  // highest card
		Card[]     fourOfAKind_2  = {new Card("H", "2"), new Card("S", "2"), new Card("C", "2"), new Card("D", "2"),  new Card("H", "10")};
		Hand       hand_1         = new Hand(fourOfAKind_1);
		Hand       hand_2         = new Hand(fourOfAKind_2);
		Evaluator  evaluate       = new Evaluator();
		boolean    firstHandWins  = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
	}
	
	public void testScore4() {
		Card[]    fullHouse_1    = {new Card("H", "A"), new Card("D", "A"), new Card("C", "A"), new Card("S", "J"),  new Card("D", "J")};
		Card[]    fullHouse_2    = {new Card("H", "2"), new Card("D", "2"), new Card("C", "2"), new Card("S", "4"),  new Card("D", "4")};
		Card[]    threeOfAKind_1 = {new Card("H", "A"), new Card("D", "A"), new Card("C", "A"), new Card("S", "2"),  new Card("D", "3")};
		Card[]    threeOfAKind_2 = {new Card("H", "2"), new Card("D", "2"), new Card("C", "2"), new Card("S", "4"),  new Card("D", "5")};
		Hand      hand_1         = new Hand(fullHouse_1);
		Hand      hand_2         = new Hand(fullHouse_2);
		Hand      hand_3         = new Hand(threeOfAKind_1);
		Hand      hand_4         = new Hand(threeOfAKind_2);
		Evaluator evaluate       = new Evaluator();
		boolean   firstHandWins  = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore5() {
		Card[]    flush_1       = {new Card("S", "A"), new Card("S", "2"), new Card("S", "4"), new Card("S", "6"),  new Card("S", "8")};
		Card[]    flush_2       = {new Card("H", "3"), new Card("H", "2"), new Card("H", "5"), new Card("H", "7"),  new Card("H", "9")};
		Card[]    flush_3       = {new Card("S", "A"), new Card("S", "2"), new Card("S", "4"), new Card("S", "6"),  new Card("S", "8")};
		Card[]    flush_4       = {new Card("H", "A"), new Card("H", "2"), new Card("H", "4"), new Card("H", "6"),  new Card("H", "8")};
		Hand      hand_1        = new Hand(flush_1);
		Hand      hand_2        = new Hand(flush_2);
		Hand      hand_3        = new Hand(flush_3);
		Hand      hand_4        = new Hand(flush_4);
		Evaluator evaluate      = new Evaluator();
		boolean   firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore6() {
		Card[]    straight_1    = {new Card("S", "A"), new Card("H", "K"), new Card("C", "Q"), new Card("D", "J"),  new Card("D", "10")};
		Card[]    straight_2    = {new Card("H", "2"), new Card("S", "3"), new Card("D", "4"), new Card("C", "5"),  new Card("C", "6")};
		Card[]    straight_3    = {new Card("S", "A"), new Card("H", "K"), new Card("C", "Q"), new Card("D", "J"),  new Card("D", "10")};
		Card[]    straight_4    = {new Card("C", "A"), new Card("C", "K"), new Card("D", "Q"), new Card("H", "J"),  new Card("S", "10")};
		Hand      hand_1        = new Hand(straight_1);
		Hand      hand_2        = new Hand(straight_2);
		Hand      hand_3        = new Hand(straight_3);
		Hand      hand_4        = new Hand(straight_4);
		Evaluator evaluate      = new Evaluator();
		boolean   firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore7() {
		Card[]    twoPair_1     = {new Card("S", "A"), new Card("H", "A"), new Card("C", "3"), new Card("D", "3"),  new Card("D", "10")};
		Card[]    twoPair_2     = {new Card("C", "4"), new Card("H", "4"), new Card("S", "8"), new Card("D", "8"),  new Card("D", "10")};
		Card[]    twoPair_3     = {new Card("S", "A"), new Card("H", "A"), new Card("C", "3"), new Card("D", "3"),  new Card("D", "10")};
		Card[]    twoPair_4     = {new Card("C", "A"), new Card("D", "A"), new Card("D", "3"), new Card("H", "3"),  new Card("S", "10")};
		Hand      hand_1        = new Hand(twoPair_1);
		Hand      hand_2        = new Hand(twoPair_2);
		Hand      hand_3        = new Hand(twoPair_3);
		Hand      hand_4        = new Hand(twoPair_4);
		Evaluator evaluate      = new Evaluator();
		boolean   firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore8() {
		Card[]    onePair_1     = {new Card("S", "A"), new Card("H", "A"), new Card("C", "2"), new Card("D", "3"),  new Card("D", "10")};
		Card[]    onePair_2     = {new Card("C", "3"), new Card("H", "3"), new Card("S", "2"), new Card("D", "4"),  new Card("D", "10")};
		Card[]    onePair_3     = {new Card("S", "A"), new Card("H", "A"), new Card("C", "2"), new Card("D", "3"),  new Card("D", "10")};
		Card[]    onePair_4     = {new Card("C", "A"), new Card("D", "A"), new Card("D", "2"), new Card("H", "3"),  new Card("S", "10")};
		Hand      hand_1        = new Hand(onePair_1);
		Hand      hand_2        = new Hand(onePair_2);
		Hand      hand_3        = new Hand(onePair_3);
		Hand      hand_4        = new Hand(onePair_4);
		Evaluator evaluate      = new Evaluator();
		boolean   firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testScore9() {
		Card[]    high_1        = {new Card("S", "A"), new Card("H", "5"), new Card("C", "7"), new Card("D", "8"),  new Card("D", "10")};
		Card[]    high_2        = {new Card("C", "2"), new Card("H", "5"), new Card("S", "7"), new Card("D", "9"),  new Card("D", "10")};
		Card[]    high_3        = {new Card("S", "A"), new Card("H", "5"), new Card("C", "7"), new Card("D", "8"),  new Card("D", "10")};
		Card[]    high_4        = {new Card("C", "A"), new Card("D", "5"), new Card("D", "7"), new Card("H", "8"),  new Card("S", "10")};
		Hand      hand_1        = new Hand(high_1);
		Hand      hand_2        = new Hand(high_2);
		Hand      hand_3        = new Hand(high_3);
		Hand      hand_4        = new Hand(high_4);
		Evaluator evaluate      = new Evaluator();
		boolean   firstHandWins = evaluate.firstHandWins(hand_1, hand_2);
		
		assertEquals(true, firstHandWins);
		firstHandWins = evaluate.firstHandWins(hand_3, hand_4);
		assertEquals(true, firstHandWins);
	}
	
	public void testCardDeck() {
		CardDeck cardDeck = new CardDeck(cardPath);
		assertEquals(true, cardDeck.hasFiftyTwoCard());
	}
	
	public void testRank() {
		Card    card_1 = new Card("C", "A");
		Card    card_2 = new Card("C", "2");
		boolean correctRank = false;
		if(card_1.greaterRankThan(card_2)) {
			correctRank = true;
		}
		assertEquals(true, correctRank);
	}
	
	public void testSuit() {
		Card    card_1 = new Card("S", "A");
		Card    card_2 = new Card("C", "2");
		boolean correctSuit = false;
		if(card_1.greaterSuitThan(card_2)) {
			correctSuit = true;
		}
		assertEquals(true, correctSuit);
	}
	
	public void testRFPermutation() {
		Card[]            rf            = {new Card("S", "A"), new Card("S", "K"), new Card("S", "Q"), new Card("S", "J"),  new Card("S", "10")};	
        ArrayList<Card[]> permutedHands = getPermutation(rf);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isRoyalFlush());
		}
		
	}
	
	public void testSFPermutation() {
		Card[]            sf            = {new Card("S", "J"), new Card("S", "10"), new Card("S", "9"), new Card("S", "8"),  new Card("S", "7")};	
        ArrayList<Card[]> permutedHands = getPermutation(sf);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isStraightFlush());
		}
	}
	
	public void testFOAKPermutation() {
		Card[]            foak          = {new Card("S", "J"), new Card("H", "J"), new Card("D", "J"), new Card("C", "J"),  new Card("S", "7")};	
        ArrayList<Card[]> permutedHands = getPermutation(foak);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isFourOfAKind());
		}
	}
	
	public void testFHPermutation() {
		Card[]            fh            = {new Card("S", "J"), new Card("D", "J"), new Card("C", "J"), new Card("H", "2"),  new Card("D", "2")};	
        ArrayList<Card[]> permutedHands = getPermutation(fh);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isFullHouse());
		}
	}
	
	public void testFPermutation() {
		Card[]            f             = {new Card("S", "J"), new Card("S", "9"), new Card("S", "8"), new Card("S", "4"),  new Card("S", "2")};	
        ArrayList<Card[]> permutedHands = getPermutation(f);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isFlush());
		}
	}
	
	public void testSPermutation() {
		Card[]            s             = {new Card("S", "J"), new Card("H", "10"), new Card("D", "9"), new Card("C", "8"),  new Card("S", "7")};	
        ArrayList<Card[]> permutedHands = getPermutation(s);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isStraight());
		}
	}
	
	public void testTOKPermutation() {
		Card[]            TOK           = {new Card("S", "J"), new Card("H", "J"), new Card("D", "J"), new Card("C", "8"),  new Card("S", "7")};	
        ArrayList<Card[]> permutedHands = getPermutation(TOK);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isThreeOfAKind());
		}
	}
	
	public void testTPPermutation() {
		Card[]            TP            = {new Card("S", "J"), new Card("H", "J"), new Card("D", "8"), new Card("C", "8"),  new Card("S", "2")};	
        ArrayList<Card[]> permutedHands = getPermutation(TP);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isTwoPair());
		}
	}
	
	public void testPPermutation() {
		Card[]            P            = {new Card("S", "J"), new Card("H", "J"), new Card("D", "9"), new Card("C", "8"),  new Card("S", "2")};	
        ArrayList<Card[]> permutedHands = getPermutation(P);
		
		for(int i = 0; i < permutedHands.size(); i++) {
			Card[] permutedHand = permutedHands.get(i);
	        assertEquals(true, new Hand(permutedHand).isOnePair());
		}
	}
}
