package bg.softuni.springdataadvancedqueryinglab;

import bg.softuni.springdataadvancedqueryinglab.models.Size;
import bg.softuni.springdataadvancedqueryinglab.services.IngredientService;
import bg.softuni.springdataadvancedqueryinglab.services.LabelService;
import bg.softuni.springdataadvancedqueryinglab.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component //!!!!
public class ConsoleRunner implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;
    private LabelService labelService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService, LabelService labelService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.labelService = labelService;
    }

    @Override
    public void run(String... args) throws Exception {

//        printShampoosBySize(Size.MEDIUM);
//        printShampoosBySizeOrLabelId(Size.MEDIUM, 10L);
//        printShampoosByPriceHigherThan(BigDecimal.valueOf(5));
//        printIngredientsByNameStartingWith("M");
//        printIngredientsByNames(List.of("Lavender", "Herbs", "Apple"));
//        printShampoosCountByPriceLowerThan(BigDecimal.valueOf(8.50));
//        printShampoosWithIngredientsIncludedIn(List.of("Berry", "Mineral-Collagen"));
//        printShampoosWithIngredientsLessThan(2);
//        updateIngredientsByPrice();
        deleteIngredientsByName("Apple");




    }

    private void deleteIngredientsByName(String ingredientName) {
        ingredientService.deleteIngredientByName(ingredientName);
    }

//    private void updateIngredientsByPrice() {
//       ingredientService.updatePriceBy10Percent();
//    }

    private void printShampoosWithIngredientsLessThan(int count) {
        shampooService.findAllShampoosWithIngredientsCountLessThan(count)
                .forEach(System.out::println);
    }

    private void printShampoosWithIngredientsIncludedIn(List<String> ingredients) {
        shampooService.findAllShampoosWithIngredientsIncludedIn(ingredients)
                .forEach(System.out::println);
    }

    private void printShampoosCountByPriceLowerThan(BigDecimal price) {
        System.out.println(shampooService.findAllShampoosWithPriceLowerThan(price));

    }

    private void printIngredientsByNames(List<String> ingredients) {
        ingredientService.findAllIngredientsContainedIn(ingredients)
                .forEach(System.out::println);
    }

    private void printIngredientsByNameStartingWith(String startingLetter) {
        ingredientService.findAllIngredientsStartingWith(startingLetter)
                .forEach(System.out::println);
    }

    private void printShampoosByPriceHigherThan(BigDecimal price) {
        shampooService.findShampoosByPriceHigherThan(BigDecimal.valueOf(5))
                .forEach(System.out::println);
    }

    private void printShampoosBySizeOrLabelId(Size size, long id) {
        shampooService.findBySizeOrLabelIdOrderByPrice(Size.MEDIUM, 10L)
                .forEach(System.out::println);
    }

    private void printShampoosBySize(Size size) {
        shampooService.findBySize(Size.MEDIUM)
                .forEach(System.out::println);
    }

}
