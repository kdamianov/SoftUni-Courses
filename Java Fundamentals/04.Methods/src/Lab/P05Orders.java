package Lab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (product) {
            case "coffee":
                price = 1.50;
                calculatePrice(quantity, price);
                break;
            case "water":
                price = 1.00;
                calculatePrice(quantity, price);
                break;
            case "coke":
                price = 1.40;
                calculatePrice(quantity, price);
                break;
            case "snacks":
                price = 2.00;
                calculatePrice(quantity, price);
                break;

        }

    }
    public static void calculatePrice(int count, double singlePrice) {
        double finalPrice = count * singlePrice;
        System.out.printf("%.2f", finalPrice);
    }

}
