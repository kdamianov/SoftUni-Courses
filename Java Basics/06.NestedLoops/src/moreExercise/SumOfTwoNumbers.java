package moreExercise;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int combination = 0;
        int ttlComb = 0;
        boolean combFound = false;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                combination++;
                ttlComb++;
                if (magicNum == i + j) {
                    combFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, i, j, magicNum);
                }

                } if (combFound) {
                break;
                }
        } if (!combFound) {
            System.out.printf("%d combinations - neither equals %d", ttlComb, magicNum);
        }
    }
}
