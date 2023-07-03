package bg.softuni.springdataadvancedqueryinglab.services.implementations;

import bg.softuni.springdataadvancedqueryinglab.models.Size;
import bg.softuni.springdataadvancedqueryinglab.repositories.ShampooRepository;
import bg.softuni.springdataadvancedqueryinglab.services.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> findBySize(Size size) {
        return shampooRepository.findBySizeOrderById(size)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .toList();
    }

    @Override
    public List<String> findBySizeOrLabelIdOrderByPrice(Size size, long labelId) {
        return shampooRepository.findBySizeOrLabelIdOrderByPrice(size, labelId)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .toList();
    }

    @Override
    public List<String> findShampoosByPriceHigherThan(BigDecimal price) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),
                        shampoo.getSize(),
                        shampoo.getPrice()))
                .toList();
    }

    @Override
    public int findAllShampoosWithPriceLowerThan(BigDecimal price) {
        return shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<String> findAllShampoosWithIngredientsIncludedIn(List<String> ingredients) {
        return shampooRepository.findByIngredientsIn(ingredients)
                .stream()
                .map(shampoo -> String.format("%s", shampoo.getBrand()))
                .distinct()
                .toList();
    }

    @Override
    public List<String> findAllShampoosWithIngredientsCountLessThan(int count) {
        return shampooRepository.findAllShampoosWithIngredientsLessThan(count)
                .stream()
                .map(shampoo -> String.format("%s", shampoo.getBrand()))
                .toList();
    }
}
