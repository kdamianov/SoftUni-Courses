package exam16And17April2022;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodInKg = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int ttlFoodInGrams = foodInKg * 1000;
        int eatenFoodInGrams = 0;
        boolean notEnough = false;

        while (!input.equals("Adopted")) {
            int foodInGrams = Integer.parseInt(input);

            eatenFoodInGrams = eatenFoodInGrams + foodInGrams;


            input = scanner.nextLine();

        }
        if (eatenFoodInGrams > ttlFoodInGrams) {
            System.out.printf("Food is not enough. You need %d grams more.", eatenFoodInGrams - ttlFoodInGrams);
        } else {
            System.out.printf("Food is enough! Leftovers: %d grams.", ttlFoodInGrams - eatenFoodInGrams);
        }

    }
}
