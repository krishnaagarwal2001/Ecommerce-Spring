package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    //This does not mean that we are trying to store a list of products inside category table
    //Telling JPA , the relationship is already owned by the product entity. So, just read from there.
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
