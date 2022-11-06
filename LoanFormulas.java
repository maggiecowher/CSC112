/**
 * This class is used in the LoanCalculator.java class in order to calculate the monthly payment and the total interest
 * paid. The calculateMonthlyPayment method takes in the initial loan amount, annual interest rate, and the term of the
 * loan in years, and with some calculations returns the monthly payment on the loan. The calculateTotalInterest method
 * takes in the loan term in years, the monthly payment calculated in the previous method, and the initial loan amount.
 * The method then does some calculations and returns the total interest paid on the loan. By completing these
 * calculations in a different class, the LoanCalculator.java class can be more simplistic and readable.
 * <p>
 * This class is also used in the LoanAdvisor.java class which in addition to the LoanCalculator.java class, advises the
 * user how to change the terms of their loan in order to save money.
 * @author: Maggie Cowher
 */
public class LoanFormulas {
    // Method to calculate the monthly payment based on the loan amount, annual interest rate, and number of years.
    public static double calculateMonthlyPayments(double principleAmount, double annualRate, int loanTerm) { // Initialize values to be used in calculations
        // Initialize variables to create simplicity in the monthly payment equation
        int numOfPayments = loanTerm * 12;
        double monthlyRate = (annualRate / 100) / 12;

        // Calculate and return the monthly payment
        return (principleAmount * (monthlyRate * ((Math.pow((1 + monthlyRate), (numOfPayments))) / (Math.pow((1 + monthlyRate), (numOfPayments)) - 1))));
    }

    // Method to calculate the total interest that will be paid based on the loan amount, annual interest rate, and number of years.
    public static double calculateTotalInterest(int loanTerm, double monthlyPayment, double principleAmount) { // Initialize values to be used in calculations
        // Initialize variable to create simplicity in the total interest equation
        int numOfPayments = loanTerm * 12;

        // Calculate and return the total interest
        return (monthlyPayment * numOfPayments) - principleAmount;
    }
}
