package FE05ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

//100/100

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawKey = scanner.nextLine();

        String instructions = scanner.nextLine();

        while(!instructions.equals("Generate")) {
            String[] instructionsLine = instructions.split(">>>");
            String command = instructionsLine[0];
            StringBuilder newKey = new StringBuilder(rawKey);

            switch (command) {
                case "Contains":
                //[0]"Contains>>>[1]{substring}"
                    String substring = instructionsLine[1];
                    if (rawKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                //[0]"Flip>>>[1]Upper/Lower>>>[2]{startIndex}>>>[3]{endIndex}"
                    String letterType = instructionsLine[1];
                    int startIndex = Integer.parseInt(instructionsLine[2]);
                    int endIndex = Integer.parseInt(instructionsLine[3]);

                    if (letterType.equals("Upper")) {
                        String currentSubstr = rawKey.substring(startIndex, endIndex);
                        newKey = new StringBuilder(rawKey);
                        newKey.replace(startIndex, endIndex, currentSubstr.toUpperCase());
                        rawKey = newKey.toString();

                        System.out.println(rawKey);
                    }else if (letterType.equals("Lower")) {
                        String currentSubstr = rawKey.substring(startIndex, endIndex);
                        newKey = new StringBuilder(rawKey);
                        newKey.replace(startIndex, endIndex, currentSubstr.toLowerCase());
                        rawKey = newKey.toString();

                        System.out.println(rawKey);
                    }
                    break;
                case "Slice":
                //[0]Slice>>>[1]{startIndex}>>>[2]{endIndex}":
                    int startInd = Integer.parseInt(instructionsLine[1]);
                    int ednInd = Integer.parseInt(instructionsLine[2]);

                    newKey = new StringBuilder(rawKey);
                    newKey.delete(startInd, ednInd);
                    rawKey = newKey.toString();
                    System.out.println(rawKey);
                    break;
            }

            instructions = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", rawKey);
    }
}
