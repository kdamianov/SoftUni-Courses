package exercise;

import java.util.Scanner;

public class LunchBrake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tvShow = scanner.nextLine();
        int showTime = Integer.parseInt(scanner.nextLine());
        int breakInMin = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakInMin / 8.0;
        double timeForRelax = breakInMin / 4.0;
        double remainingTime = breakInMin - lunchTime - timeForRelax;

        double diff = Math.abs(remainingTime - showTime);

        if (remainingTime >= showTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    tvShow, Math.ceil(diff));
        } else System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                tvShow, Math.ceil(diff));

    }
}
