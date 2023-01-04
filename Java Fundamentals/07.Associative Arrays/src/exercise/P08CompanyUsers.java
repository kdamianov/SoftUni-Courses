package exercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyInfoMap = new LinkedHashMap<>();


        while (!input.equals("End" )) {
            String companyName = input.split(" -> ")[0];
            String id = input.split(" -> ")[1];

            if (companyInfoMap.containsKey(companyName)) {
                List<String> employees = companyInfoMap.get(companyName);
                if (!employees.contains(id)) {
                    employees.add(id);
                }
            } else {
                List<String> employees = new ArrayList<>();
                employees.add(id);
                companyInfoMap.put(companyName, employees);
            }


            input = scanner.nextLine();
        }
        companyInfoMap.entrySet()
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(id -> System.out.println("-- " + id));
                    //ascending order / нарастващ ред
                });
    }
}
