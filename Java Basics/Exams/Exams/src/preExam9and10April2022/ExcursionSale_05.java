package preExam9and10April2022;

import java.util.Scanner;

public class ExcursionSale_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seaVacation = Integer.parseInt(scanner.nextLine());
        int mountainVacation = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int seaPrice = 680;
        int mountainPrice = 499;
        int totalPrice = 0;

        while (!input.equals("Stop")) {

            if (input.equals("sea")) {
                if (seaVacation == 0) {
                    input = scanner.nextLine();
                    continue;
                }
                seaVacation--;
                totalPrice += seaPrice;
            } else if (input.equals("mountain")) {
                mountainVacation--;
                totalPrice += mountainPrice;
                if (mountainVacation == 0) {
                    input = scanner.nextLine();
                    continue;
                }
            }
            if (seaVacation == 0 && mountainVacation == 0) {
                break;
            }

            input = scanner.nextLine();

        }
        if (seaVacation == 0 && mountainVacation == 0) {
            System.out.println("Good job! Everything is sold.");
        }
        System.out.printf("Profit: %d leva.", totalPrice);
    }
}