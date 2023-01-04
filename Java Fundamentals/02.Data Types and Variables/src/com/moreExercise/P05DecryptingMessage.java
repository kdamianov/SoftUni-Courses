package com.company;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < lines; i++) {
            char symbol = scanner.nextLine().charAt(0);
            char message = (char) (symbol + key);
            System.out.print(message);
        }
    }
}
