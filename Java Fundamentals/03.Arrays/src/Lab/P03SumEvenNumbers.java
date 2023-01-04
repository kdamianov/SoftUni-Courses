package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineInput = scanner.nextLine();

        int[] numbersArr = Arrays.stream(lineInput.split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            int currentEllement = numbersArr[i];
            if (currentEllement % 2 == 0) {
                sum += currentEllement;
            }
        }

        System.out.println(sum);
    }
}
