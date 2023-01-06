package exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] heiganChamber = new int[15][15];
        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3_000_000;

        int plagueCloud = 3500;
        int eruption = 6000;
        String previousSpell = "";
        String currentSpell = "";

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        while (playerHP > 0 && heiganHP > 0) {
            heiganHP -= damageToHeigan;

            if (previousSpell.equals("Cloud")) {
                playerHP -= plagueCloud;
            }
            if (playerHP <= 0 || heiganHP <= 0) {
                continue;
            }

            String[] input = scanner.nextLine().split("\\s+");
            currentSpell = input[0];
            int hitRow = Integer.parseInt(input[1]);
            int hitCol = Integer.parseInt(input[2]);

            if (isInArea(hitRow, hitCol, playerRow, playerCol)) {
                if (!isInArea(hitRow, hitCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    previousSpell = "";
                } else if (!isInArea(hitRow, hitCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    previousSpell = "";
                } else if (!isInArea(hitRow, hitCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    previousSpell = "";
                } else if (!isInArea(hitRow, hitCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    previousSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHP -= plagueCloud;
                        previousSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHP -= eruption;
                        previousSpell = "Eruption";
                    }
                }
            }
        }
        previousSpell = previousSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String playerStatus = playerHP <= 0 ? String.format("Player: Killed by %s", previousSpell) : String.format("Player: %d", playerHP);
        String heiganStatus = heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP);
        String playerPosition = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganStatus);
        System.out.println(playerStatus);
        System.out.println(playerPosition);

    }
    private static boolean isInArea (int targetRow, int targetCol, int plMoveRow, int plMoveCol) {
        return ((targetRow - 1 <= plMoveRow && targetRow + 1 >= plMoveRow)
                && (targetCol - 1 <= plMoveCol && targetCol + 1 >= plMoveCol));
    }
    private static boolean isWall (int plMove) {
        return (plMove < 0 || plMove >+ 15);
    }
}
