public class Main {
    public static void main(String[] args) {
        // Take input from user
        int principal = (int) Console.readInput("Principal loan (£1K - £1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readInput("Annual Interest Rate: ", 1, 30);
        int years = (int) Console.readInput("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterestRate, years);
        new Report(mortgage);
    }
}