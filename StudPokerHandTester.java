package proj4;

import java.util.ArrayList;

/**
 * test all methods in StudPokerHand class
 */
public class StudPokerHandTester {
    /**
     * all tests for StudPokerHand class' methods
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Testing.startTests();
        testAddCard();
        testGetIthCard();
        testToString();
        testCompareToHandAWin();
        testCompareToHandBWin();
        testCompareToTie();
        Testing.finishTests();
    }

    /**
     * test get_Ith_card() method
     */
    public static void testGetIthCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        ArrayList<Card> studCards = new ArrayList<>();
        CommunityCardSet cc = new CommunityCardSet(cardList);
        StudPokerHand studHand = new StudPokerHand(cc, studCards);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        studCards.add(card1); studCards.add(card2);
        Card actual = studHand.get_Ith_card(1);
        Testing.assertEquals("Test getIthCard", card2, actual);
    }

    /**
     * test addCard() method
     */
    public static void testAddCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        ArrayList<Card> studCards = new ArrayList<>();
        CommunityCardSet cc = new CommunityCardSet(cardList);
        StudPokerHand studHand = new StudPokerHand(cc, studCards);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        studCards.add(card1); studCards.add(card2);
        Testing.assertEquals("Test addCard", card1, studHand.get_Ith_card(0));
    }

    /**
     * test toString() method
     */
    public static void testToString(){
        ArrayList<Card> cardList = new ArrayList<>();
        ArrayList<Card> studCards = new ArrayList<>();
        CommunityCardSet cc = new CommunityCardSet(cardList);
        StudPokerHand studHand = new StudPokerHand(cc, studCards);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        studCards.add(card1); studCards.add(card2);
        String expected = "10 of Clubs, 4 of Diamonds, ";
        Testing.assertEquals("Test toString", expected, studHand.toString());
    }

    /**
     * test compareTo() method
     */
    public static void testCompareToHandAWin(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        ArrayList<Card> studCardsA = new ArrayList<>();
        ArrayList<Card> studCardsB = new ArrayList<>();
        StudPokerHand handA = new StudPokerHand(ccSet, studCardsA);
        StudPokerHand handB = new StudPokerHand(ccSet, studCardsB);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        Card card6 = new Card(3, "Hearts");
        Card card7 = new Card(10, "Diamonds");
        Card card8 = new Card(13, "Spades");
        Card card9 = new Card(11, "Hearts");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        studCardsA.add(card6); studCardsA.add(card7); studCardsB.add(card8); studCardsB.add(card9);
        int actual = handA.compareTo(handB);
        int expected = 1;
        Testing.assertEquals("Test compareTo()", expected, actual);
    }

    /**
     * test compareTo() method
     */
    public static void testCompareToHandBWin(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        ArrayList<Card> studCardsA = new ArrayList<>();
        ArrayList<Card> studCardsB = new ArrayList<>();
        StudPokerHand handA = new StudPokerHand(ccSet, studCardsA);
        StudPokerHand handB = new StudPokerHand(ccSet, studCardsB);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        Card card6 = new Card(8, "Hearts");
        Card card7 = new Card(2, "Diamonds");
        Card card8 = new Card(14, "Spades");
        Card card9 = new Card(11, "Hearts");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        studCardsA.add(card6); studCardsA.add(card7); studCardsB.add(card8); studCardsB.add(card9);
        int actual = handA.compareTo(handB);
        int expected = -1;
        Testing.assertEquals("Test compareTo()", expected, actual);
    }

    /**
     * test compareTo() method
     */
    public static void testCompareToTie(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        ArrayList<Card> studCardsA = new ArrayList<>();
        ArrayList<Card> studCardsB = new ArrayList<>();
        StudPokerHand handA = new StudPokerHand(ccSet, studCardsA);
        StudPokerHand handB = new StudPokerHand(ccSet, studCardsB);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        Card card6 = new Card(3, "Hearts");
        Card card7 = new Card(10, "Diamonds");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        studCardsA.add(card6); studCardsA.add(card7); studCardsB.add(card6); studCardsB.add(card7);
        int actual = handA.compareTo(handB);
        int expected = 0;
        Testing.assertEquals("Test compareTo()", expected, actual);
    }
}
