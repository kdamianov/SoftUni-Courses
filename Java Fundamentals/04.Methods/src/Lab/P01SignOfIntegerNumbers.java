package Lab;

import java.util.Scanner;

public class P01SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printNumberSign(num);

    }
    public static void printNumberSign(int num) {
        if (num > 0) {
            System.out.printf("The number %d is positive.", num);
        } else if (num <0) {
            System.out.printf("The number %d is negative.", num);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }
}
