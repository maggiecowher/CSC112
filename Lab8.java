/**
 * This program allows the user to play a version of the game "Blind Man's Bluff". The program has four classes, the
 * first is the Card.java class. This class allows a Card object to be instantiated for the game and has enum types that
 * are the suit and tank of the card. This class also has a print method to output the rank and suit and a compareTo
 * method that uses the order of the enum values to compare the rank of the cards and the suit if the ranks are equal.
 * </p>
 * The second class is the Node.java class, which utilizes the Card class, as the data type of the Nodes are Card
 * objects. The Node class is used in the LinkedList.java class. Other than the constructor, the LinkedList>java class
 * has a shuffle method, which randomizes a previously ordered deck of cards, a remove from index and insert at index
 * method used in its swap method that is used in the shuffle method, as well as an add at tail and remove from head
 * method which is used in a method called rage-quit in the Lab8.java class. The LinkedList.java class also has a print,
 * isEmpty, and sanity check method. The sanity check makes sure that the prev and next pointers as well as the size
 * variable have been changed properly.
 * </p>
 * The last class is the Lab8.java class, which has a method called initialize_deck which is called at the beginning of
 * the main method to create a deck of cards. It also has a method that is used to play the game. This method uses the
 * methods in the LinkedList.java class as well as the Card.java class to play the game. At the end of 5 rounds (if the
 * user did not rage-quit) the user will be shown win-loss statistics and asked if they would like to continue. If they
 * choose to continue the method is called recursively, otherwise the program ends. If the user loses three rounds in a
 * row they are given the option to rage-quit. If they decide to do this, the cards dealt to the players will be
 * returned to the deck, the deck will be shuffled, and 5 new cards will be dealt to each player. After this the game
 * will start again.
 * </p>
 * Maggie Cowher
 * April 12, 2022
 */

import java.util.Scanner;

public class Lab8 {

    public static LinkedList initialize_deck() {

        LinkedList deck = new LinkedList();

        // populate linked list with a single deck of cards
        for (Card.suites s : Card.suites.values()) {
            for(Card.ranks r : Card.ranks.values()) {
                if (r != Card.ranks.NULL && s != Card.suites.NULL) {
                    Card newCard = new Card(s, r);
                    deck.add_at_tail(newCard);
                }
            }
        }

        return deck;
    }

    private static void play_blind_mans_bluff(LinkedList player1, LinkedList computer, LinkedList deck) {
        Scanner scnr = new Scanner(System.in); // Scanner object for user input

        // Point tracker variable
        int playerPoints = 0;
        int computerPoints = 0;
        int rageTracker = 0;
        boolean lostLastRound = false; // Used to track if the player is losing in a row
        int count = 1;

        System.out.println("\nStarting Blind mans Bluff \n");

        while (!player1.isEmpty()) {
            // Check if the user lost last round, if not, clear rage tracker
            if (!lostLastRound) {
                rageTracker = 0;
            }

            // play the game
            System.out.println("Round " + count + ":");
            Node currP = player1.head;
            Node currC = computer.head;

            // Display computer's card and have user guess
            System.out.print("Your opponent's card is: ");
            currC.data.print_card();
            System.out.println();
            System.out.println("Do you believe your card is higher or lower than your opponent's? Type 1 for lower or 2 for higher");
            int choice = scnr.nextInt();


            // Compare cards
            if (choice == 1) { // User guesses their card is less than the computer's
                if (currP.data.compareTo(currC.data) < 0) { // If the user's card is less than the computers
                    System.out.println("That guess was correct, you win this round!");
                    playerPoints += 1;
                    lostLastRound = false;
                } else { // If the user's card is greater than the computer's (there are no ties)
                    System.out.println("That guess was incorrect, you lose this round");
                    computerPoints += 1;
                    rageTracker += 1;
                    lostLastRound = true;
                }
            } else { // User guesses their card is greater than the computer's
                if (currP.data.compareTo(currC.data) > 0) { // If the user's card is greater than the computer's
                    System.out.println("That guess was correct, you win this round!");
                    playerPoints += 1;
                    lostLastRound = false;
                } else { // If the user's card is less than the computers (there are no ties)
                    System.out.println("That guess was incorrect, you lose this round");
                    computerPoints += 1;
                    rageTracker += 1;
                    lostLastRound = true;
                }
            }

            // Add cards back into deck after the game is over
            deck.add_at_tail(player1.remove_from_head());
            deck.add_at_tail(computer.remove_from_head());

            if (rageTracker >= 3) { // If the player loses three times in a row
                break;
            }

            currC = currC.next;
            currP = currP.next;
            count += 1;
        }

        if (rageTracker >= 3) { // See if user wants to rage-quit
            System.out.println("You have lost three times in a row! Would you like to rage quit and play again? Type \"yes\" or \"no\"");
            String answer = scnr.next();
            if (answer.equalsIgnoreCase("yes")) {
                rageQuit(player1, computer, deck);
                play_blind_mans_bluff(player1, computer, deck);
            }
        } else { // If the game ran through completely, display win/loss statistics and see if the user would like to play again
            System.out.println("Game Statistics:");
            System.out.println("Opponent points: " + computerPoints);
            System.out.println("Your points: " + playerPoints);
            if (computerPoints > playerPoints) {
                System.out.println("The computer won this game");
            } else {
                System.out.println("You won this game");
            }
            System.out.println("Would you like to play again? Type \"yes\" or \"no\"");
            String answer = scnr.next();
            if (answer.equalsIgnoreCase("yes")) { // If the user wants to play again, shuffle deck and re-deal cards, call method again
                deck.shuffle(512);
                int num_cards_dealt = 5;
                for (int i = 0; i < num_cards_dealt; i++) {
                    // player removes a card from the deck and adds to their hand
                    player1.add_at_tail(deck.remove_from_head());
                    computer.add_at_tail(deck.remove_from_head());
                }
                play_blind_mans_bluff(player1, computer, deck);
            }
        }


    }

    public static void rageQuit(LinkedList player1, LinkedList computer, LinkedList deck) {

        // Refill deck with cards from player1 and computer
        while (!player1.isEmpty() && !computer.isEmpty()) {
            deck.add_at_tail(player1.remove_from_head());
            deck.add_at_tail(computer.remove_from_head());
        }

        // Shuffle
        deck.shuffle(512);
        deck.print();
        deck.sanity_check(); // because we can all use one

        // Deal 5 cards
        int num_cards_dealt = 5;
        for (int i = 0; i < num_cards_dealt; i++) {
            // player removes a card from the deck and adds to their hand
            player1.add_at_tail(deck.remove_from_head());
            computer.add_at_tail(deck.remove_from_head());
        }
    }

    public static void main(String[] args) {

        // create a deck (in order)
        LinkedList deck = initialize_deck();
        deck.print();
        deck.sanity_check(); // because we can all use one

        // shuffle the deck (random order)
        deck.shuffle(512);
        deck.print();
        deck.sanity_check(); // because we can all use one

        // cards for player 1 (hand)
        LinkedList player1 = new LinkedList();
        // cards for player 2 (hand)
        LinkedList computer = new LinkedList();

        int num_cards_dealt = 5;
        for (int i = 0; i < num_cards_dealt; i++) {
            // player removes a card from the deck and adds to their hand
            player1.add_at_tail(deck.remove_from_head());
            computer.add_at_tail(deck.remove_from_head());
        }

        // let the games begin!
        play_blind_mans_bluff(player1, computer, deck);
    }
}
