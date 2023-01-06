package Exercise.CardsWithPower;


import java.util.Scanner;

//100/100

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuite cardSuit = CardSuite.valueOf(scanner.nextLine());

        int cardPower = cardRank.getPower() + cardSuit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, cardPower);
    }
}
