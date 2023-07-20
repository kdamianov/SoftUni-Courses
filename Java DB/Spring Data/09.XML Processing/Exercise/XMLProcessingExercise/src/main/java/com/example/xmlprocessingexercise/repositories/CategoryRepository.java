package com.example.xmlprocessingexercise.repositories;

import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusDto;
import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusRootDto;
import com.example.xmlprocessingexercise.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusDto" +
            "(c.name, count (p.id), avg (p.price), sum (p.price))" +
            "from Product p " +
            "join p.categories c " +
            "group by c.id " +
            "order by count (p.id) desc ")
    List<CategoryStatusDto> getProductStats();
}
