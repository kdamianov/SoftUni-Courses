package easterBasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }
    public boolean removeEgg(String color) {
        return data.removeIf(e -> e.getColor().equals(color));
    }
    public Egg getStrongestEgg() {
        return Collections.max(data, Comparator.comparing(Egg::getStrength));
    }
    public Egg getEgg(String color) {
        return data.stream()
                .filter(e -> e.getColor().equals(color))
                .findAny()
                .orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(material).append(" basket contains:").append(System.lineSeparator());
        for (Egg egg : data) {
            sb.append(egg).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
