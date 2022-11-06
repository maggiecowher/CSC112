import java.util.Scanner;

public class HeartRateZones {
    public static void main(String[] args) {
        /*
        This code reflects an app that allows a user to input their age and resting heart rate, to calculate what their target heart rate
        would be depending on what range they choose. The code gives the user 5 range options, from the lowest range to
        the highest. The code takes this input, along with the age and resting heart rate, and uses these values to
        calculate the user's maximum heart rate, and two other values that dictate the range in which their heart rate
        should fall. The code also prints an error message if the user chooses a target range not given as an option.
        */

        Scanner scnr = new Scanner(System.in);

        // Declare variables for inputted values
        int age;
        int restingHeartRate;
        int targetZone;

        // Print header
        System.out.println("Target Heart Rate Zone Calculator");
        System.out.println();

        // Ask user to input variables
        System.out.println("Enter your age: ");
        age = scnr.nextInt();
        System.out.println("Enter your resting heart rate: ");
        restingHeartRate = scnr.nextInt();

        // Give user options for target heart rate ranges
        System.out.println("Choose your target [1-5]:");
        System.out.println("1. Boost recovery, get ready to train at higher rates");
        System.out.println("2. Building endurance, weight loss");
        System.out.println("3. Improving cardio fitness, weight management");
        System.out.println("4. Speed endurance");
        System.out.println("5. Maximal effort, interval training");

        // Ask user to choose target range
        System.out.println();
        System.out.println("your choice? ");
        targetZone = scnr.nextInt();

        // Initialize variables for equation
        int maxHeartRate = 220 - age;
        int d = maxHeartRate - restingHeartRate;

        // Calculate heart rate zone based on inputted target zone
        if (targetZone == 1) {
            double zoneOneLowEnd = (d * 0.5) + restingHeartRate;
            double zoneOneHighEnd = (d * 0.6) + restingHeartRate;
            System.out.print("Exercise to keep your heart rate in the zone ");
            System.out.printf("%.2f", zoneOneLowEnd);
            System.out.print(" - ");
            System.out.printf("%.2f", zoneOneHighEnd);
            System.out.println(" beats per minute");
        } else if (targetZone == 2) {
            double zoneTwoLowEnd = (d * 0.6) + restingHeartRate;
            double zoneTwoHighEnd = (d * 0.7) + restingHeartRate;
            System.out.print("Exercise to keep your heart rate in the zone ");
            System.out.printf("%.2f", zoneTwoLowEnd);
            System.out.print(" - ");
            System.out.printf("%.2f", zoneTwoHighEnd);
            System.out.println(" beats per minute");
        } else if (targetZone == 3) {
            double zoneThreeLowEnd = (d * 0.7) + restingHeartRate;
            double zoneThreeHighEnd = (d * 0.8) + restingHeartRate;
            System.out.print("Exercise to keep your heart rate in the zone ");
            System.out.printf("%.2f", zoneThreeLowEnd);
            System.out.print(" - ");
            System.out.printf("%.2f", zoneThreeHighEnd);
            System.out.println(" beats per minute");
        } else if (targetZone == 4) {
            double zoneFourLowEnd = (d * 0.8) + restingHeartRate;
            double zoneFourHighEnd = (d * 0.9) + restingHeartRate;
            System.out.print("Exercise to keep your heart rate in the zone ");
            System.out.printf("%.2f", zoneFourLowEnd);
            System.out.print(" - ");
            System.out.printf("%.2f", zoneFourHighEnd);
            System.out.println(" beats per minute");
        } else if (targetZone == 5) {
            double zoneFiveLowEnd = (d * 0.9) + restingHeartRate;
            double zoneFiveHighEnd = d + restingHeartRate;
            System.out.print("Exercise to keep your heart rate in the zone ");
            System.out.printf("%.2f", zoneFiveLowEnd);
            System.out.print(" - ");
            System.out.printf("%.2f", zoneFiveHighEnd);
            System.out.println(" beats per minute");
        } else {
            System.out.println("Sorry, " + targetZone + " is not a valid option.");
        }
    }
}
