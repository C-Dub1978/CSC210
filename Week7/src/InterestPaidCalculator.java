import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by klown on 6/21/17.
 */
public class InterestPaidCalculator {

    public static void main(String[] args) {
        final String outputFileName = "report.txt";
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

        try {
            inputFile = new File(inputTextFileName);
            inputScanner = new Scanner(inputFile).useDelimiter(" ");
            canOpenInputFile = true;
        } catch(FileNotFoundException e) {
            System.out.println("error opening input file");
        }
        try {
            outputFile = new File(outputFileName);
            printWriter = new PrintWriter(outputFile);
            canOpenOutputFile = true;
        } catch(Exception e) {
            System.out.println("error opening output file");
        }

        if(canOpenInputFile && canOpenOutputFile) {
            // start logic for reading the file input and building investment objects
            while(inputScanner.hasNextLine()) {
                int account = inputScanner.nextInt();
                double invest = inputScanner.nextDouble();
                double apr = inputScanner.nextDouble();
                char type = inputScanner.next().charAt(0);
                try {
                    Investment inv = new Investment(invest, apr, type, account);
                    inv.calculateResults();
                    inv.displayResults();
                } catch(IllegalArgumentException e) {
                    System.out.println(e);
                }
                inputScanner.nextLine();
            }
            inputScanner.close();
            printWriter.close();
        }
    }
}
