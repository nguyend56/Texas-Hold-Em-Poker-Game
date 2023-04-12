package proj4;

import java.util.ArrayList;

/**
 * test all methods in PokerHand class
 */
public class PokerHandTester {
    /**
     * all PokerHand tests
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Testing.startTests();
        testAddCard();
        testGetIthCard();
        testToString();
        testFlushHandAndTwoPairHand();
        testHighCardHandAndFlushHand();
        testPairHandAndHighCardHand();
        testFlushHands();
        testTwoPairHandsThatHaveDifferentPairs();
        test_pair_hands_that_have_same_pair();
        testPairHandsThatHaveSamePairAndSameHighestAndSecondHighestHighCard();
        testTwoDifferentHighCardHands();
        testTwoHighCardHandsThatHaveSameHighestAndSecondHighestHighCard();
        twoEqualHand();
        Testing.finishTests();
    }

// Unit testing starts below
    /**
     * test get_Ith_card() method
     */
    public static void testGetIthCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        PokerHand hand = new PokerHand(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        hand.addCard(card1); hand.addCard(card2); hand.addCard(card3); hand.addCard(card4); hand.addCard(card5);
        Card actual = hand.get_Ith_card(3);
        Testing.assertEquals("Test getIthCard", card4, actual);
    }

    /**
     * test addCard() method
     */
    public static void testAddCard(){
        ArrayList<Card> cardList = new ArrayList<>();
        PokerHand hand = new PokerHand(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        hand.addCard(card1); hand.addCard(card2); hand.addCard(card3); hand.addCard(card4); hand.addCard(card5);
        Testing.assertEquals("Test addCard", card2, hand.get_Ith_card(1));
    }

    /**
     * test toString() method
     */
    public static void testToString(){
        ArrayList<Card> cardList = new ArrayList<>();
        PokerHand hand = new PokerHand(cardList);
        Card card1 = new Card(10, "Clubs");
        Card card2 = new Card(4, "Diamonds");
        Card card3 = new Card(2, "Spades");
        Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Hearts");
        hand.addCard(card1); hand.addCard(card2); hand.addCard(card3); hand.addCard(card4); hand.addCard(card5);
        String expected = "10 of Clubs, 4 of Diamonds, 2 of Spades, Ace of Clubs, 2 of Hearts, ";
        Testing.assertEquals("Test toString", expected, hand.toString());
    }

    // Tests for compareTo()
    // Test hands with different types

    public static void testFlushHandAndTwoPairHand(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(4, "Spades"); Card card2 = new Card(5, "Spades");
        Card card3 = new Card(6, "Spades"); Card card4 = new Card(7, "Spades");
        Card card5 = new Card(8, "Spades");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(4, "Spades"); Card card7 = new Card(4, "Spades");
        Card card8 = new Card(6, "Spades"); Card card9 = new Card(6, "Spades");
        Card card10 = new Card(8, "Spades");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = 1;
        Testing.assertEquals("comparing a flush hand to a two-pair hand", expect, actual);
    }

    public static void testHighCardHandAndFlushHand(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(5, "Spades"); Card card2 = new Card(9, "Diamonds");
        Card card3 = new Card(2, "Spades"); Card card4 = new Card(8, "Clubs");
        Card card5 = new Card(12, "Clubs");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(12, "Spades"); Card card7 = new Card(11, "Spades");
        Card card8 = new Card(9, "Spades"); Card card9 = new Card(10, "Spades");
        Card card10 = new Card(8, "Spades");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing a high card hand to a flush hand", expect, actual);
    }

    public static void testPairHandAndHighCardHand(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(14, "Hearts"); Card card2 = new Card(5, "Hearts");
        Card card3 = new Card(11, "Spades"); Card card4 = new Card(7, "Clubs");
        Card card5 = new Card(7, "Spades");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(4, "Hearts"); Card card7 = new Card(7, "Spades");
        Card card8 = new Card(6, "Spades"); Card card9 = new Card(10, "Diamonds");
        Card card10 = new Card(8, "Clubs");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = 1;
        Testing.assertEquals("comparing a pair hand to a high card hand", expect, actual);
    }

    // Test hands with same type

    public static void testFlushHands(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(5, "Spades"); Card card2 = new Card(6, "Spades");
        Card card3 = new Card(4, "Spades"); Card card4 = new Card(13, "Spades");
        Card card5 = new Card(6, "Spades");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(13, "Hearts"); Card card7 = new Card(10, "Hearts");
        Card card8 = new Card(11, "Hearts"); Card card9 = new Card(14, "Hearts");
        Card card10 = new Card(12, "Hearts");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing two flush hands", expect, actual);
    }

    public static void testTwoPairHandsThatHaveDifferentPairs(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(5, "Hearts"); Card card2 = new Card(5, "Spades");
        Card card3 = new Card(12, "Spades"); Card card4 = new Card(7, "Clubs");
        Card card5 = new Card(7, "Spades");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(2, "Hearts"); Card card7 = new Card(6, "Hearts");
        Card card8 = new Card(6, "Diamonds"); Card card9 = new Card(8, "Hearts");
        Card card10 = new Card(8, "Clubs");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing two two-pair hands that have different pairs", expect, actual);
    }

    public static void test_pair_hands_that_have_same_pair(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(8, "Clubs"); Card card2 = new Card(3, "Hearts");
        Card card3 = new Card(14, "Spades"); Card card4 = new Card(14, "Clubs");
        Card card5 = new Card(2, "Spades");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(9, "Diamonds"); Card card7 = new Card(14, "Hearts");
        Card card8 = new Card(14, "Diamonds"); Card card9 = new Card(4, "Hearts");
        Card card10 = new Card(6, "Clubs");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing two pair hands that have same pair", expect, actual);
    }

    public static void testPairHandsThatHaveSamePairAndSameHighestAndSecondHighestHighCard(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(6, "Spades"); Card card2 = new Card(3, "Hearts");
        Card card3 = new Card(10, "Diamonds"); Card card4 = new Card(10, "Clubs");
        Card card5 = new Card(14, "Clubs");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(10, "Clubs"); Card card7 = new Card(14, "Hearts");
        Card card8 = new Card(4, "Spades"); Card card9 = new Card(10, "Hearts");
        Card card10 = new Card(6, "Clubs");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing two pair hands that have same pair " +
                "and same highest and second highest high card", expect, actual);
    }

    public static void testTwoDifferentHighCardHands(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(8, "Spades"); Card card2 = new Card(3, "Hearts");
        Card card3 = new Card(10, "Diamonds"); Card card4 = new Card(5, "Clubs");
        Card card5 = new Card(4, "Clubs");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(10, "Clubs"); Card card7 = new Card(12, "Hearts");
        Card card8 = new Card(4, "Spades"); Card card9 = new Card(9, "Hearts");
        Card card10 = new Card(6, "Clubs");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = -1;
        Testing.assertEquals("comparing two different high card hands", expect, actual);
    }

    public static void testTwoHighCardHandsThatHaveSameHighestAndSecondHighestHighCard(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(8, "Spades"); Card card2 = new Card(11, "Hearts");
        Card card3 = new Card(10, "Diamonds"); Card card4 = new Card(5, "Clubs");
        Card card5 = new Card(4, "Clubs");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(10, "Clubs"); Card card7 = new Card(5, "Hearts");
        Card card8 = new Card(4, "Diamonds"); Card card9 = new Card(2, "Hearts");
        Card card10 = new Card(11, "Spades");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = 1;
        Testing.assertEquals("comparing two high card hands that have same highest and " +
                "second highest high card", expect, actual);
    }

    // Test two equal hands

    public static void twoEqualHand(){
        ArrayList<Card> firstHandCard = new ArrayList<>();
        Card card1 = new Card(5, "Spades"); Card card2 = new Card(11, "Hearts");
        Card card3 = new Card(10, "Diamonds"); Card card4 = new Card(7, "Clubs");
        Card card5 = new Card(12, "Clubs");
        firstHandCard.add(card1); firstHandCard.add(card2); firstHandCard.add(card3);
        firstHandCard.add(card4); firstHandCard.add(card5);
        PokerHand firstHand = new PokerHand(firstHandCard);

        ArrayList<Card> secondHandCard = new ArrayList<>();
        Card card6 = new Card(12, "Clubs"); Card card7 = new Card(5, "Hearts");
        Card card8 = new Card(10, "Diamonds"); Card card9 = new Card(11, "Hearts");
        Card card10 = new Card(7, "Spades");
        secondHandCard.add(card6); secondHandCard.add(card7); secondHandCard.add(card8);
        secondHandCard.add(card9); secondHandCard.add(card10);
        PokerHand secondHand = new PokerHand(secondHandCard);

        int actual = firstHand.compareTo(secondHand);
        int expect = 0;
        Testing.assertEquals("comparing two equal hands", expect, actual);
    }
}
