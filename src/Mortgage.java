public class Mortgage {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private int years;

    public Mortgage(int principal, float annualInterestRate, int years) {
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setYears(years);
    }

    public double calculateMortgage() {
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal *
                (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(int numberOfPaymentsMade)
    {
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

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

    private void setYears(int years) {
        if (years <= 0 )
            throw new IllegalArgumentException("Loan period in years cannot be 0 or less.");
        this.years = years;
    }

    public int getYears() {
        return years;
    }
}
