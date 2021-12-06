import java.util.*;
public class Player extends Deck{
    
    public Card playCard(){
        Card card = this.deck.get(0);
        this.deck.remove(0);
        return card;
    }

    public void win(ArrayList<Card> cards){
        Card card;
        for (int i = 0; i < cards.size(); i++){
            card = cards.get(i);
            this.deck.add(card);
        }
    }
    public ArrayList<Card> dropCards(){
        int it = 3;
        ArrayList<Card> dropping = new ArrayList<Card>();
        if (this.getNumCards() < 3) {
            it = this.getNumCards();
        }
        for (int i = 0; i < it; i++) {
            dropping.add(this.playCard());
        }
        return dropping;
    }
}