import java.util.Comparator;

class CardComparator implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        if (c1.getRank().compareTo(c2.getRank()) == 0)
            return c1.getSuit().compareTo(c2.getSuit());
        else
            return c1.getRank().compareTo(c2.getRank());
    }
}
