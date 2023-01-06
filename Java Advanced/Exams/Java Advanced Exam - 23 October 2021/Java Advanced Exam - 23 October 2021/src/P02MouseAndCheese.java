import java.util.Scanner;

//judge 100/100

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int mouseRow = 0;
        int mouseCol = 0;
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        int eatenCheese = 0;

        while (!command.equals("end")) {
            matrix[mouseRow][mouseCol] = "-";

            if (command.equals("up") && mouseRow != 0) {
                mouseRow--;
            }else if (command.equals("down") && mouseRow != size - 1) {
                mouseRow++;
            }else if (command.equals("left") && mouseCol != 0) {
                mouseCol--;
            }else if (command.equals("right") && mouseCol != size - 1) {
                mouseCol++;
            }else {
                matrix[mouseRow][mouseCol] = "-";
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseCol].equals("c")) {
                eatenCheese++;
            } else if (matrix[mouseRow][mouseCol].equals("B")) {
                continue;
            }

            matrix[mouseRow][mouseCol] = "M";

            command = scanner.nextLine();
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}
