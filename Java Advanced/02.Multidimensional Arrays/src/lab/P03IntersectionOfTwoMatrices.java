package lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRow = Integer.parseInt(scanner.nextLine());
        int matrixCol = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[matrixRow][matrixCol];
        for (int r = 0; r < matrixRow; r++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int c = 0; c < matrixCol; c++) {
                firstMatrix[r][c] = rowInput[c].charAt(0);
            }
        }
        char[][] secondMatrix = new char[matrixRow][matrixCol];
        for (int r = 0; r < matrixRow; r++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int c = 0; c < matrixCol; c++) {
                secondMatrix[r][c] = rowInput[c].charAt(0);
            }
        }

        for (int r = 0; r < matrixRow; r++) {
            for (int c = 0; c < matrixCol; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c]) {
                    System.out.print(firstMatrix[r][c] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
