package exam6And7July2019;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double nightPrice = Double.parseDouble(scanner.nextLine());
        int addExpenses = Integer.parseInt(scanner.nextLine());


        if (nights > 7) {
            nightPrice = nightPrice * 0.95;
        }

        double ttlNightsPrice = nights * nightPrice;
        double addExpensesSum = budget * addExpenses / 100;

        double ttlExpenses = ttlNightsPrice + addExpensesSum;

        if (ttlExpenses <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - ttlExpenses);
        } else {
            System.out.printf("%.2f leva needed.", ttlExpenses - budget);
        }


    }
}



