package exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String text = "";

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            switch (command) {
                case "1":
                    stack.push(text);
                    text = text.concat(commandLine[1]);
                    break;
                case "2":
                    stack.push(text);
                    int arg = Integer.parseInt(commandLine[1]);
                    text = text.substring(0, text.length()-arg);
                    break;
                case "3":
                    int index = Integer.parseInt(commandLine[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }

}
