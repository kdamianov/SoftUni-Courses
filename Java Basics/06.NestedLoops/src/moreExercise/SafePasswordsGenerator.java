package moreExercise;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxNumPasswords = Integer.parseInt(scanner.nextLine());

        char A = '#';
        char B = '@';
        int countPasswords = 0;
        boolean stop = false;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                countPasswords++;
                if (countPasswords > maxNumPasswords) {
                    stop = true;
                    break;
                }
                System.out.printf("%c%c%d%d%c%c|", A, B, i, j, B, A);
                A++;
                B++;


                if (A > 55) {
                    A = 35;
                }
                if (B > 96) {
                    B = 64;
                }
            }

        }
    }
}
