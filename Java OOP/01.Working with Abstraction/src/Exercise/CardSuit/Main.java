package Exercise.CardSuit;

import Exercise.CardRank.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Card Suits:");
//        for (CardSuite cardSuite : CardSuite.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuite.ordinal(), cardSuite.name());
//        }

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuite cardSuit = CardSuite.valueOf(scanner.nextLine());

        int cardPower = cardRank.getPower() + cardSuit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, cardPower);
    }
}
