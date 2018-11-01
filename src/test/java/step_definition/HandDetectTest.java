package step_definition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import core.Card;
import core.Hand;
import core.SimplisticPoker;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HandDetectTest {
	SimplisticPoker simplisticPoker;
	int             dataSize = 0;
	
	private void initSimplisticPokerByDataTable(DataTable arg1) {
		List<List<String>> data        = arg1.raw();
		ArrayList<String>  permutation = new ArrayList<String>();
		dataSize                       = data.size();
		for(int i = 1; i < dataSize; i++) {
			permutation.add(data.get(i).get(0));
		}
	    simplisticPoker = new SimplisticPoker(permutation);
	}

	@Given("^Initialize game by list of RF permutation$")
	public void initialize_game_by_list_of_RF_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every RF$")
	public void game_detects_every_RF() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isRoyalFlush());
	    }
	}
	
	@Given("^Initialize game by list of SF permutation$")
	public void initialize_game_by_list_of_SF_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every SF$")
	public void game_detects_every_SF() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isStraightFlush());
	    }
	}

	@Given("^Initialize game by list of FOK permutation$")
	public void initialize_game_by_list_of_FOK_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every FOK$")
	public void game_detects_every_FOK() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isFourOfAKind());
	    }
	}
	
	@Given("^Initialize game by list of FH permutation$")
	public void initialize_game_by_list_of_FH_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every FH$")
	public void game_detects_every_FH() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isFullHouse());
	    }
	}
	
	@Given("^Initialize game by list of F permutation$")
	public void initialize_game_by_list_of_F_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every F$")
	public void game_detects_every_F() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isFlush());
	    }
	}
	
	@Given("^Initialize game by list of S permutation$")
	public void initialize_game_by_list_of_S_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every S$")
	public void game_detects_every_S() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isStraight());
	    }
	}
	
	@Given("^Initialize game by list of TOK permutation$")
	public void initialize_game_by_list_of_TOK_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every TOK$")
	public void game_detects_every_TOK() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isThreeOfAKind());
	    }
	}
	
	@Given("^Initialize game by list of TP permutation$")
	public void initialize_game_by_list_of_TP_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every TP$")
	public void game_detects_every_TP() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isTwoPair());
	    }
	}
	
	@Given("^Initialize game by list of OP permutation$")
	public void initialize_game_by_list_of_OP_permutation(DataTable arg1) throws Throwable {
		initSimplisticPokerByDataTable(arg1);
	}

	@Then("^Game detects every OP$")
	public void game_detects_every_OP() throws Throwable {
		for(int i = 0; i < dataSize-1; i++) {
	    	simplisticPoker.opponentDrawHand(i);
	        assertEquals(true, simplisticPoker.getOpponent().getHand().isOnePair());
	    }
	}
}
