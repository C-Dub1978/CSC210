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
        double baseMetabolicRate = 0.0D;
        // ternary logic, if gender is set to 'm', use first assignment, if it's
        // female or space character, default to female rate
        baseMetabolicRate = gender == ('m') ? MALE_METABOLIC_RATE :
                FEMALE_METABOLIC_RATE;
        // adjust depending on the switch parameter value
        switch(type) {
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
        if(last.length() < 7) {
            last = last + X.substring(0, 0 + (ID_LENGTH - last.length()));
        }
        drinkerId = last.toUpperCase();
        System.out.println(drinkerId);
    }
}
