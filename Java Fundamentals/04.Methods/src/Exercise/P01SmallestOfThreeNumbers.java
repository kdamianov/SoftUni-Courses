package Exercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());

        smallestOfThreeNumbers(numOne, numTwo, numThree);
    }

    private static void smallestOfThreeNumbers (int one, int two, int three) {
        if (one <= two && one <= three) {
            System.out.println(one);
        }else if (two <= one && two <= three) {
            System.out.println(two);
        }else if (three <= one && three <= two) {
            System.out.println(three);
        }
    }

}
