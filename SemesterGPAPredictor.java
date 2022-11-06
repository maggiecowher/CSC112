import java.util.Scanner;

public class SemesterGPAPredictor {
    public static void main(String[] args) {
        /*
        This code resembles an app that helps the student (user) predict what their GPA might be at the end of the
        semester. The student is expected to have four courses, and will input the credit hours and anticipated grade
        for each course. The code will take in the credit hours as an integer, and the grade as a string. The code uses
        if statements to convert the string variables into double variables. These double variables will then be used
        to calculate GPA. GPA is calculated by multiplying a course's credit hours by its grade point. This value is
        called the quality point, and by adding each quality point together, and dividing that total by the total amount
        of credit hours, the predicted GPA can be calculated. This value is then outputted to the student.
         */

        Scanner scnr = new Scanner(System.in);

        // Print Header
        System.out.println("Semester GPA Predictor: Let's see what your GPA could be this semester...");

        // Declare variables to be inputted by users and manipulated for GPA calculation
        String grade;
        int i;
        int courseHours;
        double qualityPoints = 0;
        double totalHours = 0;
        double gradePoints = 0;
        double semesterGPA;

        // Create for loop that asks the user to input values and calculates the quality points and total hours based on input
        for (i = 1; i <= 4; i++) {
            System.out.println("Course " + i + ": Number of hours?");
            courseHours = scnr.nextInt();
            System.out.println("Course " + i + ": Expected grade?");
            grade = scnr.next();

            // Assign letter grades to numeric values
            switch (grade) {
                case "A": gradePoints = 4.0;
                break;
                case "A-": gradePoints = 3.67;
                break;
                case "B+": gradePoints = 3.33;
                break;
                case "B": gradePoints = 3.0;
                break;
                case "B-": gradePoints = 2.67;
                break;
                case "C+": gradePoints = 2.33;
                break;
                case "C": gradePoints = 2.0;
                break;
                case "C-": gradePoints = 1.67;
                break;
                case "D+": gradePoints = 1.33;
                break;
                case "D": gradePoints = 1.0;
                break;
                case "F": gradePoints = 0.0;
                break;
            }
            // Use assigned grade point values to calculate the total hours and quality points attained by the student
            qualityPoints = qualityPoints + (gradePoints * courseHours);
            totalHours = totalHours + courseHours;
        }

        // Calculate GPA based on expected course grades
        semesterGPA = qualityPoints / totalHours;

        // Print results to user
        System.out.printf("Your semester GPA would be: %.4f", semesterGPA);
        System.out.println();

    }

    public static void gradeToPoints(String grade) {
        double gradePoints = 0;
        // Assign letter grades to numeric values
        switch (grade) {
            case "A": gradePoints = 4.0;
                break;
            case "A-": gradePoints = 3.67;
                break;
            case "B+": gradePoints = 3.33;
                break;
            case "B": gradePoints = 3.0;
                break;
            case "B-": gradePoints = 2.67;
                break;
            case "C+": gradePoints = 2.33;
                break;
            case "C": gradePoints = 2.0;
                break;
            case "C-": gradePoints = 1.67;
                break;
            case "D+": gradePoints = 1.33;
                break;
            case "D": gradePoints = 1.0;
                break;
            case "F": gradePoints = 0.0;
                break;
    }
}
