package moreExercise;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double result = 0;
        double to9 = 0;
        double to19 = 0;
        double to29 = 0;
        double to39 = 0;
        double to50 = 0;
        double invalid = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (num >= 0 && num <=9) {
                result += num * 0.2;
                to9 ++;

            } else if (num>= 10 && num <= 19) {
                result += num * 0.3;
                to19 ++;

            } else if (num>= 20 && num <= 29) {
                result += num * 0.4;
                to29 ++;

            } else if (num>= 30 && num <= 39) {
                result += 50;
                to39 ++;

            } else if (num >= 40 && num <= 50) {
                result += 100;
                to50 ++;

            } else {
                result = result * 1.0 / 2;
                invalid ++;

            }
            result = result++;
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", to9 / n * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", to19 / n * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", to29 / n * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", to39 / n * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", to50 / n * 100);
        System.out.printf("Invalid numbers: %.2f%%%n", invalid / n * 100);
    }
}
