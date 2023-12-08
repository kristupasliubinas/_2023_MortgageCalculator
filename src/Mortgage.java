public class Mortgage {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public Mortgage(int principal, float annualInterestRate, byte years) {
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setYears(years);
    }

    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        double mortgage = principal *
                (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(int numberOfPaymentsMade)
    {
        float monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        double remainingBalance = principal *
                (Math.pow((1 + monthlyInterestRate), numberOfPayments) - Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)) /
                (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        return remainingBalance;
    }

    private void setPrincipal(int principal) {
        if (principal <= 0)
            throw new IllegalArgumentException("Principal loan cannot be 0 or less.");
        this.principal = principal;
    }

    private void setAnnualInterestRate(float annualInterestRate) {
        if (annualInterestRate <= 0)
            throw new IllegalArgumentException("Annual interest rate cannot be 0 or less.");
        this.annualInterestRate = annualInterestRate;
    }

    private void setYears(byte years) {
        if (years <= 0 )
            throw new IllegalArgumentException("Loan period in years cannot be 0 or less.");
        this.years = years;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short paymentNumber = 1; paymentNumber <= balances.length; paymentNumber++)
            balances[paymentNumber - 1] = calculateBalance(paymentNumber);

        return balances;
    }
}
