//Author: Stefan Ignat
//Created: 11/15/2021
//Last modified: 11/16/2021
//Desc: Quick showcase of card game "War" in Java using inheritance and Array Lists.
//Files: Main, Player, Deck, Card
import java.util.*;
public class Main{
    public static void displayPile(ArrayList<Card> pile){
        System.out.println("Size of pile is: " + pile.size());
    }
    public static void main(String args[]){

        Scanner reader = new Scanner(System.in);
        String choice = "p";
        Deck playDeck = new Deck();
        ArrayList<Card> pile = new ArrayList<Card>();
        Player player = new Player();
        Player comp = new Player();

        playDeck.newDeck();
        playDeck.shuffle();

        System.out.println("Player has " + player.getNumCards() + " cards.");
        System.out.println("Computer has " + comp.getNumCards() + " cards.");
        int handSize = 26;
        for (int i = 0; i < handSize; i++) {
            System.out.println("Dealing");
            player.deck.add(playDeck.deal());
            comp.deck.add(playDeck.deal());
        }
        System.out.println("Player has " + player.getNumCards() + " cards.");
        System.out.println("Computer has " + comp.getNumCards() + " cards.");

        do {
            Card faceupP = player.playCard();
            System.out.println("Player plays " + faceupP.rank+ " of " +faceupP.suit);
            pile.add(faceupP);

            Card faceupC = comp.playCard();
            System.out.println("Computer plays " + faceupC.rank+ " of " +faceupC.suit);
            pile.add(faceupC);

            displayPile(pile);

            if(faceupP.getValue() > faceupC.getValue()){
                System.out.println("Player wins!");
                player.win(pile);
                pile.clear();
            }
            else if (faceupP.getValue() < faceupC.getValue()){
                System.out.println("Computer wins!");
                comp.win(pile);
                pile.clear();
            }
            else {
                System.out.println("It's a Draw. Drop three.");
                ArrayList<Card> dropP = player.dropCards();
                for (int i = 0; i < dropP.size(); i++){
                    pile.add(dropP.get(i));
                }
                ArrayList<Card> dropC = comp.dropCards();
                for (int i = 0; i < dropC.size(); i++){
                    pile.add(dropC.get(i));
                }
            }

            displayPile(pile);
            System.out.println("Player has " + player.getNumCards() + " cards.");
            System.out.println("Computer has " + comp.getNumCards() + " cards.");
            System.out.println("Do you wish to continue? Type q to quit.");
            choice = reader.nextLine();
        }
        while (player.getNumCards() != 0 && comp.getNumCards() != 0 && !choice.equalsIgnoreCase("Q"));

        if(player.getNumCards() == 0){
            System.out.println("Player wins!");
        }
        else if (comp.getNumCards() == 0){
            System.out.println("Computer wins!");
        }
        else{
            System.out.println("Player has " + player.getNumCards() + " cards.");
            System.out.println("Computer has " + comp.getNumCards() + " cards.");
        }
        reader.close();
    }
}
