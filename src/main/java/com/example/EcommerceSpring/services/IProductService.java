package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IProductService {
    ProductDTO getProductById(@PathVariable Long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;

    List<ProductDTO> getExpensiveProducts(double minPrice);

    List<ProductDTO> getAllProducts();
}
