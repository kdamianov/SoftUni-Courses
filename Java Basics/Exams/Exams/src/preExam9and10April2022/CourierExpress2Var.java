package preExam9and10April2022;

import java.util.Scanner;

public class CourierExpress2Var {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double packWeight = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int distance = Integer.parseInt(scanner.nextLine());

        double pricePerKm = 0;

        switch (type) {
            case "standard":
                if (packWeight < 1) {
                    pricePerKm = 0.03;
                } else if (packWeight < 10) {
                    pricePerKm = 0.05;
                } else if (packWeight < 40) {
                    pricePerKm = 0.10;
                }else if (packWeight < 90) {
                    pricePerKm = 0.15;
                } else if (packWeight < 150) {
                    pricePerKm = 0.20;
                }
                break;
            case "express":
                if (packWeight < 1) {
                    pricePerKm = 0.03 * 0.80 * packWeight + 0.03;
                } else if (packWeight < 10) {
                    pricePerKm = 0.05 * 0.40 * packWeight + 0.05;
                } else if (packWeight < 40) {
                    pricePerKm = 0.10 * 0.05 * packWeight + 0.10;
                }else if (packWeight < 90) {
                    pricePerKm = 0.15 * 0.02 * packWeight + 0.15;
                } else if (packWeight < 150) {
                    pricePerKm = 0.20 * 0.02 * packWeight + 0.20;
                }
                break;
        }
        double totalPrice = pricePerKm * distance;

        System.out.printf("The delivery of your shipment with " +
                "weight of %.3f. would cost %.2f lv.", packWeight, totalPrice);
    }
}
