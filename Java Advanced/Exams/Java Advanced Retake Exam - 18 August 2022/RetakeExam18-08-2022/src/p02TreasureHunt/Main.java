package p02TreasureHunt;

import java.util.*;

//Judge 87 / 100

public class Main {
    public static int playerRow; //не се променят през цялата програма
    public static int playerCol;
    public static List<String> moves = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] map = new String[rows][cols];

        fillMatrix(scanner, rows, map);

        findPlayerPosition(rows, cols, map);

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            if (command.equals("up")) {
                movePlayer(map, -1, 0, "up");
            } else if (command.equals("down")) {
                movePlayer(map, 1, 0, "down");
            } else if (command.equals("left")) {
                movePlayer(map, 0, -1, "left");
            } else if (command.equals("right")) {
                movePlayer(map, 0, 1, "right");
            }
            command = scanner.nextLine();
        }
        if (map[playerRow][playerCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s%n", String.join(", ", moves));
        } else {
            System.out.println("The map is fake!");
        }

    }

    private static void findPlayerPosition(int rows, int cols, String[][] map) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col].equals("Y")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] map) {
        for (int row = 0; row < rows; row++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            map[row] = rowInput;
        }
    }
    private static boolean isOutOfBounds(String[][] map, int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[r].length;
    }
    public static void movePlayer (String[][] map, int rowChanger, int colChanger, String command) {
        int nextRow = playerRow + rowChanger;
        int nextCol = playerCol + colChanger;

        if (isOutOfBounds(map, nextRow, nextCol)) {
            nextRow = playerRow;
            nextCol = playerCol;
        } else if (map[nextRow][nextCol].equals("T")) {
            nextRow = playerRow;
            nextCol = playerCol;
        } else {
            moves.add(command);
        }
        playerRow = nextRow;
        playerCol = nextCol;
    }
}

