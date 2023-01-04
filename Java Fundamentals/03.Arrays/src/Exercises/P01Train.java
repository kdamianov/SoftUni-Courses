package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[n];
        int sumPeople = 0;
        for (int i = 0; i < n; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
            sumPeople += wagons[i];
            System.out.print(wagons[i] + " ");
        }
        System.out.println();
        System.out.println(sumPeople);
    }
}
