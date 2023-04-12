package proj4;

import java.util.ArrayList;

/**
 * defines properties and behavior of a community card set
 */
public class CommunityCardSet {
    private ArrayList<Card> listOfCard;
    public static final int NUMBER_OF_CARD_IN_CCS = 5;

    /**
     * non-default constructor for representing a community card set, consisting of an arraylist of card
     * @param cardList an arraylist of 5 cards in a hand
     */
    public CommunityCardSet(ArrayList<Card> cardList) {
        listOfCard = cardList;
    }

    /**
     * adding cards to a community card set if the it contains less than 5 cards
     * @param theCard the card which is add to the hand
     */
    public void addCard(Card theCard) {
        if (listOfCard.size() < NUMBER_OF_CARD_IN_CCS) {
            listOfCard.add(theCard);
        }
    }

    /**
     * get the card based on its index in the listOfCard
     * @param cardIndex an index of the card
     * @return the card at that index in listOfCard
     */
    public Card get_Ith_card(int cardIndex) {
        return listOfCard.get(cardIndex);
    }

    /**
     * return the hand as a printable string like "King of Spades"
     * @return a printable string
     */
    public String toString() {
        String printable_CCS= "";
        for (int i = 0; i < NUMBER_OF_CARD_IN_CCS; i++) {
            printable_CCS += "" + listOfCard.get(i) + ", ";
        }
        return printable_CCS;
    }
}
