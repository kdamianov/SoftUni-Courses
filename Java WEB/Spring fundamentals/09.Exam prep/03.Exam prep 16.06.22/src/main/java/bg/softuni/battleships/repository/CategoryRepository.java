package bg.softuni.battleships.repository;

import bg.softuni.battleships.models.entity.Category;
import bg.softuni.battleships.models.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategoryNameEnum name);
}
