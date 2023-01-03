package exam6And7July2019;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int numDrinks = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (drink) {
            case"Espresso":
                switch (sugar) {
                    case "Without":
                        price = 0.90;
                        break;
                    case "Normal":
                        price = 1;
                        break;
                    case "Extra":
                        price = 1.20;
                        break;
                }

                break;
            case "Cappuccino":
                switch (sugar) {
                    case "Without":
                        price = 1;
                        break;
                    case "Normal":
                        price = 1.20;
                        break;
                    case "Extra":
                        price = 1.60;
                        break;
                }

                break;
            case "Tea":
                switch (sugar) {
                    case "Without":
                        price = 0.50;
                        break;
                    case "Normal":
                        price = 0.60;
                        break;
                    case "Extra":
                        price = 0.70;
                        break;
                }

                break;
        }
        double ttlPrice = price * numDrinks;

        if (sugar.equals("Without")) {
            ttlPrice = ttlPrice * 0.65;
        }
        if (drink.equals("Espresso") && numDrinks >= 5) {
            ttlPrice = ttlPrice * 0.75;
        }
        if (ttlPrice > 15) {
            ttlPrice = ttlPrice * 0.80;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.", numDrinks, drink, ttlPrice);


    }
}
