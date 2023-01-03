package exam28And29March2020;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }

        }
        if (count == 2) {
            System.out.println(n + " is a Prime!");
        } else {
            System.out.println("Not a prime");
        }

    }
}
