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

    public Investment(double initialInvestment, double apr, double term, char type) {
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

    public double calculateResults() {
        double convertedAPR;
        
    }
}
