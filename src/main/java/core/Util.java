package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Util {
	public final String jack    = "J";
	public final String queen   = "Q";
	public final String king    = "K";
	public final String ace     = "A";
	public final String diamond = "D";
	public final String club    = "C";
	public final String heart   = "H";
	public final String spade   = "S";
	private final int  intSpade   = 4;
	private final int  intHeart   = 3;
	private final int  intDiamond = 2;
	private final int  intClubs   = 1;
	
	public String incrementRank(String rank) {
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
		return nextRank;
	}
	
	public Card[] cleanNullCard(Card[] cards) {
		int nullCount = 0;
		for(int i = 0; i < cards.length; i++) {
			if(cards[i] == null) {
				nullCount++;
			}
		}
		Card[] cleanedCards = new Card[5-nullCount];
		for(int i = 0; i < cleanedCards.length; i++) {
			cleanedCards[i] = cards[i];
		}
		return cleanedCards;
	}
	
	private String readCardText(String path) {
		String cardText = "";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String sCurrentLine;
	        int    lineNum = 0;
	        while ((sCurrentLine = br.readLine()) != null) {
	            cardText = sCurrentLine;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return cardText;
	}
	
	private ArrayList<String> readMultipleCardText(String path) {
		ArrayList<String> cardText = new ArrayList<String()>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String sCurrentLine;
	        int    lineNum = 0;
	        while ((sCurrentLine = br.readLine()) != null) {
	            cardText = sCurrentLine;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return cardText;
	}
	
	public int toIntRank(String rank) {
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
	
	public <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (java.util.Map.Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public int countValueInArr(int[] arr, int value) {
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				counter++;
			}
		}
		return counter;
	}
	
	public int countCardArr(Card[] arr) {
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				counter++;
			}
		}
		return counter;
	}
	
	public boolean containsCardInArr(Card[] arr, Card card) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(card)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean intArrayContains(int[] arr, int value) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	public int getCardIndex(Card[] arr, Card card) {
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(card)) {
				index = i;
			}
		}
		return index;
	}
	
	public int getIndexOfValueInIntArr(int[] arr, int value) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isGreaterThan(Card card_1, Card card_2) {
		if(toIntRank(card_1.getRank()) > toIntRank(card_2.getRank())) {
			return true;
		}
		return false;
	}
	
	public Card convertStringCardToCardObject(String card) {
		String suit = card.substring(0, 1);
		String rank = card.substring(1, 2);
		if(rank.equals("1")) {
			rank += "0";
		}
		return new Card(suit, rank);
	}
	
	public int toIntSuit(String suit) {
		if(suit.equals(spade)) {
			return intSpade;
		}
		else if(suit.equals(heart)) {
			return intHeart;
		}
		else if(suit.equals(diamond)) {
			return intDiamond;
		}
		else if(suit.equals(club)){
			return intClubs;
		}
		return -1;
	}
}
