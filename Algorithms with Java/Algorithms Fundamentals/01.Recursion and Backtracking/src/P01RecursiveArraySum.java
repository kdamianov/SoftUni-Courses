import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        // Може и в обратен ред --> sum = sumNumbers(arr, arr.length -1);
        sum = sumNumbers(arr, 0);

        System.out.println(sum);
    }

    private static int sumNumbers(int[] numbers, int index) {
        //if (index < 0) {
        if (index >= numbers.length) {
            return 0;
        }
        //return numbers[index] + sumNumbers(numbers, index - 1);
        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}