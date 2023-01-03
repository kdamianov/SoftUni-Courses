package moreExercise;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
        double budget = Double.parseDouble(scanner.nextLine());
        //•	Втори ред –  Сезон – текст "Summer" или "Winter"
        String season = scanner.nextLine();

        String carClass = "";
        String carType = "";

        if (budget <= 100) {
            carClass = "Economy class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                budget = budget * 0.35;
            } else if (season.equals("Winter")) {
                carType = "Jeep";
                budget = budget * 0.65;
            }
        } else if (budget <= 500) {
            carClass = "Compact class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                budget = budget * 0.45;
            } else if (season.equals("Winter")) {
                carType = "Jeep";
                budget = budget * 0.80;
            }
        } else if (budget > 500) {
            carClass = "Luxury class";
            carType = "Jeep";
            budget = budget * 0.90;
        }
        System.out.printf("%s%n%s - %.2f", carClass, carType, budget);
    }
}
