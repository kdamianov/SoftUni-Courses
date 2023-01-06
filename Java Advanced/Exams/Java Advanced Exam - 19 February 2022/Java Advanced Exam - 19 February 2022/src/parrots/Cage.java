package parrots;

import java.util.ArrayList;
import java.util.List;

//Judge 90/100

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }
    public Parrot sellParrot(String name) {
        Parrot toSell = null;
        for (Parrot p: this.data){
            if(p.getName().equals(name)){
                p.setAvailable(false);
                toSell = p;
            }
        }
        return toSell;
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        List <Parrot> toSell = new ArrayList<>();
        this.data.forEach(p -> {
            if (p.getSpecies().equals(species)) {
                p.setAvailable(false);
                toSell.add(p);
            }
        });
        return toSell;
    }
    public int count () {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":");
        for (Parrot parrot : data) {
            sb.append(parrot.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
