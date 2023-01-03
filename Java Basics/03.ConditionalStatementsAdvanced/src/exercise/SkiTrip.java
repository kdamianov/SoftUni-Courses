package exercise;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String positiveOrNegative = scanner.nextLine();

        double price = 0;
        double nights = days - 1;

        switch (roomType) {
            case "room for one person":
                price = nights * 18.00;

                break;
            case "apartment":
                if (days < 10) {
                    price = (nights * 25.00) * 0.70;
                } else if (days > 10 && days <=15) {
                    price = (nights * 25.00) * 0.65;
                } else if (days > 15) {
                    price = (nights * 25.00) * 0.50;
                }

                break;
            case "president apartment":
                if (days < 10) {
                    price = (nights * 35.00) * 0.90;
                } else if (days > 10 && days <=15) {
                    price = (nights * 35.00) * 0.85;
                } else if (days > 15) {
                    price = (nights * 35.00) * 0.80;
                }

                break;
        }
        if (positiveOrNegative.equals("positive")) {
            price = price * 1.25;

        } else if (positiveOrNegative.equals("negative")) {
            price = price * 0.90;
        }
        System.out.printf("%.2f", price);
    }
}
