import java.util.ArrayList;
import java.util.Collections;

public class Logic {

    /*
     * In general, hand should be sorted before being passed to checker methods
     * If a checker method is true (eg 4 of a kind), then the hand will be resorted
     * such that the ranking sub-hand is ordered first
     * e.g [3, 5, A, A, A] -> [A, A, A, 3, 5]
     * [2, 2, 3, 5, 5] -> [2, 2, 5, 5, 3]

     * Must evaluate hands from best possible to worst to avoid undervaluing a hand
     */


    // TODO put all constants in one file
    // TODO add enum class for hand types
    public static final int hand_size = 5;

    public static int bestHand(ArrayList<Card> hand) {
        Collections.sort(hand, new CardComparator());
        if (isStraightFlush(hand)) return 0;
        if (is4OfAKind(hand)) return 1;
        if (isFullHouse(hand)) return 2;
        if (isFlush(hand)) return 3;
        if (isStraight(hand)) return 4;
        if (is3OfAKind(hand)) return 5;
        if (is2Pair(hand)) return 6;
        if (is1Pair(hand)) return 7;
        else return 8;
    }

    // TODO implement tiebreaker logic

    private static boolean isStraightFlush(ArrayList<Card> hand) {
        return (isFlush(hand) && isStraight(hand));
    }

    // may modify hand
    private static boolean is4OfAKind(ArrayList<Card> hand) {
        if (hand.get(0).getRank() == hand.get(3).getRank())
            return true;
        else if (hand.get(1).getRank() == hand.get(4).getRank()) {
            // shift last 4 values to front and move first value to end
            Collections.rotate(hand, -1); // [t, a, n, k, s] becomes [a, n, k, s, t]
            return true;
        }

        return false;
        //return (hand.get(0).getRank() == hand.get(3).getRank() || hand.get(1).getRank() == hand.get(4).getRank());
    }

    // calls3OfAKind which calls nPairs which may modify hand
    private static boolean isFullHouse(ArrayList<Card> hand) {
        return (is3OfAKind(hand) && is1Pair(hand));
    }


    private static boolean isFlush(ArrayList<Card> hand) {
        Suit flushSuit = hand.get(0).getSuit();
        for (int i = 1; i < 5; i++) {
            if (flushSuit != hand.get(i).getSuit())
                return false;
        }

        return true;
    }

    private static boolean isStraight(ArrayList<Card> hand) {
        int counter;
        for (int i = 0; i < hand_size - 1; i++) {
            counter = 1;
            for (int j = i; j < i + hand_size - 1; j++) {
                if (Math.floorMod(hand.get(j % 5).getRank().getValue(), 13) == Math.floorMod(hand.get((j + 1) % 5).getRank().getValue() - 1, 13)) {
                    counter++;
                } else
                    break;
            }

            if (counter == 5)
                return true;
        }

        return false;
    }


    // will return 3ofakind on a 4 of a kind, but doesn't matter since is4OfAKind should be called first
    // modifies hand when hand contains 3 of a kind
    private static boolean is3OfAKind(ArrayList<Card> hand) {
        for (int i = 0; i < hand_size - 2; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank() &&
                    hand.get(i + 1).getRank() == hand.get(i + 2).getRank()) {
                Collections.rotate(hand, hand_size - i);
                return true;
            }
        }

        return false;
    }

    // detects strict 2 pair, [3, 3, 3, 3, 1] would be false since it's 4 of a kind
    // [3, 3, 2, 2, 1] would be true
    // calls calculateNPairs which may modify hand
    private static boolean is2Pair(ArrayList<Card> hand) {
        return (calculateNPairs(hand) == 2);
    }


    // detects strict 1 pair, [4, 4, 4, 2, 1] should be false
    // calls calculateNPairs which may modify hand
    private static boolean is1Pair(ArrayList<Card> hand) {
        return (calculateNPairs(hand) == 1);
    }

    // Note: 3 of a kind and 4 of a kind are not pairs and should not count towards nPairs
    // Does not need to be perfectly sorted to work; cards with same rank should be adjacent for this to work
    // [10, 10, 10, 2, 2] would return 1
    private static int calculateNPairs(ArrayList<Card> hand) {
        int nPairs = 0;
        Rank last = null;

        for (int i = 0; i < hand_size - 2; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank() && hand.get(i).getRank() != hand.get(i + 2).getRank() && hand.get(i).getRank() != last) { // only matches on 1 pair, not 3 or 4 of a kind
                Collections.rotate(hand.subList(nPairs * 2, hand_size), hand_size - i);
                nPairs++;
            }
            last = hand.get(i).getRank();
        }

        if (hand.get(hand_size - 2).getRank() == hand.get(hand_size - 1).getRank() && hand.get(hand_size - 2).getRank() != hand.get(hand_size - 3).getRank()) {
            Collections.rotate(hand.subList(nPairs * 2, hand_size), hand_size - (hand_size - 2));
            nPairs++;
        }

        return nPairs;
    }


}
