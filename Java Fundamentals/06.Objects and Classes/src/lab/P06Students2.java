package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        private String getLastName() {
            return this.lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private String getAge() {
            return this.age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        private String getTown() {
            return this.town;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String input  = scanner.nextLine();

        while (!input.equals("end")) {
            String[] studentArr = input.split(" ");
            String firstName = studentArr[0];
            String lastName = studentArr[1];
            String age = studentArr[2];
            String town = studentArr[3];


            if (isStudentExisting(students, firstName, lastName)) {
                Student student = getStudent(students, firstName, lastName, age, town);

            } else {
                Student student = new Student(firstName, lastName, age, town);
                students.add(student);
            }


            input = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();

        for (Student item : students) {
            if (item.getTown().equals(searchTown)) {
                System.out.printf("%s %s is %s years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }


    }
    private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {
        for (Student student: students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName, String age, String town) {
        Student existingStudent = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.lastName.equals(lastName)) {
                existingStudent = student;
                existingStudent.age = age;
                existingStudent.town = town;

            }
        }
        return existingStudent;
    }
}
