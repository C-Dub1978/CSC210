/**
 * Account class with data fields and logic to calculate the monthly bill
 */

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class CellPhoneAccount {
    private String cellNumber;
    private char accountType;
    private int numTextsTotal;
    private double numGBUsed;
    private double monthsBillTotal;

    /**
     * Constructor
     * @param phoneNum
     * @param type
     * @param texts
     * @param gbUsed
     */
    public CellPhoneAccount(String phoneNum, char type, int texts,
                            double gbUsed) {
        cellNumber = phoneNum;
        accountType = type;
        numTextsTotal = texts;
        numGBUsed = gbUsed;
        monthsBillTotal = 0.0D;
    }

    /**
     * Getter, for the phone number
     * @return cellNumber
     */
    public String getCellNumber() {
        return cellNumber;
    }

    /**
     * Setter, for the phone number
     * @param cellNumber
     */
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     * Getter, for the account type character (P or U)
     * @return the character representing the account type
     */
    public char getAccountType() {
        return accountType;
    }

    /**
     * Setter for the account type
     * @param accountType
     */
    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter, number of texts for the month
     * @return number of texts total
     */
    public int getNumTextsTotal() {
        return numTextsTotal;
    }

    /**
     * Setter, for monthly texts
     * @param numTextsTotal
     */
    public void setNumTextsTotal(int numTextsTotal) {
        this.numTextsTotal = numTextsTotal;
    }

    /**
     * Getter for the data usage field
     * @return data field
     */
    public double getNumGBUsed() {
        return numGBUsed;
    }

    /**
     * Setter, set the data used
     * @param numGBUsed
     */
    public void setNumGBUsed(double numGBUsed) {
        this.numGBUsed = numGBUsed;
    }

    /**
     * Getter, for the monthly total bill amount
     * @return total bill
     */
    public double getMonthsBillTotal() {
        return monthsBillTotal;
    }

    /**
     * Setter, for the monthly bill amount
     * @param monthsBillTotal
     */
    public void setMonthsBillTotal(double monthsBillTotal) {
        this.monthsBillTotal = monthsBillTotal;
    }

    /**
     * Method to calculate the monthly bill based upon the data fields
     * and the below constant values
     */
    public void calculateMonthTotal() {
        final double BASE_FEE_BASIC = 5.99D;
        final double BASE_FEE_UNLIMITED = 59.99D;
        final double TEXT_CHARGE = 0.10D;
        final double DATA_CHARGE_BASIC = 3.39D;
        final double DATA_CHARGE_UNLIMITED = 2.29D;
        final double TAX_RATE = 0.081D;
        final double UNIVERSAL_FEE = 1.44D;

        //logic here to calculate bill

        if(accountType == 'P') {
            double textCharges = numTextsTotal * TEXT_CHARGE;
            double dataCharges = Math.ceil(numGBUsed) * DATA_CHARGE_BASIC;
            double totalBeforeTax = BASE_FEE_BASIC + textCharges +
                    dataCharges + UNIVERSAL_FEE;
            double tax = totalBeforeTax * TAX_RATE;
            monthsBillTotal = totalBeforeTax + tax;
        } else {
            double dataCharges = 0.0D;
            if(Math.ceil(numGBUsed) > 2) {
                dataCharges =
                        (Math.ceil(numGBUsed) - 2) * DATA_CHARGE_UNLIMITED;
            }
            double totalBeforeTax = BASE_FEE_UNLIMITED + dataCharges +
                    UNIVERSAL_FEE;
            double tax = totalBeforeTax * TAX_RATE;
            monthsBillTotal = totalBeforeTax + tax;
        }
    }
}
