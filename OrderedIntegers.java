import java.util.Scanner;

public class OrderedIntegers {
    public static void main(String[] args) {
        /*
        This code resembles an app that sorts a list of three integers for the user. The user will input three random
        integers, which will be sorted using if and else if statements. This sorted list will be printed to the user in
        decreasing order. By using boolean variables, the code can decrease the amount of if branches needed to compare
        the values.
        */

        Scanner scnr = new Scanner(System.in);

        // Print header
        System.out.println("Order Three Integers ======");

        // Instruct user to input variables
        System.out.println("Enter three integers: ");

        // Declare variable types for inputted integers
        int firstIn;
        int secondIn;
        int thirdIn;

        // Assign inputs to variables
        firstIn = scnr.nextInt();
        secondIn = scnr.nextInt();
        thirdIn = scnr.nextInt();

        // Declare boolean variables to assign cases with either true or false
        boolean firstLargerThanSecond = firstIn > secondIn;
        boolean firstLargerThanThird = firstIn > thirdIn;
        boolean secondLargerThanFirst = secondIn > firstIn;
        boolean secondLargerThanThird = secondIn > thirdIn;

        if ((firstLargerThanSecond) && (firstLargerThanThird)) {
            if (secondLargerThanThird) {
                System.out.println("The integers in decreasing order: " + firstIn + " " + secondIn + " " + thirdIn);
            } else {
                System.out.println("The integers in decreasing order: " + firstIn + " " + thirdIn + " " + secondIn);
            }
        } else if ((secondLargerThanFirst) && (secondLargerThanThird)) {
            if (firstLargerThanThird) {
                System.out.println("The integers in decreasing order: " + secondIn + " " + firstIn + " " + thirdIn);
            } else {
                System.out.println("The integers in decreasing order: " + secondIn + " " + thirdIn + " " + firstIn);
            }
        } else {
            if (secondLargerThanFirst) {
                System.out.println("The integers in decreasing order: " + thirdIn + " " + secondIn + " " + firstIn);
            } else {
                System.out.println("The integers in decreasing order: " + thirdIn + " " + firstIn + " " + secondIn);
            }
        }

    }
}
