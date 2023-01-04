package exercise;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Брой пакети химикали
        int penPack = Integer.parseInt(scanner.nextLine());
        //•	Брой пакети маркери
        int markerPack = Integer.parseInt(scanner.nextLine());
        //•	Литри препарат
        int cleaningLiquid = Integer.parseInt(scanner.nextLine());
        //•	Процент намаление
        int discountPercent = Integer.parseInt(scanner.nextLine());

        double totalPrice = (penPack * 5.80) + (markerPack * 7.20) + (cleaningLiquid * 1.20);

        double discountPrice = totalPrice - (totalPrice * discountPercent / 100);


        System.out.println(discountPrice);



    }
}
