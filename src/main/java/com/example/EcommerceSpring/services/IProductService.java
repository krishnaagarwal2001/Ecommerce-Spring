package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductService {
    ProductDTO getProductById(@PathVariable Long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;
}
