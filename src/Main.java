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
        var report = new Report(mortgage);
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
}