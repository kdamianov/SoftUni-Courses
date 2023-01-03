package exam16And17April2022;

import java.util.Scanner;

public class CatFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCats = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        double ttlFood = 0;

        for (int i = 1; i <= numCats; i++) {
            double foodInGrams = Double.parseDouble(scanner.nextLine());

            if (foodInGrams >= 100 && foodInGrams < 200) {
                group1 ++;
            } else if (foodInGrams >= 200 && foodInGrams < 300) {
                group2 ++;
            } else if (foodInGrams >= 300 && foodInGrams < 400) {
                group3 ++;
            }

            ttlFood = ttlFood + foodInGrams;


        }
        double ttlFoodInKg = ttlFood / 1000;
        double foodPrice = ttlFoodInKg * 12.45;

        System.out.printf("Group 1: %d cats.%n" +
                "Group 2: %d cats.%n" +
                "Group 3: %d cats.%n" +
                "Price for food per day: %.2f lv.", group1, group2, group3, foodPrice);

    }
}
