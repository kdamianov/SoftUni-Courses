package moreExercise;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.next().charAt(0);
        char last = scanner.next().charAt(0);
        char excluded = scanner.next().charAt(0);

        int validComb = 0;

        for (int i = first; i <= last ; i++) {
            for (int j = first; j <= last; j++) {
                for (int k = first; k <= last; k++) {
                    if (i != excluded && j != excluded && k != excluded){
                        validComb++;
                        System.out.printf("%c%c%c ", i, j, k);
                    }
                }
            }
        }
        System.out.println(validComb);
    }
}
