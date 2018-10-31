package step_definition;

import static org.junit.Assert.assertEquals;

import core.SimplisticPoker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HTBBeatsAIPTest {
	SimplisticPoker simplisticPoker;
	boolean         isCucumberTestMode = true;
	String          inputPath          = "./src/main/resources/";
	
	@Given("^HTB draws RF card and API draws SF card$")
	public void htb_draws_card_and_API_draws_card() throws Throwable {
		int rfsfIndex   = 0;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(rfsfIndex);
	    simplisticPoker.startGame(rfsfIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}
	
	@Then("^HTB beats API$")
	public void htb_beats_API() throws Throwable {
	    assertEquals(simplisticPoker.aiWon(), false);
	}
	
	@Given("^HTB draws RF card and API draws FOK card$")
	public void htb_draws_RF_card_and_API_draws_FOK_card() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws FH card$")
	public void htb_draws_RF_card_and_API_draws_FH_card() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws F card$")
	public void htb_draws_RF_card_and_API_draws_F_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws S card$")
	public void htb_draws_RF_card_and_API_draws_S_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws TOK card$")
	public void htb_draws_RF_card_and_API_draws_TOK_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isThreeOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws TP card$")
	public void htb_draws_RF_card_and_API_draws_TP_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isTwoPair(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws OP card$")
	public void htb_draws_RF_card_and_API_draws_OP_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isOnePair(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}

	@Given("^HTB draws RF card and API draws HC card$")
	public void htb_draws_RF_card_and_API_draws_HC_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isHighCard(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isRoyalFlush(), true);
	}
	
	@Given("^HTB draws SF card and API draws FOK card$")
	public void htb_draws_SF_card_and_API_draws_FOK_card() throws Throwable {
		int deckIndex   = 0;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws FH card$")
	public void htb_draws_SF_card_and_API_draws_FH_card() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws F card$")
	public void htb_draws_SF_card_and_API_draws_F_card() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws S card$")
	public void htb_draws_SF_card_and_API_draws_S_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws TOK card$")
	public void htb_draws_SF_card_and_API_draws_TOK_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isThreeOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws TP card$")
	public void htb_draws_SF_card_and_API_draws_TP_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isTwoPair(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws OP card$")
	public void htb_draws_SF_card_and_API_draws_OP_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isOnePair(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}

	@Given("^HTB draws SF card and API draws HC card$")
	public void htb_draws_SF_card_and_API_draws_HC_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"HTB_SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isHighCard(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraightFlush(), true);
	}
}
