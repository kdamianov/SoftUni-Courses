package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        String rotationNumberString = rotation.split("[()]")[1];
        int rotationNumber = Integer.parseInt(rotationNumberString);
        int rotationAngle = rotationNumber % 360;
        String input = scanner.nextLine();

        List<String> wordList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while(!input.equals("END")) {
            wordList.add(input);

            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }
        int rows = wordList.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                }else {
                    matrix[row][col] = ' ';
                }
            }
        }
        //НАЧИНИ ЗА ЧЕТЕНЕ НА МАТРИЦИ!!!

        //from top to bottom --> row ++
        //from bottom to top --> row --
        //from left to right --> col ++
        //from right to left --> col --
        switch (rotationAngle) {
            case 0:
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int c = 0; c < cols; c++) {
                    for (int r = rows - 1; r >= 0; r--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int r = rows - 1; r >=0 ; r--) {
                    for (int c = cols - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int c = cols - 1; c >= 0; c--) {
                    for (int r = 0; r < rows; r++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
