package step_definition;

import static org.junit.Assert.assertEquals;

import core.Player;
import core.SimplisticPoker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AIPExchangeTest {
	SimplisticPoker simplisticPoker;
	boolean         isCucumberTestMode = true;
	String          inputPath          = "./src/main/resources/";
	
	@Given("^HTB draws card and AIP draws one card away RF$")
	public void htb_draws_card_and_AIP_draws_one_card_away_RF() throws Throwable {
		int deckIndex   = 0;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP exchanges one card$")
	public void aip_exchanges_one_card() throws Throwable {
	    boolean oneCardExchanged = false;
		if(simplisticPoker.getAI().exchangeSize() == 1) {
	    	oneCardExchanged = true;
	    }
		assertEquals(true, oneCardExchanged);
	}
	
	@Given("^HTB draws card and AIP draws one card away RF from deck without RF$")
	public void htb_draws_card_and_AIP_draws_one_card_away_RF_from_deck_without_RF() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}
	
	@Given("^AIP has RF$")
	public void aip_has_RF() throws Throwable {
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	}

	@Then("^AIP wins HTB$")
	public void aip_wins_HTB() throws Throwable {
	    assertEquals(true, simplisticPoker.aiWon());
	}

	@Given("^AIP does not have RF$")
	public void aip_does_not_have_RF() throws Throwable {
	    assertEquals(false, simplisticPoker.getAI().getHand().isRoyalFlush());
	}

	@Then("^AIP loses HTB$")
	public void aip_loses_HTB() throws Throwable {
		assertEquals(false, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws card and AIP draws one card away SF$")
	public void htb_draws_card_and_AIP_draws_one_card_away_SF() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP has SF$")
	public void aip_has_SF() throws Throwable {
	    assertEquals(true, simplisticPoker.getAI().getHand().isStraightFlush());
	}

	@Given("^HTB draws card and AIP draws one card away SF from deck without SF$")
	public void htb_draws_card_and_AIP_draws_one_card_away_SF_from_deck_without_SF() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP does not have SF$")
	public void aip_does_not_have_SF() throws Throwable {
	    assertEquals(false, simplisticPoker.getAI().getHand().isStraightFlush());
	}
	
	@Given("^HTB draws card and AIP draws TOK$")
	public void htb_draws_card_and_AIP_draws_TOK() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP has FH$")
	public void aip_has_FH() throws Throwable {
	    assertEquals(true, simplisticPoker.getAI().getHand().isFullHouse());
	}
}
