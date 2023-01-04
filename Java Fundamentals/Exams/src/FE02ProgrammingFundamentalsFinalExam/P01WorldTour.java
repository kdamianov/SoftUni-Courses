package FE02ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
//100/100 в JUDGE!!!


public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String commandInput = scanner.nextLine();

        StringBuilder tour = new StringBuilder(stops);
        while(!commandInput.equals("Travel")) {
            String[]commandLine = commandInput.split(":");
            String command = commandLine[0];

            switch (command) {
                case "Add Stop":
                //"[0]Add Stop:[1]{index}:[2]{string}":
                    int index = Integer.parseInt(commandLine[1]);
                    String newStopString = commandLine[2];
                    if (index >= 0 && index < tour.length()) {
                        tour.insert(index, newStopString);
                    }
                    System.out.println(tour);
                    break;
                case "Remove Stop":
                //[0]"Remove Stop:[1]{start_index}:[2]{end_index}":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);
                    if (startIndex >= 0 && startIndex < tour.length() && endIndex >=0 && endIndex < tour.length()) {
                        tour.delete(startIndex, endIndex +1);
                    }
                    System.out.println(tour);
                    break;
                case "Switch":
                    //[0]"Switch:[1]{old_string}:[2]{new_string}":
                    String oldString = commandLine[1];
                    String newString = commandLine[2];
                    if (stops.contains(oldString)) {
                        stops = tour.toString().replace(oldString, newString);
                        tour = new StringBuilder(stops);
                    //tour.replace(tour.indexOf(oldString), tour.indexOf(oldString) + oldString.length(), newString);
                    }
                    System.out.println(tour);
                    break;
            }

            commandInput = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", tour);
    }
}
