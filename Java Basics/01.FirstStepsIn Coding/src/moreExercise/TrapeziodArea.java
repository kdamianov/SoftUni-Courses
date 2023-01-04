package moreExercise;

import java.util.Scanner;

public class TrapeziodArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //чете от конзолата три числа b1, b2 и h
        double b1 = Double.parseDouble(scanner.nextLine());

        double b2 = Double.parseDouble(scanner.nextLine());

        double h = Double.parseDouble(scanner.nextLine());

        //Формулата за лице на трапец е (b1 + b2) * h / 2.0
        double formula = (b1 + b2) * h / 2.0;

        System.out.printf("%.2f", formula);

    }
}

