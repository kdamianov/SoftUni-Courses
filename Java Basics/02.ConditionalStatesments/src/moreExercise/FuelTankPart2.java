import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Типа на горивото – текст с възможности: "Gas", "Gasoline" или "Diesel"
        String fuelType = scanner.nextLine();
        //•	Количество гориво – реално число в интервала [1.00 … 50.00]
        double fuelIn = Double.parseDouble(scanner.nextLine());
        //•	Притежание на клубна карта – текст с възможности: "Yes" или "No"
        String clubCard = scanner.nextLine();

        double finalPrice = 0;

        switch (fuelType) {
            case "Gas":
                finalPrice = fuelIn * 0.93;
                if (clubCard.equals("Yes")) {
                    finalPrice = fuelIn * (0.85);
                }
                break;
            case "Gasoline":
                finalPrice = fuelIn * 2.22;
                if (clubCard.equals("Yes")) {
                    finalPrice = fuelIn * 2.04;
                }
                break;
            case "Diesel":
                finalPrice = fuelIn * 2.33;
                if (clubCard.equals("Yes")) {
                    finalPrice = fuelIn * 2.21;
                }
                break;
        }
        if (fuelIn > 20 && fuelIn <= 25) {
            finalPrice -= finalPrice * 0.08;
        } else if (fuelIn > 25) {
            finalPrice -= finalPrice * 0.10;
        }
        System.out.printf("%.2f lv.", finalPrice);

    }
}
