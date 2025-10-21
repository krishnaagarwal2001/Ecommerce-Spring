package com.example.EcommerceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

/*
    Entities in JPA are nothing but POJOs representing data that can be persisted in the database.
    An entity represents a table stored in a database. Every instance of an entity represents a row in the table.

    We must also ensure that the entity has a no-arg constructor and a primary key
    JPA entity classes required explicit no-arg constructor. (JPA Specification)

    entity classes must not be declared final.
*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    /*
     * FetchType.EAGER — the associated Category entity is fetched immediately
     * along with the Product (i.e., in the same query or via an immediate join).
     *
     * FetchType.LAZY — the associated Category entity is fetched only when it’s
     * actually accessed in code (e.g., product.getCategory()), which triggers a
     * separate SQL query at that moment.
     *
     * Default Values
     * ManyToOne --> Eager
     * OneToOne --> Eager
     * OneToMany --> Lazy
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "categoryId")
    private Category category;
}
