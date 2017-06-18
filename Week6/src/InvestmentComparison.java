import java.util.Scanner;

public class InvestmentComparison {
    private static final int MINIMUM_VALUE = 1;

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String choice;
//        do {
//            System.out.println("Compare Annual Compounding to: ");
//            System.out.println("\tQ - Quarterly Compounding");
//        } while()
        Investment invest = new Investment(1, 30,75,'M');
        invest.calculateResults();
        invest.displayResults();
    }

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

    public static double getPercentageRateFromUser() {
        final double MAXIMUM = 30.0D;
        Scanner input = new Scanner(System.in);
        double apr;
        do {
            System.out.println("Please enter a percentage rate greater than" +
                    " 1, maximum of " + MAXIMUM + ":");
            while(!input.hasNextDouble()) {
                System.out.println("Error, invalid input. Please enter a" +
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

    public static char getCompoundFromUser() {
       return 'c';
    }
}


