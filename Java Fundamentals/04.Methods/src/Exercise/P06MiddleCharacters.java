package Exercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleChar(text);
    }
    private static void printMiddleChar (String text) {
        if (text.length() % 2 != 0){
            int indexOfMiddleChar = text.length() / 2;
            System.out.println(text.charAt(indexOfMiddleChar));
        }else {
            int indexOfFirstMidChar = text.length() / 2 - 1;
            int indexOfSecondMidChar = text.length() / 2;
            System.out.println(text.charAt(indexOfFirstMidChar) + "" + text.charAt(indexOfSecondMidChar));
        }
    }
}
