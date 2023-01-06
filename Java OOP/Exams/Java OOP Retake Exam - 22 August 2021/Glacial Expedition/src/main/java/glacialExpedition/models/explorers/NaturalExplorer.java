package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double ENERGY = 60;
    private static final double DEFAULT_ENERGY_DECREASE = 7;
    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(0, this.getEnergy() - DEFAULT_ENERGY_DECREASE));
    }
}
