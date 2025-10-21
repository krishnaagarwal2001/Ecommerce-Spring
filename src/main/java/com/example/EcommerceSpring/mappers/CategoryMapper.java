package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.CategoryWithAllProductsDTO;
import com.example.EcommerceSpring.entity.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public  static Category toEntity(CategoryDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryWithAllProductsDTO toCategoryWithAllProductsDTO(Category category) {
        return CategoryWithAllProductsDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(category.getProducts().stream().map(ProductMapper::toDTO).toList())
                .build();
    }
}
