import java.util.*;
public class Deck {
    ArrayList<Card> deck =  new ArrayList<Card>();

    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public void newDeck() {
        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for(int j = 0; j < ranks.length; j++) {
                String rank = ranks[j];
                Card card = new Card(suit, rank);
                this.deck.add(card);
            }
        }
    }
    public int getNumCards(){
        return deck.size();
    }
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
    public Card deal(){
        Card card = this.deck.remove(0);
        return card;
    }
}
