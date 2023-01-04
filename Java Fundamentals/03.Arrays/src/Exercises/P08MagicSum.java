package Exercises;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= array.length- 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                int sum = array[i] + array[j];
                int first = array[i];
                int second = array[j];
                if (sum == n) {
                    System.out.printf("%d %d%n", first, second);
                }
            }
        }
    }
}
