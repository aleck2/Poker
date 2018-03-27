
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Player extends BasePlayer {
    private static final int hand_size = 5;


    public void playerUI(CardPile deck) {
        int numberOfReplacements = 0;
        boolean hasAce = false;
        ArrayList<Card> oldHandCopy = new ArrayList<>(hand);

        Collections.sort(hand, new CardComparator());
        System.out.println("The cards in your hand are: ");
        printHand();
        if (hand.get(hand_size - 1).getRank() == Rank.ACE)  // Ace will be last card scanner hand
            System.out.println("Since you have an Ace, you can keep the Ace and discard the other four cards.");

        System.out.println("Please type the numbers corresponding to the cards you want to discard delimited by spaces: ");
        handleUserInput(deck, hand, oldHandCopy);

        Collections.sort(hand, new CardComparator());
        System.out.println("\nNow, let's see how you did against the competition: ");

    }

    private boolean hasAce(ArrayList<Card> hand) {
        for (int i = 0; i < hand_size; i++) {
            if (hand.get(i).getRank() == Rank.ACE)
                return true;
        }
        return false;
    }

    // input assumes user won't give index out of bounds
    private void handleUserInput(CardPile deck, ArrayList<Card> hand, ArrayList<Card> oldHandCopy) {
        boolean hasAce = hasAce(hand);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();
            if (inputLine.equals(""))
                break;
            int[] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(Integer::parseInt).toArray();

            if (numbers.length == 0)
                break;

            else if (numbers.length == hand_size - 1 && hasAce) { // can remove any card so long as there remains one Ace from original hand
                for (int i = 0; i < numbers.length; i++) {
                    hand.set(numbers[i] - 1, deck.deal());
                }
                hasAce = hasAce(hand);

                if (!hasAce) {
                    System.out.println("HEY! You had to keep at least 1 ACE; try again");
                    hand = new ArrayList<Card>(oldHandCopy);
                    hasAce = true;
                } else
                    break;
            } else if (numbers.length <= hand_size - 2) {
                for (int i = 0; i < numbers.length; i++) {
                    hand.set(numbers[i] - 1, deck.deal());
                }
                break;
            } else
                System.out.println("Invalid input, try again!");

        }

    }
}
