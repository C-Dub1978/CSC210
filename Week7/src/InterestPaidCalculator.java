import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by klown on 6/21/17.
 */
public class InterestPaidCalculator {

    public static void main(String[] args) {
        final File outputFileName = new File("report.txt");
        String inputTextFileName;
        File inputFile = null;
        Scanner inputScanner = null;
        Scanner keyboardReader = new Scanner(System.in);
        File outputFile = null;
        PrintWriter printWriter = null;
        boolean canOpenInputFile = false;
        boolean canOpenOutputFile = false;
        int numAccountsProcessed = 0;
        double totalInterestPaidAnnual = 0.0D;

        System.out.println("This program will calculate the interest paid" +
                "by an investment company,\n from all accounts, over " +
                "the course of one year.");
        System.out.println();
        System.out.println("Enter input data filename (inlcuding .txt):");
        inputTextFileName = keyboardReader.next();
        System.out.println("filename: " + inputTextFileName);
        System.out.println();
        System.out.println("Reading file and calculating interest.....");

        try {
            inputFile = new File(inputTextFileName);
            //System.err.println(inputFile.getAbsolutePath());
            inputScanner = new Scanner(inputFile);
            while(inputScanner.hasNextLine()) {
                System.out.println(inputScanner.nextLine());
            }

        } catch(Exception e) {
            System.out.println("error");
        }
    }
}
