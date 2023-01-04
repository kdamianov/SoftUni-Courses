package Lab;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Double::parseDouble).collect(Collectors.toList());

        //3 3 6 1  6 6 1  12 1
        for (int i = 0; i < numbers.size() - 1; i++) {
            double firstElement = numbers.get(i);
            double secondElement = numbers.get(i + 1);
            if (firstElement == secondElement) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = -1;
            }
        }
        System.out.print(joinElementsByDelimeter(numbers," "));
    }
    public static String joinElementsByDelimeter (List<Double> list, String delimeter) {
        String result = "";
        for (Double num: list) {
            DecimalFormat df = new DecimalFormat("0.#");


            String numFormat = df.format(num) + delimeter;
            result += numFormat;
        }
            return result;
    }
}
