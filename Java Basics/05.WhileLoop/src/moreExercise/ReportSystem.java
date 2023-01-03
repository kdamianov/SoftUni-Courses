package moreExercise;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int ccCount = 0;
        int csCount = 0;
        double ccPayment = 0;
        double csPayment = 0;
        int paymentCount = 0;
        String command = scanner.nextLine();

        boolean enough = false;

        while (!command.equals("End")) {
            double productPrice = Double.parseDouble(command);

            paymentCount++;
            if (paymentCount % 2 ==0) {
                if (productPrice < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");

                    ccCount++;
                    ccPayment = ccPayment + productPrice;
                }


            } else {
                if (productPrice > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");

                    csCount++;
                    csPayment = csPayment + productPrice;
                }

            }
            double collectedMoney = ccPayment + csPayment;

            if (collectedMoney >= money) {
                enough = true;
                break;
            }

            command = scanner.nextLine();


        }
        if (enough) {
            System.out.printf("Average CS: %.2f%n" +
                    "Average CC: %.2f", csPayment / csCount, ccPayment / ccCount);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }

    }
}
