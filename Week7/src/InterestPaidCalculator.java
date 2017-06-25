import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
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
            inputScanner = new Scanner(inputFile);
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
            while(inputScanner.hasNextLine()) {
                    String inputLine = inputScanner.nextLine();
                    String[] tokens = inputLine.split("\\s+");
                    if(tokens.length == 4) {
                        int account = Integer.parseInt(tokens[0]);
                        double invest = Double.parseDouble(tokens[1]);
                        double apr = Double.parseDouble(tokens[2]);
                        char type = tokens[3].charAt(0);
                        try {
                            Investment inv = new Investment(invest, apr, type, account);
                            inv.calculateResults();
                            totalInterestPaidAnnual += inv.getEarnings();
                            printWriter.println(account + " " + inv.getEarnings() + "\n");
                            numAccountsProcessed++;
                        } catch (IllegalArgumentException e) {
                            System.out.println("input error");
                        }


                    } else {
                        printWriter.println("Invalid data line, " + inputLine + " ignored\n");
                    }


            }
            inputScanner.close();
            printWriter.close();

            System.out.println("For " + numAccountsProcessed + " accounts processed, the company paid " + totalInterestPaidAnnual);
        }
    }
}
