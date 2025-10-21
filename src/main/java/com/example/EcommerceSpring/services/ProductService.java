package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductDTO getProductById(Long id) throws Exception {
    return productRepository.findById(id)
            .map(ProductMapper::toDTO)
            .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception{
        Category category =  categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new Exception("Category not found"));

        Product savedProduct = productRepository.save(ProductMapper.toEntity(productDTO,category));
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> getExpensiveProducts(double minPrice) {
        List<ProductDTO> response = new ArrayList<>();

        for(Product product : productRepository.findExpensiveProducts(minPrice)){
            response.add(ProductMapper.toDTO(product));
        }

        return response;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> response = new ArrayList<>();

        for(Product product : productRepository.findAll()){
            response.add(ProductMapper.toDTO(product));
        }

        return response;
    }
}
