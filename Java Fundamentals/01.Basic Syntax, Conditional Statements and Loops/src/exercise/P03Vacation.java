package exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (group) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45;
                } else if (day.equals("Saturday")) {
                    price = 9.80;
                } else if (day.equals("Sunday")) {
                    price = 10.46;
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90;
                } else if (day.equals("Saturday")) {
                    price = 15.60;
                } else if (day.equals("Sunday")) {
                    price = 16;
                }
                break;
            case "Regular" :
                if (day.equals("Friday")) {
                    price = 15;
                } else if (day.equals("Saturday")) {
                    price = 20;
                } else if (day.equals("Sunday")) {
                    price = 22.50;
                }
                break;
        }
        double ttlPrice = num * price;
        if (group.equals("Students") && num >= 30) {
            ttlPrice = ttlPrice * 0.85;
        } else if (group.equals("Business") && num >=100) {
            ttlPrice = (num - 10) * price;
        } else if (group.equals("Regular") && num >=10 && num <=20) {
            ttlPrice = ttlPrice * 0.95;
        }
        System.out.printf("Total price: %.2f", ttlPrice);
    }
}
