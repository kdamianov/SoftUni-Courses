package moreExercise;

import java.util.Scanner;

public class SecretDoorLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int ones = Integer.parseInt(scanner.nextLine());

        boolean isNotPrime = false;

        for (int i = 2; i <= hundreds; i=i +2) {
            for (int j = 1; j <=tens ; j++) {
                isNotPrime = false;
                for (int del = 2; del <= j-1; del++) {
                    if (j % del == 0) {
                        isNotPrime = true;
                    }
                } if (!isNotPrime && j!=1) {
                    for (int k = 2; k <=ones ; k = k + 2) {
                        System.out.printf("%d %d %d%n", i, j ,k);

                    }
                }
            }
        }
    }
}
//for (int j = 1; j <= n2; j++) {
//                isNotPrime = false;
//                for (int del = 2; del <= j - 1; del++) {
//                    if (j % del == 0) {
//                        isNotPrime = true;
//                        break;
//                    }
//                }
//                if (!isNotPrime && j != 1) {