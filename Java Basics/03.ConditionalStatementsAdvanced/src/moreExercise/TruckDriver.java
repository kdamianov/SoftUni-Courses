package moreExercise;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – Сезон – текст "Spring", "Summer", "Autumn" или "Winter"
        String season = scanner.nextLine();
        //•	Втори ред –  Километри на месец – реално число в интервала [10.00...20000.00]
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double wage = 0;

        if (kmPerMonth <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    wage = 0.75;
                    break;
                case "Summer":
                    wage = 0.90;
                    break;
                case "Winter":
                    wage = 1.05;
                    break;
            }
        } else if (kmPerMonth <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    wage = 0.95;
                    break;
                case "Summer":
                    wage = 1.10;
                    break;
                case "Winter":
                    wage = 1.25;
                    break;
            }
        } else if (kmPerMonth <= 20000) {
            wage = 1.45;
        }
        System.out.printf("%.2f", ((kmPerMonth * wage) * 4) * 0.90);
    }
}
