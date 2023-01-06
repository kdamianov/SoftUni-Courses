import java.util.Scanner;

// Judge 90/100
public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandCounts = Integer.parseInt(scanner.nextLine());

        char[][] track = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;
        for (int row = 0; row < size; row++) {
            track[row] = scanner. nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (track[row][col] == 'P'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        for (int i = 0; i < commandCounts; i++) {
            String command = scanner.nextLine();
                int currentPlayerRow = playerRow;
                int currentPlayerCol = playerCol;

                if (track[playerRow][playerCol] != 'T' && track[playerRow][playerCol] != 'B') {
                    track[playerRow][playerCol] = '.';
                }

                switch (command) {
                    case "up":
                        if (playerRow > 0) {
                            playerRow--;
                        } else {
                            playerRow = size - 1;
                        }
                        break;
                    case "down":
                        if (playerRow < size - 1) {
                            playerRow++;
                        } else {
                            playerRow = 0;
                        }
                        break;
                    case "left":
                        if (playerCol > 0) {
                            playerCol--;
                        } else {
                            playerCol = size - 1;
                        }
                        break;
                    case "right":
                        if (playerCol < size - 1) {
                            playerCol++;
                        } else {
                            playerCol = 0;
                        }
                        break;
                }
                if (track[playerRow][playerCol] == 'B') {
                    if (command.equals("up")) {
                        playerRow--;
                    }else if (command.equals("down")) {
                        playerRow++;
                    }else if (command.equals("left")) {
                        playerCol--;
                    }else if (command.equals("right")) {
                        playerCol++;
                    }
                }
                if (track[playerRow][playerCol] == 'T') {
                    playerRow = currentPlayerRow;
                    playerCol = currentPlayerCol;
                }
                if ((track[playerRow][playerCol] == 'F')) {
                    track[playerRow][playerCol] = 'P';
                    System.out.println("Well done, the player won first place!");
                    printTrack(size, track);
                    return;
                }
                track[playerRow][playerCol] = 'P';
        }
        System.out.println("Oh no, the player got lost on the track!");
        printTrack(size, track);
    }
    private static void printTrack(int size, char[][] track) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(track[row][col]);
            }
            System.out.println();
        }
    }
}
