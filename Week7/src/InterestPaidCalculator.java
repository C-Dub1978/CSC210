/**
 * This program will read input from a text file,
 * parse the information and attempt to calculate
 * interest paid to all valid lines in the accounting
 * document
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
public class InterestPaidCalculator {
    /**
     * Main method, attempts to open 2 different files, one input
     * and one output, and parse information. Once input information
     * is valid, it will create investment objects checking to
     * see if the input arguments are valid.
     * @param args, the command line arguments
     */
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
        } catch(IOException e) {
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
                        printWriter.printf(account + " %.2f\n", inv.getEarnings());
                        numAccountsProcessed++;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("*****Invalid data line, " + inputLine + " ignored\n");
                    }


                } else {
                    System.out.println("*****Invalid data line, " + inputLine + " ignored\n");
                }
            }
            inputScanner.close();
            printWriter.close();
            System.out.println("Results:");
            System.out.printf("\tFor " + numAccountsProcessed + " accounts processed, the company paid\n"
                    + "\t$%.2f total interest", totalInterestPaidAnnual);
        } else {
            System.out.println("File I/O error, exiting...");
        }
    }
}
