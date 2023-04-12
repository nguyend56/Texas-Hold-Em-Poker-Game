// I affirm that I have carried out the attached academic endeavors with full academic honesty, in accordance with the
// Union College Honor Code and the course syllabus - Darren

package proj4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * module the Texas Hold'em poker game
 */
public class Client {
    /**
     * get a community card set dealt from a deck of card
     * @param deckOfCard a deck of card which is an arraylist containing 52 card objects
     * @return a CommunityCardSet object
     */
    private static CommunityCardSet dealCommunityHand(Deck deckOfCard){
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < CommunityCardSet.NUMBER_OF_CARD_IN_CCS; i++){
            cardList.add(deckOfCard.deal());
        }
        return new CommunityCardSet(cardList);
    }

    /**
     * print out the community card set
     * @param communityCardSet the community card set
     */
    private static void printCommunityCards(CommunityCardSet communityCardSet){
        String printableCards = "| ";
        for (int i = 0; i < CommunityCardSet.NUMBER_OF_CARD_IN_CCS; i++){
            printableCards += communityCardSet.get_Ith_card(i) + " | ";
        }
        System.out.println(printableCards);
    }

    /**
     * print out the stud poker hand
     * @param studCards stud poker hand
     */
    private static void printStudCards(ArrayList<Card> studCards){
        String printableCards = "| ";
        for (int i = 0; i < StudPokerHand.NUMBER_OF_CARD_IN_SPH; i++){
            printableCards += studCards.get(i) + " | ";
        }
        System.out.println(printableCards);
    }

    /**
     * simulate a Texas Hold'em poker game. draw five community cards
     * from a deck and then repeatedly draw two new 2-card hands from a given deck, ask the user who the winner is
     * (or if there's a tie), taking into account the community cards. If the player is correct, they get one point and
     * the game continues. If the player is incorrect, the game ends and the player's total points should be displayed.
     * The game is also over if there are not enough cards left in the deck to play another round.
     * @param args a string array which its name is changeable
     */
    public static void main(String[] args) {
        Deck theDeck = new Deck();
        theDeck.shuffle();
        int playerPoints = 0;
        boolean gameCondition = true;
        CommunityCardSet communityCards = dealCommunityHand(theDeck);

        while (gameCondition && theDeck.size() >= 4){
            ArrayList<Card> studHandOne = new ArrayList<>();
            ArrayList<Card> studHandTwo = new ArrayList<>();
            for (int i = 0; i < StudPokerHand.NUMBER_OF_CARD_IN_SPH; i++){
                studHandOne.add(theDeck.deal());
                studHandTwo.add(theDeck.deal());
            }

            StudPokerHand handA = new StudPokerHand(communityCards, studHandOne);
            StudPokerHand handB = new StudPokerHand(communityCards, studHandTwo);

            System.out.println("The community cards are: ");
            printCommunityCards(communityCards);
            System.out.println();
            System.out.println("Which of the following hand is worth more?");
            System.out.println("Hand a:");
            printStudCards(studHandOne);
            System.out.println("Hand b:");
            printStudCards(studHandTwo);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter 1 or -1 (or 0 to indicate they are of equal value): ");
            int userResponse = input.nextInt();

            if (userResponse == handA.compareTo(handB)){
                playerPoints += 1;
                System.out.println("your point is: " +  playerPoints);
                System.out.println("Correct!!!");
                System.out.println("-------------------------");
            } else {
                System.out.println("game over hahahah");
                gameCondition = false;
            }
        }
    }
}
