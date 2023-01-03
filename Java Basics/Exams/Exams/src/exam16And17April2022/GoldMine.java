package exam16And17April2022;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLocations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numLocations; i++) {
            double expectedAvgYield = Double.parseDouble(scanner.nextLine());
            int numDays = Integer.parseInt(scanner.nextLine());

            double ttlGoldMined = 0;
            double realAvgYield = 0;

            for (int j = 1; j <= numDays; j++) {
                double minedGoldPerDay = Double.parseDouble(scanner.nextLine());
                ttlGoldMined += minedGoldPerDay;
                realAvgYield = ttlGoldMined / numDays;
            }

            if (realAvgYield >= expectedAvgYield) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", realAvgYield);
            } else {
                System.out.printf("You need %.2f gold.%n", expectedAvgYield - realAvgYield);
            }
        }
    }
}
