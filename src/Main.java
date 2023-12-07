import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        // Take input from user
        int principal = (int) readInput("Principal loan (£1K - £1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readInput("Annual Interest Rate: ", 1, 30);
        int years = (int) readInput("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterestRate, years);

        printMortgage(mortgage);
        printBalance(principal, annualInterestRate, years);
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

    public static double calculateBalance(int principal, float annualInterestRate, int years, int numberOfPaymentsMade)
    {
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double remainingBalance = principal *
                (Math.pow((1 + monthlyInterestRate), numberOfPayments) - Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)) /
                (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        return remainingBalance;
    }

    private static void printMortgage(Mortgage mortgage) {
        System.out.println("\nMORTGAGE\n--------");
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage.calculateMortgage());
        System.out.println("Monthly Payments: " + formattedResult);
    }

    private static void printBalance(int principal, float annualInterestRate, int years) {
        System.out.println("\nREMAINING BALANCE\n----------------");
        double balance;
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println("After Payment " + month + ": " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}