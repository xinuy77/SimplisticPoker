package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardDeck {
	private LinkedHashSet<Card> cards;
	private Util                util = new Util();
	
	
	public CardDeck(String cardTextPath) {
		String cardText = readCardText(cardTextPath);
		initCards(cardText);
		shuffleDeck();
	}
	
	public void shuffleDeck() {
		List<Card> list = new ArrayList<Card>(cards);
		cards = (LinkedHashSet<Card>) newShuffledSet(list);
	}
	
	public static <T> Set<T> newShuffledSet(Collection<T> collection) {
	    List<T> shuffleMe = new ArrayList<T>(collection);
	    Collections.shuffle(shuffleMe);
	    return new LinkedHashSet<T>(shuffleMe);
	}
	
	public boolean hasFiftyTwoCard() {
		if(cards.size() == 52) {
			return true;
		}
		return false;
	}
	
	public void removeCardFromDeck(Card[] hand) {
		int    cardCurIndex = 0;
		Card[] removeCandidates = new Card[5];
		while(cardCurIndex < 4) {
			for(Card card: cards) {
				if(cardCurIndex >= 5) {
					break;
				}
			    String curRank = card.getRank();
			    String curSuit = card.getSuit();
			    if(curRank.equals(hand[cardCurIndex].getRank()) &&
			       curSuit.equals(hand[cardCurIndex].getSuit())) {
			    	removeCandidates[cardCurIndex] = card;
			        cardCurIndex++;
			    }
			}
		}
		cards.removeAll(Arrays.asList(removeCandidates));
	}
	
	public String toString() {
		String cardText = "";
		for(Card card : cards) {
			cardText += card.toString() + " ";
		}
		return cardText;
	}
	
	public Card[] drawThreeOfAKind() {
		Card   first        = new Card(util.spade, "10"); 
		Card   second       = new Card(util.heart, "3"); 
		Card   third        = new Card(util.club, util.ace); 
		Card   forth        = new Card(util.diamond, util.ace); 
		Card   fifth        = new Card(util.spade, util.ace);
		Card[] threeOfAKind = {first, second, third, forth, fifth};
		
		return threeOfAKind;
	}
	
	public Card[] drawHighCard() {
		Card   first    = new Card(util.spade, "10"); 
		Card   second   = new Card(util.heart, "3"); 
		Card   third    = new Card(util.club, "4"); 
		Card   forth    = new Card(util.diamond, "3"); 
		Card   fifth    = new Card(util.spade, util.ace);
		Card[] highCard = {first, second, third, forth, fifth};
		
		return highCard;
	}
	
	public Card[] drawRoyalFlush() {
		Card   first      = new Card(util.spade, "10"); 
		Card   second     = new Card(util.spade, util.jack); 
		Card   third      = new Card(util.spade, util.queen); 
		Card   forth      = new Card(util.spade, util.king); 
		Card   fifth      = new Card(util.spade, util.ace);
		Card[] royalFlush = {first, second, third, forth, fifth};
		
		return royalFlush;
	}
	
	public Card[] drawStraight() {
		Card   first      = new Card(util.spade, "10"); 
		Card   second     = new Card(util.heart, util.jack); 
		Card   third      = new Card(util.club, util.queen); 
		Card   forth      = new Card(util.diamond, util.king); 
		Card   fifth      = new Card(util.club, util.ace);
		Card[] straight = {first, second, third, forth, fifth};

		return straight;
	}
	
	public Card[] drawStraightFlush() {
		Card   first         = new Card(util.spade, "8"); 
		Card   second        = new Card(util.spade, "7"); 
		Card   third         = new Card(util.spade, "6"); 
		Card   forth         = new Card(util.spade, "5"); 
		Card   fifth         = new Card(util.spade, "4");
		Card[] straightFlush = {first, second, third, forth, fifth};
		
		return straightFlush;
	}
	
	public Card[] drawFullHouse() {
		Card   first         = new Card(util.spade, "J"); 
		Card   second        = new Card(util.heart, "J"); 
		Card   third         = new Card(util.diamond, "J"); 
		Card   forth         = new Card(util.club, "10"); 
		Card   fifth         = new Card(util.club, "10");
		Card[] fullHouse     = {first, second, third, forth, fifth};
		
		return fullHouse;
	}
	
	public Card[] drawFlush() {
		Card   first         = new Card(util.spade, "4"); 
		Card   second        = new Card(util.spade, util.jack); 
		Card   third         = new Card(util.spade, "8"); 
		Card   forth         = new Card(util.spade, "2"); 
		Card   fifth         = new Card(util.spade, "9");
		Card[] flush = {first, second, third, forth, fifth};
		
		return flush;
	}
	
	public boolean contains(Card card) {
		return cards.contains(card);
	}
	
	//returns null if no card is left
	public Card drawCard() {
		Card card = null;
		for(Card tmp: cards) {
			cards.remove(tmp);
			card = tmp;
			break;
		}
		return card;
	}
	
	public Card[] drawHand() {
		Card[] hand = new Card[5];
		for(int i = 0; i < hand.length; i++) {
			hand[i] = drawCard();
		}
		return hand;
	}
	
	private String readCardText(String path) {
		String cardText = "";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null) {
	            cardText = sCurrentLine;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return cardText;
	}
	
	private void initCards(String cardText) {
		String[] cardTextArr = cardText.split("\\s+");
		         cards       = new LinkedHashSet<Card>();
		String   rank;
		String   suit;
		Card     card;
		
		for(int i = 0; i < cardTextArr.length; i++) {
			cards.add(util.convertStringCardToCardObject(cardTextArr[i]));
		}
	}
}
