package preExam9and10April2022;

import java.util.Scanner;

public class ExcursionSaleVar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seaVac = Integer.parseInt(scanner.nextLine());
        int mountainVac = Integer.parseInt(scanner.nextLine());

        double ttlPrice = 0;
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String type = input;
            if (type.equals("sea")) {
                if (seaVac == 0) {
                    input = scanner.nextLine();
                    continue;
                }
                seaVac--;
                ttlPrice = ttlPrice + 680;
            } else if (type.equals("mountain")) {
                if (mountainVac == 0) {
                    input = scanner.nextLine();
                    continue;
                }
                mountainVac--;
                ttlPrice = ttlPrice + 499;
            }
            if (seaVac == 0 && mountainVac == 0) {
                System.out.println("Good job! Everything is sold.");
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Profit: %.0f leva.", ttlPrice);
    }
}
