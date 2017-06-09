import com.sun.org.apache.bcel.internal.classfile.SourceFile;

/**
 * Created by klown on 6/8/17.
 */
public class Drinker {
    private String drinkerId;
    private double weightInKg;
    private double heightInMt;
    private int numDrinksConsumed;
    private int numHoursElapsed;
    private int weightInLbs;
    private int heightInInches;
    private char gender;
    private double metabolicRate;
    private double currentBAC;

    public Drinker() {
        drinkerId = "";
        weightInKg = 0.0D;
        heightInMt = 0.0D;
        numDrinksConsumed = 0;
        numHoursElapsed = 0;
        weightInLbs = 0;
        heightInInches = 0;
        gender = ' ';
        metabolicRate = 0.0D;
        currentBAC = 0.0D;
    }

    public Drinker(String lastName, char gender, int weightLbs, int heightInch,
                   int drinksConsumed, int time, char metabolicType) {
        this.gender = gender;
        numDrinksConsumed = drinksConsumed;
        numHoursElapsed = time;
        currentBAC = 0.0D;
        setId(lastName);
        setWeight(weightLbs);
        setHeight(heightInch);
        setMetabolicRate(metabolicType);
    }

    /**
     * Setter setWeight, converts to Kg and sets field, and sets lbs field to
     * parameter value;
     *
     * @param lbs, weight in lbs
     */
    public void setWeight(int lbs) {
        weightInLbs = lbs;
        final double LBS_IN_KG = 2.20462D;
        lbs /= LBS_IN_KG;
        weightInKg = lbs;
    }

    /**
     * Setter setHeight, converts to meters and sets field, and sets height
     * inches field to parameter value
     *
     * @param height, height in inches
     */
    public void setHeight(int height) {
        heightInInches = height;
        final double INCHES_IN_METER = 39.3701D;
        height /= INCHES_IN_METER;
        heightInMt = height;
    }

    public void setMetabolicRate(char type) {
        final double MALE_METABOLIC_RATE = 0.015D;
        final double FEMALE_METABOLIC_RATE = 0.014D;
        double baseMetabolicRate;
        // ternary logic, if gender is set to 'm', use first assignment, if it's
        // female or space character, default to female rate
        baseMetabolicRate = gender == ('M') ? MALE_METABOLIC_RATE :
                FEMALE_METABOLIC_RATE;
        // adjust depending on the switch parameter value
        switch (type) {
            case 'V':
                baseMetabolicRate -= 0.002;
                break;
            case 'S':
                baseMetabolicRate -= 0.001;
                break;
            case 'A':
                break;
            case 'F':
                baseMetabolicRate += 0.001;
                break;
            default:
                System.out.println("Invalid metabolic type choice," +
                        " metabolic rate will remain unchanged.");
                break;
        }
        metabolicRate = baseMetabolicRate;
    }

    public void setId(String last) {
        final int ID_LENGTH = 7;
        final String X = "XXXXXXX";
        if (last.length() < 7) {
            last = last + X.substring(0, 0 + (ID_LENGTH - last.length()));
        } else {
            last = last.substring(0, 7);
        }
        drinkerId = last.toUpperCase();
    }

    /**
     * This method will calculate the person's current BAC
     */
    public void calculateCurrentBAC() {
        final double GRAMS_IN_KG = 1000.0D;
        final int GRAMS_IN_DRINK = 14;
        double volDistrib = gender == ('m') ? calculateMenVolume() :
                calculateWomenVolume();

        double convertedWeight = weightInKg * GRAMS_IN_KG;
        int totalAlcoholInDrinks = numDrinksConsumed * GRAMS_IN_DRINK;
        double initialBAC = (totalAlcoholInDrinks / (convertedWeight *
                volDistrib)) * 100;
        currentBAC = initialBAC - (numHoursElapsed * metabolicRate);
    }

    /**
     * This method calculates the male volume
     *
     * @return volDist, the male volume
     */
    public double calculateMenVolume() {
        double volDist = 1.0178 - ((0.012127 * weightInKg) /
                Math.pow(heightInMt, 2));
        return volDist;
    }

    /**
     * This method calculates the female volume
     *
     * @return volDist, the female volume
     */
    public double calculateWomenVolume() {
        double volDist = 0.8736 - ((0.0124 * weightInKg) /
                Math.pow(heightInMt, 2));
        return volDist;
    }

    public void displayDrinkerInfo() {
        String gender = this.gender == ('M') ? "male" : "female";
        System.out.println("Calculations for: ");
        System.out.println("\t" + gender + "drinker, id " + drinkerId);
        System.out.println("\twho is " + heightInInches + " tall and weighs" +
                weightInLbs + " pounds");
        System.out.println("\tafter drinking " + numDrinksConsumed + ", in " +
                numHoursElapsed + " hours:");
        System.out.printf("Current BAC is approximately %.3f\n", currentBAC);
    }

    public void analyzeBAC() {
        System.out.println();
        final double IMPAIRMENT = 0.02D;
        final double COMMERCIAL = 0.04D;
        final double ALL = 0.08D;
        if (currentBAC < IMPAIRMENT) {
            System.out.println("You are ok to drive!");
        } else if (currentBAC >= IMPAIRMENT && currentBAC < COMMERCIAL) {
            System.out.println("You may legally drive, but must use caution " +
                    "\nas you may be partially impaired\n");
        } else if (currentBAC >= COMMERCIAL && currentBAC < ALL) {
            System.out.printf("You may NOT legally drive any commercial" +
                    "vehicle because you have exceeded\n the legal commercial limit"

                    + " of %.3f\n", COMMERCIAL);
        } else {
            System.out.printf("You may not legally drive ANY vehicle," +
                    "because you have exceeded\n the legal limit of %.3f\n", ALL);
            double futureBAC = currentBAC - metabolicRate;
            if (futureBAC >= ALL) {
                System.out.println("Even waiting an hour will not help, " +
                        " please find a ride home!");
            } else {
                System.out.println("You will be legally allowed to drive home" +
                        " in 1 hour, but should greatly\n consider finding" +
                        " a ride home...");
            }
        }
    }
}
