import java.util.Scanner;
import java.util.Random;

/*
This code allows the user to play a guessing game with the computer. The computer randomizes a number between 1 and 100,
then the user will guess what the chosen number is. For each guess, the code will instruct the user if their guess was
too high, too low, or correct, and counts each number of guesses, displaying that value to the user after the correct
guess. The code then asks the user if they would like to play again. If the user responds yes, the computer restarts
the guesses counter and chooses a new random number between 1 and 100. If the user responds no, the code prints goodbye.
 */

public class HighLowGuessingGame {
    public static void main(String[] args) {
        // Create scanner object
        Scanner scnr = new Scanner(System.in);

        // Create random object
        Random r = new Random();

        // Initialize values to be entered by user
        int userGuess;
        char userAnswer = 'y';

        // Initialize guess counter variable
        int counter = 0;

        // Initialize random number
        int ranNumber;

        // Print Header
        System.out.println("=== Hi-Lo Guessing Game ===");

        // Print the rules of the game to user
        System.out.println("Please enter your guess or a negative number to terminate the round.");

        // Play game
        while (userAnswer == 'y') {  // Prompts loop to quit when user no longer wants to continue playing
            ranNumber = r.nextInt(100) + 1;
            System.out.println(); // Formatting purposes
            System.out.println("I picked a number between 1-100");
            System.out.println(); // Formatting purposes
            System.out.println("What is your guess? : ");
            userGuess = scnr.nextInt();

            // Loop will quit, and the user will have the option to play a new game after entering a negative value
            // Else the user will be instructed whether their guess is too high or too low, until they guess correctly
            // User's guesses will be counted and output to them
            while (userGuess >= 0) {
                if (userGuess == ranNumber) {
                    counter += 1;
                    System.out.println("That is correct! You made " + counter + " guesses to find the number.");
                    break;
                } else if (userGuess > ranNumber) {
                    counter += 1;
                    System.out.println("Go lower: ");
                    userGuess = scnr.nextInt();
                } else {
                    counter += 1;
                    System.out.println("Go higher: ");
                    userGuess = scnr.nextInt();
                }
            }
            counter = 0; // Counter variable is reset before each new game
            System.out.println("Would you like to play again? [y/n]"); // Asks user if they want to play again
            userAnswer = scnr.next().charAt(0);

        }

        // Print goodbye message to user when they are done playing
        System.out.println("Goodbye!");
    }
}
