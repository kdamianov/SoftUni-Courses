package exercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentInfoMap = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentInfoMap.containsKey(name)) {
                studentInfoMap.put(name, new ArrayList<>());
                studentInfoMap.get(name).add(grade);
            } else {
                studentInfoMap.get(name).add(grade);
            }
        }
        Map<String, Double> averageGradeMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentInfoMap.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = getAverageGrade(grades);

            if (averageGrade >= 4.50) {
                averageGradeMap.put(studentName, averageGrade);
            }
        }

        averageGradeMap.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));


    }
    private static double getAverageGrade (List<Double> grades) {
        double sumGrades = 0;
        for (Double grade : grades) {
            sumGrades += grade;
        }
        return sumGrades / grades.size();
    }
}
