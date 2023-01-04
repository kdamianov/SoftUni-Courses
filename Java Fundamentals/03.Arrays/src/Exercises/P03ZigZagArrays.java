package Exercises;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 1; i <= n ; i++) {
            String[] line = scanner.nextLine().split(" ");

            if ( i % 2 != 0) {
                firstArr[i-1] = line[0];
                secondArr[i-1] = line[1];
            } else {
                firstArr[i-1] = line[1];
                secondArr[i-1] = line[0];
            }
        }
        for (String element : firstArr) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (String element : secondArr) {
            System.out.print(element + " ");
        }
    }
}
