package moreEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> students = new TreeMap<>();

        while (!firstInput.equals("end of contests")) {
            String[] contestData = firstInput.split(":");
            String contest = contestData[0];
            String password = contestData[1];

            contests.put(contest, password);

            firstInput = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();

        while (!secondInput.equals("end of submissions")) {
        //{[C# Fundamentals]=>[fundPass]=>[Tanya]=>[350]}
            String[] secondInputData = secondInput.split("=>");
            String course = secondInputData[0];
            String password = secondInputData[1];
            String user = secondInputData[2];
            int points = Integer.parseInt(secondInputData[3]);

            //check if course is valid
            if (contests.containsKey(course)) {
                //check if password is correct
                if (contests.get(course).equals(password)) {
                    //LinkedHashMap -> course -> points
                    LinkedHashMap<String, Integer> courseInfoMap = new LinkedHashMap<>();
                    courseInfoMap.put(course, points);
                    //Map Students <user, courseInfoMap>
                    //check if student is in the Map
                    if (!students.containsKey(user)) {
                        students.put(user, courseInfoMap);
                    } else {
                        //check if student is in the course
                        if (!students.get(user).containsKey(course)) {
                            students.get(user).put(course, points);
                        //puts the greater result
                        } else {
                            students.get(user).put(course, Math.max(points, students.get(user).get(course)));
                        }
                    }
                }
            }
            secondInput = scanner.nextLine();
        }
        int totalPoints = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : students.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalPoints) {
                totalPoints = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : students.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalPoints) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalPoints);
            }
        }
        System.out.println("Ranking:");
        students.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }
}
