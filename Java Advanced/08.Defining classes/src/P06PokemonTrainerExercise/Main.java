package P06PokemonTrainerExercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pokemon> pokemonList = new ArrayList<>();

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();


        String[] firstInput = scanner.nextLine().split("\\s+");

        while (!firstInput[0].equals("Tournament")) {
            String trainerName = firstInput[0];
            String pokemonName = firstInput[1];
            String pokemonElement = firstInput[2];
            int pokemonHealth = Integer.parseInt(firstInput[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonList.add(pokemon);

            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName, 0, pokemonList));
            trainerMap.get(trainerName).addPokemon(pokemon);

            firstInput = scanner.nextLine().split("\\s+");
        }

        String secondInput = scanner.nextLine();
        while (!secondInput.equals("End")) {
            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                if (trainer.getValue().getPokemons().size() > 0) {
                    boolean pokemonHasElement = false;

                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(secondInput)) {
                            pokemonHasElement = true;
                            trainer.getValue().setBadgesNumber();
                            break;
                        } else {
                            pokemon.removeHealth();
                        }
                    }
                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        if (pokemon.getHealth() <= 0) {
                            trainer.getValue().getPokemons().remove(pokemon);
                            break;
                        }
                    }
                }
            }

            secondInput = scanner.nextLine();
        }
        trainerMap.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadgesNumber()
                        ,t1.getValue().getBadgesNumber()))
                .forEach(t ->
                        System.out.printf("%s %d %s%n",
                                t.getKey(), t.getValue().getBadgesNumber()
                                ,t.getValue().getPokemons().size()));

    }
}
