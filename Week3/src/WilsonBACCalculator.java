///**
// * BAC calculator for both men and women
// * It will ask for height, weight, drinks consumed, and hours since first drinks,
// * then calculate and display both male and female current bac's at that time
// */
//
//import java.util.Scanner;
//
///**
// * @Author Chris Wilson
// * @Verison, 1.0, Java Assignment 3
// */
//public class WilsonBACCalculator {
//    /**
//     * Main method, instantiates a scanner for input, sets some constants for calculations
//     * and calls the class methods for calculating
//     * @param args, the command line arguments
//     */
//    public static void main(String[] args) {
//        // set constant local vars for
//        final double LBS_IN_KG = 2.20462D;
//        final double INCHES_IN_METER = 39.3701D;
//        final double MALE_METABOLIC_RATE = 0.015D;
//        final double FEMALE_METABOLIC_RATE = 0.014D;
//        // call description method
//        describeProgram();
//        // get input without type checking
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the person's height in inches: ");
//        double height = scanner.nextDouble();
//        System.out.println("Please enter the person's weight, in pounds: ");
//        double weight = scanner.nextDouble();
//        System.out.println("Please enter number of drinks consumed: ");
//        int drinksConsumed = scanner.nextInt();
//        System.out.println("Please enter number of WHOLE hours elapsed since first drink was consumed: ");
//        int hoursElapsed = scanner.nextInt();
//        // convert weight to kg, and height to meters
//        double heightMeters = height / INCHES_IN_METER;
//        double weightKgs = weight / LBS_IN_KG;
//        // get volumes for both genders
//        double maleVol = calculateMenVolume(weightKgs, heightMeters);
//        double femaleVol = calculateWomenVolume(weightKgs, heightMeters);
//        // get current BAC for both genders
//        double maleCurrent = calculateCurrentBAC(weight, maleVol, MALE_METABOLIC_RATE, drinksConsumed, hoursElapsed);
//        double femaleCurrent = calculateCurrentBAC(weight, femaleVol, FEMALE_METABOLIC_RATE, drinksConsumed, hoursElapsed);
//        // display results
//        displayResults(drinksConsumed, hoursElapsed, maleCurrent, femaleCurrent);
//
//    }
//
//    /**
//     * Program description method, simply states what will be done
//     */
//    public static void describeProgram() {
//        System.out.println("This program will calculate and show current BAC");
//        System.out.println("Based upon height, weight, and gender, drinks, and hours,\nthe program will calculate BAC at this time:");
//        System.out.println();
//    }
//
//    /**
//     * This method calculates the male volume
//     * @param weightKgs, weight in kg
//     * @param heightMts, height in meters
//     * @return volDist, the male volume
//     */
//    public static double calculateMenVolume(double weightKgs, double heightMts) {
//        double volDist = 1.0178 - ((0.012127 * weightKgs) / Math.pow(heightMts, 2));
//        return volDist;
//    }
//
//    /**
//     * This method calculates the female volume
//     * @param weightKgs, weight in kg
//     * @param heightMts, height in meters
//     * @return volDist, the female volume
//     */
//    public static double calculateWomenVolume(double weightKgs, double heightMts) {
//        double volDist = 0.8736 - ((0.0124 * weightKgs) / Math.pow(heightMts, 2));
//        return volDist;
//    }
//
//    /**
//     * This method will calculate the person's current BAC
//     * @param weightLbs
//     * @param volDistrib
//     * @param metabolicRate
//     * @param numDrinks
//     * @param hoursElapsed
//     * @return currentBAC, the current BAC
//     */
//    public static double calculateCurrentBAC(double weightLbs, double volDistrib, double metabolicRate, int numDrinks, double hoursElapsed) {
//        final double gramsInLb = 453.592;
//        final int gramsInDrink = 14;
//
//        double convertedWeight = weightLbs * gramsInLb;
//        int totalAlcoholInDrinks = numDrinks * gramsInDrink;
//        double initialBAC = (totalAlcoholInDrinks / (convertedWeight * volDistrib)) * 100;
//        double currentBAC = initialBAC - (hoursElapsed * metabolicRate);
//        return currentBAC;
//    }
//
//    /**
//     * Method to display results and format them accordingly
//     * @param numDrinks
//     * @param hours
//     * @param maleBAC
//     * @param femaleBAC
//     */
//    public static void displayResults(int numDrinks, int hours, double maleBAC, double femaleBAC) {
//        System.out.println();
//        System.out.println();
//        System.out.println("After drinking " + numDrinks + "drinks in " + hours + " hours: ");
//        System.out.printf("\tMale BAC is: %.3f", maleBAC);
//        System.out.println();
//        System.out.printf("\tFemale BAC is: %.3f\n", femaleBAC);
//    }
//
//}
