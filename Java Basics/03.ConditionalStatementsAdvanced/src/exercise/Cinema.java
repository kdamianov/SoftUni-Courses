package exercise;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double income = 0.0;
//•	Premiere – премиерна прожекция, на цена 12.00 лева.
//•	Normal – стандартна прожекция, на цена 7.50 лева.
//•	Discount – прожекция за деца, ученици и студенти на намалена цена от 5.00 лева.
        switch (projection) {
            case "Premiere":
                income = rows * columns * 12.00;
                break;
            case "Normal":
                income = rows * columns * 7.50;
                break;
            case "Discount":
                income = rows * columns * 5.00;
                break;

        }
        System.out.printf("%.2f leva", income);
    }
}
