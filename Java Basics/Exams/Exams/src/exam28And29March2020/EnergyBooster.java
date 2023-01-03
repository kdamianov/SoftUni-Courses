package exam28And29March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String set = scanner.nextLine();
        int numSets = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (fruit) {
            case "Watermelon":
                if (set.equals("small")) {
                    price = numSets * 56 * 2;
                } else {
                    price = numSets * 28.70 * 5;
                }
                break;
            case "Mango":
                if (set.equals("small")) {
                    price = numSets * 36.66 * 2;
                } else {
                    price = numSets * 19.60 * 5;
                }
                break;
            case "Pineapple":
                if (set.equals("small")) {
                    price = numSets * 42.10 * 2;
                } else {
                    price = numSets * 24.80 * 5;
                }
                break;
            case "Raspberry":
                if (set.equals("small")) {
                    price = numSets * 20 * 2;
                } else {
                    price = numSets * 15.20 * 5;
                }
                break;
        }
        if (price <= 1000 && price > 400) {
            price = price * 0.85;
        } else if (price > 1000) {
            price = price * 0.50;
        }
        System.out.printf("%.2f lv.", price);

    }
}
