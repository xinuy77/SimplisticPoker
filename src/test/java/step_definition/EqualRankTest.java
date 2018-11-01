package step_definition;

import static org.junit.Assert.assertEquals;

import core.Card;
import core.Evaluator;
import core.SimplisticPoker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EqualRankTest {
	SimplisticPoker simplisticPoker;
	boolean         isCucumberTestMode = true;
	String          inputPath          = "./src/main/resources/";
	
	@Given("^HTB draws RF and AIP draws RF$")
	public void htb_draws_RF_and_AIP_draws_RF() throws Throwable {
		int deckIndex   = 0;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isRoyalFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isRoyalFlush());
	}

	@Then("^Highest hand wins$")
	public void highest_hand_wins() throws Throwable {
	    assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Then("^Highest suit wins$")
	public void highest_suit_wins() throws Throwable {
	    Card ai_hand = simplisticPoker.getAI().getHand().getCard(0);
	    Card hb_hand = simplisticPoker.getOpponent().getHand().getCard(0);
	    if(ai_hand.greaterSuitThan(hb_hand)) {
	    	assertEquals(true, simplisticPoker.aiWon());
	    }
	    else {
	    	assertEquals(false, simplisticPoker.aiWon());
	    }   
	}
	
	@Then("^Highest suit of highest card wins$")
	public void highest_suit_of_highest_card_wins() throws Throwable {
		Card ai_hand = simplisticPoker.getAI().getHand().getCard(4);
	    Card hb_hand = simplisticPoker.getOpponent().getHand().getCard(4);
	    if(ai_hand.greaterSuitThan(hb_hand)) {
	    	assertEquals(true, simplisticPoker.aiWon());
	    }
	    else {
	    	assertEquals(false, simplisticPoker.aiWon());
	    }   
	}
	
	@Given("^HTB draws SF and AIP draws SF$")
	public void htb_draws_SF_and_AIP_draws_SF() throws Throwable {
		int deckIndex   = 1;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isStraightFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isStraightFlush());
	}

	@Then("^Highest card wins$")
	public void highest_card_wins() throws Throwable {
		Card ai_hand = simplisticPoker.getAI().getHand().getCard(4);
		Card hb_hand = simplisticPoker.getOpponent().getHand().getCard(4);
	    if(ai_hand.greaterRankThan(hb_hand)) {
	    	assertEquals(true, simplisticPoker.aiWon());
	    }
	    else {
	    	assertEquals(false, simplisticPoker.aiWon());
	    }   
	}
	
	@Given("^HTB draws SF and AIP draws SF with same highest cards$")
	public void htb_draws_SF_and_AIP_draws_SF_with_same_highest_cards() throws Throwable {
		int deckIndex   = 2;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isStraightFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isStraightFlush());
	}
	
	@Given("^HTB draws FOK and AIP draws FOK$")
	public void htb_draws_FOK_and_AIP_draws_FOK() throws Throwable {
		int deckIndex   = 3;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFourOfAKind());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFourOfAKind());
	}

	@Then("^Highest quadruplet wins$")
	public void highest_quadruplet_wins() throws Throwable {
	    assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws FH and AIP draws FH$")
	public void htb_draws_FH_and_AIP_draws_FH() throws Throwable {
		int deckIndex   = 4;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFullHouse());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFullHouse());
	}

	@Then("^Highest triplet wins$")
	public void highest_triplet_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws TOK and AIP draws TOK$")
	public void htb_draws_TOK_and_AIP_draws_TOK() throws Throwable {
		int deckIndex   = 5;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isThreeOfAKind());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isThreeOfAKind());
	}
	
	@Given("^HTB draws S and AIP draws S$")
	public void htb_draws_S_and_AIP_draws_S() throws Throwable {
		int deckIndex   = 6;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isStraight());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isStraight());
	}
	
	@Given("^HTB draws S and AIP draws S with different rank$")
	public void htb_draws_S_and_AIP_draws_S_with_different_rank() throws Throwable {
		int deckIndex   = 7;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isStraight());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isStraight());
	}
	
	@Given("^HTB draws TP and AIP draws TP with same highest rank$")
	public void htb_draws_TP_and_AIP_draws_TP_with_same_highest_rank() throws Throwable {
		int deckIndex   = 8;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isTwoPair());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isTwoPair());
	}

	@Then("^Highest suit of two pair wins$")
	public void highest_suit_of_two_pair_wins() throws Throwable {
	    assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws TP and AIP draws TP with different highest rank$")
	public void htb_draws_TP_and_AIP_draws_TP_with_different_highest_rank() throws Throwable {
		int deckIndex   = 9;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isTwoPair());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isTwoPair());
	}

	@Then("^Highest card of two pair wins$")
	public void highest_card_of_two_pair_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}

	@Given("^HTB draws OP and AIP draws OP with equal rank$")
	public void htb_draws_OP_and_AIP_draws_OP_with_equal_rank() throws Throwable {
		int deckIndex   = 10;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isOnePair());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isOnePair());
	}

	@Then("^Highest suit of pair wins$")
	public void highest_suit_of_pair_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws OP and AIP draws OP with distinct rank$")
	public void htb_draws_OP_and_AIP_draws_OP_with_distinct_rank() throws Throwable {
		int deckIndex   = 11;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isOnePair());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isOnePair());
	}

	@Then("^Highest rank of pair wins$")
	public void highest_rank_of_pair_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws HC and AIP draws HC with same rank$")
	public void htb_draws_HC_and_AIP_draws_HC_with_same_rank() throws Throwable {
		int deckIndex   = 12;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isHighCard());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isHighCard());
	}

	@Then("^Highest suit of highest rank wins$")
	public void highest_suit_of_highest_rank_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}

	@Given("^HTB draws HC and AIP draws HC with distinct rank$")
	public void htb_draws_HC_and_AIP_draws_HC_with_distinct_rank() throws Throwable {
		int deckIndex   = 13;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isHighCard());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isHighCard());
	}

	@Then("^Highest suit and highest rank wins$")
	public void highest_suit_and_highest_rank_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws F and AIP draws F with same rank$")
	public void htb_draws_F_and_AIP_draws_F_with_same_rank() throws Throwable {
		int deckIndex   = 14;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}
	
	@Given("^HTB draws F and AIP draws F with four same rank$")
	public void htb_draws_F_and_AIP_draws_F_with_four_same_rank() throws Throwable {
		int deckIndex   = 15;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}

	@Then("^Highest suit highest rank of fifth wins$")
	public void highest_suit_highest_rank_of_fifth_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws F and AIP draws F with three same rank$")
	public void htb_draws_F_and_AIP_draws_F_with_three_same_rank() throws Throwable {
		int deckIndex   = 16;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}

	@Then("^highest rank of four remaining wins$")
	public void highest_rank_of_four_remaining_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}

	@Given("^HTB draws F and AIP draws F with two same rank$")
	public void htb_draws_F_and_AIP_draws_F_with_two_same_rank() throws Throwable {
		int deckIndex   = 17;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}

	@Then("^highest rank of six remaining wins$")
	public void highest_rank_of_six_remaining_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}
	
	@Given("^HTB draws F and AIP draws F with one same rank$")
	public void htb_draws_F_and_AIP_draws_F_with_one_same_rank() throws Throwable {
		int deckIndex   = 18;
	    simplisticPoker = new SimplisticPoker(inputPath+"equal.txt", isCucumberTestMode);
	    simplisticPoker.opponentAndAIDrawsHand(deckIndex);
	    simplisticPoker.startGame(deckIndex);
	    assertEquals(true, simplisticPoker.getAI().getHand().isFlush());
	    assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	}

	@Then("^highest rank of eight remaining wins$")
	public void highest_rank_of_eight_remaining_wins() throws Throwable {
		assertEquals(true, simplisticPoker.aiWon());
	}

}
