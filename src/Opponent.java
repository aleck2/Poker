public class Opponent extends BasePlayer {
    private int id;

    public Opponent(int _id) {
        this.id = _id;
    }

    // TODO implement fancier AI
    public void checkHand(CardPile deck) {
        // Straight flush = 0, 4 of a kind = 1 ... 1 pair = 7, high card  = 8
        int typeOfHand = Logic.bestHand(hand);
        if (typeOfHand <= 7) {
            if (typeOfHand == 1) { // 4 of a kind replace odd card out
                redraw(4, deck);
                System.out.println("1 card. ");
            } else if (typeOfHand == 5) { // 3 of a kind replace 2 odd cards out
                redraw(3, deck);
                redraw(4, deck);
                System.out.println("2 cards. ");
            } else if (typeOfHand == 6) { // 2 of a kind replace 1 odd card out
                redraw(4, deck);
                System.out.println("1 card. ");
            } else if (typeOfHand == 7) { // 1 pair replace 3 odd cards out
                redraw(2, deck);
                redraw(3, deck);
                redraw(4, deck);
                System.out.println("3 cards. ");
            } else
                System.out.println("0 Cards. ");
        } else {
//            // these functions discard within
//            if (has4SameSuit(deck)) {
//                System.out.println("1 card. ");
//                return;
//            }
//            else if (has4SameSequence(deck)){
//                System.out.println("1 card. ");
//                return;
//            }
//            else if (hasAce(deck)) {
//                System.out.println("4 cards. ");
//                return;
//            }
//            // else keep highest 2 cards
//            redraw(2, deck);
//            redraw(3, deck);
//            redraw(4, deck);
            //System.out.println("3 cards." );
            System.out.println("0 cards.");

        }
    }


}
