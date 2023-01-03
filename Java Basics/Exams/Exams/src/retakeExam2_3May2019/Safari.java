package retakeExam2_3May2019;

import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuelNeeded = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();

        double fuel = fuelNeeded * 2.10;

        double totalPrice = fuel + 100;

        if (day.equals("Saturday")) {
            totalPrice = totalPrice * 0.90;
        } else if (day.equals("Sunday")) {
            totalPrice = totalPrice * 0.80;
        }

        if (budget >= totalPrice) {
            System.out.printf("Safari time! Money left: %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", totalPrice - budget);
        }
    }
}
