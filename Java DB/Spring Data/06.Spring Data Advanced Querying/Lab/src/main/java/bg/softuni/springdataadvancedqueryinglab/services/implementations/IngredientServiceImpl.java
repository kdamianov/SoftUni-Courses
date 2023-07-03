package bg.softuni.springdataadvancedqueryinglab.services.implementations;

import bg.softuni.springdataadvancedqueryinglab.repositories.IngredientRepository;
import bg.softuni.springdataadvancedqueryinglab.services.IngredientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findAllIngredientsStartingWith(String startingLetter) {
        return ingredientRepository.findAllByNameStartingWith(startingLetter)
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .toList();
    }

    @Override
    public List<String> findAllIngredientsContainedIn(List<String> ingredients) {
        return ingredientRepository.findAllByNameInOrderByPrice(ingredients)
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .toList();
    }

    @Override
    @Transactional
    public void deleteIngredientByName(String name) {
        ingredientRepository.deleteIngredientByName(name);
    }

//    @Override
//    @Transactional
//    public void updatePriceBy10Percent() {
//    ingredientRepository.updatePriceBy10Percent();
//    }

}
