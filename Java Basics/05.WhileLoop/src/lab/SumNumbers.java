package lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initNum = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        while (sum < initNum) {
            int currentNum = Integer.parseInt(scanner.nextLine());

            sum += currentNum;
        }
        System.out.printf("%d", sum);
    }
}
