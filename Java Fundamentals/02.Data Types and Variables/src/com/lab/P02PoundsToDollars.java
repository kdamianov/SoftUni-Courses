package com.company;

import java.util.Scanner;

public class P02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float britishPound = Float.parseFloat(scanner.nextLine());

        float usDollar = britishPound * 1.36f;

        System.out.printf("%.3f", usDollar);
    }
}
