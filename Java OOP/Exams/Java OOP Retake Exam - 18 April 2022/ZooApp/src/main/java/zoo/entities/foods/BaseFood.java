package zoo.entities.foods;

public abstract class BaseFood implements Food{
    private int calories;
    private double price; //price of the food

    protected BaseFood(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}
