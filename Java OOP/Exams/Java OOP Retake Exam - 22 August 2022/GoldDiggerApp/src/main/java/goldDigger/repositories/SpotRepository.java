package goldDigger.repositories;

import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;

import java.util.*;

public class SpotRepository implements Repository<Spot>{
    private Map<String, Spot> spots;

    public SpotRepository() {
        this.spots = new LinkedHashMap<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots.values());
        //връща unmodifiable collection от стойностите на Мар-а!
    }

    @Override
    public void add(Spot spot) {
        spots.put(spot.getName(), spot);
    }

    @Override
    public boolean remove(Spot spot) {
        return spots.remove(spot.getName()) != null;
        ////не трябва да е null, за да е успешно премахването!
    }

    @Override
    public Spot byName(String name) {
        return spots.get(name);
        //тк е Map, само метод get()!!!
    }
}
