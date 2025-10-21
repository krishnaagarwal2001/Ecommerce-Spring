package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.CategoryWithAllProductsDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

    CategoryDTO findByName(String name) throws Exception;

    CategoryWithAllProductsDTO getCategoryWithAllProducts(Long id) throws Exception;
}
