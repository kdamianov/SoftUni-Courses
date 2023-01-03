package moreExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
        double budget = Double.parseDouble(scanner.nextLine());
        //•	Втори ред –  Сезон – текст "Summer" или "Winter"
        String season = scanner.nextLine();

        String accommodation = "";
        String location = "";

        if (budget <= 1000) {
            accommodation = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    budget = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    budget = budget * 0.45;
                    break;
            }
        } else if (budget <= 3000) {
            accommodation = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    budget = budget * 0.80;
                    break;
                case "Winter":
                    location = "Morocco";
                    budget = budget * 0.60;
                    break;
            }
        } else if (budget > 3000) {
            accommodation = "Hotel";
            budget = budget * 0.90;
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    break;
                case "Winter":
                    location = "Morocco";
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", location, accommodation, budget);
    }
}
