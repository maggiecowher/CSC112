import java.util.Scanner;

public class DetectOrderedLists {
    public static void main(String[] args) {
        /*
        This code resembles an app that takes input from a user as a list of numbers, and determines whether this list
        is sorted or not. This code determines if the values are all equal, if they are sorted in increasing or
        decreasing order, or if the list is not sorted at all. This determination is outputted to the user. 
         */

        Scanner scnr = new Scanner(System.in);

        // Print header
        System.out.println("Detect Sorted Lists =======");

        // Instruct user to input variables
        System.out.println("Enter three integers: ");

        // Declare variables to assign with user input
        int a = scnr.nextInt();
        int b = scnr.nextInt();
        int c = scnr.nextInt();

        // Compare user inputs to determine sorting of list and output results to user
        if ((a == b) && (a == c)) {
            System.out.println("These numbers are the same.");
        } else if ((a >= b) && (b >= c)) {
            System.out.println("This list is sorted in decreasing order.");
        } else if ((a <= b) && (b <= c)) {
            System.out.println("This list is sorted in increasing order.");
        } else {
            System.out.println("This list is not sorted.");
        }

    }
}
