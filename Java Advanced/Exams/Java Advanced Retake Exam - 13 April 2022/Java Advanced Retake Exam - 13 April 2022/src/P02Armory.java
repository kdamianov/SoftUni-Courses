import java.util.Arrays;
import java.util.Scanner;

//Judge: 100/100

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] armoryMatrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            armoryMatrix[row] = scanner.nextLine().toCharArray();
        }

        int rowPosition = 0;
        int colPosition = 0;

        for (int row = 0; row < armoryMatrix.length; row++) {
            for (int col = 0; col < armoryMatrix[row].length; col++) {
                if (armoryMatrix[row][col] == 'A') {
                        rowPosition = row;
                        colPosition = col;
                }
            }
        }
        int coins = 0;
        boolean isOut = false;

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            armoryMatrix[rowPosition][colPosition] = '-';
            switch (command) {
                case "up":
                    rowPosition -= 1;
                    if (rowPosition < 0) {
                        isOut = true;
                        break;
                    }
                    break;
                case "down":
                    rowPosition += 1;
                    if (rowPosition > size - 1) {
                        isOut = true;
                        break;
                    }
                    break;
                case "left":
                    colPosition -= 1;
                    if (colPosition < 0) {
                        isOut = true;
                        break;
                    }
                    break;
                case "right":
                    colPosition += 1;
                    if (colPosition > size - 1) {
                        isOut = true;
                        break;
                    }
                    break;
            }
            if (isOut) {
                break;
            }
            if (Character.isDigit(armoryMatrix[rowPosition][colPosition])) {
                coins += Character.getNumericValue(armoryMatrix[rowPosition][colPosition]);
            }
            if (coins >= 65) {
                armoryMatrix[rowPosition][colPosition] = 'A';
                break;
            }
            if (armoryMatrix[rowPosition][colPosition] == 'M') {
                armoryMatrix[rowPosition][colPosition] = '-';
                for (int row = 0; row < armoryMatrix.length; row++) {
                    for (int col = 0; col < armoryMatrix[row].length; col++) {
                        if (armoryMatrix[row][col] == 'M') {
                            rowPosition = row;
                            colPosition = col;
                        }
                    }
                }
            }
            armoryMatrix[rowPosition][colPosition] = 'A';
        }
        if (isOut) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins. %n", coins);
        for (char[] chars : armoryMatrix){
            for (char c : chars) {
                System.out.print(c + "");
            }
                System.out.println();
        }
    }
}
