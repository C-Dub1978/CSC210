import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by klown on 6/8/17.
 */
public class BACCalculator {
    public static void main(String[] args) {
        describeProgram();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter drinker's last name: ");
        String last = scanner.next();
        System.out.println("Enter drinker's gender (M for male, F for female)" +
                ":");
        String gender = scanner.next();
        gender.toUpperCase();
        // check the above string for M or F, then set the char value
        System.out.println("Enter the drinker's height (in whole inches): ");
        int height = scanner.nextInt();
        System.out.println("Enter the drinker's weight (in whole pounds): ");
        int weight = scanner.nextInt();
        System.out.println("Enter number of drinks consumed: ");
        int drinks = scanner.nextInt();
        System.out.println("Enter number of hours since first drinks: ");
        int hours = scanner.nextInt();
        System.out.println();
        System.out.println("Metabolism type choices -");
        System.out.println("\tV - Very slow metabolism");
        System.out.println("\tS - Slow metabolism");
        System.out.println("\tA - Average metabolism");
        System.out.println("\tF - Fast metabolism");
        System.out.println("Please select the drinker's metabolism type: ");
        String type = scanner.next();
        type.toUpperCase();
        System.out.println();
        System.out.println();

        char metabolic;
        if(type.equals("V")) {
            metabolic = 'V';
        } else if(type.equals("S")) {
            metabolic = 'S';
        } else if(type.equals("A")) {
            metabolic = 'A';
        } else if(type.equals("F")) {
            metabolic = 'F';
        } else {
            metabolic = 'A';
        }

        char genderChar;
        if(gender.equals("M")) {
            genderChar = 'M';
        } else if(gender.equals("F")) {
            genderChar = 'F';
        } else {
            genderChar = 'M';
        }

        Drinker drinker = new Drinker(last, genderChar, weight, height, drinks, hours, metabolic);
        drinker.calculateCurrentBAC();
        drinker.analyzeBAC();
    }

    /**
     * Program description method, simply states what will be done
     */
    public static void describeProgram() {
        System.out.println("This program will calculate and show current BAC");
        System.out.print("Based upon height, weight, and gender, drinks, and " +
                "hours,");
        System.out.println(" the program will calculate BAC at this time:");
        System.out.println();
    }
}
