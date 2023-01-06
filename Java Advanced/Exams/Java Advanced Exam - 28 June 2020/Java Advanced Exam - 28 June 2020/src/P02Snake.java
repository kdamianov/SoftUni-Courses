import java.util.Scanner;

//Judge 100/100

public class P02Snake {
    static int food;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[n][n];
        int snakeRow = 0;
        int snakeCol = 0;



        for (int r = 0; r < n; r++) {
            territory[r] = scanner.nextLine().toCharArray();
            for (int c = 0; c < n; c++) {
                if (territory[r][c] == 'S') {
                    snakeRow = r;
                    snakeCol = c;
                }
            }
        }
        boolean isIn = true;

        while (food < 10) {

            String command = scanner.nextLine();

            territory[snakeRow][snakeCol] = '.';

            if (command.equals("up")) {
                snakeRow --;
            } else if (command.equals("down")) {
                snakeRow++;
            } else if (command.equals("left")) {
                snakeCol--;
            }else if (command.equals("right")) {
                snakeCol++;
            }

            if (isOut(n, snakeRow, snakeCol)) {
                isIn = false;
                break;
            }

            if (territory[snakeRow][snakeCol] == '*') {
                food++;
            }
            if (territory[snakeRow][snakeCol] == 'B') {
                territory[snakeRow][snakeCol] = '.';
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (territory[r][c] == 'B') {
                            snakeRow = r;
                            snakeCol = c;
                        }
                    }
                }
            }

            territory[snakeRow][snakeCol] = 'S';
        }
        if (isIn) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", food);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(territory[r][c]);
            }
            System.out.println();
        }

    }
    private static boolean isOut(int n, int snakeRow, int snakeCol) {
        return snakeRow < 0 || snakeRow > n - 1 || snakeCol < 0 || snakeCol > n - 1;
    }
}
