package exam6And7July2019;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        String packageType = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        boolean isPositive = false;
        boolean invalidInput = false;

        double price = 0;

        switch (city) {
            case "Bansko":
            case "Borovets":
                switch (packageType){
                    case "withEquipment":
                        price = 100;
                        if (vip.equals("yes"))
                            price = price * 0.90;
                        break;
                    case "noEquipment":
                        price = 80;
                        if (vip.equals("yes"))
                            price = price * 0.95;
                        break;
                    default:
                        invalidInput = true;
                        break;

                }
                break;
            case "Varna":
            case "Burgas":
                switch (packageType){
                    case "withBreakfast":
                        price = 130;
                        if (vip.equals("yes"))
                            price = price * 0.88;
                        break;
                    case "noBreakfast":
                        price = 100;
                        if (vip.equals("yes"))
                            price = price * 0.93;
                        break;
                    default:
                        invalidInput = true;
                        break;
                }
                break;
            default:
                invalidInput = true;
                break;
        }
        if (days > 7) {
            days = days - 1;
        }
        double ttlPrice = price * days;

        if (days<1) {
            isPositive = true;
            System.out.println("Days must be positive number!");
        } else if (invalidInput){
            System.out.println("Invalid input!");
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", ttlPrice);
        }
    }
}
