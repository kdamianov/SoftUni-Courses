package exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

// NE RABOTI!!!!!


public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int countToPush = Integer.parseInt(input[0]); //to add
        int countToPop = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] numbersToAdd = scanner.nextLine().split(" ");

        for (int i = 0; i < countToPush; i++) {
            stack.push(Integer.parseInt(numbersToAdd[i]));
        }

        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }

        //if X is present -> print true
        //if not -> print the smallest
        //if empty -> print 0
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(elementToSearch)) {
            System.out.println("true");
        } else {
//            int minElement = Integer.MAX_VALUE;
//            for (Integer number : stack) {
//                if (number < minElement) {
//                    minElement = number;
//                }
//            }
            int minElement = Collections.min(stack);
            System.out.println(minElement);
        }

    }
}
