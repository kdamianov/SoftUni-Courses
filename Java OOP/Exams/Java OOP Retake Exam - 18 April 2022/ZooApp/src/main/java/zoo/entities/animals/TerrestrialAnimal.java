package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{
    private static final double INITIAL_WEIGHT = 5.50;
    //Can only live in LandArea!

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_WEIGHT, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + 5.70);
    }
}
