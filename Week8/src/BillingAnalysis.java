/**
 * Main class to work with the other 2. This is the entry point and will
 * call all the class methods after building the other objects
 */
import java.util.Scanner;
/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class BillingAnalysis {
    /**
     * Static method to display the lowest/average/highest bills
     * @param listObj, the AccountsListImpl object passed to it
     */
    public static void displayAnalysisSummary(AccountsListImpl listObj) {
        System.out.println("Monthly billing analysis for " +
                listObj.getNumAccountsStored() + " cell phone accounts: \n");
        System.out.printf("\t%-25s%10.2f\n", "Lowest bill charge: ",
                listObj.returnLowestBill());
        System.out.printf("\t%-25s%10.2f\n", "Average bill charge: ",
                listObj.returnAverageBill());
        System.out.printf("\t%-25s%10.2f\n", "Highest bill charge: ",
                listObj.returnHighestBill());
        System.out.println();
    }

    /**
     * Main method, entry point for all input and calculations
     * @param args, the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This program will collect data from an input" +
                " file from a cell phone provider, and process the accounts " +
                "for display and data storage");
        boolean programRunning = true;
        while(programRunning) {
            AccountsListImpl accountsList = new AccountsListImpl();
            boolean fileInput = true;
            Scanner inputScanner = new Scanner(System.in);
            while(fileInput) {
                System.out.println();
                System.out.println("Please enter a valid input file name, " +
                        "inlcuding the .txt: ");
                String inputFileName = inputScanner.next();
                accountsList.storeInputData(inputFileName);
                fileInput = (accountsList.getNumAccountsStored() == 0);
            }
            System.out.println();
            System.out.println("The program will now calculate all monthly " +
                    "bills from the input data.....");
            accountsList.calculateAllMonthlyCharges();
            accountsList.createBillingReport();
            System.out.println();
            System.out.println();
            displayAnalysisSummary(accountsList);
            System.out.println();
            System.out.println("Run again (y/n)?");
            char answer = inputScanner.next().charAt(0);
            System.out.println();
            programRunning = answer == 'y' || answer == 'Y';
        }
    }
}
