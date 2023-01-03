package exercise;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int numOfFishermen = Integer.parseInt(scanner.nextLine());

        double shipPrice = 0;

        switch (season) {
            case "Spring":
                shipPrice = 3000;
                break;
            case "Summer":
            case "Autumn":
                shipPrice = 4200;
                break;
            case "Winter":
                shipPrice = 2600;
                break;

        }
        if (numOfFishermen <= 6) {
            shipPrice = shipPrice * 0.90;
        } else if (numOfFishermen > 7 && numOfFishermen <= 11) {
            shipPrice = shipPrice * 0.85;
        } else if (numOfFishermen > 12) {
            shipPrice = shipPrice * 0.75;
        }

        if (numOfFishermen % 2 ==0 && !(season.equals("Autumn"))) {
            shipPrice = shipPrice * 0.95;
        }
        double diff = Math.abs(shipPrice - budget);

        if (budget >= shipPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
