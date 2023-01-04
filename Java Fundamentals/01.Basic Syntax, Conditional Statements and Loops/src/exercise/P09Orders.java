package exercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double ttlSum = 0;
        for (int i = 1; i <= orders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            double sum = pricePerCapsule * days * capsuleCount;
            System.out.printf("The price for the coffee is: $%.2f%n", sum);
            ttlSum +=sum;
        }
        System.out.printf("Total: $%.2f", ttlSum);
    }
}
