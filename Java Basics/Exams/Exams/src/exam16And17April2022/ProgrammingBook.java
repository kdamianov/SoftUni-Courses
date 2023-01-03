package exam16And17April2022;

import java.util.Scanner;

public class ProgrammingBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pagePrice = Double.parseDouble(scanner.nextLine());
        double coverPrice = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());
        double designerTax = Double.parseDouble(scanner.nextLine());
        int teamAmmountPercent = Integer.parseInt(scanner.nextLine());


        double initPrice = pagePrice * 899 + coverPrice * 2;
        double discountPrice = initPrice - (initPrice * discountPercent / 100);
        double ttlPrice = discountPrice + designerTax;
        double finalPrice = ttlPrice - (ttlPrice * teamAmmountPercent / 100);

        System.out.printf("Avtonom should pay %.2f BGN.", finalPrice);


    }
}
