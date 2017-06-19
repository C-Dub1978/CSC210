/**
 * Main class, used to build an investment object after user input
 */
import java.util.Scanner;

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class InvestmentComparison {
    private static final int MINIMUM_VALUE = 1;

    /**
     * Main method
     * @param args, the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Investment investmentAnnual;
        Investment investmentOther;
        char compoundChoice = getCompoundFromUser();
        double initial;
        double rate;
        int time;
        while(compoundChoice != 'E') {
            initial = getInitialInvestmentFromUser();
            rate = getPercentageRateFromUser();
            time = getTermFromUser();

            investmentAnnual = new Investment(initial, rate, time, 'A');
            investmentOther = new Investment(initial, rate, time,
                    compoundChoice);
            investmentAnnual.calculateResults();
            investmentOther.calculateResults();
            investmentAnnual.displayResults();
            System.out.println();
            investmentOther.displayResults();
            double difference = investmentOther.getEarnings() -
                    investmentAnnual.getEarnings();
            String compoundingType =
                    investmentOther.convertCompoundingTypeToString();
            System.out.println();
            System.out.println("Compounding Analysis: ");
            System.out.printf("\tYou earn $ %,.2f", difference);
            System.out.print(" more with " + compoundingType +
                    " compounding\n");
            System.out.print("\tvs. Annual compounding");
            System.out.println();
            System.out.println();
            compoundChoice = getCompoundFromUser();
        }
        if(compoundChoice == 'E') {
            System.out.println("Bye bye!!");
            System.exit(0);
        }
    }

    /**
     * Gets initial investment from the user
     * @return investment, the initial investment amount
     */
    public static double getInitialInvestmentFromUser() {
        final int MAXIMUM = 500000;
        Scanner input = new Scanner(System.in);
        double investment;
        do{
            System.out.println("Please enter an initial investment amount " +
                    "greater than 1, with maximum amount being " + MAXIMUM +
                    ":");
            while(!input.hasNextDouble()) {
                System.out.println("Error, invalid input. Please enter an" +
                        " investment amount greater than 1: ");
                input.next();
            }
            investment = input.nextDouble();
            if(investment < MINIMUM_VALUE || investment > MAXIMUM) {
                System.out.println("Error, bad investment amount");
            }
        } while(investment < MINIMUM_VALUE || investment > MAXIMUM);
        return investment;
    }

    /**
     * Gets the apr from user input
     * @return apr, the percentage rate
     */
    public static double getPercentageRateFromUser() {
        final double MAXIMUM = 30.0D;
        Scanner input = new Scanner(System.in);
        double apr;
        do {
            System.out.println("Please enter a percentage rate greater than" +
                    " 1, maximum of " + MAXIMUM + ":");
            while(!input.hasNextDouble()) {
                System.out.println("Error, invalid input. Please enter a " +
                        "percentage rate greater than 1, maximum of " +
                        MAXIMUM + ":");
                input.next();
            }
            apr = input.nextDouble();
            if(apr < MINIMUM_VALUE || apr > MAXIMUM) {
                System.out.println("Error, bad percentage rate");
            }
        } while(apr < MINIMUM_VALUE || apr > MAXIMUM);
        return apr;
    }

    /**
     * Gets the term (in years) from user input
     * @return term, amount in years
     */
    public static int getTermFromUser() {
        final double MAXIMUM = 75;
        Scanner input = new Scanner(System.in);
        int term;
        do {
            System.out.println("Please enter the term, (years) for the loan," +
                    "between 1 and " + MAXIMUM + ":");
            while(!input.hasNextInt()) {
                System.out.println("Error, invalid input. Please enter the " +
                        "term (years) for the loan, between 1 and "
                     + MAXIMUM + ":");
                input.next();
            }
            term = input.nextInt();
            if(term < MINIMUM_VALUE || term > MAXIMUM) {
                System.out.println("Error, bad term amount");
            }
        } while(term < MINIMUM_VALUE || term > MAXIMUM);
        return term;
    }

    /**
     * Gets the compounding type from user input
     * @return choice, the character representation of compound type
     */
    public static char getCompoundFromUser() {
        Scanner input = new Scanner(System.in);
        char choice;
        do {
            System.out.println("Compare Annual Compounding to:");
            System.out.println("\tQ - Quarterly Compounding");
            System.out.println("\tM - Monthly Compounding");
            System.out.println("\tD - Daily Compounding");
            System.out.println("\tE - Exit Program");
            System.out.println("Enter choice from menu above: ");
            choice = input.next().toUpperCase().charAt(0);
            if(choice != 'Q' && choice != 'M' &&
                    choice != 'D' && choice != 'E') {
                System.out.println("Error, invalid choice");
            }
        } while(choice != 'Q' && choice != 'M' &&
                    choice != 'D' && choice != 'E');

        return choice;
    }
}


