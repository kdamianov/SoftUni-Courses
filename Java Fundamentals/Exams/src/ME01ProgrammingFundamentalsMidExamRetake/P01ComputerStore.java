package ME01ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while(!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            sum += price;



            input = scanner.nextLine();
        }
        double taxes = sum * 20 / 100;
        double ttlPrice = sum + taxes;
        if (input.equals("special")) {
            ttlPrice = ttlPrice * 0.90;
        }
        if (ttlPrice > 0) {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", sum, taxes, ttlPrice);
        } else {
            System.out.println("Invalid order!");
        }

    }
}
