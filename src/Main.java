import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Take input from user
        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal loan (£1K - £1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float annualInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30)
                break;
            System.out.println("Enter a number greater than 0 and less than or equal to 30.");
        }

        int years;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a number between 1 and 30.");
        }


        // Calculate mortgage
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal *
                (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);


        // Present result on the console screen
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage monthly payment: " + formattedResult);
    }
}