package P06PokemonTrainerExercise;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgesNumber;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badgesNumber, List<Pokemon> pokemonList) {
        this.name = name;
        this.badgesNumber = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon (Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesNumber() {
        return badgesNumber;
    }

    public void setBadgesNumber() {
        this.badgesNumber ++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

}
