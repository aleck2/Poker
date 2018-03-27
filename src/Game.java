import java.util.Scanner;

/*
 * My First Java Program (somewhat refactored): Poker
 * Game class contains main and adjudicates the flow of the program
 *
 */


public class Game {

    public static int getNumberofOpponents() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Poker!");
        System.out.printf("How many computer opponents would you like (1-3): ");
        int opponents_n = scan.nextInt();
        System.out.println("Excellent choice! " + opponents_n + " opponent(s) it is.");
        System.out.println("So it begins."); // "No, now it ends..."
        System.out.println("Shuffling the deck...");
        return opponents_n;
    }


    public static void main(String[] args) {
        int i;
        final int hand_size = 5; // TODO make prettier
        int opponents_n = getNumberofOpponents();
        CardPile deck = new CardPile();
        boolean tie = false;
        int winningPlayerIndex = 0;

        Opponent[] opponents = new Opponent[opponents_n];
        for (i = 0; i < opponents_n; i++) {
            opponents[i] = new Opponent(i);
            for (int j = 0; j < hand_size; j++)
                opponents[i].addCardToHand(deck.deal());
            System.out.printf("Computer Player %d discarded ", i + 1);
            opponents[i].checkHand(deck);
            System.out.println();
        }

        Player user = new Player();
        for (i = 0; i < 5; i++)
            user.addCardToHand(deck.deal());

        user.playerUI(deck);
        String[] handDescriptions = {"Straight Flush", "4 of a Kind", "Full House", "Flush", "Straight", "3 of a Kind",
                "2 Pair", "1 Pair", "High Card"};

        int[] rank = new int[opponents_n + 1];
        rank[opponents_n] = Logic.bestHand(user.hand);


        for (i = 0; i < opponents_n; i++) {
            System.out.println("Computer Player " + (i + 1) + " has the following hand: ");
            opponents[i].printHand();
            rank[i] = Logic.bestHand(opponents[i].hand);
            System.out.println("Computer Player " + (i + 1) + " has a " + (handDescriptions[rank[i]]));
            System.out.println("\n ");
        }
        // find winner
        for (i = 1; i < opponents_n + 1; i++) {
            if (rank[i] < rank[winningPlayerIndex])
                winningPlayerIndex = i;
            else if (rank[i] == rank[winningPlayerIndex])
                tie = true;
        }

        System.out.println("...And here is your new hand: ");
        user.printHand();
        System.out.println("You have a " + (handDescriptions[rank[opponents_n]]));

        if (!tie && (winningPlayerIndex == opponents_n))
            System.out.println("Congratulations, you won");
        else if (!tie)
            System.out.println("Sorry, the winner is: Computer Player " + (winningPlayerIndex + 1));
        else { // tieBreaker
            System.out.println("It's a tie. I've yet to implement this feature... so... ugh... you're all winners!");
        }

    }

}

