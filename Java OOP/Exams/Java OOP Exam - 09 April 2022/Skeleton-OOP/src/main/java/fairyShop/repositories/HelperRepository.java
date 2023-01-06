package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.*;

public class HelperRepository<T> implements Repository<Helper>{
    private List<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }

    @Override
    public void add(Helper model) {
        this.helpers.add(model);
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model);
        //трябва да не е празно, за да върне true!!!!
    }

    @Override
    public Helper findByName(String name) {
        return helpers
                .stream()
                .filter(h -> h.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
