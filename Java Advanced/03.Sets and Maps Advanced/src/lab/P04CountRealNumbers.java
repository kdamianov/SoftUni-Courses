package lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            double currentNum = input[i];

            if (numbersMap.containsKey(currentNum)) {
                numbersMap.put(currentNum, numbersMap.get(currentNum) + 1);

            } else {
                numbersMap.put(currentNum, 1);
            }
        }
        numbersMap.entrySet().forEach(e -> System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));
    }
}
