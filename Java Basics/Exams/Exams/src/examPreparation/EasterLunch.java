package examPreparation;

import java.util.Scanner;

public class EasterLunch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sweetBreadCount = Integer.parseInt(scanner.nextLine());
        int eggsCount = Integer.parseInt(scanner.nextLine());
        int cookiesKg = Integer.parseInt(scanner.nextLine());

        double priceSweetBread = sweetBreadCount * 3.20;
        double eggsPrice = eggsCount * 4.35;
        double cookiesPrice = cookiesKg * 5.40;
        double eggsPaint = eggsCount * 12 * 0.15;

        double totalPrice = priceSweetBread + eggsPrice + cookiesPrice + eggsPaint;

        System.out.printf("%.2f", totalPrice);


    }
}
