package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Map<String, Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {

        return beverages.get(drinkName);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return beverages.values();
    }

    @Override
    public void add(Beverages entity) {
        beverages.put(entity.getName(), entity);
    }
}
