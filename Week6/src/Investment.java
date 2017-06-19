/**
 * Investment class, calculates compound investments
 */

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class Investment {
    private double initialInvestment;
    private double apr;
    private int term;
    private char compoundType;
    private double balance;
    private double earnings;

    /**
     * Parameterized constructor
     * @param initialInvestment, beginning balance
     * @param apr, percentage rate
     * @param term, amount in years
     * @param type, designator for compounding
     */
    public Investment(double initialInvestment, double apr, int term,
                      char type) {
        this.initialInvestment = initialInvestment;
        this.apr = apr;
        this.term = term;
        balance = initialInvestment;
        earnings = 0.0D;
        compoundType = type;
    }

    /**
     * Getter, gets the earnings
     * @return
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * method to return a string letter for compound type
     * @return
     */
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

    /**
     * Calculates earnings with a for loop
     */
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

    /**
     * Prints out all results formatted nicely
     */
    public void displayResults() {
        System.out.println("Results for " + convertCompoundingTypeToString() +
            " compounding: ");
        System.out.printf("\t%-30s $ %,.2f\n", "For an initial investment of: ",
                initialInvestment);
        System.out.printf("\t%-30s %.3f %%\n", "after" + term + " years at: ",
                apr, "%");
        System.out.printf("\t%-30s $ %,.2f\n", "The ending balance is: ",
                balance);
        System.out.printf("\t%-30s $ %,.2f\n", "For earnings of: ",
                earnings);
    }
}
