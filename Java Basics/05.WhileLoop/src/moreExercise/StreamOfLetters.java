package moreExercise;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();

        int countC = 0;
        int countO = 0;
        int countN = 0;
        String word = "";

        while (!letter.equals("End")) {
            char letterChar = letter.charAt(0);

            if (letterChar < 65 || letterChar >90 && letterChar < 97 || letterChar > 122) {
                letter = scanner.nextLine();
                continue;
            }

            if (letter.equals("c")) {
                countC++;
                if (countC >1) {
                    word = word + letter;
                }

            } else if (letter.equals("n")) {
                countN++;
                if (countN > 1) {
                    word = word + letter;
                }
            } else if (letter.equals("o")) {
                countO++;
                if (countO > 1) {
                    word = word + letter;
                }
            } else {
                word = word + letter;
            }

            if (countC >= 1 && countN >= 1 && countO >=1) {
                word = word + " ";
                System.out.print(word);
                word = "";
                countC = 0;
                countN = 0;
                countO = 0;
            }

            letter = scanner.nextLine();
        }
    }
}
