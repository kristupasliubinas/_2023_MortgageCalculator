import java.text.NumberFormat;

public class Report {
    private final NumberFormat currency;
    private Mortgage mortgage;

    public Report(Mortgage mortgage) {
        setMortgage(mortgage);
        currency = NumberFormat.getCurrencyInstance();
        printMortgage();
        printBalance();
    }

    private void printMortgage() {
        System.out.println("\nMORTGAGE\n--------");
        String formattedResult = currency.format(mortgage.calculateMortgage());
        System.out.println("Monthly Payments: " + formattedResult);
    }

    private void printBalance() {
        System.out.println("\nREMAINING BALANCE\n----------------");
        var paymentNumber = 0;
        for (double balance : mortgage.getRemainingBalances()) {
            paymentNumber++;
            System.out.println("After Payment " + paymentNumber + ": " + currency.format(balance));
        }
    }

    private void setMortgage(Mortgage mortgage){
        this.mortgage = mortgage;
    }
}
