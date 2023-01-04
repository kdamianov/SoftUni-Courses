package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0){

            int firstCard = firstPlayerCards.get(0);
            int secondCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard){
                secondPlayerCards.add(secondCard);
                secondPlayerCards.add(firstCard);
            }

            if (firstPlayerCards.size() == 0) {
                System.out.print("Second player wins! ");
                System.out.println("Sum: " + getSumOfCards(secondPlayerCards));
            } else if (secondPlayerCards.size() == 0) {
                System.out.print("First player wins! ");
                System.out.println("Sum: " + getSumOfCards(firstPlayerCards));
            }

        }
    }
    private static int getSumOfCards (List <Integer> listCards) {
        int sum = 0;
        for (Integer card : listCards) {
            sum += card;
        }
        return sum;
    }
}
