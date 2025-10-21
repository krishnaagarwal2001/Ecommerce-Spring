package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
    return ProductDTO.builder()
        .id(product.getId())
        .image(product.getImage())
        .price(product.getPrice())
        .description(product.getDescription())
        .color(product.getColor())
        .price(product.getPrice())
        .brand(product.getBrand())
        .discount(product.getDiscount())
        .model(product.getModel())
        .title(product.getTitle())
        .popular(product.isPopular())
            .categoryId(product.getCategory().getId())
        .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category) {
        return Product.builder()
                .image(productDTO.getImage())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .color(productDTO.getColor())
                .brand(productDTO.getBrand())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .popular(productDTO.isPopular())
                .category(category)
                .build();
    }

}
