package proj4;

import java.util.ArrayList;

/**
 * defines properties and behavior of a stud poker hand
 */
public class StudPokerHand {
    private ArrayList<Card> studCards;
    private CommunityCardSet communityCard;
    public static final int NUMBER_OF_CARD_IN_SPH = 2;

    /**
     * non-default constructor for representing a stud poker hand, consisting of an arraylist of card
     * @param cardList an arraylist of 2 cards in a hand
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        communityCard = cc;
        studCards = cardList;
    }

    /**
     * adding cards to a stud poker hand if the it contains less than 2 cards
     * @param theCard the card which is add to the hand
     */
    public void addCard(Card theCard) {
        if (studCards.size() < NUMBER_OF_CARD_IN_SPH) {
            studCards.add(theCard);
        }
    }

    /**
     * get the card based on its index in the studCards
     *
     * @param cardIndex an index of the card
     * @return the card at that index in studCards
     */
    public Card get_Ith_card(int cardIndex) {
        return studCards.get(cardIndex);
    }

    /**
     * return the stud poker hand as a printable string like "King of Spades"
     * @return a printable string
     */
    public String toString() {
        String printable_SPH = "";
        for (int i = 0; i < NUMBER_OF_CARD_IN_SPH; i++) {
            printable_SPH += "" + studCards.get(i) + ", ";
        }
        return printable_SPH;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {
        return (this.getBestFiveCardHand()).compareTo(other.getBestFiveCardHand());
    }

    /**
     * helper method for compareTo, get the best five card hand out of all five card hands
     * @return PokerHand: the best five card hand
     */
    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * helper method for getBestFiveCardHand, get all five card hands possible
     * @return an arraylist containing all the five card hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands() {
        int numberOfCardInStudHand = 7;
        ArrayList<PokerHand> allFiveCardHands = new ArrayList<>();

        ArrayList<Card> communityList = new ArrayList<>();
        for (int i = 0; i < CommunityCardSet.NUMBER_OF_CARD_IN_CCS; i++){
            communityList.add(communityCard.get_Ith_card(i));
        }

        for (int i = 0; i < numberOfCardInStudHand - 1; i++) {
            for (int j = i + 1; j < numberOfCardInStudHand; j++) {
                ArrayList<Card> L = new ArrayList<>();
                L.addAll(communityList);
                L.addAll(studCards);
                L.remove(j);
                L.remove(i);
                PokerHand oneFiveCardHand = new PokerHand(L);
                allFiveCardHands.add(oneFiveCardHand);
            }
        } return allFiveCardHands;
    }

    /**
     * helper method for getAllFiveCardHands, get the community card list
     * @return an arraylist containing 5 cards in community card set
     */
//    private ArrayList<Card> getCommunityCardList(){
//        ArrayList<Card> communityList = new ArrayList<>();
//        for (int i = 0; i < CommunityCardSet.NUMBER_OF_CARD_IN_CCS; i++){
//            communityList.add(communityCard.get_Ith_card(i));
//        }
//        return communityList;
//    }
}

