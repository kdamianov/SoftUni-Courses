package exercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String typeVacation = "";

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                typeVacation = "Camp";
                budget = budget * 0.30;

            } else if (season.equals("winter")) {
                budget = budget * 0.70;
                typeVacation = "Hotel";
            }

        } else if (budget > 100 && budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                budget = budget * 0.40;
                typeVacation = "Camp";
            } else if (season.equals("winter")) {
                budget = budget * 0.80;
                typeVacation = "Hotel";
            }
        } else if (budget > 1000) {
            destination = "Europe";
            budget = budget * 0.90;
            typeVacation = "Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", typeVacation, budget);

    }
}
