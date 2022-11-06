/** This program is a word-guessing game that gives the user 6 attempts to find guess the word. If the user's guess
 * is a valid word in the dictionary, each letter is printed with a corresponding color. Green if the letter is in the
 * correct place, yellow if the letter is in the word but not in the correct place, and grey if the letter is not in the
 * word. The program uses a do-while loop to end the program when the user guesses the word, or if the user has done all
 * six attempts. There is another do-while loop inside the initial one to allow the user to guess a correct word for one
 * try, in other words, the attempt number does not increase if the user guesses a word not found in the dictionary.
 * </p>
 * Maggie Cowher
 * February 20, 2022
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dlewor {

    // constants to allow colored text and backgrounds
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {
        // print welcome message
        System.out.println("Welcome to Dlewor(TM)");

        // Open the file
        FileInputStream myFile = null;

        // Assign command line argument to file that will be open, and check for exceptions
        try {
            myFile = new FileInputStream("src/" + args[0]);
        } catch (FileNotFoundException notFound) {
            System.out.println("I'm sorry, that is not a valid file name");
        } catch (Exception e) {
            System.out.println("I'm sorry, we ran into a problem");
        }

        // Create a scanner object ot read the file
        Scanner fileReader = new Scanner(myFile);

        // Create an array list to store 5-letter words
        ArrayList<String> fiveLetterWords = new ArrayList<>();

        // Use a fileReader to create an array list of five-letter words
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            if (data.length() == 5) { // If the word has five letters it is added to the array list
                fiveLetterWords.add(data);
            }
        }

        // Create random number generator
        Random rand = new Random();
        int index = rand.nextInt(fiveLetterWords.size());

        // Select a word from the array list using the random number as the index
        String word = fiveLetterWords.get(index);

        // Check if list is sorted
        boolean isSorted = isSorted(fiveLetterWords);

        // Declare variables to be used inside loops and accessed outside loops
        String target; // Declare the word the user inputs
        boolean wordExists; // Declare before search
        int wordIndex; // Initialize before search
        Scanner scnr = new Scanner(System.in); // Create Scanner object
        int count = 0; // To end game if the user doesn't guess correctly in 6 tries
        int[] match;

        // Do-while loop to find the correct word
        do {
            do {
                System.out.println("Enter word " + (count + 1) + ":"); // Prompt user to enter a word
                target = scnr.next(); // Initialize target word
                if (isSorted) { // Binary search for a sorted list
                    wordIndex = binarySearch(fiveLetterWords, target, 0, fiveLetterWords.size() - 1);
                    // Method call initializes index of target word in array list, if it is -1, the word does not exist
                    if (wordIndex == -1) {
                        wordExists = false; // Either true or false must be initialized every time
                        System.out.println("Invalid Word");
                    } else {
                        wordExists = true; // Either true or false must be initialized every time
                    }
                } else { // Linear search for a non-sorted list
                    wordIndex = linearSearch(fiveLetterWords, target, 0, fiveLetterWords.size() - 1);
                    // Method call initializes index of target word in array list, if it is -1, the word does not exist
                    if (wordIndex == -1) {
                        wordExists = false; // Either true or false must be initialized every time
                        System.out.println("Invalid Word");
                    } else {
                        wordExists = true; // Either true or false must be initialized every time
                    }
                }
            } while (!wordExists); // Do-while loop maintains the "try" attempt until the word is valid

            match = matchDlewor(word, target); // Initializes match array
            printDlewor(target, match); // Prints the letters with corresponding colors of the guessed word

            count += 1; // Count increases by 1 each time to keep track of number of attempts

        } while (!foundMatch(match) && count < 6); // Loop continues until either the word is found or after 6 attempts

        if (!foundMatch(match)) // Prints the word if the user never guesses it correctly
            System.out.println(word);

    }

    // Checks if the letters in the attempted word match with the letters in the target word
    public static int[] matchDlewor(String target, String attempt) {
        int[] match = {-1, -1, -1, -1, -1}; // Declare and initialize integer array to store matches
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (target.charAt(j) == attempt.charAt(i)) {
                    if (j == i) {
                        match[i] = 1; // If the letter is in the correct spot
                    } else {
                        match[i] = 0; // If the letter exists in the word but is not in the correct spot
                    }
                }
            }
        }
        return match;
    }

    // Method to see if all the letters match
    public static boolean foundMatch(int[] match) {
        for (int value : match) {
            if (value != 1)
                return false;
        }
        return true;
    }

    // Takes the attempted word and the array of integers to display to the user what letters are correct, if any
    public static void printDlewor(String attempt, int[] match) {
        for (int i = 0; i < match.length; i++) {
            if (match[i] == -1) {
                // Prints letter grey if it does not exist in the word
                System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + attempt.charAt(i));
            } else if (match[i] == 0) {
                // Prints letter yellow if it exists in the word but is in the wrong place
                System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + attempt.charAt(i));
            } else {
                // Prints letter green if the letter is in the correct location
                System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + attempt.charAt(i));
            }
            System.out.print(ANSI_RESET);
        }
        System.out.println(); // Create new line
    }

    // Recursive linear search to see if word exists and return the index of the word if it does
    public static int linearSearch(ArrayList<String> fiveLetterWords, String target, int begin, int end) {
        if (begin > end) { // Word does not exist
            return -1;
        }
        if (target.equals(fiveLetterWords.get(begin))) {
            return begin;
        } else if (target.equals(fiveLetterWords.get(end))) {
            return end;
        } else {
            return linearSearch(fiveLetterWords, target, begin + 1, end - 1);
        }
    }

    // Recrusive binary search for a sorted list, continually halves the list being searched to see if the word exists,
    // returning the index if it does
     public static int binarySearch(ArrayList<String> fiveLetterWords, String target, int begin, int end) {
        int mid;
        if (begin > end) { // Word does not exist
            return -1;
        }
        // Complete binary search using recursion
         mid = (begin + end) / 2;
         if (target.equals(fiveLetterWords.get(mid))) {
             return mid;
         } else if (fiveLetterWords.get(mid).compareTo(target) > 0) {
             return binarySearch(fiveLetterWords, target, begin, mid - 1);
         } else {
             return (binarySearch(fiveLetterWords, target, mid + 1, end));
         }
    }

    // Determines whether the list is sorted in order to use the proper search function
    public static boolean isSorted(ArrayList<String> fiveLetterWords) {
        for (int i = 0; i < fiveLetterWords.size() - 1; i++) {
            if (fiveLetterWords.get(i).compareTo(fiveLetterWords.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
