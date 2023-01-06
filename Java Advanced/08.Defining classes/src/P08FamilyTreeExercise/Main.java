package P08FamilyTreeExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String personName ="";
        String personBirthday = "";
        Person person = new Person();

        if (input.contains("/")) {
            personBirthday = input;
            person.setPersonBirthday(personBirthday);
        } else {
            personName = input;
            person.setPersonName(personName);
        }

//        •	"{FirstName} {LastName} – {FirstName} {LastName}" --> parent - child
//        •	"{FirstName} {LastName} – {day/month/year}" --> parent - child
//        •	"{day/month/year} – {FirstName} {LastName}" --> parent - child
//        •	"{day/month/year} – {day/month/year}" --> parent - child
//        •	"{FirstName} {LastName} {day/month/year}"  --> person -> birthdate
        Map<String, String> parentsMap = new LinkedHashMap<>();
        Map<String, String> childrenMap = new LinkedHashMap<>();

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("End")) {
            if (secondInput.contains("-")) {

            }else {
                String[] data = secondInput.split("\\s+");
                String name = data[0];
                String date = data[1];
            }

            secondInput = scanner.nextLine();
        }



    }
}
