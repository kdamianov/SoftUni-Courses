package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Student {
        //Полета -> характеристики
        private String name;
        private String lastName;
        private double grade;
        //конструктор
        public Student (String name, String lastName, double grade) {
            this.name = name;
            this.lastName = lastName;
            this.grade = grade;


        }
        //функционалности -> методи (какво прави студентът?)
        public double getGrade () {
            return this.grade;
        }
        public String toString () {
            return String.format("%s %s: %.2f", this.name, this.lastName, this.grade);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой студенти
        List<Student> studentsList = new ArrayList<>();

        for (int studentCount = 1; studentCount <= n; studentCount++) {
            String personalData = scanner.nextLine();

            String firstName = personalData.split(" ")[0];
            String lastNAme = personalData.split(" ")[1];
            double grade = Double.parseDouble(personalData.split(" ")[2]);

            Student student = new Student(firstName, lastNAme, grade);
            studentsList.add(student);
        }
        studentsList.sort(Comparator.comparingDouble(Student::getGrade). reversed());

        for (Student student: studentsList) {
            System.out.println(student.toString());
        }
    }
}
