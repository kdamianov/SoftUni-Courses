package exam15_16June2019;

import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        double ttlPrice = 0;

        for (int i = 1; i <=n ; i++) {
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());

            if (name.equals("Thrones")) {
                price = price * 0.50;
            } else if (name.equals("Lucifer")) {
                price = price * 0.60;
            } else if (name.equals("Protector")) {
                price = price * 0.70;
            } else if (name.equals("TotalDrama")) {
                price = price * 0.80;
            } else if (name.equals("Area")) {
                price = price * 0.90;
            }

            ttlPrice += price;


        }
        if (ttlPrice <= budget) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - ttlPrice);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", ttlPrice - budget);
        }

    }
}
