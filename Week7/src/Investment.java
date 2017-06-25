/**
 * Investment class, calculates compound investments
 */

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class Investment {
    private double beginningBalance;
    private double apr;
    private int term;
    private char compoundType;
    private double endingBalance;
    private double earnings;
    private int accountNumber;

    /**
     * Parameterized constructor
     * @param initialInvestment, beginning balance
     * @param apr, percentage rate
     * @param type, designator for compounding
     */
    public Investment(double initialInvestment, double apr, char type,
                      int accountNum) throws IllegalArgumentException {
        final int MAX_BEGINNING_BALANCE = 500000;
        final int MIN_BEGINNING_BALANCE = 1;
        final double MAX_APR = 30.0D;
        final double MIN_APR = 1.0D;
        if(initialInvestment < MIN_BEGINNING_BALANCE) {
            throw new IllegalArgumentException("Error, investment amount too small");
        } else if(initialInvestment > MAX_BEGINNING_BALANCE) {
            throw new IllegalArgumentException("Error, investment amount too large");
        } else {
            beginningBalance = initialInvestment;
            endingBalance = initialInvestment;
        }
        if(apr < MIN_APR) {
            throw new IllegalArgumentException("Error, percentage rate too small");
        } else if(apr > MAX_APR) {
            throw new IllegalArgumentException("Error, percentage rate too large");
        }
        else {
            this.apr = apr;
        }
        if(type != 'A' && type != 'Q' && type != 'M' && type != 'D') {
            throw new IllegalArgumentException("Error, compound type invalid");
        } else {
            compoundType = type;
        }
        earnings = 0.0D;
        accountNumber = accountNum;
        term = 1;
    }

    /**
     * Getter, gets the earnings
     * @return
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Getter, gets the account number;
     * @return
     */
    public int getAccountNumber() {
        return accountNumber;
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
            double amount = endingBalance * convertedAPR;
            endingBalance += amount;
        }
        earnings = endingBalance - beginningBalance;
    }

    /**
     * Prints out all results formatted nicely
     */
    public void displayResults() {
        System.out.println("Results for " + convertCompoundingTypeToString() +
                " compounding: ");
        System.out.printf("\t%-30s $ %,.2f\n", "For an initial investment of: ",
                beginningBalance);
        System.out.printf("\t%-30s %.3f %%\n", "after" + term + " years at: ",
                apr, "%");
        System.out.printf("\t%-30s $ %,.2f\n", "The ending balance is: ",
                endingBalance);
        System.out.printf("\t%-30s $ %,.2f\n", "For earnings of: ",
                earnings);
    }
}

