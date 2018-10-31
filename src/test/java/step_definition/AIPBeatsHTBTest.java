package step_definition;

import static org.junit.Assert.assertEquals;

import core.SimplisticPoker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIPBeatsHTBTest {
	SimplisticPoker simplisticPoker;
	boolean         isCucumberTestMode = true;
	String          inputPath          = "./src/main/resources/";
	
	@Given("^HTB draws SF card and AIP draws RF card$")
	public void htb_draws_SF_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 0;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isStraightFlush());
	}
	
	@Given("^AIP holds$")
	public void aip_holds() throws Throwable {
	    assertEquals(false, simplisticPoker.getAI().wantsToExchange());
	}

	@Then("^AIP beats HTB$")
	public void AIP_beats_HTB() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}

	@Given("^HTB draws FOK card and AIP draws RF card$")
	public void htb_draws_FOK_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFourOfAKind());
	}

	@Given("^HTB draws FH card and AIP draws RF card$")
	public void htb_draws_FH_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFullHouse());
	}

	@Given("^HTB draws F card and AIP draws RF card$")
	public void htb_draws_F_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}

	@Given("^HTB draws S card and AIP draws RF card$")
	public void htb_draws_S_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isRoyalFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraight(), true);
	}

	@Given("^HTB draws TOK card and AIP draws RF card$")
	public void htb_draws_TOK_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isRoyalFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws RF card$")
	public void htb_draws_TP_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isRoyalFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws RF card$")
	public void htb_draws_OP_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isRoyalFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws RF card$")
	public void htb_draws_HC_card_and_AIP_draws_RF_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"RFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isRoyalFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
	
	@Given("^HTB draws FOK card and AIP draws SF card$")
	public void htb_draws_FOK_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFourOfAKind(), true);
	}

	@Given("^HTB draws FH card and AIP draws SF card$")
	public void htb_draws_FH_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFullHouse(), true);
	}

	@Given("^HTB draws F card and AIP draws SF card$")
	public void htb_draws_F_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFlush(), true);
	}

	@Given("^HTB draws S card and AIP draws SF card$")
	public void htb_draws_S_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraight(), true);
	}

	@Given("^HTB draws TOK card and AIP draws SF card$")
	public void htb_draws_TOK_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws SF card$")
	public void htb_draws_TP_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws SF card$")
	public void htb_draws_OP_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws SF card$")
	public void htb_draws_HC_card_and_AIP_draws_SF_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"SFbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraightFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
	
	@Given("^HTB draws FH card and AIP draws FOK card$")
	public void htb_draws_FH_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFullHouse(), true);
	}

	@Given("^HTB draws F card and AIP draws FOK card$")
	public void htb_draws_F_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFlush(), true);
	}

	@Given("^HTB draws S card and AIP draws FOK card$")
	public void htb_draws_S_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraight(), true);
	}

	@Given("^HTB draws TOK card and AIP draws FOK card$")
	public void htb_draws_TOK_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws FOK card$")
	public void htb_draws_TP_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws FOK card$")
	public void htb_draws_OP_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws FOK card$")
	public void htb_draws_HC_card_and_AIP_draws_FOK_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"FOKbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFourOfAKind(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
	
	@Given("^HTB draws F card and AIP draws FH card$")
	public void htb_draws_F_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isFlush(), true);
	}

	@Given("^HTB draws S card and AIP draws FH card$")
	public void htb_draws_S_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraight(), true);
	}

	@Given("^HTB draws TOK card and AIP draws FH card$")
	public void htb_draws_TOK_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws FH card$")
	public void htb_draws_TP_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws FH card$")
	public void htb_draws_OP_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws FH card$")
	public void htb_draws_HC_card_and_AIP_draws_FH_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"FHbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFullHouse(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
	
	@Given("^HTB draws S card and AIP draws F card$")
	public void htb_draws_S_card_and_AIP_draws_F_card() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"Fbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isStraight(), true);
	}

	@Given("^HTB draws TOK card and AIP draws F card$")
	public void htb_draws_TOK_card_and_AIP_draws_F_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"Fbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws F card$")
	public void htb_draws_TP_card_and_AIP_draws_F_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"Fbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws F card$")
	public void htb_draws_OP_card_and_AIP_draws_F_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"Fbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws F card$")
	public void htb_draws_HC_card_and_AIP_draws_F_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"Fbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isFlush(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
	
	@Given("^HTB draws TOK card and AIP draws S card$")
	public void htb_draws_TOK_card_and_AIP_draws_S_card() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"Sbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isThreeOfAKind(), true);
	}

	@Given("^HTB draws TP card and AIP draws S card$")
	public void htb_draws_TP_card_and_AIP_draws_S_card() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"Sbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isTwoPair(), true);
	}

	@Given("^HTB draws OP card and AIP draws S card$")
	public void htb_draws_OP_card_and_AIP_draws_S_card() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"Sbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isOnePair(), true);
	}

	@Given("^HTB draws HC card and AIP draws S card$")
	public void htb_draws_HC_card_and_AIP_draws_S_card() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"Sbeat.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(simplisticPoker.getAI().getHand().isStraight(), true);
	    assertEquals(simplisticPoker.getOpponent().getHand().isHighCard(), true);
	}
}
