package exam28And29March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numDays = Integer.parseInt(scanner.nextLine());

        double ttlFood = Double.parseDouble(scanner.nextLine());

        int ttlEatenDogFood = 0;
        int ttlEatenCatFood = 0;
        double ttlEatenFood = 0;
        double ttlBiscuits = 0;

        for (int i = 1; i <= numDays; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());

            ttlEatenDogFood += dogFood;
            ttlEatenCatFood += catFood;
            ttlEatenFood += dogFood + catFood;

            if (i % 3 == 0) {
                double biscuits = (dogFood + catFood) * 0.10;
                ttlBiscuits += biscuits;
            }



        }
        System.out.printf("Total eaten biscuits: %.0fgr.%n" +
                "%.2f%% of the food has been eaten.%n" +
                "%.2f%% eaten from the dog.%n" +
                "%.2f%% eaten from the cat.",
                ttlBiscuits, ttlEatenFood / ttlFood * 100, ttlEatenDogFood / ttlEatenFood * 100,
                ttlEatenCatFood / ttlEatenFood * 100);

    }
}
