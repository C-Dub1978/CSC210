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
        balance = initialInvestment;
        earnings = 0.0D;
        compoundType = type;
    }

    public double getEarnings() {
        return earnings;
    }

    public String convertCompoundingTypeToString() {
        String type;
        if(compoundType == 'A') {
            type = "Annual";
        } else if(compoundType == 'Q') {
            type = "Quarterly";
        } else if(compoundType == 'M') {
            type = "Monthly";
        } else if(compoundType == 'D') {
            type = "Daily";
        } else {
            type = "Daily";
        }
        return type;
    }

    public void calculateResults() {
        double convertedAPR = apr * .01;
        int occurence = 0;
        if(compoundType == 'A') {
            occurence = term * 1;
        } else if(compoundType == 'Q') {
            occurence = term * 4;
            convertedAPR /= 4;
        } else if(compoundType == 'M') {
            occurence = term * 12;
            convertedAPR /= 12;
        } else if(compoundType == 'D') {
            occurence = term * 365;
            convertedAPR /= 365;
        }
        for(int i = 0; i < occurence; i++) {
            double amount = balance * convertedAPR;
            balance += amount;
        }
        earnings = balance - initialInvestment;
    }

    public void displayResults() {
        System.out.println("Results for " + convertCompoundingTypeToString() +
                " compounding: ");
        System.out.printf("\tFor an initial investment of $ " +
                "%,.2f", initialInvestment);
        System.out.printf("\n\tafter " + term + " years at %.3f%%", apr );
        System.out.printf("\n\tthe ending balance is $ %,.2f", balance);
        System.out.printf("\n\tfor earnings of $ %,.2f", earnings);
        System.out.println();
    }
}
