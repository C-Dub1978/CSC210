/**
 * Class for storing all cell phone accounts in an array,
 * with different methods for calculating and storing data
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class AccountsListImpl {
    public static final int ARRAY_MAX_SIZE = 500;

    private CellPhoneAccount[] accountArray;
    private int numAccountsStored;

    public AccountsListImpl() {
        accountArray = new CellPhoneAccount[ARRAY_MAX_SIZE];
        numAccountsStored = 0;
    }

    /**
     * Getter, get the size of the array
     * @return accounts stored field
     */
    public int getNumAccountsStored() {
        return numAccountsStored;
    }

    /**
     * Method to add a CellPhoneAccount object to the array
     * @param accountObj, the CellPhoneAccount object
     * @throws ArrayIndexOutOfBoundsException
     */
    public void addAccount(CellPhoneAccount accountObj) throws
            ArrayIndexOutOfBoundsException {
        if(numAccountsStored >= ARRAY_MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("The array is currently " +
                    "full and cannot hold any more accounts");
        } else {
            accountArray[numAccountsStored] = accountObj;
            numAccountsStored++;
        }
    }

    /**
     * Method to try to read a data file, process the accounts and add them
     * to the array
     * @param fileName, the string name of the file to try to open
     */
    public void storeInputData(String fileName) {
        boolean loopRunner = true;
        try {
            File inputDataFile = new File(fileName);
            Scanner inputScanner = new Scanner(inputDataFile);
            System.out.println("Please wait while the data is read...");

            while(inputScanner.hasNextLine() && loopRunner) {
                String[] inputLine = inputScanner.nextLine().split("\\s+");
                String phoneNum = inputLine[0];
                char planType = inputLine[1].charAt(0);
                int texts = Integer.parseInt(inputLine[2]);
                double data = Double.parseDouble(inputLine[3]);
                CellPhoneAccount account = new CellPhoneAccount(phoneNum,
                        planType, texts, data);
                try {
                    addAccount(account);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("No more data will be read from the"
                            + "file...");
                    loopRunner = false;
                }
            }
            inputScanner.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error, file: " + fileName + " could" +
                    "not be opened");
        }
    }

    /**
     * Method to loop through the array and call the calculation method
     * which is an instance method inside the CellPhoneAccount class
     */
    public void calculateAllMonthlyCharges() {
        for(CellPhoneAccount account: accountArray) {
            if(account != null) {
                account.calculateMonthTotal();
            }
        }
    }

    /**
     * Method to create and print to a gorgeous output file
     */
    public void createBillingReport() {
        PrintWriter outputWriter;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter name of output billing file: ");
        String fileName = inputScanner.next();
        try {
            double totalCharges = 0.0D;
            File outputFile = new File(fileName);
            outputWriter = new PrintWriter(outputFile);
            for(CellPhoneAccount account: accountArray) {
                if(account != null) {
                    outputWriter.printf("%-18s%8.2f\n", account.getCellNumber(),
                            account.getMonthsBillTotal());
                    totalCharges += account.getMonthsBillTotal();
                }
            }
            outputWriter.printf("%-18s%8.2f\n", "Total", totalCharges);
            outputWriter.close();
        } catch(IOException e) {
            System.out.println("File " + fileName + " could not be" +
                    "opened, report will not be generated");
        }
    }

    /**
     * Method to calculate the lowest bill total in the array and return it
     * @return lowest, the lowest total
     */
    public double returnLowestBill() {
        double lowest = accountArray[0].getMonthsBillTotal();
        for(CellPhoneAccount account: accountArray) {
            if(account != null) {
                double comparator = account.getMonthsBillTotal();
                if(comparator < lowest) {
                    lowest = comparator;
                }
            }
        }
        return lowest;
    }

    /**
     * Method to calculate the average bill of all accounts
     * @return average, the average bill amount
     */
    public double returnAverageBill() {
        double average = 0.0D;
        for(CellPhoneAccount account: accountArray) {
            if(account != null) {
                average += account.getMonthsBillTotal();
            }
        }
        return average / numAccountsStored;
    }

    /**
     * Method to find the highest bill total and return it
     * @return highest, the highest bill
     */
    public double returnHighestBill() {
        double highest = accountArray[0].getMonthsBillTotal();
        for(CellPhoneAccount account: accountArray) {
            if(account != null) {
                double comparator = account.getMonthsBillTotal();
                if(comparator > highest) {
                    highest = comparator;
                }
            }
        }
        return highest;
    }
}
