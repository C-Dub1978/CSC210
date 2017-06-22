import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by klown on 6/21/17.
 */
public class InterestPaidCalculator {

    public static void main(String[] args) {
        final File outputFileName = new File("report.txt");
        File inputFile = null;
        Scanner inputScanner = null;
        File outputFile = null;
        PrintWriter printWriter = null;
        String inputTextFileName = "";
        boolean canOpenInputFile = false;
        boolean canOpenOutputFile = false;
        Scanner keyboardReader = new Scanner(System.in);
        int numAccountsProcessed = 0;
        double totalInterestPaidAnnual = 0.0D;
        System.out.println("This program will......");
    }
}
