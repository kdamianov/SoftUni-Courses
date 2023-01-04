package Exercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);

        getCharsInRange(one, two);

    }
    private static void getCharsInRange (char first, char second) {
        if (first < second) {
            for (int i = (char) (first + 1); i < second; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = (char) second + 1; i < first; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
