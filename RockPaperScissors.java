import java.util.Scanner;
import java.util.Random;

/*
This code plays three rounds of a game of rock, paper, scissors. The code takes input from the user and assigns names to
the two players, and then randomly chooses their moves for the three rounds. Each player choice has a method outside of
main, and there is a method outside of main that determines the winner. The player choice methods randomize each chioce
by initializing string variables for each move, and creating a random object to randomize which string variable is
chosen. The determineWinner method decides which player won, or if there was a tie depending on the random chosen moves.
These methods are called in main to print the results to the user.
 */

public class RockPaperScissors {
    public static void main(String[] args) {
        // Create Scanner and Random Objects
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();

        // Prompt user to enter a seed value assign that value to the seed variable for the random object
        System.out.print("Enter a seed value for random: ");
        int seed = scnr.nextInt();
        rand.setSeed(seed);

        // Initialize strings for player names
        String player1name;
        String player2name;

        // Assign player names to string variables by asking user to input names
        System.out.println("Enter player 1 name: ");
        player1name = scnr.next();
        System.out.println("Enter player 2 name: ");
        player2name = scnr.next();

        // Formatting
        System.out.println();
        System.out.println(player1name + " vs " + player2name + " for 3 rounds");

        // Counter variables are created to count the number of times each player wins, these values will be printed to
        // user.
        int player1Counter = 0;
        int player2Counter = 0;

        // For loop plays the game for three rounds but ties do not count and will not be counted in the for loop, and
        // calls the methods used below.
        for (int i = 0; i < 3;) {
            String player1 = player1Choice();
            String player2 = player2Choice();

            // The numbers assigned to result in the determineWinner method dictates which player won based on random
            // chosen moves. The code prints different responses based on who is the winner.
            if (determineWinner(player1, player2) == 0) {
                System.out.println("Tie");
            } else if (determineWinner(player1, player2) == 1) {
                player1Counter++;
                System.out.println(player1 + " -- " + player2 + " " + player1name + " wins with " + player1.toLowerCase());
                i++;
            } else {
                player2Counter++;
                System.out.println(player1 + " -- " + player2 + " " + player2name + " wins with " + player2.toLowerCase());
                i++;
            }
        }

        // Display winning results to the user
        System.out.println(player1name + " wins " + player1Counter + " and " + player2name + " wins " + player2Counter);



    }
    // This method creates a string bracket that has spots for the three choices, and randomizes the choice by using the
    // random object and an integer called player1Choice
    public static String player1Choice() {
        String[] choice = {"ROCK","PAPER","SCISSORS"};
        Random rand = new Random();
        int player1Choice = rand.nextInt(3);
        return choice[player1Choice];

    }

    // This method creates a string bracket that has spots for the three choices, and randomizes the choice by using the
    // random object and an integer called player2Choice
    public static String player2Choice() {
        String[] choice = {"ROCK","PAPER","SCISSORS"};
        Random rand = new Random();
        int player2Choice = rand.nextInt(3);
        return choice[player2Choice];
    }

    // Using if statements, the code compares the two random chosen moves, and assigns the variable result with a number,
    // either 0 for a tie, 1 is player 1 wins, or 2 if player 2 wins. This number is used in main to display the winner.
    public static int determineWinner(String player1, String player2) {
        int result;

        if (player1.equals("ROCK")) {
            if (player2.equals("ROCK")) {
                result = 0;
            }
            else if (player2.equals("PAPER")) {
                result = 2;
            }
            else {
                result = 1;
            }
        }
        else if (player1.equals("PAPER")) {
            if (player2.equals("ROCK")) {
                result = 1;
            }
            else if (player2.equals("PAPER")) {
                result = 0;
            }
            else {
                result = 2;
            }
        }
        else {
            if (player2.equals("ROCK")) {
                result = 2;
            }
            else if (player2.equals("PAPER")) {
                result = 1;
            }
            else {
                result = 0;
            }
        }

        return result;
    }
}
