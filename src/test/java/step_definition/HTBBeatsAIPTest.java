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
}
