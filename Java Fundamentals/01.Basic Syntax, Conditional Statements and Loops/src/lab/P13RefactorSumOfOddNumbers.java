package lab;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class P13RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());;
        int sum = 0;

        for (int i = 0; i <= 2 * n; i++) {
            if (i % 2 !=0) {
                sum = sum + i;
                System.out.println(i);
            }
        }
        System.out.printf("Sum: %d%n", sum);

    }

}
