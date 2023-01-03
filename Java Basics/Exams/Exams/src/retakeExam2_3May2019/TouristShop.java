package retakeExam2_3May2019;

import java.util.Scanner;

public class TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();
        int productCount = 0;
        double productSum = 0;
        double lastProduct = 0;
        boolean notEnough = false;

        while (!command.equals("Stop")) {
            String productName = command;
            productCount++;
            double productPrice = Double.parseDouble(scanner.nextLine());

            if (productCount % 3 ==0) {
                productPrice = productPrice / 2;
            }
            lastProduct = productPrice;


            if (productPrice > budget) {
                notEnough = true;
                break;
            }
            budget = budget - productPrice;
            productSum = productSum + productPrice;

            command = scanner.nextLine();
        }
        if (notEnough) {
            System.out.printf("You don't have enough money!%n" +
                    "You need %.2f leva!", lastProduct - budget);
        } else {
            System.out.printf("You bought %d products for %.2f leva.", productCount, productSum);
        }


    }
}
