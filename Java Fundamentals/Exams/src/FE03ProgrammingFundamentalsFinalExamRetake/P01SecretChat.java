package FE03ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;
//100 / 100 Judge!!!!
public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String[] instructions = scanner.nextLine().split(":\\|:");
        StringBuilder decryptedMessage = new StringBuilder(message);

        while (!instructions[0].equals("Reveal")) {
            String command = instructions[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(instructions[1]);
                    decryptedMessage.insert(index, " ");
                    message = decryptedMessage.toString();
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = instructions[1];
                    if (message.contains(substring)) {
                        String reversed = new StringBuilder(substring).reverse().toString();
                        int startIndex = decryptedMessage.indexOf(substring);
                        int lastIndex = startIndex + substring.length() ;

                        decryptedMessage = new StringBuilder(message);
                        decryptedMessage.delete(startIndex, lastIndex);
                        decryptedMessage.append(reversed);
                        message = decryptedMessage.toString();

                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toChange = instructions[1];
                    String replacement = instructions[2];

                    message = message.replace(toChange, replacement);
                    decryptedMessage = new StringBuilder(message);
                    System.out.println(message);
                    break;

            }

            instructions = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
