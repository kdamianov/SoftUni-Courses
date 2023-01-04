package ME02ProgrammingFundamentalsMidExam;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        double sum = 0;
        boolean isNotGreater = false;
        for (int element = 0; element <= numbers.size() - 1; element++) {
            sum += numbers.get(element); //finds the sum of the elements
        }
        double averageValue = sum / numbers.size();
        List<Integer> newList = new ArrayList<>();
        for (int element = 0; element <= numbers.size() - 1; element++) {
            if (numbers.get(element)> averageValue) {
                int greaterValue = numbers.get(element);
                newList.add(greaterValue); //adds the greater numbers in the new list
            }

        }
        if (newList.size() == 0) {
            isNotGreater = true;
            System.out.println("No");
        }
        Collections.sort(newList); //sorts the list
        Collections.reverse(newList); //reverses the list after sorting
        List<Integer> topFive = new ArrayList<>(); //will contain the top5 reversed numbers
        if (newList.size() >= 5) {
            for (int i = 0; i < 5; i++) {  //finds the top 5 numbers
                topFive.add(newList.get(i));
            }
        } else {
            for (int i = 0; i <= newList.size() - 1; i++) {
                topFive.add(newList.get(i));
            }
        }
        for (Integer element : topFive) { //prints the new list
            System.out.print(element + " ");
        }
    }
}
