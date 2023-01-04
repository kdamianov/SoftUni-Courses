package com.company;

import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double one = Double.parseDouble(scanner.nextLine());
        double two = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;
        double result = Math.abs(one - two);

        if (result < eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }
}
