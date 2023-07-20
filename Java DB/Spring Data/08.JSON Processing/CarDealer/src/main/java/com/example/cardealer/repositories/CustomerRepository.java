package com.example.cardealer.repositories;

import com.example.cardealer.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c ORDER BY c.birthDate ASC, c.isYoungDriver DESC")
    List<Customer> findAllByBirthDateAscAndYoungDriverDesc();

    List<Customer> findAllBySalesIsNotNull();
}
