package fairyShop.models;

public class Sleepy extends BaseHelper{
    private static final int INITIAL_ENERGY = 50;
    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        int sleepysEnergy = this.getEnergy();
        if (sleepysEnergy - 15 < 0) {
            sleepysEnergy = 0;
        } else {
            sleepysEnergy -= 15;
        }
    }
}
