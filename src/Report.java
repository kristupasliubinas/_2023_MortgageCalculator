import java.text.NumberFormat;

public class Report {
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
        var paymentNumber = 0;
        for (double balance : mortgage.getRemainingBalances()) {
            paymentNumber++;
            System.out.println("After Payment " + paymentNumber + ": " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private void setMortgage(Mortgage mortgage){
        this.mortgage = mortgage;
    }
}
