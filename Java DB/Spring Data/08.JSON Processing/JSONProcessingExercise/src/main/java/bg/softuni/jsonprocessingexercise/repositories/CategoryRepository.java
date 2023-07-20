package bg.softuni.jsonprocessingexercise.repositories;


import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryStatsDto;
import bg.softuni.jsonprocessingexercise.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryStatsDto" +
            "(c.name, count (p.id), avg (p.price), sum (p.price))" +
            "from Product p " +
            "join p.categories c " +
            "group by c.id " +
            "order by count (p.id) desc ")
    List<CategoryStatsDto> getProductStats();
}
