package finalExam07Aug22;

import java.util.Scanner;

public class P01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String commandInput = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);

        while(!commandInput.equals("Finish")) {
            String[] tokens = commandInput.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Replace":
                    //	"Replace {currentChar} {newChar}"
                    String current = tokens[1];
                    String replacement = tokens[2];
                    text = text.replace(current, replacement);
                    System.out.println(text);
                    break;
                case "Cut":
                    //"Cut [1]{startIndex} [2]{endIndex}"
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >=0 && startIndex < text.length() && endIndex >= 0 && endIndex < text.length()) {
                        String substring = text.substring(startIndex, endIndex + 1);
                        text = text.replace(substring, "");
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make": //Upper ot Lower
                    //"Make {Upper/Lower}"
                    String upperOrLower = tokens[1];
                    if (upperOrLower.contains("Upper")) {
                        text = text.toUpperCase();
                        System.out.println(text);
                    }else if (upperOrLower.contains("Lower")) {
                        text = text.toLowerCase();
                        System.out.println(text);
                    }
                    break;
                case "Check":
                    //"Check {string}"
                    String toCheck = tokens[1];
                    if (text.contains(toCheck)) {
                        System.out.printf("Message contains %s%n", toCheck);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", toCheck);
                    }
                    break;
                case "Sum":
                    //"Sum [1]{startIndex} [2]{endIndex}"
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    if (start >=0 && start < text.length() && end >= 0 && end < text.length()) {
                        String sumChars = text.substring(start, end + 1);
                        int sum = 0;
                        for (char symbol : sumChars.toCharArray()) {
                            sum += symbol;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

            }

            commandInput = scanner.nextLine();
        }
    }

}
