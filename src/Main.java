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
        printBalance(mortgage);
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

    private static void printMortgage(Mortgage mortgage) {
        System.out.println("\nMORTGAGE\n--------");
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage.calculateMortgage());
        System.out.println("Monthly Payments: " + formattedResult);
    }

    private static void printBalance(Mortgage mortgage) {
        System.out.println("\nREMAINING BALANCE\n----------------");
        double balance;
        for (short month = 1; month <= mortgage.getYears() * MONTHS_IN_YEAR; month++) {
            balance = mortgage.calculateBalance(month);
            System.out.println("After Payment " + month + ": " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}