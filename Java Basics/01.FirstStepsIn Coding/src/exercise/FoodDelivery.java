package exercise;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //broi pileshki menuta
        int chickenMenu = Integer.parseInt(scanner.nextLine());
        //broi ribni menuta
        int fishMenu = Integer.parseInt(scanner.nextLine());
        //broi vegetarianski menuta
        int vegetarianMenu = Integer.parseInt(scanner.nextLine());

        //•	Пилешко меню –  10.35 лв.
        double chickenPrice = chickenMenu * 10.35;

        //•	Меню с риба – 12.40 лв.
        double fishPrice = fishMenu * 12.40;

        //•	Вегетарианско меню  – 8.15 лв
        double vegetarianPrice = vegetarianMenu * 8.15;

        double priceAllMenus = chickenPrice + fishPrice + vegetarianPrice;

        double priceDessert = priceAllMenus * 0.20;

        double totalPrice = priceAllMenus + priceDessert + 2.50;

        System.out.printf("%.2f", totalPrice);






    }
}
