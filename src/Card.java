public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Rank _rank, Suit _suit) {
        this.rank = _rank;
        this.suit = _suit;
    }

    public String returnCardString() {
        return String.format("%s %s", rank, suit);
    }
}
