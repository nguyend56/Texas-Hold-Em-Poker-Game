package proj4;

/**
 * test all methods in Deck class
 */
public class DeckTester {

    /**
     * all tests for Deck class' methods
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Testing.startTests();
        testShuffle();
        testIsEmptyTrue();
        testIsEmptyFalse();
        testDealTrue();
        testDealNull();
        testSize();
        testGather();
        testToString();
        Testing.finishTests();
    }

    /**
     * test shuffle() method
     */
    public static void testShuffle(){
        Deck theDeck = new Deck();
        String initialDeck = theDeck.toString();
        theDeck.shuffle();
        String shuffleDeck = theDeck.toString();
        boolean expected = false;
        boolean actual = (initialDeck.equals(shuffleDeck));
        Testing.assertEquals("Test shuffle()", expected, actual);
    }

    /**
     * test isEmpty() method
     */
    public static void testIsEmptyTrue(){
        Deck theDeck = new Deck();
        int numberOfCardInDeck = theDeck.size();
        for (int i = 0; i < numberOfCardInDeck; i++){
            theDeck.deal();
        }
        boolean expected = true;
        boolean actual = theDeck.isEmpty();
        Testing.assertEquals("Test isEmpty()", expected, actual);
    }

    /**
     * test isEmpty() method
     */
    public static void testIsEmptyFalse(){
        Deck theDeck = new Deck();
        boolean expected = false;
        boolean actual = theDeck.isEmpty();
        Testing.assertEquals("Test isEmpty()", expected, actual);
    }

    /**
     * test deal() method
     */
    public static void testDealTrue(){
        Deck theDeck = new Deck();
        Card theCard = theDeck.deal();
        String expected = "2 of Spades";
        String actual = theCard.toString();
        Testing.assertEquals("Test deal()", expected, actual);
    }

    /**
     * test deal() method
     */
    public static void testDealNull(){
        Deck theDeck = new Deck();
        int numberOfCardInDeck = theDeck.size();
        for (int i = 0; i < numberOfCardInDeck; i++){
            theDeck.deal();
        }
        boolean expected = true;
        boolean actual = (theDeck.deal() == null);
        Testing.assertEquals("Test deal()", expected, actual);
    }

    /**
     * test size() method
     */
    public static void testSize(){
        Deck theDeck = new Deck();
        theDeck.deal();
        theDeck.deal();
        theDeck.deal();
        int expected = 49;
        int actual = theDeck.size();
        Testing.assertEquals("Test size()", expected, actual);
    }

    /**
     * test gather() method
     */
    public static void testGather(){
        Deck theDeck = new Deck();
        String initialDeck = theDeck.toString();
        int numberOfCardInDeck = theDeck.size();
        for (int i = 0; i < numberOfCardInDeck; i++){
            theDeck.deal();
        }
        theDeck.gather();
        String gatherDeck = theDeck.toString();
        boolean expected = true;
        boolean actual = (initialDeck.equals(gatherDeck));
        Testing.assertEquals("Test gather()", expected, actual);
    }

    /**
     * test toString() method
     */
    public static void testToString(){
        Deck theDeck = new Deck();
        String expected = "2 of Spades\n" + "2 of Hearts\n" +
                "2 of Diamonds\n" +
                "2 of Clubs\n" +
                "3 of Spades\n" +
                "3 of Hearts\n" +
                "3 of Diamonds\n" +
                "3 of Clubs\n" +
                "4 of Spades\n" +
                "4 of Hearts\n" +
                "4 of Diamonds\n" +
                "4 of Clubs\n" +
                "5 of Spades\n" +
                "5 of Hearts\n" +
                "5 of Diamonds\n" +
                "5 of Clubs\n" +
                "6 of Spades\n" +
                "6 of Hearts\n" +
                "6 of Diamonds\n" +
                "6 of Clubs\n" +
                "7 of Spades\n" +
                "7 of Hearts\n" +
                "7 of Diamonds\n" +
                "7 of Clubs\n" +
                "8 of Spades\n" +
                "8 of Hearts\n" +
                "8 of Diamonds\n" +
                "8 of Clubs\n" +
                "9 of Spades\n" +
                "9 of Hearts\n" +
                "9 of Diamonds\n" +
                "9 of Clubs\n" +
                "10 of Spades\n" +
                "10 of Hearts\n" +
                "10 of Diamonds\n" +
                "10 of Clubs\n" +
                "Jack of Spades\n" +
                "Jack of Hearts\n" +
                "Jack of Diamonds\n" +
                "Jack of Clubs\n" +
                "Queen of Spades\n" +
                "Queen of Hearts\n" +
                "Queen of Diamonds\n" +
                "Queen of Clubs\n" +
                "King of Spades\n" +
                "King of Hearts\n" +
                "King of Diamonds\n" +
                "King of Clubs\n" +
                "Ace of Spades\n" +
                "Ace of Hearts\n" +
                "Ace of Diamonds\n" +
                "Ace of Clubs\n";
        String actual = theDeck.toString();
        Testing.assertEquals("Test toString", expected, actual);
    }
}
