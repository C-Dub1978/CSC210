/**
 * Created by klown on 6/11/17.
 */
public class Investment {
    private double initialInvestment;
    private double apr;
    private int term;
    private char compoundType;
    private double balance;
    private double earnings;

    public Investment(double initialInvestment, double apr, int term, char type) {
        this.initialInvestment = initialInvestment;
        this.apr = apr;
        this.term = term;
        compoundType = type;
        balance = this.initialInvestment;
        earnings = 0.0D;
    }

    public double getEarnings() {
        return earnings;
    }

    public String convertCompoundingTypeToString() {
        String type;
        if(compoundType == 'a' || compoundType == 'A') {
            type = "Annual";
        } else if(compoundType == 'q' || compoundType == 'Q') {
            type = "Quarterly";
        } else if(compoundType == 'm' || compoundType == 'M') {
            type = "Monthly";
        } else if(compoundType == 'd' || compoundType == 'D') {
            type = "Daily";
        } else {
            type = "Daily";
        }
        return type;
    }

    public void calculateResults() {
        final double convertedAPR = apr * .01;
        System.out.println("converted apr: " + convertedAPR);
        int earningCycle;
        double interestEarned = 0;
        if(compoundType == 'a' || compoundType == 'A') {
            earningCycle = 1;
        } else if(compoundType == 'q' || compoundType == 'Q') {
            earningCycle = 4;
        } else if(compoundType == 'm' || compoundType == 'M') {
            earningCycle = 12;
        } else if(compoundType == 'd' || compoundType == 'D') {
            earningCycle = 365;
        } else {
            earningCycle = 1;
        }

        for(int i = 0; i < earningCycle; i++) {
            double interest = initialInvestment * convertedAPR;
            interestEarned += interest;
        }
        earnings = interestEarned * term;
        balance = initialInvestment + earnings;
    }

    public void displayResults() {
        System.out.println("Results for annual compounding: ");
        System.out.printf("\tFor an initial investment of $ " +
                "%.2f", initialInvestment);
        System.out.printf("\n\tafter " + term + " years at %.3f%%", apr );
        System.out.printf("\n\tthe ending balance is $ %.2f", balance);
        System.out.printf("\n\tfor earnings of $ %.2f", earnings);
    }



    // TEST GETTERS/SETTERS, DELETE AFTER TESTING
    public double getBalance() {
        return balance;
    }
}
