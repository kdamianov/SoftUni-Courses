package exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 1 ;
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillMatrixPatternA(counter, n, matrix);
            printMatrix(n, matrix);
        } else {
            fillMatrixPatterB(counter, n, matrix);
            printMatrix(n, matrix);
        }







    }

    private static void fillMatrixPatterB(int counter, int n, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int counter, int n, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void printMatrix(int n, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
