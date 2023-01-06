package lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
//ДА СЕ ОПРАВИ СРЕДНАТА ОЦЕНКА!!!!!

public class P08AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> gradesByStudents = new LinkedHashMap<>();

        while(n-- > 0) {
            String name = scanner.nextLine();
            Double grade = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0);

            gradesByStudents.put(name, grade);
        }

        gradesByStudents.forEach((name, grade) ->System.out.printf("%s is graduated with %f%n", name, grade));
    }
}
