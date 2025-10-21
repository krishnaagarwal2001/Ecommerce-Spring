package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<ProductDTO> getExpensiveProducts(double minPrice) {
        return List.of();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }
}
