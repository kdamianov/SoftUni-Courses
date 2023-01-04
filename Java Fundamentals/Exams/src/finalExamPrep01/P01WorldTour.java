package finalExamPrep01;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine(); //всички спирки
        String command = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);//създаваме StringBuilder, тк има повече функционалности

        while (!command.equals("Travel")) {
            if (command.contains("Add Stop")) {
                //•	"Add Stop:[1]{index}:[2]{String}":
                int index = Integer.parseInt(command.split(":")[1]);
                String stopName = command.split(":")[2];
                //Insert the given string at that index ONLY IF the index is valid!!!
                if (isValidIndex(index, stopsBuilder)) {
                    stopsBuilder.insert(index, stopName);
                }
            }else if (command.contains("Remove Stop")) {
                //•	"Remove Stop:[1]{start_index}:[2]{end_index}":
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }
            }else if (command.contains("Switch")) {
                //•	"Switch:[1]{old_string}:[2]{new_string}":
                //IF the old string is in the initial string, replace it with the new one (all occurrences)!!
                String oldText = command.split(":")[1];
                String newText = command.split(":")[2];
                if (stops.toString().contains(oldText)) {
                    String updatedText = stopsBuilder.toString().replace(oldText, newText);
                    stopsBuilder = new StringBuilder(updatedText);
                }
            }

            System.out.println(stopsBuilder);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stopsBuilder);

    }
    //метод, който валидира индекс в stopsBuilder
    public static boolean isValidIndex (int index, StringBuilder builder) {
        return index >= 0 && index <= builder.length() - 1;
    }
}
