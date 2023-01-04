package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> specialNumAndPower = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int specialNum = specialNumAndPower.get(0);
        int power = specialNumAndPower.get(1);

        while (elements.contains(specialNum)) {

            int elementIndex = elements.indexOf(specialNum);

            int left = Math.max(0, elementIndex - power);
            int right = Math.min(elementIndex + power, elements.size() - 1 );

            for (int i = right; i >= left; i--) {
                elements.remove(i);
            }
        }
        int sum = 0;
        for (Integer number : elements) {
            sum += number;
        }
        System.out.println(sum);
    }
}
