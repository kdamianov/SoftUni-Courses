package exam28And29March2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodInKg = Integer.parseInt(scanner.nextLine());
        int foodInGr = foodInKg * 1000;
        String input = scanner.nextLine();
        int ttlFoodEaten = 0;
        while (!input.equals("Adopted")) {
            int foodEatenInGr = Integer.parseInt(input);

            ttlFoodEaten += foodEatenInGr;

            input = scanner.nextLine();

        }
        if (ttlFoodEaten <= foodInGr) {
            System.out.printf("Food is enough! Leftovers: %d grams.", foodInGr - ttlFoodEaten);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", ttlFoodEaten - foodInGr);
        }


    }
}
