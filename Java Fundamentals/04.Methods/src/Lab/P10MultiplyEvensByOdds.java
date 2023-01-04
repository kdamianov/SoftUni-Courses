package Lab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultOfEvenAndOdds(number));
    }
    public static int getEvenSum (int n) {
        int evenSum = 0;
        int digit = 0;
        while (n !=0) {
            digit = n % 10;
            if (digit % 2 == 0) {
                evenSum += Math.abs(digit);
            }
            n /= 10;
        }
        return evenSum;
    }
    public static int getOddSum (int n) {
        int oddSum = 0;
        int digit = 0;
        while (n != 0) {
            digit = n % 10;
            if (digit % 2 != 0) {
                oddSum += Math.abs(digit);
            }
            n /= 10;
        }
        return oddSum;
    }
    public static int getMultOfEvenAndOdds (int n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);

        return evenSum * oddSum;
    }
}
