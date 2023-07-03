package bg.softuni.springdataadvancedqueryinglab.services;

import bg.softuni.springdataadvancedqueryinglab.models.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<String> findBySize(Size size);

    List<String> findBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<String> findShampoosByPriceHigherThan(BigDecimal price);


    int findAllShampoosWithPriceLowerThan(BigDecimal price);

    List<String> findAllShampoosWithIngredientsIncludedIn(List<String> ingredients);

    List<String> findAllShampoosWithIngredientsCountLessThan(int count);
}
