package com.company;

import java.util.Scanner;

public class P04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Town Sofia has population of 1286383 and area 492 square km.

        String town = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        String result = String.format("Town %s has population of " +
                "%d and area %d square km.", town, population, area);

        System.out.println(result);
    }
}
