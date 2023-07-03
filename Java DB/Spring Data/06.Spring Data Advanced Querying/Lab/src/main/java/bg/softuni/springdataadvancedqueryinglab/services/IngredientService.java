package bg.softuni.springdataadvancedqueryinglab.services;

import java.util.List;

public interface IngredientService {

    List<String> findAllIngredientsStartingWith(String startingLetter);

    List<String> findAllIngredientsContainedIn(List<String> ingredients);

//    @Transactional
//    void updatePriceBy10Percent();

    void deleteIngredientByName(String name);

}
