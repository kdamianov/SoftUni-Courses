package exercise.birthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> thigsWithBirthDay = new ArrayList<>();

        while(!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String objectType = tokens[0];

            switch (objectType){
                case "Citizen":
                    String personName = tokens[1];
                    int personAge = Integer.parseInt(tokens[2]);
                    String personId = tokens[3];
                    String personBrithDate = tokens[4];

                    Citizen citizen = new Citizen(personName, personAge, personId, personBrithDate);
                    thigsWithBirthDay.add(citizen);

                    break;
                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];

                    Pet pet = new Pet(petName, petBirthDate);
                    thigsWithBirthDay.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        for (Birthable birthable : thigsWithBirthDay) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
