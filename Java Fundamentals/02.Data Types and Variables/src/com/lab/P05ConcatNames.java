package com.company;

import javax.print.DocFlavor;
import java.util.Scanner;

public class P05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimeter = scanner.nextLine();

        System.out.println(firstName + delimeter + secondName);
    }
}
