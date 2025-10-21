package com.example.EcommerceSpring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWithAllProductsDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
