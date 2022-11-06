import java.util.Scanner;

public class FoodCarbonFootprint {
    public static void main(String[] args) {

        /*
        Description: This code allows a user to calculate their daily and annual carbon footprint based on their
        inputted kilo-caloric intake of certain foods. A persons carbon footprint is defined by their greenhouse gas
        emissions resulting from the food they eat. Each food has its own carbon dioxide emission rate.
        <p>
        @author: Maggie Cowher
         */

        // Declare food type variables and assign carbon footprint
        double beefCarbonFootprint = 0.01378;
        double cheeseCarbonFootprint = 0.00447;
        double yogurtCarbonFootprint = 0.00349;
        double chickenCarbonFootprint = 0.00337;
        double milkCarbonFootprint = 0.00317;
        double eggsCarbonFootprint = 0.00306;
        double beansCarbonFootprint = 0.00140;
        double tofuCarbonFootprint = 0.00138;
        double lentilsCarbonFootprint = 0.00078;
        double nutsCarbonFootprint = 0.00039;

        // Declare food type variables that will be assigned with inputted kilocalories
        int beefKiloCalories;
        int cheeseKiloCalories;
        int yogurtKiloCalories;
        int chickenKiloCalories;
        int milkKiloCalories;
        int eggsKiloCalories;
        int beansKiloCalories;
        int tofuKiloCalories;
        int lentilsKiloCalories;
        int nutsKiloCalories;

        // Print header
        System.out.println("Food Carbon Footprint Calculator =========================");

        // Get values for kilocalories variables
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the amount of kilocalories you consume for these food types");
        System.out.println("Beef: ");
        beefKiloCalories = scnr.nextInt();
        System.out.println("Chicken: ");
        chickenKiloCalories = scnr.nextInt();
        System.out.println("Cheese: ");
        cheeseKiloCalories = scnr.nextInt();
        System.out.println("Yogurt: ");
        yogurtKiloCalories = scnr.nextInt();
        System.out.println("Milk: ");
        milkKiloCalories = scnr.nextInt();
        System.out.println("Eggs: ");
        eggsKiloCalories = scnr.nextInt();
        System.out.println("Tofu: ");
        tofuKiloCalories = scnr.nextInt();
        System.out.println("Beans: ");
        beansKiloCalories = scnr.nextInt();
        System.out.println("Lentils: ");
        lentilsKiloCalories = scnr.nextInt();
        System.out.println("Nuts: ");
        nutsKiloCalories = scnr.nextInt();

        // Print a blank line for formatting purposes
        System.out.println();

        // Declare variables for daily and annual carbon footprint, and daily kilocalories
        double dailyCarbonFootprint;
        double annualCarbonFootprint;
        int dailyKiloCalories;

        // Calculate daily carbon footprint based on kilocalories
        dailyKiloCalories = beefKiloCalories + chickenKiloCalories + cheeseKiloCalories + yogurtKiloCalories + milkKiloCalories + eggsKiloCalories + tofuKiloCalories + beansKiloCalories + lentilsKiloCalories + nutsKiloCalories;
        dailyCarbonFootprint = (beefKiloCalories * beefCarbonFootprint) + (chickenKiloCalories * chickenCarbonFootprint) + (cheeseKiloCalories * cheeseCarbonFootprint) + (yogurtKiloCalories * yogurtCarbonFootprint) + (milkKiloCalories * milkCarbonFootprint) + (eggsKiloCalories * eggsCarbonFootprint) + (tofuKiloCalories * tofuCarbonFootprint) + (beansKiloCalories * beansCarbonFootprint) + (lentilsKiloCalories * lentilsCarbonFootprint) + (nutsKiloCalories * nutsCarbonFootprint);
        annualCarbonFootprint = (dailyCarbonFootprint * 365) / 1000 ;

        // Output results to user
        System.out.println("Your total number of kilocalories per day would be: " + dailyKiloCalories);
        System.out.print("Your daily food carbon footprint would be ");
        System.out.printf("%.3f", dailyCarbonFootprint);
        System.out.println(" kilograms of carbon dioxide equivalent.");
        System.out.print("Your annual food carbon footprint would be ");
        System.out.printf("%.3f", annualCarbonFootprint);
        System.out.println(" tons of carbon dioxide equivalent.");

    }
}
