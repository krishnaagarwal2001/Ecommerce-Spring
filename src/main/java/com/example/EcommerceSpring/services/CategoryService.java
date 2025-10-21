package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.CategoryWithAllProductsDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> response = new ArrayList<>();

        for(Category category : categoryRepository.findAll()) {
            response.add(CategoryMapper.toDTO(category));
        }

        return response;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        Category category = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO findByName(String name) throws Exception {
        return categoryRepository.findByName(name).map(CategoryMapper::toDTO)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public CategoryWithAllProductsDTO getCategoryWithAllProducts(Long id) throws Exception {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category not found"));

        return CategoryMapper.toCategoryWithAllProductsDTO(category);
    }


}
