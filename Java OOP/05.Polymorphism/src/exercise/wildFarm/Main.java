package exercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] animalTokens = input.split("\\s+");
            //"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".
            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            double animalWeight = Double.parseDouble(animalTokens[2]);
            String livingRegion = animalTokens[3];

            if ("Cat".equals(animalType)) {
                String breed = animalTokens[4];
                Animal cat = new Cat(animalName, animalWeight, livingRegion, breed);
                animals.add(cat);
            } else if ("Mouse".equals(animalType)) {
                Animal mouse = new Mouse(animalName, animalWeight, livingRegion);
                animals.add(mouse);
            } else if ("Tiger". equals(animalType)) {
                Animal tiger = new Tiger(animalName, animalWeight, livingRegion);
                animals.add(tiger);
            } else if ("Zebra".equals(animalType)) {
                Animal zebra = new Zebra(animalName, animalWeight, livingRegion);
                animals.add(zebra);
            }
            input = scanner.nextLine();

            String[] foodTokens = input.split("\\s+");
            String foodType = foodTokens[0];
            int quantity = Integer.parseInt(foodTokens[1]);

            if ("Vegetable".equals(foodType)) {
                Food vegetable = new Vegetable(quantity);
                foods.add(vegetable);
            } else if ("Meat".equals(foodType)) {
                Food meat = new Meat(quantity);
                foods.add(meat);
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);

        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }

    }
}
