import java.text.NumberFormat;

public class Report {
    final byte MONTHS_IN_YEAR = 12;
    private Mortgage mortgage;

    public Report(Mortgage mortgage) {
        setMortgage(mortgage);
        printMortgage();
        printBalance();
    }

    private void printMortgage() {
        System.out.println("\nMORTGAGE\n--------");
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage.calculateMortgage());
        System.out.println("Monthly Payments: " + formattedResult);
    }

    private void printBalance() {
        System.out.println("\nREMAINING BALANCE\n----------------");
        double balance;
        for (short month = 1; month <= mortgage.getYears() * MONTHS_IN_YEAR; month++) {
            balance = mortgage.calculateBalance(month);
            System.out.println("After Payment " + month + ": " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private void setMortgage(Mortgage mortgage){
        this.mortgage = mortgage;
    }
}
