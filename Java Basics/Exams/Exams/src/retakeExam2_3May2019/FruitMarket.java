package retakeExam2_3May2019;

import java.util.Scanner;

public class FruitMarket {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        double strawberryPrice = Double.parseDouble(scanner.nextLine());
        double bananasInKilos = Double.parseDouble(scanner.nextLine());
        double orangesInKilos = Double.parseDouble(scanner.nextLine());
        double raspberriesInKilos = Double.parseDouble(scanner.nextLine());
        double strawberriesInKilos = Double.parseDouble(scanner.nextLine());

        double raspberryPrice = strawberryPrice / 2;
        double orangePrice = raspberryPrice * 0.60;
        double bananaPrice = raspberryPrice * 0.20;

        double money = strawberriesInKilos * strawberryPrice + bananasInKilos * bananaPrice +
                orangesInKilos * orangePrice + raspberriesInKilos * raspberryPrice;

        System.out.printf("%.2f", money);

    }
}
