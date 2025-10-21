package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //This is not SQL but HQL
    //this p.price is not column but java field
    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);
}
