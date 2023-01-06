package P07GoogleExercise;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;

    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append("\n");
        if (company != null) {
            sb.append(company.toString());
        }
        sb.append("Car:").append("\n");
        if (car != null) {
            sb.append(car.toString());
        }
        sb.append("Pokemon:").append("\n");
        if (pokemons.size() !=0) {
            pokemons.forEach(p -> sb.append(p.toString()).append("\n"));
        }
        sb.append("Parents:").append("\n");
        parents.forEach(p -> sb.append(p.toString()).append("\n"));
        sb.append("Children:").append("\n");
        children.forEach((c -> sb.append(c.toString()).append("\n")));


        return sb.toString();
    }
}
