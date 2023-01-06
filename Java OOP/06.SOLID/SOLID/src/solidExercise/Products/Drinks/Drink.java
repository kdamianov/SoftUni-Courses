package solidExercise.Products.Drinks;

import solidExercise.Products.Product;

public abstract class Drink implements Product {
    private double milliliters;
    private double caloriesPer100Grams;
    private double density;

    public Drink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getCaloriesPer100Grams() {
        return caloriesPer100Grams;
    }

    public void setCaloriesPer100Grams(double caloriesPer100Grams) {
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getMilliliters() {
        return milliliters;
    }
    @Override
    public double getCalories() {
        double grams = milliliters * density;
        return (caloriesPer100Grams / 100) * grams;
    }

    public double getLitres(){
        return milliliters * 1000;
    }

    @Override
    public double getKilograms() {
        return getLitres() * density;
    }
}
