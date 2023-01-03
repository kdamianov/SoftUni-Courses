package moreExercise;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double two = 0;
        double three = 0;
        double four = 0;
        double five = 0;
        double ttlGrades = 0;

        for (int i = 1; i <= n ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >=2 && grade <= 2.99) {
                two ++;
            } else if (grade <= 3.99) {
                three ++;
            } else if (grade <= 4.99) {
                four ++;
            } else {
                five ++;
            }
            ttlGrades += grade;


        }
        System.out.printf("Top students: %.2f%%%n", five / n * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", four / n * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", three / n * 100);
        System.out.printf("Fail: %.2f%%%n", two / n * 100);
        System.out.printf("Average: %.2f", ttlGrades / n);
    }
}
