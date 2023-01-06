package lab;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(info[0]);
        int columns = Integer.parseInt(info[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(", ");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
            }
        }
        int sum = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                sum += matrix[r][c];
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
