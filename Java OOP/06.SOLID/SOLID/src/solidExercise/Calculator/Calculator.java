package solidExercise.Calculator;

import solidExercise.Products.Product;

import java.util.List;

public interface Calculator {
    double total(List<Product> products);
    double average(List<Product> products);
}
