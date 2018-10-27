package core;

import java.util.ArrayList;
import java.util.Arrays;

public class SimplisticPoker {
	Player              ai;
	Player              opponent;
	ArrayList<CardDeck> cardDeck;
	Evaluator           evaluator;
	Util                util;
	ArrayList<Integer>  aiWon;
	
	public static void main(String[] args) {
		String          inputPath       = "./src/main/resources/testInput.txt";
		SimplisticPoker simplisticPoker = new SimplisticPoker(inputPath);
	}
	
	public boolean aiWon() {
		for(int i = 0; i < aiWon.size(); i++) {
			if(aiWon.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public SimplisticPoker(String inputPath, boolean isCucumberTestMode) {
		initFields();
		initCardDeck(inputPath);
		if(!isCucumberTestMode) {
		
		}
	}

	public SimplisticPoker(String inputPath) {
		initFields();
		initCardDeck(inputPath);
		startEachRound();
	}
	
	public void startEachRound() {
		for(int i = 0; i < cardDeck.size(); i++) {
			opponentAndAIDrawsHand(i);
			System.out.println("----- ROUND " + (i + 1) + " -----");
			startGame(i);
			System.out.println("------- END -------");
		}
	}
	
	private void initCardDeck(String inputPath) {
		ArrayList<String> inputCardText   = util.readMultipleCardText(inputPath);
		boolean           cardAlreadyRead = true;
		for(int i = 0; i < inputCardText.size(); i++) {
			System.out.println("Input Text:" + inputCardText.get(i));
			cardDeck.add(new CardDeck(inputCardText.get(i), cardAlreadyRead));
		}
	}
	
	private void initFields() {
		 util            = new Util();
         cardDeck        = new ArrayList<CardDeck>();
         aiWon           = new ArrayList<Integer>();
         evaluator       = new Evaluator();
	}
	
	public void opponentAndAIDrawsHand(int cardDeckIndex) {
		opponent = new Player(cardDeck.get(cardDeckIndex).drawHand(), false);
		ai       = new Player(cardDeck.get(cardDeckIndex).drawHand(), true);
	}
	
	public Player getAI() {
		return ai;
	}
	
	public void startGame(int cardDeckIndex) {
		printAIandOpponentHand();
		if(ai.wantsToExchange()) {
			exchangeCard(cardDeckIndex);
		}
		printResult();
	}
	
	public void printResult() {
		if(evaluator.firstHandWins(ai.getHand(), opponent.getHand())) {
			System.out.println("AI WINS!");
			aiWon.add(1);
		}
		else {
			System.out.println("AI LOSES!");
			aiWon.add(0);
		}
		System.out.println("AI had " + evaluator.handResultToString(ai.getHand()));
		System.out.println("Opponent had " + evaluator.handResultToString(opponent.getHand()));
	}
	
	public void exchangeCard(int cardDeckIndex) {
		Card[] exchangeCards             = ai.getExchangeCardArr(); 
		Card[] exchangeOnlyOneCard       = ai.getExchangeOnlyOneCardArr(); 
		int    sizeOfExchangeCards       = util.countCardArr(exchangeCards);
		int    sizeOfExchangeOnlyOneCard = util.countCardArr(exchangeOnlyOneCard);
		if(sizeOfExchangeCards > 0) {
			printAIExchangeCard();
		}
		else if(sizeOfExchangeOnlyOneCard > 0) {
			printAIOnlyOneExchangeCard();
			exchangeCards    = new Card[1];
			exchangeCards[0] = exchangeOnlyOneCard[0];
		}
		Card[] newCards = new Card[exchangeCards.length];
		for(int i = 0; i < newCards.length; i++) {
			newCards[i] = cardDeck.get(cardDeckIndex).drawCard();
		}
		ai.exchange(exchangeCards, newCards);
		printAIExchangedCards(exchangeCards);
	}
	
	public void printAIExchangedCards(Card[] exchangeCards) {
		System.out.println("AI exchanged cards: " + Arrays.toString(exchangeCards));
		System.out.println("AI new hand: " + ai.getHand().toStringHand());
	}
	
	public void printAIExchangeCard() {
		System.out.println("AI wants to exchange following card: " + ai.toStringExchangeCard());
	}
	
	public void printAIOnlyOneExchangeCard() {
		System.out.println("AI wants to exchange only one of following card:" + ai.toStringExchangeOnlyOneCard());
	}
	
	public void printAIandOpponentHand() {
		System.out.println("Opponents Hand: " + opponent.getHand().toStringHand());
		System.out.println("AI Hand: " + ai.getHand().toStringHand());
	}
}
