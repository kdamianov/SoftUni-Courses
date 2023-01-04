package Exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            if (isSumDigitsDivisibleBy8(number) && isHoldingOddDigit(number))
            System.out.println(number);
        }


    }
    //•	Its sum of digits is divisible by 8, e.g. 8, 16, 88 --> true
    private static boolean isSumDigitsDivisibleBy8 (int number) {
        int sumDigits = 0;
        while (number > 0) {
            int lastDigit = number % 10;

            sumDigits +=lastDigit;

            number = number / 10;
        }
        return sumDigits % 8 == 0;
    }
    //•	Holds at least one odd digit, e.g. 232, 707, 87578. --> true
    private static boolean isHoldingOddDigit (int number) {
        while (number > 0) {
            int lastDigit = number % 10;

            if (lastDigit % 2 == 1) {
                return true;
            }

            number /= 10;
        }
        return false;
    }
}
