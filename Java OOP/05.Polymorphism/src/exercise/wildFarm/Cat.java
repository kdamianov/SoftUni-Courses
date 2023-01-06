package exercise.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                breed,
                df.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
