package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String commandInput = scanner.nextLine();

        while(!commandInput.equals("END")) {
            String[] commandLine = commandInput.split("\\s+");
            if (commandLine.length != 5) {
                System.out.println("Invalid input!");
                commandInput = scanner.nextLine();
                continue;
            }
            String command = commandLine[0];
            int rowOne = Integer.parseInt(commandLine[1]);
            int colOne = Integer.parseInt(commandLine[2]);
            int rowTwo = Integer.parseInt(commandLine[3]);
            int colTwo = Integer.parseInt(commandLine[4]);

            if (command.equals("swap") && commandLine.length == 5 &&
                    rowOne >= 0 &&
                    rowOne < rows &&
                    colOne >= 0 &&
                    colOne < cols &&
                    rowTwo >= 0 &&
                    rowTwo < rows &&
                    colTwo >= 0 &&
                    colTwo < cols) {
               String firstElement =  matrix[rowOne][colOne];
               String secondElement = matrix[rowTwo][colTwo];
               matrix[rowTwo][colTwo] = firstElement;
               matrix[rowOne][colOne] = secondElement;

               for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
               }
            } else {
                System.out.println("Invalid input!");
            }
            commandInput = scanner.nextLine();
        }
        System.out.println();
    }
}
