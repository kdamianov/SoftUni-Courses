package Exercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        int sum = printSumOfFirstTwoInt(one, two);

        System.out.println(printSubtractionOfSumAndThirdInt(sum, three));
    }
    //prints the sum of first two integers
    private static int printSumOfFirstTwoInt (int first, int second){

        return first + second;
    }
    //prints the subtraction of the sum and the third integer
    private static int printSubtractionOfSumAndThirdInt (int sum, int third) {
        return sum - third;
    }
}
