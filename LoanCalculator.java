/**
 * This code allows a user to calculate their monthly loan payment as well as the total interest on
 * the loan. Monthly payment can be calculated when the loan amount, the monthly interest rate, and the number of
 * monthly payments is known. The user will input the loan amount, the annual interest rate, and the term of the
 * loan in years. These values will be put in the LoanFormulas.java class methods to calculate the monthly loan
 * payment and total interest. Using methods from another class creates understandability and simplicity in code. After
 * using the LoanFormulas.java class methods, the code outputs the users monthly payment and total interest paid.
 * <p>
 * @author: Maggie Cowher
 */

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        // Declare inputs for loan amount, annual interest rate, and term of loan (in years)
        double principleAmount;
        double annualRate;
        int loanTerm;

        // Print header
        System.out.println("Monthly Payment Calculator =========================");

        // Have user input variables and assign to declared variables
        System.out.println("Please enter the loan amount [e.g. 10000.00]: ");
        principleAmount = scnr.nextDouble();
        System.out.println("Please enter the annual interest rate [e.g. 5]: ");
        annualRate = scnr.nextDouble();
        System.out.println("Please enter the term of the loan in years [e.g. 6]: ");
        loanTerm = scnr.nextInt();

        // Print a blank line for formatting purposes
        System.out.println();

        // Declare and initialize monthly payment required to pay off loan
        double monthlyPayment = LoanFormulas.calculateMonthlyPayments(principleAmount, annualRate, loanTerm);


        // declare and initialize total interest that will be paid over the course of the loan
        double totalInterest = LoanFormulas.calculateTotalInterest(loanTerm, monthlyPayment, principleAmount);

        // Output results to user
        System.out.print("Monthly payment: ");
        System.out.printf("%.2f", monthlyPayment);
        System.out.println();
        System.out.print("Total interest paid: ");
        System.out.printf("%.2f", totalInterest);
        System.out.println();
    }
}

