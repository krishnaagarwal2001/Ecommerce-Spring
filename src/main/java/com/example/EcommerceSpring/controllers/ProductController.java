package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) Integer minPrice){

        if(minPrice != null){
            return ResponseEntity.ok(this.productService.getExpensiveProducts(minPrice));
        }

        List<ProductDTO> response = this.productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

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


    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.productService.getProductWithCategory(id));
    }
}
