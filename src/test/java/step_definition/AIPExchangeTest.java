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
	
	@Given("^HTB draws card and AIP draws TOK from deck without TOK$")
	public void htb_draws_card_and_AIP_draws_TOK_from_deck_without_TOK() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP does not have FH$")
	public void aip_does_not_have_FH() throws Throwable {
	    assertEquals(false, simplisticPoker.getAI().getHand().isFullHouse());
	}

	@Given("^HTB draws card and AIP draws TP$")
	public void htb_draws_card_and_AIP_draws_TP() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP exchanges cards$")
	public void aip_exchanges_cards() throws Throwable {
	    boolean exchangedMultipleCards = false;
		if(simplisticPoker.getAI().exchangeSize() > 1) {
	    	exchangedMultipleCards = true;
	    }
		assertEquals(true, exchangedMultipleCards);
	}

	@Given("^AIP has TP$")
	public void aip_has_TP() throws Throwable {
	    assertEquals(true, simplisticPoker.getAI().getHand().isTwoPair());
	}
	
	@Given("^HTB draws card and AIP draws TP from deck without FH$")
	public void htb_draws_card_and_AIP_draws_TP_from_deck_without_FH() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}
	
	@Given("^HTB draws card and AIP draws one card away F$")
	public void htb_draws_card_and_AIP_draws_one_card_away_F() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP has F$")
	public void aip_has_F() throws Throwable {
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	}
	
	@Given("^HTB draws card and AIP draws one card away F from deck without F$")
	public void htb_draws_card_and_AIP_draws_one_card_away_F_from_deck_without_F() throws Throwable {
		int deckIndex   = 9;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP does not have F$")
	public void aip_does_not_have_F() throws Throwable {
		 assertEquals(false, simplisticPoker.getAI().getHand().isFlush());
	}

	@Given("^HTB draws card and AIP draws one card away S$")
	public void htb_draws_card_and_AIP_draws_one_card_away_S() throws Throwable {
		int deckIndex   = 10;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP has S$")
	public void aip_has_S() throws Throwable {
		 assertEquals(true, simplisticPoker.getAI().getHand().isStraight());
	}

	@Given("^HTB draws card and AIP draws one card away S from deck without S$")
	public void htb_draws_card_and_AIP_draws_one_card_away_S_from_deck_without_S() throws Throwable {
		int deckIndex   = 11;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Given("^AIP does not have S$")
	public void aip_does_not_have_S() throws Throwable {
		assertEquals(false, simplisticPoker.getAI().getHand().isStraight());
	}
	
	@Given("^HTB draws card and AIP draws hand with three same suit$")
	public void htb_draws_card_and_AIP_draws_hand_with_three_same_suit() throws Throwable {
		int deckIndex   = 12;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Then("^AIP exchanges two card$")
	public void aip_exchanges_two_card() throws Throwable {
	    boolean exchangedTwoCard = false;
	    if(simplisticPoker.getAI().exchangeSize() == 2) {
	    	exchangedTwoCard = true;
	    }
	    assertEquals(true, exchangedTwoCard);
	}
	
	@Given("^HTB draws card and AIP draws hand with three card in sequence$")
	public void htb_draws_card_and_AIP_draws_hand_with_three_card_in_sequence() throws Throwable {
		int deckIndex   = 13;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}
	
	@Given("^HTB draws card and AIP draws hand with one pair$")
	public void htb_draws_card_and_AIP_draws_hand_with_one_pair() throws Throwable {
		int deckIndex   = 14;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isOnePair());
	}

	@Given("^HTB draws card and AIP draws hand with no pair$")
	public void htb_draws_card_and_AIP_draws_hand_with_no_pair() throws Throwable {
		int deckIndex   = 15;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}

	@Then("^AIP exchanges three cards$")
	public void aip_exchanges_three_cards() throws Throwable {
		 boolean exchangedThreeCard = false;
		 if(simplisticPoker.getAI().exchangeSize() == 3) {
		    	exchangedThreeCard = true;
		 }
		 assertEquals(true, exchangedThreeCard);
	}
	
	@Given("^HTB draws SF and AIP draws SF with same highest card$")
	public void htb_draws_SF_and_AIP_draws_SF_with_same_highest_card() throws Throwable {
		int deckIndex   = 16;
	    simplisticPoker = new SimplisticPoker(inputPath+"exchange.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	}
}
