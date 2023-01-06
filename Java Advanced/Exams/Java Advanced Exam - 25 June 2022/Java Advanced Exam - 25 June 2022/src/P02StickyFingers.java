import java.util.Arrays;
import java.util.Scanner;


//Judge: 100/100


public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fields = Integer.parseInt(scanner.nextLine());

        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[fields][fields];

        for (int i = 0; i < fields; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        int rowD = 0;
        int colD = 0;
        for (int row = 0; row < fields; row++) {
            for (int col = 0; col < fields; col++) {
                if (matrix[row][col].equals("D")) {
                    rowD = row;
                    colD = col;
                }
            }
        }

        String nextPosition = null;
        int stolenMoney = 0;
        boolean isCaught = false;

        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
                case "up":
                    if (rowD - 1 >= 0) {
                        matrix[rowD][colD] = "+";
                        rowD--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (rowD + 1 < matrix.length) {
                        matrix[rowD][colD] = "+";
                        rowD++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (colD + 1 < matrix.length) {
                        matrix[rowD][colD] = "+";
                        colD++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (colD - 1 >= 0) {
                        matrix[rowD][colD] = "+";
                        colD--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            if (matrix[rowD][colD].equals("$")) {
                System.out.printf("You successfully stole %d$.%n", rowD * colD);
                stolenMoney += rowD * colD;
            } else if (matrix[rowD][colD].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                matrix[rowD][colD] = "#";
                printMatrix(matrix);
                return;
            }
            matrix[rowD][colD] = "D";
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] field : matrix) {
                System.out.println(String.join(" ", field));
        }
    }
}
