package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	private static final String cardPath = "./src/main/resources/card.txt";
	
	public static void main(String[] args) {
		CardDeck  cardDeck      = new CardDeck(cardPath);
		Hand      opponent_hand = new Hand(cardDeck.drawHand());
		Card[]    ai_hand       = cardDeck.drawHand();
		Player    ai            = new Player(ai_hand, true);
		Evaluator evaluator     = new Evaluator();
		Util      util          = new Util();
		
		System.out.println("Opponents Hand: " + opponent_hand.toStringHand());
		System.out.println("AI Hand: " + ai.getHand().toStringHand());
		
		if(ai.wantsToExchange()) {
			Card[] exchangeCards             = ai.getExchangeCardArr(); 
			Card[] exchangeOnlyOneCard       = ai.getExchangeOnlyOneCardArr(); 
			int    sizeOfExchangeCards       = util.countCardArr(exchangeCards);
			int    sizeOfExchangeOnlyOneCard = util.countCardArr(exchangeOnlyOneCard);
			if(sizeOfExchangeCards > 0) {
				System.out.println("AI wants to exchange following card: " + ai.toStringExchangeCard());
			}
			else if(sizeOfExchangeOnlyOneCard > 0) {
				System.out.println("AI wants to exchange only one of following card:" + ai.toStringExchangeOnlyOneCard());
				exchangeCards    = new Card[1];
				exchangeCards[0] = exchangeOnlyOneCard[0];
			}
			Card[] newCards = new Card[exchangeCards.length];
			for(int i = 0; i < newCards.length; i++) {
				newCards[i] = cardDeck.drawCard();
			}
			ai.exchange(exchangeCards, newCards);
			System.out.println("AI exchanged cards: " + Arrays.toString(exchangeCards));
			System.out.println("AI new hand: " + ai.getHand().toStringHand());
		}
		
		if(evaluator.firstHandWins(ai.getHand(), opponent_hand)) {
			System.out.println("AI WINS!");
		}
		else {
			System.out.println("AI LOSES!");
		}
		System.out.println("AI had " + evaluator.handResultToString(ai.getHand()));
		System.out.println("Opponent had " + evaluator.handResultToString(opponent_hand));
	}
}
