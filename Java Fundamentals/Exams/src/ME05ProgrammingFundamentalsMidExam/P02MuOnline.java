package ME05ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        String[] roomsArr = scanner.nextLine().split("\\|");
        int ttlBitcoins = 0;
        boolean isDead = false;

        for (int room = 0; room < roomsArr.length; room++) {
            String[] commandInput = roomsArr[room].split(" ");
            String command = commandInput[0];
            int value = Integer.parseInt(commandInput[1]);


            switch (command) {
                case "potion":
                    int diffHealth = 100 - health;
                    health = health + value;
                    if (health > 100) {
                        value = diffHealth;
                        health = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", value);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoins = value;
                    ttlBitcoins += bitcoins;
                    System.out.printf("You found %d bitcoins.%n", bitcoins);
                    break;
                default:
                    String monster = command;
                    health -= value;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        isDead = true;
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", room + 1);
                    }
                    break;
            }
            if (isDead) {
                break;
            }
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", ttlBitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
