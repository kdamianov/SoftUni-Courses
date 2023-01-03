package exam18And19July2020;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price = 0;


        switch (type) {
            case "90X130":
                price = 110;
                if (count > 30 && count <= 60) {
                    price = price * 0.95;
                } else if (count > 60) {
                    price = price * 0.92;
                }
                break;
            case "100X150":
                price = 140;
                if (count > 40 && count <= 80) {
                    price = price * 0.94;
                } else if (count > 80) {
                    price = price * 0.90;
                }
                break;
            case "130X180":
                price = 190;
                if (count > 20 && count <= 50) {
                    price = price * 0.93;
                } else if (count > 50) {
                    price = price * 0.88;
                }
                break;
            case "200X300":
                price = 250;
                if (count > 25 && count <= 50) {
                    price = price * 0.91;
                } else if (count > 50) {
                    price = price * 0.86;
                }
                break;
        }
        double finalPrice = price * count;
        if (delivery.equals("With delivery")) {
            finalPrice = finalPrice + 60;
        }
        if (count > 99) {
            finalPrice = finalPrice * 0.96;
        }


        if (count < 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", finalPrice);
        }
    }
}
