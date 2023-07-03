package bg.softuni.springdataadvancedqueryinglab.repositories;

import bg.softuni.springdataadvancedqueryinglab.models.Shampoo;
import bg.softuni.springdataadvancedqueryinglab.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s " +
            "JOIN s.ingredients i " +
            "WHERE i IN :ingredientNames")
    Set<Shampoo> findByIngredientsIn(@Param("ingredientNames") Collection<String> ingredients);

    @Query("SELECT s FROM Shampoo s WHERE SIZE(s.ingredients) < :count")
    List<Shampoo> findAllShampoosWithIngredientsLessThan(@Param("count") int count);
}
