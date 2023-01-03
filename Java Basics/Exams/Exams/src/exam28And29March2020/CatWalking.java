package exam28And29March2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minWalk = Integer.parseInt(scanner.nextLine());
        int numWalk = Integer.parseInt(scanner.nextLine());
        int calsDay = Integer.parseInt(scanner.nextLine());

        int calsWalk = minWalk * 5;
        int ttlCals = numWalk * calsWalk;

        if (ttlCals >= calsDay / 2) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", ttlCals);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", ttlCals);
        }


    }

}
