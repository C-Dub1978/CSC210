import java.util.Scanner;

/**
 * Created by klown on 6/11/17.
 */
public class InvestmentComparison {
    public static void main(String[] args) {
        getInitialInvestment();
        Investment i = new Investment(5555.55, 5.5, 5, 'm');

    }

    public static double getInitialInvestment() {
        Scanner input = new Scanner(System.in);
        double investment;
        do{
            System.out.println("Please enter an initial investment amount " +
                    "greater than 1: ");
            while(!input.hasNextDouble()) {
                System.out.println("Error, invalid input. Please enter an" +
                        " investment amount greater than 1: ");
                input.next();
            }
            investment = input.nextDouble();
            if(investment < 1) {
                System.out.println("Error, investment amount too small");
            }
        } while(investment < 1);
        return investment;
    }
}
