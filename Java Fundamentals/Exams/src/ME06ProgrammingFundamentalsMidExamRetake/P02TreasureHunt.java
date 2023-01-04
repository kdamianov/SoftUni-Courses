package ME06ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /////ИМА ГРЕШКА В СМЕТКИТЕ!!!!!!!!







        //the initial treasure chest (loot separated by "|")
        String[] initialTreasure = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commmandLine = input.split(" ");
            String command = commmandLine[0];

            switch (command) {
                case "Loot" :
                    for (int i = 1; i <= commmandLine.length - 1; i++) {
                        boolean isContained = false;
                        for (int j = 0; j <= initialTreasure.length - 1; j++) {
                            if (commmandLine[i].equals(initialTreasure[j])) {
                                isContained = true;
                                break;
                            }
                        }
                        if (!isContained) {
                            String newChest = commmandLine[i] + " " + String.join(" ", initialTreasure);
                            initialTreasure = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop" :
                    int dropIndex = Integer.parseInt(commmandLine[1]);
                    if (dropIndex >= 0 && dropIndex <= initialTreasure.length - 1) {
                        String droppedItem = initialTreasure[dropIndex];
                        for (int i = dropIndex; i < initialTreasure.length; i++) {
                            initialTreasure[dropIndex] = initialTreasure[dropIndex + 1];
                        }
                        initialTreasure[initialTreasure.length -1] = droppedItem;
                    } else {
                        break;
                    }
                    break;
                case "Steal" :
                    int numStolenItems = Integer.parseInt(commmandLine[1]);
                    if (numStolenItems >= 0 && numStolenItems <= initialTreasure.length) {
                        for (int i = 0; i < numStolenItems; i++) {
                            System.out.print(initialTreasure[initialTreasure.length - numStolenItems + i]);
                            if (i != numStolenItems - 1) {
                                System.out.print(", ");
                            }
                        }
                    String[] tempChest = new String[initialTreasure.length - numStolenItems];
                        for (int i = 0; i < tempChest.length; i++) {
                            tempChest[i] = initialTreasure[i];
                        }
                        initialTreasure = tempChest;
                    } else if (numStolenItems >=0) {
                        for (int i = 0; i < initialTreasure.length; i++) {
                            System.out.print(initialTreasure[i]);
                            if (i != initialTreasure.length -1) {
                                System.out.print(", ");
                            }
                        }
                        initialTreasure = new String[0];
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
        String treasureCount = String.join("", initialTreasure);
        int charCounter = 0;
        for (int i = 0; i < initialTreasure.length; i++) {
            charCounter ++;
        }
        double averageTreasure = (1.0 * charCounter) / initialTreasure.length;
        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
