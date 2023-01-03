package exercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double excursionPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());


        int toys = puzzles + dolls + teddyBears + minions + trucks;

        double ttlPrice = 2.60 * puzzles + 3 * dolls + 4.10 * teddyBears + 8.20 * minions + 2 * trucks;
        double endPrice = ttlPrice;

        if (toys >= 50) {
            endPrice = ttlPrice - ttlPrice * 0.25;
        }

        double netProfit = endPrice - endPrice * 0.10;
        double moneyLeft = Math.abs(netProfit - excursionPrice);

        if (netProfit >= excursionPrice) {
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", moneyLeft);
        }
    }
}
