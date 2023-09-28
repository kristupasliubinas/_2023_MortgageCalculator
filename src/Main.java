import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Take input from user
        int principal = (int) readInput("Principal loan (£1K - £1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readInput("Annual Interest Rate: ", 1, 30);
        int years = (int) readInput("Period (Years): ", 1, 30);

        // Calculate mortgage
        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        // Present result on the console screen
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage monthly payment: " + formattedResult);
    }

    public static double readInput(String inputMessage, double min, double max) {
        double input;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(inputMessage);
            input = scanner.nextDouble();
            if (input >= min && input <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }

        return input;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, int years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal *
                (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        return mortgage;
    }
}