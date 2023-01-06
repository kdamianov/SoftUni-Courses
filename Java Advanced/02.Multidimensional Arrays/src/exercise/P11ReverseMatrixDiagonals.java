package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        for (int col = cols - 1; col >= 0; col--) {
            int printedRow = rows;
            for (int printedCol = col; printedCol <= cols -1 && printedRow > 0; printedCol++) {
                    System.out.print(matrix[printedRow - 1][printedCol] + " ");
                    printedRow --;
            }
            System.out.println();
        }
        if (rows >= 2) {
            for (int row = rows - 2; row >= 0 ; row--) {
                int printedRow = row;
                for (int col = 0; col <= row && col < cols; col++) {
                    System.out.print(matrix[printedRow][col] + " ");
                    printedRow --;
                }
                System.out.println();
            }
        }
    }
}
