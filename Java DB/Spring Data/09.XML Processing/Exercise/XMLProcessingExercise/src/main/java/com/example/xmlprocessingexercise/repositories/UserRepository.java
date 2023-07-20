package com.example.xmlprocessingexercise.repositories;

import com.example.xmlprocessingexercise.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (select COUNT(p) from Product p where p.seller.id = u.id and p.buyer is not null) > 0 " +
            "order by u.lastName, u.firstName")
    List<User> findAllWithMoreThanOneSoldProduct();
    @Query("select u from User u " +
            "join u.soldProducts p " +
            "where p.buyer is not null " +
            "order by size(u.soldProducts) desc, u.lastName")
    List<User> findAllUsersWithMoreThaneOneSoldProductDetailedInfo();
}
