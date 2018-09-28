import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardDeck {
	//String path = "./src/main/resources/card.txt";
	private HashSet<Card> cards;
	private final String jack  = "J";
	private final String queen = "Q";
	private final String king  = "K";
	private final String ace  = "A";
	
	public static void main(String[] args) {
		String path = "./src/main/resources/card.txt";
		CardDeck cardDeck = new CardDeck(path);
		System.out.println(cardDeck.toString());
		Card[] straight = cardDeck.drawStraight();
		Card[] straight2 = cardDeck.drawStraight();
		System.out.println(cardDeck.toString());
		System.out.println("got card:");
		for(int i = 0; i < straight.length; i++) {
			System.out.println(straight[i].toString());
			System.out.println(straight2[i].toString());

		}
	}
	
	public String toString() {
		String cardText = "";
		for(Card card : cards) {
			cardText += card.toString() + " ";
		}
		return cardText;
	}
	
	public Card[] drawRoyalFlush() {
		Card first        = new Card("S", "10"); 
		Card second       = new Card("S", "J"); 
		Card third        = new Card("S", "Q"); 
		Card forth        = new Card("S", "K"); 
		Card fifth        = new Card("S", "A");
		Card[] royalFlush = {first, second, third, forth, fifth};
		
		return royalFlush;
	}
	
	public Card[] drawStraight() {
		Card[] straight = new Card[5];
		String nextRank = null;
		int    arr_size = 0;
		while (arr_size < straight.length) {
			for(Card card : cards) {
				if(nextRank != null) {				
					if(!card.getRank().equals(nextRank)) {
						cards.add(card);
						continue;
					}
				}
				if(arr_size == straight.length) {
					break;
				}
				straight[arr_size++] = card;
				System.out.println("iterating: " + card.toString());
				if(card.getRank().equals(ace)) {
					nextRank = "2";
				}
				else if(card.getRank().equals(jack)) {
					nextRank = queen;
				}
				else if(card.getRank().equals(queen)) {
					nextRank = king;
				}
				else if(card.getRank().equals(king)) {
					nextRank = ace;
				}
				else {
					nextRank = "" + (Integer.parseInt(card.getRank()) + 1);
				}
			}
			
		}

		return straight;
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
	
	public CardDeck(String cardTextPath) {
		String cardText = readCardText(cardTextPath);
		initCards(cardText);
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
		         cards       = new HashSet<Card>();
		String   rank;
		String   suit;
		Card     card;
		
		for(int i = 0; i < cardTextArr.length; i++) {
			rank = cardTextArr[i].substring(1, 2);
			suit = cardTextArr[i].substring(0, 1);
			card = new Card(suit, rank);
			cards.add(card);
		}
	}
}
