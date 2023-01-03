package exam6And7July2019;

import java.util.Scanner;

public class PoolDay {

    public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        double taxPrice = Double.parseDouble(scanner.nextLine());
        double sunbedTax = Double.parseDouble(scanner.nextLine());
        double umbrellaTax = Double.parseDouble(scanner.nextLine());

        double ttlTax = numPeople * taxPrice;
        double ttlSunbed = Math.ceil(numPeople * 0.75) * sunbedTax;
        double ttlUmbrella = Math.ceil(numPeople * 0.50) * umbrellaTax;

        double finalPrice = ttlTax + ttlSunbed + ttlUmbrella;

        System.out.printf("%.2f lv.", finalPrice);
    }
}
