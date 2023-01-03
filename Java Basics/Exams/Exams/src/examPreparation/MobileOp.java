package examPreparation;

import java.util.Scanner;

public class MobileOp {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        String duration = scanner.nextLine();
        String type = scanner.nextLine();
        String mobileInternet = scanner.nextLine();
        int month = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (type) {
            case "Small":
                if (duration.equals("one")) {
                    price = 9.98;
                }else if (duration.equals("two")) {
                    price = 8.58;
                }
                break;
            case "Middle":
                if (duration.equals("one")) {
                    price = 18.99;
                }else if (duration.equals("two")) {
                    price = 17.09;
                }
                break;
            case "Large":
                if (duration.equals("one")) {
                    price = 25.98;
                }else if (duration.equals("two")) {
                    price = 23.59;
                }
                break;
            case "ExtraLarge":
                if (duration.equals("one")) {
                    price = 35.99;
                }else if (duration.equals("two")) {
                    price = 31.79;
                }
                break;
        }
        if (mobileInternet.equals("yes")) {
            if (price <= 10) {
                price = price + 5.50;
            } else if (price <= 30) {
                price = price + 4.35;
            } else {
                price = price + 3.85;
            }
        }

        double ttlPrice = price * month;

        if (duration.equals("two")) {
            ttlPrice = ttlPrice - (ttlPrice * 0.0375);
        }
        System.out.printf("%.2f lv.", ttlPrice);
    }
}
