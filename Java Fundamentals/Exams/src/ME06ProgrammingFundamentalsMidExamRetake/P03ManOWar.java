package ME06ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipStatus = Arrays.stream(scanner.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warshipStatus = Arrays.stream(scanner.nextLine().split(">")).
                map(Integer::parseInt).collect(Collectors.toList());

        int maximumHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        boolean isSunkWarship = false;
        boolean isSunkPirateship = false;

        while (!input.equals("Retire")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Fire":
                    int fireIndex = Integer.parseInt(commandLine[1]);
                    int fireDamage = Integer.parseInt(commandLine[2]);
                    if (fireIndex >= 0 && fireIndex <= warshipStatus.size() - 1) {
                        int statusLeft = warshipStatus.get(fireIndex) - fireDamage;
                        warshipStatus.set(fireIndex, statusLeft);
                        if (statusLeft <= 0) {
                            isSunkWarship = true;
                            break;
                        }
                    } else {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Defend":
                    int startDefendIndex = Integer.parseInt(commandLine[1]);
                    int endDefendIndex = Integer.parseInt(commandLine[2]);
                    int defendDamage = Integer.parseInt(commandLine[3]);
                    if ((startDefendIndex >= 0 && startDefendIndex <= pirateShipStatus.size() -1) &&
                            (endDefendIndex >= 0 && endDefendIndex<= pirateShipStatus.size() - 1)) {
                        for (int i = startDefendIndex; i <= endDefendIndex; i++) {
                            pirateShipStatus.set(i, pirateShipStatus.get(i) - defendDamage);
                            if (pirateShipStatus.get(i) <= 0) {
                                isSunkPirateship = true;
                                break;
                            }
                        }
                    } else {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(commandLine[1]);
                    int repairValue = Integer.parseInt(commandLine[2]);
                    if (repairIndex >=0 && repairIndex <= pirateShipStatus.size() -1 ){
                        int newSectionValue = repairValue + pirateShipStatus.get(repairIndex);
                        if (newSectionValue > maximumHealth) {
                            newSectionValue = maximumHealth;
                        }
                        pirateShipStatus.set(repairIndex, newSectionValue);
                    } else {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Status":
                    int countRepairs = 0;
                    for (int i = 0; i <= pirateShipStatus.size() -1; i++) {
                        int sectionStatus = pirateShipStatus.get(i);
                        if (sectionStatus < maximumHealth * 0.20) {
                            countRepairs ++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", countRepairs);
                    break;
            }
            if (isSunkWarship) {
                System.out.println("You won! The enemy ship has sunken.");
                break;
            }
            if (isSunkPirateship) {
                System.out.println("You lost! The pirate ship has sunken.");
                break;
            }

            input = scanner.nextLine();
        }
        if (!isSunkPirateship && !isSunkWarship) {
            int pirateshipSum = 0;
            int warshipSum = 0;
            for (Integer section : pirateShipStatus) {
                pirateshipSum += section;
            }
            System.out.printf("Pirate ship status: %d%n", pirateshipSum);
            for (Integer section : warshipStatus) {
                warshipSum +=section;
            }
            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }
}
