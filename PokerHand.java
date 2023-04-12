package proj4;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * defines properties and behavior of a single playing hand which consists 5 card. Compare two hands to see which
 * one is a better hand
 */
public class PokerHand {

    private ArrayList<Card> listOfCard;
    public static final int NUMBER_OF_CARD_IN_HAND = 5;

    /**
     * non-default constructor for representing a poker hand, consisting of an arraylist of card
     * @param cardList an arraylist of 5 cards in a hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        listOfCard = cardList;
    }

    /**
     * adding cards to a hand if the hand contains less than 5 cards
     * @param theCard the card which is add to the hand
     */
    public void addCard(Card theCard) {
        if (listOfCard.size() < NUMBER_OF_CARD_IN_HAND) {
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
        String printable_hand = "";
        for (int i = 0; i < NUMBER_OF_CARD_IN_HAND; i++) {
            printable_hand += "" + listOfCard.get(i) + ", ";
        }
        return printable_hand;
    }

// ---------------------------------------------------------------------------------------------------------------
// compareTo()

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other) {
        if (this.checkType() > other.checkType()) {
            return 1;
        } else if (this.checkType() < other.checkType()) {
            return -1;
        } else {
            if (this.checkType() == 3 && other.checkType() == 3) {
                return compareFlushHands(other);
            } else if (this.checkType() == 2 && other.checkType() == 2) {
                return compareTwoPairHands(other);
            } else if (this.checkType() == 1 && other.checkType() == 1) {
                return comparePairHands(other);
            } else {
                return compareHighCardHands(other);
            }
        }
    }

// ---------------------------------------------------------------------------------------------------------------
// compareTo()'s helper methods

    /**
     * get the ranks of all the cards in hand and put them into an arraylist
     * @return an arraylist containing ranks of all the cards in hand
     */
    private ArrayList<Integer> getHandRanks() {
        ArrayList<Integer> handRanks = new ArrayList<>();
        for (Card handCard : listOfCard) {
            handRanks.add(handCard.getRank());
        }
        handRanks.sort(Comparator.naturalOrder());
        return handRanks;
    }

    /**
     * compare two flush hands to see which one is a better hand
     * @param listOfOtherHand an arraylist containing all other hand's cards
     * @return 1 if this hand is better than other hand, 0 if they are the same and -1 if other hand is better
     */
    private int compareFlushHands(PokerHand listOfOtherHand) {
        ArrayList<Integer> handRanks = getHandRanks();
        ArrayList<Integer> otherHandRanks = listOfOtherHand.getHandRanks();
        for (int i = 0; i < handRanks.size(); i++) {
            if (handRanks.get(handRanks.size() - i - 1) > otherHandRanks.get(handRanks.size() - i - 1)) {
                return 1;
            } else if (handRanks.get(handRanks.size() - i - 1) < otherHandRanks.get(handRanks.size() - i - 1)) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * compare two two-pair hands to see which one is a better hand
     * @param listOfOtherHand an arraylist containing all other hand's cards
     * @return 1 if this hand is better than other hand, 0 if they are the same and -1 if other hand is better
     */
    private int compareTwoPairHands(PokerHand listOfOtherHand) {
        ArrayList<Integer> handRanks = getHandRanks();
        ArrayList<Integer> otherHandRanks = listOfOtherHand.getHandRanks();
        Integer handOutlier;
        Integer otherHandOutlier;

        if (this.fullHouseOutlier() != -1) {
            handOutlier = this.fullHouseOutlier();
            handRanks.remove(handOutlier);
        } else if (this.twoPairAndFourOfAKindOutlier() != -1) {
            handOutlier = this.twoPairAndFourOfAKindOutlier();
            handRanks.remove(handOutlier);
        } else {
            handOutlier = 0;
        }

        if (listOfOtherHand.fullHouseOutlier() != -1) {
            otherHandOutlier = listOfOtherHand.fullHouseOutlier();
            otherHandRanks.remove(otherHandOutlier);
        } else if (this.twoPairAndFourOfAKindOutlier() != -1) {
            otherHandOutlier = listOfOtherHand.twoPairAndFourOfAKindOutlier();
            otherHandRanks.remove(otherHandOutlier);
        } else {
            otherHandOutlier = 0;
        }

        if (handRanks.get(handRanks.size() - 1) > otherHandRanks.get(otherHandRanks.size() - 1)) {
            return 1;
        } else if (handRanks.get(handRanks.size() - 1) < otherHandRanks.get(otherHandRanks.size() - 1)) {
            return -1;
        } else {
            if (handRanks.get(0) > otherHandRanks.get(0)) {
                return 1;
            } else if (handRanks.get(0) < otherHandRanks.get(0)) {
                return -1;
            } else {
                if (handOutlier > otherHandOutlier) {
                    return 1;
                } else if (handOutlier < otherHandOutlier) {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * compare two pair hands to see which one is a better hand
     * @param listOfOtherHand an arraylist containing all other hand's cards
     * @return 1 if this hand is better than other hand, 0 if they are the same and -1 if other hand is better
     */
    private int comparePairHands(PokerHand listOfOtherHand) {
        ArrayList<Integer> handRanks = getHandRanks();
        ArrayList<Integer> otherHandRanks = listOfOtherHand.getHandRanks();
        Integer handPair = this.findPair();
        Integer otherHandPair = listOfOtherHand.findPair();
        if (handPair > otherHandPair) {
            return 1;
        } else if (handPair < otherHandPair) {
            return -1;
        } else {
            handRanks.remove(handPair);
            handRanks.remove(handPair);
            otherHandRanks.remove(otherHandPair);
            otherHandRanks.remove(otherHandPair);
            for (int i = 0; i < handRanks.size(); i++) {
                int lastCardIndex = handRanks.size() - 1;
                if (handRanks.get(lastCardIndex - i) > otherHandRanks.get(lastCardIndex - i)) {
                    return 1;
                } else if (handRanks.get(lastCardIndex - i) < otherHandRanks.get(lastCardIndex - i)) {
                    return -1;
                }
            }
            return 0;
        }
    }

    /**
     * compare two high-card hands to see which one is a better hand
     * @param listOfOtherHand an arraylist containing all other hand's cards
     * @return 1 if this hand is better than other hand, 0 if they are the same and -1 if other hand is better
     */
    private int compareHighCardHands(PokerHand listOfOtherHand) {
        ArrayList<Integer> handRanks = getHandRanks();
        ArrayList<Integer> otherHandRanks = listOfOtherHand.getHandRanks();
        for (int i = 0; i < handRanks.size(); i++) {
            if (handRanks.get(handRanks.size() - i - 1) > otherHandRanks.get(handRanks.size() - i - 1)) {
                return 1;
            } else if (handRanks.get(handRanks.size() - i - 1) < otherHandRanks.get(handRanks.size() - i - 1)) {
                return -1;
            }
        }
        return 0;
    }

// ---------------------------------------------------------------------------------------------------------------
// other helper methods for compareTo()'s helper methods

    /**
     * check the type of the hand
     * @return 3 if it's a flush, 2 if it's a two-pair, 1 if it's a pair and 0 if it's a high-card
     */
    private int checkType() {
        String root = listOfCard.get(0).getSuit();
        int count = 0;
        for (Card theCard : listOfCard) {
            if (theCard.getSuit().equals(root)) {
                count += 1;
            }
        }
        if (count == 5) {
            return 3;
        } else {
            int pairCount = 0;
            for (int i = 0; i < NUMBER_OF_CARD_IN_HAND; i++) {
                for (int j = 0; j < i; j++) {         // this nested loop checks how many single pair in player's hand
                    if (listOfCard.get(i).getRank() == listOfCard.get(j).getRank()) {
                        pairCount += 1;
                    }
                }
            }
            if (pairCount == 2 || pairCount == 4 || pairCount == 6) {
                // in 2 pairs category, there will be 2 separated pairs, thus if number of pair_count equals 2, this hand
                // is a two pair. Similarly, full house category has 4 single pairs (3 single pairs from 3 cards with the
                // same rank and 1 single pair from the 2 other cards left), four of a kind category has 6 single pairs
                // from 4 cards with the same rank.
                return 2;
            } else if (pairCount == 1 || pairCount == 3) {
                // in pair category, there will be 1 single pair, thus if number of pair_count equals 1, this hand is a
                // pair in three of a kind category, 3 cards of a same rank have 3 single pairs, thus if number of
                // pair_count equals 3, this hand is a three of a kind.
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * determine the higher-rank pair in a full house hand
     * @return the rank of higher-rank pair if the hand is a full house, otherwise return -1
     */
    private int fullHouseOutlier() {
        ArrayList<Integer> handRanks = getHandRanks();
        if (handRanks.get(0).equals(handRanks.get(1)) && handRanks.get(2).equals(handRanks.get(3))
                && handRanks.get(3).equals(handRanks.get(4))) {
            return handRanks.get(2);
        } else if (handRanks.get(3).equals(handRanks.get(4)) && handRanks.get(0).equals(handRanks.get(1))
                && handRanks.get(1).equals(handRanks.get(2))) {
            return handRanks.get(0);
        } else {
            return -1;
        }
    }

    /**
     * determine the card which is not in a pair of a two-pair or four of a kind hand
     * @return the rank of a card which is not in a pair of a two-pair or four of a kind hand, otherwise return -1
     */
    private int twoPairAndFourOfAKindOutlier() {
        ArrayList<Integer> handRanks = getHandRanks();
        if (handRanks.get(1).equals(handRanks.get(2)) && handRanks.get(3).equals(handRanks.get(4))) {
            return handRanks.get(0);
        } else if (handRanks.get(0).equals(handRanks.get(1)) && handRanks.get(3).equals(handRanks.get(4))) {
            return handRanks.get(2);
        } else if (handRanks.get(0).equals(handRanks.get(1)) && handRanks.get(2).equals(handRanks.get(3))) {
            return handRanks.get(4);
        } else {
            return -1;
        }
    }

    /**
     * determine the pair in a pair hand
     * @return the rank of cards in the pair, otherwise return -1
     */
    private int findPair() {
        ArrayList<Integer> handRanks = getHandRanks();
        if (handRanks.get(0).equals(handRanks.get(1))) {
            return handRanks.get(0);
        } else if (handRanks.get(1).equals(handRanks.get(2))) {
            return handRanks.get(1);
        } else if (handRanks.get(2).equals(handRanks.get(3))) {
            return handRanks.get(2);
        } else if (handRanks.get(3).equals(handRanks.get(4))) {
            return handRanks.get(3);
        } else {
            return -1;
        }
    }
}


