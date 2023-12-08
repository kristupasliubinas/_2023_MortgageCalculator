public class Main {
    public static void main(String[] args) {
        // Take input from user
        int principal = (int) Console.readNumber("Principal loan (£1K - £1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterestRate, years);
        new Report(mortgage);
    }
}