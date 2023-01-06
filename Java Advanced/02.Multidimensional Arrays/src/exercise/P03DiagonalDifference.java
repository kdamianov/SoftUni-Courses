package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            int[] rowInput = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowInput;
        }
        int mainDiagonal = 0;
        for (int index = 0; index < size; index++) {
            mainDiagonal += matrix[index][index];
        }

        
        int secondaryDiagonal = 0;
        for (int row = size - 1, col = 0; row >= 0 && col < size; row--, col ++) {
            secondaryDiagonal += matrix[row][col];
        }
        System.out.println(Math.abs(secondaryDiagonal - mainDiagonal));
    }
}
