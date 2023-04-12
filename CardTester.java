package proj4;

/**
 * test all methods in Card class
 */
public class CardTester {
    /**
     * all tests for Card class' methods
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Testing.startTests();
        testGetRank();
        testGetSuit();
        testToString();
        Testing.finishTests();
    }

    /**
     * test getRank() method
     */
    public static void testGetRank() {
        Card theCard = new Card(12, "Spades");
        int actual = theCard.getRank();
        int expected = 12;
        Testing.assertEquals("Test getRank()", expected, actual);
    }

    /**
     * test getSuit() method
     */
    public static void testGetSuit() {
        Card theCard = new Card(5, "Diamonds");
        String actual = theCard.getSuit();
        String expected = "Diamonds";
        Testing.assertEquals("Test getSuit()", expected, actual);
    }

    /**
     * test toString() method
     */
    public static void testToString() {
        Card theCard = new Card(8, "Clubs");
        String actual = theCard.toString();
        String expected = "8 of Clubs";
        Testing.assertEquals("Test toString()", expected, actual);
    }
}
