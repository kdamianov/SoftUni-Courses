package football.entities.field;

public class NaturalGrass extends BaseField{
    private static int CAPACITY = 250;

    public NaturalGrass(String name) {
        super(name, CAPACITY);
    }
}
