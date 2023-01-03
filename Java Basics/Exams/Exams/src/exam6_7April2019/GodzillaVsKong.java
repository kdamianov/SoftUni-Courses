package exam6_7April2019;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double clothesPerPerson = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;

        if (statists > 150) {
            clothesPerPerson = clothesPerPerson * 0.90;
        }
        double ttlClothes = statists * clothesPerPerson;

        double ttlAmount = decor + ttlClothes;

        if (ttlAmount > budget) {
            System.out.printf("Not enough money!%n" +
                    "Wingard needs %.2f leva more.", ttlAmount - budget);
        } else {
            System.out.printf("Action!%n" +
                    "Wingard starts filming with %.2f leva left.", budget - ttlAmount);
        }
    }
}
