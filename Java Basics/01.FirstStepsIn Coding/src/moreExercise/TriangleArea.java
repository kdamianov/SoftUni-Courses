package moreExercise;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        //area = a * h / 2

        double area = (a * h) / 2.0;

        System.out.printf("%.2f", area);

    }
}
