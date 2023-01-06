import java.util.Scanner;

//Judge 100/100  Формула 1 е подобна!!!!!!!!!!

public class P02Python {
    static int food = 0;
    static int length = 1;
    static int pRow = 0;
    static int pCol = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 's'){
                    pRow = row;
                    pCol = col;
                }
            }
            for (char c : matrix[row]) {
                if (c == 'f'){
                    food++;
                }
            }
        }
        for (String command : commands) {
            if (command.equals("up")){
                movePython(matrix, pRow - 1, pCol);
            } else if (command.equals("down")) {
                movePython(matrix, pRow + 1, pCol);
            } else if (command.equals("left")) {
                movePython(matrix, pRow, pCol - 1);
            } else if (command.equals("right")) {
                movePython(matrix, pRow, pCol + 1);
            }

            if (length == -1 || food == 0) {
                break;
            }
        }

        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        }else if (food > 0 && length != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        }else {
            System.out.println("You lose! Killed by an enemy!");
        }

    }

    private static void movePython(char[][] matrix,int newRow, int newCol) {
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipSnakeSide(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        if (matrix[newRow][newCol] == 'e') {
            length = -1;
        } else if (matrix[newRow][newCol] == 'f'){
            length++;
            food--;
        }

        pRow = newRow;
        pCol = newCol;
    }

    private static int[] flipSnakeSide(int length, int r, int c) {
        int[] result = new int[2];
        if (r < 0) {
            result[0] = length - 1;
            result[1] = c;
        }else if (r >= length) {
            result[1] = c;
        }else if (c < 0) {
            result[0] = r;
            result[1] = length -1;
        }else{
            result[0] = r;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix.length;
    }
}
