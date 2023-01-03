package moreExercise;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numChrysanthemums = Integer.parseInt(scanner.nextLine());
        int numRoses = Integer.parseInt(scanner.nextLine());
        int numTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double price = 0;

        switch (season) {
            case "Spring":
            case "Summer":
                price = numChrysanthemums * 2.00 + numRoses * 4.10 + numTulips * 2.50;
                if (season.equals("Spring") && numTulips > 7) {
                    price -= price * 0.05;
                }

                break;
            case "Autumn":
            case "Winter":
                price = numChrysanthemums * 3.75 + numRoses * 4.50 + numTulips * 4.15;

                if (season.equals("Winter") && numRoses >= 10) {
                    price -= price * 0.10;
                }
                break;

        }
        if ((numChrysanthemums + numRoses +numTulips) >=20) {
            price -= price * 0.20;
        }
        if (holiday.equals("Y")) {
            price += price * 0.15;
        }
        System.out.printf("%.2f", price + 2);
    }
}
