package com.company;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countOpenBracket = 0;
        int countCloseBracket = 0;
        boolean isBalanced = true;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                countOpenBracket ++;
            } else if (input.equals(")")) {
                countCloseBracket ++;
                if (countOpenBracket - countCloseBracket !=0) {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (countOpenBracket == countCloseBracket) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
