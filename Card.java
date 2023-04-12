package proj4;

/**
 * defines properties and behavior of a single playing card
 */
public class Card {
    public final static String[] SUITS = {"Spades","Hearts","Clubs","Diamonds"};
    public final static String[] RANKS_SPELLED = {"two","three","four","five","six","seven",
            "eight","nine","ten","jack","queen","king","ace"};
    public final static String[] RANKS_NUMERIC = {"2","3","4","5","6","7","8","9","10","11","12","13","14"};

    private int rank;
    private String suit;

    /**
     * non-default constructor with rank and suit of a card
     * @param newRank integer: representing the rank of a card, which is an integer from 2-14 (14=Ace)
     * @param newSuit String: representing the suit of a card, which could be "Hearts","Clubs","Spades",etc.
     */
    public Card(int newRank, String newSuit){
        this.rank = newRank;
        this.suit = newSuit;
    }

    /**
     * non-default constructor
     * @param rank String: whole cards (2-10) can either be spelled out like "two" or numeric like "2". Case insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit){
        this.rank = convertRankStringToInteger(rank);
        this.suit = suit.substring(0,1).toUpperCase() + suit.substring(1, suit.length());
    }

    /**
     * non-default constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = convertSuitIntegerToString(suit);
    }

    /**
     * getter for rank
     * @return int between 2-14
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * getter for suit
     * @return suit fully written out like "Diamonds"
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * return the card as a printable string like "King of Spades"
     * @return printable string
     */
    public String toString(){
        return convertFace(getRank()) + " of " + getSuit();
    }

    /**
     * take numeric rank and turn it into a printable string where 11-14 are turned into Face card values
     */
    private String convertFace(int rank){    
        if (rank == 11){
            return "Jack";
        }
        else if (rank == 12) {
            return "Queen";
        }
        else if (rank == 13) {
            return "King";
        }
        else if (rank == 14) {
            return "Ace";
        }
        else {                   // whole card -> just change the type
            return "" + rank;    // make int a string
        }
    }

    /**
     * helper method to convert rank from string type to integer type
     * @param rank String: whole cards (2-10) can either be spelled out like "two" or numeric like "2". Case insensitive.
     * @return rank as an integer
     */
    private int convertRankStringToInteger(String rank){
        for (int i = 0; i < RANKS_SPELLED.length; i ++){
            if (rank.toLowerCase().equals(RANKS_SPELLED[i]) || rank.equals(RANKS_NUMERIC[i])){
                return i + 2;
            }
        } return -1;
    }

    /**
     * helper method to convert suit from integer type to string type
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     * @return suit as a string
     */
    private String convertSuitIntegerToString(int suit){
        for (int i = 0; i < SUITS.length; i ++){
            if (suit == i){
                return SUITS[i];
            }
        } return "error";
    }
}

