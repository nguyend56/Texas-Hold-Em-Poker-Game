package proj4;

import java.util.ArrayList;

/**
 * test all methods in CommunityCardSet class
 */
public class CommunityCardSetTester {

    /**
     * all tests for CommunityCardSet class' methods
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Testing.startTests();
        testAddCard();
        testGetIthCard();
        testToString();
        Testing.finishTests();
    }

    /**
     * test get_Ith_card() method
     */
    public static void testGetIthCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        Card actual = ccSet.get_Ith_card(3);
        Testing.assertEquals("Test getIthCard", card4, actual);
    }

    /**
     * test addCard() method
     */
    public static void testAddCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        Testing.assertEquals("Test addCard", card3, ccSet.get_Ith_card(2));
    }

    /**
     * test toString() method
     */
    public static void testToString(){
        ArrayList<Card> cardList = new ArrayList<>();
        CommunityCardSet ccSet = new CommunityCardSet(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        ccSet.addCard(card1); ccSet.addCard(card2); ccSet.addCard(card3); ccSet.addCard(card4); ccSet.addCard(card5);
        String expected = "10 of Clubs, 4 of Diamonds, 2 of Spades, Ace of Clubs, 2 of Hearts, ";
        Testing.assertEquals("Test toString", expected, ccSet.toString());
    }
}
