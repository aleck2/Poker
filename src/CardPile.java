import java.util.ArrayList;
import java.util.Collections;

public class CardPile {
    private ArrayList<Card> cards;
    private int currIndex;

    public CardPile() {
        this.cards = new ArrayList<Card>();
        currIndex = 0;
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                cards.add(new Card(Rank.values()[j], Suit.values()[i]));
            }
        }

        Collections.shuffle(cards);
    }

    public void sort() {
        // Sort by rank, then by suit
        Collections.sort(cards, new CardComparator());
    }

    public Card deal() {
        if (currIndex == (Suit.values().length * Rank.values().length)) // already at last card
            System.err.println("Empty deck");

        currIndex++;
        return cards.get(currIndex - 1);
    }

}

