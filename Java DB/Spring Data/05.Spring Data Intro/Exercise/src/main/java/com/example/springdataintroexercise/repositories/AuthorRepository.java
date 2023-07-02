package com.example.springdataintroexercise.repositories;

import com.example.springdataintroexercise.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a ORDER BY size(a.books) DESC") //create query, to access the collection
    List<Author> findAllByBooksSizeDesc();
}
