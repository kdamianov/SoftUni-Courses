package exam18And19July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = Double.parseDouble(scanner.nextLine());
        double kilograms = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int numLuggage = Integer.parseInt(scanner.nextLine());
        double luggagePrice = 0;


        if (kilograms < 10) {
            luggagePrice = price * 0.20;
        }else if (kilograms <= 20) {
            luggagePrice = price * 0.50;
        }else {
            luggagePrice = price;
        }

        if (days < 7) {
            luggagePrice = luggagePrice * 1.40;
        } else if (days <= 30) {
            luggagePrice = luggagePrice * 1.15;
        } else {
            luggagePrice = luggagePrice * 1.10;
        }

        double ttl = luggagePrice * numLuggage;

        System.out.printf("The total price of bags is: %.2f lv. ", ttl);
    }
}
