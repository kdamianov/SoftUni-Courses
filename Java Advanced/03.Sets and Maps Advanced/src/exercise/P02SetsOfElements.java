package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setSizes = scanner.nextLine().split(" ");
        int firstSize = Integer.parseInt(setSizes[0]);
        int secondSize = Integer.parseInt(setSizes[1]);

        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSize; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSize; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

//        for (String element : firstSet) {
//            if (secondSet.contains(element)) {
//                System.out.print(element + " ");
//            }
//        }
        //ВАЖНО !!!
        firstSet.retainAll(secondSet); //метод, който проверява дали ел-ти от 1я сет,
                                       // се съдържат във 2я и ги оставя!!!
        for (String element : firstSet) {
            System.out.print(element + " ");
        }

    }
}
