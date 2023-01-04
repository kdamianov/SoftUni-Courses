package FE01ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;
//100/100 в JUDGE!!!
public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String commandInput = scanner.nextLine();
        StringBuilder decodedMessage = new StringBuilder(encryptedMessage);

        while (!commandInput.equals("Decode")) {
            String[] commandLine = commandInput.split("\\|");
            String command = commandLine[0];

            switch (command) {
                case "Move":
                //[0]]"Move [1]{number of letters}":
                    int numLetters = Integer.parseInt(commandLine[1]);
                    String substr = decodedMessage.substring(0, numLetters);
                    decodedMessage.delete(0, substr.length());
                    decodedMessage.append(substr);
                    break;
                    //int nLetters = Integer.parseInt(token[1]);
                    //String subStr = decryptedMessage.substring(0, nLetters);
                    //decryptedMessage.delete(0, subStr.length());
                    //decryptedMessage.append(subStr);

                case "Insert":
                //[0]"Insert [1]{index} [2]{value}":
                    int index = Integer.parseInt(commandLine[1]);
                    String value = commandLine[2];
                    decodedMessage.insert(index, value);
                    break;
                    //int index = Integer.parseInt(token[1]);
                    //String value = token[2];
                    //decryptedMessage.insert(index, value);

                case "ChangeAll":
                //[0]"ChangeAll [1]{substring} [2]{replacement}":
                    String substring = commandLine[1];
                    String replacement = commandLine[2];
                    if (encryptedMessage.contains(substring)) {
                    encryptedMessage = decodedMessage.toString().replace(substring, replacement);
                    decodedMessage = new StringBuilder(encryptedMessage);
                    }
                    break;
                    //String substring = token[1];
                    //String replacement = token[2];
                    //if (message.contains(substring)) {
                    //  message = decryptedMessage.toString().replace(substring, replacement);
                    //  decryptedMessage = new StringBuilder(message);
                    //  break;
                }
            encryptedMessage = decodedMessage.toString();
            commandInput = scanner.nextLine();
            }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
