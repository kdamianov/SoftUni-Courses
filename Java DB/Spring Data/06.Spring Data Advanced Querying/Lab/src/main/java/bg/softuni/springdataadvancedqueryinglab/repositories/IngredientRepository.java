package bg.softuni.springdataadvancedqueryinglab.repositories;

import bg.softuni.springdataadvancedqueryinglab.models.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String startingLetter);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> ingredients);

//    @Modifying //Указва се, че е такъв тип заявка
//    @Transactional //Указва се, че е транзакация
//    @Query("UPDATE Ingredient AS i SET  i.price = i.price * 1.1")
//    void updatePriceBy10Percent(); //-->not working with BigDecimal

    @Modifying
    @Transactional
    @Query("DELETE Ingredient AS i WHERE i.name = :name")
    void deleteIngredientByName(@Param("name") String name);
}
