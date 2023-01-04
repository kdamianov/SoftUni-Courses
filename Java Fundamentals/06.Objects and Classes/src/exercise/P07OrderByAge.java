package exercise;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P07OrderByAge {
    static class Person {
        //полета
        private String name;
        private String id;
        private int age;

        //конструктор
        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        String personalData = scanner.nextLine();

        while(!personalData.equals("End")) {
            String name = personalData.split(" ")[0];
            String id = personalData.split(" ")[1];
            int age = Integer.parseInt(personalData.split(" ")[2]);

            Person person = new Person(name, id, age);
            personList.add(person);

            personalData = scanner.nextLine();
        }
        //Person list
        personList.sort(Comparator.comparing(Person::getAge));

        for (Person person: personList) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }
    }
}
