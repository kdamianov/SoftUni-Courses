package exercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if(!coursesInfo.containsKey(courseName)) {
                coursesInfo.put(courseName, new ArrayList<>());
                coursesInfo.get(courseName).add(studentName);
            } else {
                coursesInfo.get(courseName).add(studentName);
            }

            input = scanner.nextLine();
        }
        //courseName -> List<String>
        coursesInfo.entrySet()
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
                    //ascending order / нарастващ ред
                });
    }
}
