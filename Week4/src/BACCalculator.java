/**
 * The blood alcohol content calculator program will do the following:
 * It will ask for height, weight, drinks consumed, and hours since first drinks,
 * then calculate and display both male and female current bac's at that time
 */
import java.util.Scanner;

/**
 * @Author Chris Wilson
 * @Verison, 2.0, Java Assn 4 modified from Java Assn 3
 */
public class BACCalculator {
    /**
     * Main method, instantiates a scanner for input, sets some constants for calculations
     * and calls the class methods for calculating
     *
     * @param args, the command line arguments
     */
    public static void main(String[] args) {
        // set constant local vars
        final double MALE_METABOLIC_RATE = 0.015D;
        final double FEMALE_METABOLIC_RATE = 0.014D;
        // call description method
        describeProgram();
        // get input without type checking
        Scanner scanner = new Scanner(System.in);
        Drinker drinker = new Drinker();
        System.out.println("Please enter the drinker's last name: ");
        String last = scanner.next();
        System.out.println("Please enter the drinker's phone number: ");
        String phone = scanner.next();
        System.out.println("Please enter the drinker's height in inches: ");
        double height = scanner.nextDouble();
        System.out.println("Please enter the drinker's weight, in pounds: ");
        double weight = scanner.nextDouble();

        // set fields in drinker object and calculate both male/female volume
        drinker.setId(last, phone);
        drinker.setDrinksConsumed();
        drinker.setHoursElapsed();
        drinker.setHeight(height);
        drinker.setWeight(weight);
        drinker.calculateMenVolume();
        drinker.calculateWomenVolume();

        // display
        displayResults(drinker, weight, height);
        drinker.calculateCurrentBAC(drinker.calculateMenVolume(), MALE_METABOLIC_RATE, "male");
        drinker.calculateCurrentBAC(drinker.calculateWomenVolume(), FEMALE_METABOLIC_RATE, "female");
    }

    /**
     * Program description method, simply states what will be done
     */
    public static void describeProgram() {
        System.out.println("This program will calculate and show current BAC");
        System.out.print("Based upon height, weight, and gender, drinks, and hours,");
        System.out.println(" the program will calculate BAC at this time:");
        System.out.println();
    }


    /**
     * Method to display results and format them accordingly
     *
     * @param drinker, the drinker object
     * @param weight, the previous weight in lbs
     * @param height, the previous height in inches
     */
    public static void displayResults(Drinker drinker, double weight, double height) {
        System.out.println();
        System.out.println("Calculations for Drinker " + drinker.getDrinkerId() + ",");
        System.out.println("who is " + (int)height + " inches tall and weighs " + (int)weight + " pounds.");
        System.out.println();
        System.out.print("After drinking " + drinker.getNumDrinksConsumed());
        System.out.println(" drinks, in " + drinker.getNumHoursElapsed() + " hours:");
    }

}
