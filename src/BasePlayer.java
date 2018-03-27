import java.util.ArrayList;

/*
 * Player class contains player's hand and acts mostly as UI that's called from main() *
 */

public abstract class BasePlayer {

    ArrayList<Card> hand = new ArrayList<Card>(); // TODO make this private without breaking anything
    private static final int hand_size = 5;

    public boolean addCardToHand(Card card) {
        if (hand.size() == hand_size) // cannot have more than hand_size cards in hand
            return false;
        hand.add(card);
        return true;
    }

    public void redraw(int index, CardPile deck) {
        hand.remove(index);
        hand.add(deck.deal());
    }

    public void printHand() {
        for (int i = 0; i < hand_size; i++)
            System.out.printf("%d: %s, ", i + 1, hand.get(i).returnCardString());
        System.out.println();
    }


}
