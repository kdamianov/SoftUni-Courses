package football.entities.field;

public class ArtificialTurf extends BaseField{
    private static int CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, CAPACITY);
    }
}
