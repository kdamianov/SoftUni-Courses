package exam16And17April2022;

import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fanName = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int beerBottles = Integer.parseInt(scanner.nextLine());
        int chipsPacks = Integer.parseInt(scanner.nextLine());

        double ttlBeersPrice = beerBottles * 1.20;
        double chipsPrice = ttlBeersPrice * 0.45;
        double ttlChipsPrice = Math.ceil(chipsPrice * chipsPacks);

        double ttlAmount = ttlBeersPrice + ttlChipsPrice;

        if (budget >= ttlAmount) {
            System.out.printf("%s bought a snack and has %.2f leva left.", fanName, budget - ttlAmount);
        } else {
            System.out.printf("%s needs %.2f more leva!", fanName, ttlAmount - budget);
        }


    }
}
