package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductGateway {
    ProductDTO getProductById(@PathVariable Long id) throws Exception;
}
