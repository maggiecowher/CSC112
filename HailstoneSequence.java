import java.util.Scanner;

/*
This code takes in a positive integer from the user, and prints the Hailstone sequence for that integer, with ten values
per line. The Hailstone sequence is computed by dividing an even number by 2, and multiplying an odd number by 3 then
adding 1. The code takes in and prints out the user-inputted number. The code manipulates the number in a way depending
on if it is even or odd, then prints that number to the user. It will then manipulate the resulting number, and continue
until it reaches 1. The code only prints ten values per line and will quit the while loop once it reaches 1.
 */

public class HailstoneSequence {
    public static void main(String[] args) {
        // Create scanner object
        Scanner scnr = new Scanner(System.in);

        // Create user-input variable
        int n;

        // Print header
        System.out.println("=== Hailstone Sequence ===");

        // Prompt user to input a value
        System.out.println("Enter a value: ");

        // Assign input to n
        n = scnr.nextInt();

        // Create a while loop for positive integer input
        // Loop prints ten integers per line, separated by a tab
        // Loops will exit once n reaches 1, but will print 1 before it exits
        while (n > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.print(n + "\t");
                if (n == 1) {
                    break;
                }
                else if ((n % 2) == 0) {
                    n = n / 2;
                }
                else {
                    n = (3 * n) + 1;
                }
            }
            System.out.println();
            if (n == 1) {
                break;
            }
        }

    }
}
