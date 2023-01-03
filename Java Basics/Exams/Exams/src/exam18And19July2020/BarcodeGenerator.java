package exam18And19July2020;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialNum = Integer.parseInt(scanner.nextLine());
        int finalNum = Integer.parseInt(scanner.nextLine());

        String init = String.valueOf(initialNum);
        String last = String.valueOf(finalNum);

        for (int i = init.charAt(0); i <= last.charAt(0); i++) {
            for (int j = init.charAt(1); j <= last.charAt(1); j++) {
                for (int k = init.charAt(2); k <= last.charAt(2); k++) {
                    for (int l = init.charAt(3); l <= last.charAt(3); l++) {
                        if (i%2!=0 && j%2!=0 && k%2!=0 && l%2!=0)

                            System.out.printf("%c%c%c%c ", i, j, k ,l);
                    }
                }
            }
        }

    }
}
