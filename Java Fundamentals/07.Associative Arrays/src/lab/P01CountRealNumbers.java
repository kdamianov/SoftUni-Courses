package lab;

import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //списък от входни данни
        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" ")).
                map(Double::parseDouble).collect(Collectors.toList());
        //МАР
        Map<Double, Integer> countNumbersMap = new TreeMap<>();
        //итерираме по списъка
        for (Double currentNum : numbersList) {

            countNumbersMap.putIfAbsent(currentNum, 0); //ако го няма, се добавя 0
            int currentValue = countNumbersMap.get(currentNum); //може да се ползва int(примитивен тип данни), заради горната стойност
            countNumbersMap.put(currentNum, currentValue + 1);

            //инициираме стойността на ключа
//          Integer currentValue = countNumbersMap.get(currentNum); // достъпваме стойността по дадения ключ
//          if (countNumbersMap.containsKey(currentNum)) {
//          countNumbersMap.put(currentNum, currentValue + 1);
//            } else {
//                countNumbersMap.put(currentNum, 1);
//            }
        }
        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) { //извиква се с Alt+Enter
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
