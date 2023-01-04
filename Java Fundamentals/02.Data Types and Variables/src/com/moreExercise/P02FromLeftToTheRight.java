package com.company;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=lines ; i++) {
            long one = scanner.nextLong();
            long two = scanner.nextLong();

            long sum = 0;

            if (one > two) {
                long numberOne = Math.abs(one);
                while (numberOne > 0) {
                    sum += (numberOne % 10);
                    numberOne /= 10;
                }
            } else {
                long numberTwo = Math.abs(two);
                while (numberTwo > 0) {
                    sum += (numberTwo % 10);
                    numberTwo /= 10;
                }
            }
            System.out.println(sum);
        }
    }
}
