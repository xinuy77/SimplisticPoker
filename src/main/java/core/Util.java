package core;

public class Util {
	public final String jack    = "J";
	public final String queen   = "Q";
	public final String king    = "K";
	public final String ace     = "A";
	public final String diamond = "D";
	public final String club    = "C";
	public final String heart   = "H";
	public final String spade   = "S";
	
	public String incrementRank(String rank) {
		System.out.println("executed");
		String nextRank = "";
		if(rank.equals(ace)) {
			nextRank = ace;
		}
		else if(rank.equals("10")) {
			nextRank = jack;
		}
		else if(rank.equals(jack)) {
			nextRank = queen;
		}
		else if(rank.equals(queen)) {
			nextRank = king;
		}
		else if(rank.equals(king)) {
			nextRank = ace;
		}
		else {
			nextRank = "" + (Integer.parseInt(rank) + 1);
		}
		System.out.println("printing rank:" + rank);
		return nextRank;
	}
	
	public int toIntRank(String rank) {
		System.out.println(rank);
		if(rank.equals(ace)) {
			return 14;
		}
		if(rank.equals(king)) {
			return 13;
		}
		if(rank.equals(queen)) {
			return 12;
		}
		if(rank.equals(jack)) {
			return 11;
		}
		return Integer.parseInt(rank);
	}
	
	public String toStringRank(int rank) {
		if(rank == 1) {
			return ace;
		}
		if(rank == 13) {
			return king;
		}
		if(rank == 12) {
			return queen;
		}
		if(rank == 11) {
			return jack;
		}
		return "" + rank;
	}
	
	public Card[] sortCard(Card[] arr) {
		int n = arr.length; 
    	for (int i=1; i<n; ++i) { 
            Card key = arr[i]; 
            int  j   = i-1; 
            while (j>=0 && isGreaterThan(arr[j], key)) { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    	return arr;
	}
	
	public boolean isGreaterThan(Card card_1, Card card_2) {
		if(toIntRank(card_1.getRank()) > toIntRank(card_2.getRank())) {
			return true;
		}
		return false;
	}
}
