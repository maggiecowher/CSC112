import java.util.Scanner;
import java.lang.Math;

public class TripPlanner {
    public static void main(String[] args) {

        /*
        Description: This code acts as a trip planner for the user. It takes input for the number of passengers, the
        length of the trip (in miles), the car's gas tank capacity (in gallons), the price of one gallon of gas, and the
        miles per gallon that the user's car gets. After some manipulation and calculation the code will show the user
        how many tanks of gas will be needed, the total cost of the gas for the trip, and how much each individual
        passenger should pay for gas.
        <p>
        @author: Maggie Cowher
         */

        Scanner scnr = new Scanner(System.in);

        // Declare variables to be input
        int numPassenger;
        int tripLength;
        int tankCapacity;
        double gasPrice;
        int milesPerGallon;

        // Print header
        System.out.println("My Trip Planner =========================");

        // Get values for above variables by asking user for an input
        System.out.println("Number of passengers: ");
        numPassenger = scnr.nextInt();
        System.out.println("Length of the trip in miles: ");
        tripLength = scnr.nextInt();
        System.out.println("Capacity of the car's gas tank in gallons: ");
        tankCapacity = scnr.nextInt();
        System.out.println("Price of one gallon of gas: ");
        gasPrice = scnr.nextDouble();
        System.out.println("Miles/gallon of your car: ");
        milesPerGallon = scnr.nextInt();

        // Print a blank line for formatting purposes
        System.out.println();

        // Declare calculation variables
        double gallonsNeeded;
        double tanksNeeded;
        double gasCost;
        double passengerCost;

        // Compute calculations for above variables
        gallonsNeeded = tripLength / milesPerGallon;
        tanksNeeded = gallonsNeeded / tankCapacity;
        tanksNeeded = Math.ceil(tanksNeeded);
        gasCost = tanksNeeded * tankCapacity * gasPrice;
        passengerCost = gasCost / numPassenger;

        // Output results to user
        System.out.println("You will need up to " + tanksNeeded + " tanks of gas");
        System.out.print("The total cost will be ");
        System.out.printf("%.2f", gasCost);
        System.out.println(" dollars");
        System.out.print("Each passenger should pay ");
        System.out.printf("%.2f", passengerCost);
        System.out.println(" dollars");

    }
}
