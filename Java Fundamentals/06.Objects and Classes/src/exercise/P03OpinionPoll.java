package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {
    static class Person {
        //полета Private, за да можем да контролираме достъпа до тях
        private String name;
        private int age;

        //контруктор
        public Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName () {
            return this.name;
        }
        public Integer getAge () {
            return  this.age;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String personalData = scanner.nextLine();

            String name = personalData.split(" ")[0];
            int age = Integer.parseInt(personalData.split(" ")[1]);

            if (age > 30) {
                //валиден човек
                Person person = new Person(name, age);
                personList.add(person);
            }
        }
        //списък с обекти от клас Person
        for (Person person: personList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
