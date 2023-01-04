package Exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int --> convert to string
        String input = scanner.nextLine();

        while (!input.equals("END")) {


            System.out.println(reversed(input));


            input = scanner.nextLine();
        }
    }
    private static String reversed (String text) {
        String reversed = "";
        String output = "";
        for (int i = text.length() - 1; i >=0 ; i--) {
            reversed += text.charAt(i);
            if (reversed.equals(text)) {
                output = "true";
            } else {
                output = "false";
            }
        }
        return output;
    }

}
