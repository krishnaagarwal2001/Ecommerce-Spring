package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper {
    static public List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO fakeStoreCategoryResponseDTO) {
        return fakeStoreCategoryResponseDTO.getCategories()
            .stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
