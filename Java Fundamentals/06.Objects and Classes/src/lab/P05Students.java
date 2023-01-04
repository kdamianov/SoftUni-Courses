package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        private Student (String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        private String getFirstName() {
            return this.firstName;
        }

        private String getLastName() {
            return this.lastName;
        }

        private String getAge() {
            return this.age;
        }

        private String getTown() {
            return this.town;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();
        String input  = scanner.nextLine();

        while (!input.equals("end")) {
            String[] studentArr = input.split(" ");
            String firstName = studentArr[0];
            String lastName = studentArr[1];
            String age = studentArr[2];
            String town = studentArr[3];

            Student currentStudent = new Student(firstName, lastName, age, town);
            studentList.add(currentStudent);

            input = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();
        for (Student item : studentList) {
            if (item.getTown().equals(searchTown)) {
                System.out.printf("%s %s is %s years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }

    }
}
