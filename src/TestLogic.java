import java.util.ArrayList;

public class TestLogic {

    private static void myAssert(boolean result) {
        int x;
        if (!result)
            System.out.println("**** WRONG ****");
    }

    public static ArrayList<Card> returnStraight1() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.FOUR, Suit.HEARTS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.SIX, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnStraight2() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.QUEEN, Suit.SPADES));
        hand.add(new Card(Rank.KING, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnFlush() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.TEN, Suit.SPADES));
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.FOUR, Suit.SPADES));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnTwoPair1() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));

        return hand;
    }

    public static ArrayList<Card> returnTwoPair2() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.TWO, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));

        return hand;
    }

    public static ArrayList<Card> returnTwoPair3() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.TWO, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));


        return hand;
    }

    public static ArrayList<Card> returnThreeOfAKind1() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.TWO, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnThreeOfAKind2() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.HEARTS));
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.THREE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnFourOfAKind1() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.FIVE, Suit.HEARTS));
        hand.add(new Card(Rank.FIVE, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnFourOfAKind2() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static ArrayList<Card> returnFlush1() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.EIGHT, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.SPADES));
        hand.add(new Card(Rank.TWO, Suit.SPADES));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));

        return hand;
    }

    public static void printTestHand(ArrayList<Card> hand) {
        for (int i = 0; i < 5; i++)
            System.out.printf("%s, ", hand.get(i).returnCardString());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Test Logic");
        ArrayList<Card> hand;
        int handResult;


        hand = returnFourOfAKind1();
        System.out.println("\n Four of a Kind");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 1);
        printTestHand(hand);


        hand = returnFourOfAKind2();
        System.out.println("\n Four of a Kind");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 1);
        printTestHand(hand);


        hand = returnStraight1();
        System.out.println("\n Straight");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 4);
        printTestHand(hand);

        hand = returnStraight2();
        System.out.println("\n Straight");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 4);
        printTestHand(hand);


        hand = returnThreeOfAKind1();
        System.out.println("\n Three of a Kind1");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 5);
        printTestHand(hand);

        hand = returnThreeOfAKind2();
        System.out.println("\n Three of a Kind2");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 5);
        printTestHand(hand);

        hand = returnTwoPair1();
        System.out.println("\n returnTwoPair1");
        handResult = Logic.bestHand(hand);
        myAssert(handResult == 6);
        printTestHand(hand);


        hand = returnTwoPair2();
        System.out.println("\n returnTwoPair2");
        handResult = Logic.bestHand(hand);
        printTestHand(hand);
        myAssert(handResult == 6);

        hand = returnTwoPair3();
        System.out.println("\n returnTwoPair3");
        handResult = Logic.bestHand(hand);
        printTestHand(hand);
        myAssert(handResult == 6);


        String[] handDescriptions = {"Straight Flush", "4 of a Kind", "Full House", "Flush", "Straight", "3 of a Kind",
                "2 Pair", "1 Pair", "High Card"};
        //System.out.printf("Hand = %s\n", handDescriptions[handResult]);

    }
}
