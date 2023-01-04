package moreEx;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int sum = 0;
        for (Character symbol : text.toCharArray()) {
            if (symbol > one && symbol < two) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
