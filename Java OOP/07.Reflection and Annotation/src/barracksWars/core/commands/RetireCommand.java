package barracksWars.core.commands;

import barracksWars.anntoations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command{
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            repository.removeUnit(getData()[1]);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }
}
