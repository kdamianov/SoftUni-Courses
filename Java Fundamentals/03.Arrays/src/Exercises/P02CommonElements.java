package Exercises;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a program, which prints common elements in two arrays.
        // You have to compare the elements of the second array to the elements of the first.

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String second : secondArr) {
            for (String first : firstArr) {
                if (second.equals(first)) {
                    System.out.print(second + " ");
                }
            }
        }
        
    }
}
