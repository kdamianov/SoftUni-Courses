package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> function = arr ->{
            int min = Integer.MAX_VALUE;
            for (int n : arr) {
                if (n < min) {
                    min = n;
                }
            }
            return min;
        };
        //elements -> Collections. - В ЛЕКЦИЯТА!!!!!!

        int min = function.apply(numbers);

        System.out.println(min);


    }
}
