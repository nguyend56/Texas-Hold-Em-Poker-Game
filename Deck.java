package proj4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

/**
 * defines a standard deck of 52 playing cards
 */
public class Deck {

    public final static int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    public final static String[] SUITS = {"Spades", "Hearts", "Diamonds", "Clubs"};
    public final int INDEX_OF_LAST_CARD = 51;

    private ArrayList<Card> contents = new ArrayList<>();
    private int nextToDeal;

    /**
     * default constructor representing a deck of card with 52 cards
     */
    public Deck(){
        for (int rank: RANKS){
            for (String suit: SUITS){
                Card newCard = new Card(rank, suit);
                contents.add(newCard);
            }
        }
        nextToDeal = 0;
    }

    /**
     * shuffle the remaining cards in the deck
     */
    public void shuffle(){
        for (int i = nextToDeal; i <= INDEX_OF_LAST_CARD; i++){
            int anotherCardIndex = ThreadLocalRandom.current().nextInt(nextToDeal, INDEX_OF_LAST_CARD);
            Card theCard = contents.get(i);
            Card anotherCard = contents.get(anotherCardIndex);
            contents.set(i, anotherCard);
            contents.set(anotherCardIndex, theCard);
        }
    }

    /**
     * deal card from the deck
     * @return a card dealt or null if there is no cards in the deck
     */
    public Card deal(){
        nextToDeal += 1;   // after dealing the card, nextToDeal moves to the next index
        if (size() > 0) {
            return contents.get(nextToDeal - 1);  // return nextToDeal before it moves to next index
        } else{
            return null;
        }
    }

    /**
     * check if the card is empty or not
     * @return a boolean. true if it's empty, false if it's not
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * return number of cards left in the deck after dealing cards
     * @return an integer demonstrating number of cards left in deck
     */
    public int size(){
        return INDEX_OF_LAST_CARD - nextToDeal + 1;
    }

    /**
     * the deck is returned to the state where all cards are undealt
     */
    public void gather(){
        nextToDeal = 0 ;
    }

    /**
     * return the deck as a printable string like "King of Spades"
     * @return printable string
     */
    public String toString(){
        String printable_deck = "";
        for (int i = nextToDeal; i <= INDEX_OF_LAST_CARD; i++){
            printable_deck += "" + contents.get(i) + "\n";
        }
        return printable_deck;
    }
}
