import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[size][size];

        int beeRow = 0;
        int beeCol = 0;
        for (int row = 0; row < size; row++) {
            territory[row] = scanner.nextLine().split("");
            for (int col = 0; col < territory[row].length; col++) {
                if (territory[row][col].equals("B")) {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        int flowers = 0;

        while(!command.equals("End")) {
            territory[beeRow][beeCol] = ".";

            if (command.equals("up") && beeRow != 0) {
                beeRow--;
            }else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            }else if (command.equals("left") && beeCol != 0){
                beeCol--;
            }else if (command.equals("right") && beeCol != size - 1){
                beeCol++;
            } else {
                territory[beeRow][beeCol] = ".";
                System.out.println("The bee got lost!");
                break;
            }
            if (territory[beeRow][beeCol].equals("f")) {
                flowers++;
            }else if (territory[beeRow][beeCol].equals("O")){
                continue;
            }

            territory[beeRow][beeCol] = "B";

            command = scanner.nextLine();
        }
        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %s flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }
}
