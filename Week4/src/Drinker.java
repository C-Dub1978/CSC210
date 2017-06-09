import java.util.Scanner;

/**
 * Drinker class, object to set drinker's information
 */
public class Drinker {
    private String drinkerId;
    private double weightInKg;
    private double heightInMt;
    private int numDrinksConsumed;
    private int numHoursElapsed;

    /**
     * Default constructor
     */
    public Drinker() {
        this.drinkerId = "";
        this.weightInKg = 0.0;
        this.heightInMt = 0.0;
        this.numDrinksConsumed = 0;
        this.numHoursElapsed = 0;
    }

    /**
     * Setter setId
     *
     * @param last, last name
     * @param num, phone number
     */
    public void setId(String last, String num) {
        String name = last.toUpperCase().substring(0, 3);
        String number = num.substring(num.length() - 4, num.length());
        this.drinkerId = name.concat(number);
    }

    /**
     * Setter setWeight, converts to Kg and sets field
     *
     * @param lbs, weight in lbs
     */
    public void setWeight(double lbs) {
        final double LBS_IN_KG = 2.20462D;
        lbs /= LBS_IN_KG;
        this.weightInKg = lbs;
    }

    /**
     * Setter setHeight, converts to meters and sets field
     *
     * @param height, height in inches
     */
    public void setHeight(double height) {
        final double INCHES_IN_METER = 39.3701D;
        height /= INCHES_IN_METER;
        this.heightInMt = height;
    }

    /**
     * Setter setDrinksConsumed
     */
    public void setDrinksConsumed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of drinks consumed: ");
        this.numDrinksConsumed = scanner.nextInt();
    }

    /**
     * Setter setHoursElapsed
     */
    public void setHoursElapsed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter WHOLE number of hours elapsed since first drink: ");
        this.numHoursElapsed = scanner.nextInt();
    }

    /**
     * Getter getDrinkerId, returns the id
     *
     * @return drinkerId, the id field
     */
    public String getDrinkerId() {
        return this.drinkerId;
    }

    /**
     * Getter getNumDrinksConsumed
     *
     * @return numDrinksConsumed, the number of drinks field
     */
    public int getNumDrinksConsumed() {
        return this.numDrinksConsumed;
    }

    /**
     * Getter getNumHoursElapsed
     *
     * @return numHoursElapsed, the hours field
     */
    public int getNumHoursElapsed() {
        return this.numHoursElapsed;
    }

    /**
     * This method calculates the male volume
     *
     * @return volDist, the male volume
     */
    public double calculateMenVolume() {
        double volDist = 1.0178 - ((0.012127 * weightInKg) / Math.pow(heightInMt, 2));
        return volDist;
    }

    /**
     * This method calculates the female volume
     *
     * @return volDist, the female volume
     */
    public double calculateWomenVolume() {
        double volDist = 0.8736 - ((0.0124 * weightInKg) / Math.pow(heightInMt, 2));
        return volDist;
    }

    /**
     * This method will calculate the person's current BAC
     *
     * @param volDistrib, volume
     * @param metabolicRate, constant for rate
     * @param gender, male or female string
     */
    public void calculateCurrentBAC(double volDistrib, double metabolicRate, String gender) {
        final double GRAMS_IN_KG = 1000.0D;
        final int GRAMS_IN_DRINK = 14;

        double convertedWeight = weightInKg * GRAMS_IN_KG;
        int totalAlcoholInDrinks = numDrinksConsumed * GRAMS_IN_DRINK;
        double initialBAC = (totalAlcoholInDrinks / (convertedWeight * volDistrib)) * 100;
        double currentBAC = initialBAC - (numHoursElapsed * metabolicRate);
        System.out.printf("\tA " + gender.toLowerCase() + " has a current BAC of approximately %.3f\n", currentBAC);
    }

}
