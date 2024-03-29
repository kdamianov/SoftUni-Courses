package goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

import static goldDigger.common.ExceptionMessages.*;

public class SpotImpl implements Spot{
    private String name;
    private Collection<String> exhibits;


    public SpotImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
