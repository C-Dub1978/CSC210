/**
 * This program performs numerous calculations for road trip planning such as:
 * gas cost calculation, time needed for trip
 */

import java.util.Scanner;

/**
 * @Author Chris Wilson
 * @Version 1.0
 */
public class WilsonTripCalculator {

    public static void main(String[] args) {
        double gasCost = 2.99d;
        double avgSpeed = 50.5d;
        int restBreak = 18;

        System.out.println("This program will help plan for travel costs for your trips");
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter your car's tank capacity:");
        double tankCapacity = input.nextDouble();
        System.out.println("Please enter the average miles per gallon your car gets:");
        double avgMpg = input.nextDouble();
        System.out.println("Please enter the distance you will be traveling:");
        int distance = input.nextInt();

        double gallonsNeeded = distance / avgMpg;
        double milesPerTank = tankCapacity * avgMpg;
        double totalCost = gallonsNeeded * gasCost;
        double hours = distance / avgSpeed;
        int numStopsRequired = (int) (gallonsNeeded / (tankCapacity - 2));
        double numOfTanks = Math.floor(distance / milesPerTank);
        double totalTime = (((numOfTanks * 18) / 60) + hours);

        String tankStr = "Car's tank capacity of: ";
        String avgStr = "Car's average mileage of: ";
        String distStr = "Distance to destination: ";
        String gasStr = "Gas cost for trip: ";
        String timeStr = "Time needed for trip: ";

        System.out.println("Trip Calculator");
        System.out.println();
        System.out.println("For a car trip with");
        System.out.printf("\t"  + "%-30s" + "%20.1f gallons", tankStr, tankCapacity);
        System.out.println();
        System.out.printf("\t" + "%-30s" + "%20.1f miles per gallon", avgStr, avgMpg);
        System.out.println();
        System.out.printf("\t" + "%-30s" + "%20d miles", distStr, distance);
        System.out.println();
        System.out.println();
        System.out.printf("%-50s" + "$%.2f dollars", gasStr, totalCost);
        System.out.println();
        System.out.printf("%-50s" + "%.1f hours", timeStr, totalTime);
        System.out.println();
    }
}
