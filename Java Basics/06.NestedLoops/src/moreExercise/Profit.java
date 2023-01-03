package moreExercise;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int coins1lev = Integer.parseInt(scanner.nextLine());
        int coins2leva = Integer.parseInt(scanner.nextLine());
        int bills5leva = Integer.parseInt(scanner.nextLine());
        int moneyAmmount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= coins1lev ; i++) {
            for (int j = 0; j <= coins2leva; j++) {
                for (int k = 0; k <= bills5leva ; k++) {
                    if (i + j * 2 + k * 5 == moneyAmmount) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, moneyAmmount);
                    }
                }
            }
        }
    }
}
