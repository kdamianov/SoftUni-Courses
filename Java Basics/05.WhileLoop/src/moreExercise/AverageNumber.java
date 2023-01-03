package moreExercise;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double sumN = 0;
        for (int i = 1; i <= n ; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            sumN += number;

        }
        System.out.printf("%.2f", sumN / n );
    }
}
