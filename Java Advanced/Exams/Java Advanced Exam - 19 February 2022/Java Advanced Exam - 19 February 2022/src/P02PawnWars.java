import java.util.Arrays;
import java.util.Scanner;

//Judge 100/100

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] board = new String[8][8];

        int rowW = 0;
        int colW = 0;
        int rowB = 0;
        int colB = 0;

        for (int row = 0; row < board.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = input[col];
                if (input[col].equals("b")) {
                    rowB = row;
                    colB = col;
                }
                if (input[col].equals("w")) {
                    rowW = row;
                    colW = col;
                }
            }
        }
        boolean isHit = false;

        while (rowW != 0 && rowB != 7 && !isHit) {
            if ((rowW - 1) == rowB && (colW + 1 == colB || colW - 1 == colB)) {
                String coordinates = findCoordinates(rowB, colB);
                System.out.printf("Game over! White capture on %s.%n", coordinates);
                isHit = true;
            }
            rowW --;
            if ((rowB + 1) == rowW && (colB + 1 == colW || colB - 1 == colW)) {
                String coordinates = findCoordinates(rowW, colW);
                System.out.printf("Game over! Black capture on %s.%n", coordinates);
                isHit = true;
            }
            rowB ++;
        }
        if (!isHit) {
            if (rowW == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", findCoordinates(rowW, colW));
            }else{
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", findCoordinates(rowB, colB));
            }
        }
    }
    private static String findCoordinates(int pRow, int pCol) {
        String[] col = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] row = new String[]{"8", "7", "6", "5", "4", "3", "2", "1"};
        StringBuilder sb = new StringBuilder();
        sb.append(col[pCol]).append(row[pRow]);
        return sb.toString();
    }
}
