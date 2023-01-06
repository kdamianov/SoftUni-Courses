package barracksWars.models.units;

public class Horseman extends AbstractUnit{
    //50 health and 10 attacks
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
