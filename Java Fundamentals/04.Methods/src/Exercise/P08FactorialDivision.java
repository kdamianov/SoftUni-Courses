package Exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long factOne = calculateFactorialNumber(num1);
        long factTwo = calculateFactorialNumber(num2);
        double result = factOne * 1.0 / factTwo;

        System.out.printf("%.2f", result);

    }
    public static long calculateFactorialNumber (int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
