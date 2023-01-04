package moreExercise;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – Цена за килограм зеленчуци – реално число[0.00… 1000.00]
        double priceVeg = Double.parseDouble(scanner.nextLine());
        //•	Втори ред – Цена за килограм плодове – реално число[0.00… 1000.00]
        double priceFr = Double.parseDouble(scanner.nextLine());
        //•	Трети ред – Общо килограми на зеленчуците – цяло число[0… 1000]
        int vegKg = Integer.parseInt(scanner.nextLine());
        //•	Четвърти ред – Общо килограми на плодовете – цяло число[0… 1000]
        int frKg = Integer.parseInt(scanner.nextLine());

        double ttl = ((priceVeg * vegKg) + (priceFr * frKg)) / 1.94;

        System.out.printf("%.2f", ttl);

    }
}
