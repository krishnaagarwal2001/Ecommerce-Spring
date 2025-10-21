package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /*
        To access dynamic variable from API
        We need to use @PathVariable annotation
    */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDTO response = this.productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    /*
        The annotation @RequestBody is used in controller methods to bind the body
        of an HTTP request to a Java object.
    */
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws Exception {
        ProductDTO response = this.productService.createProduct(productDTO);
        return ResponseEntity.ok(response);
    }
}
