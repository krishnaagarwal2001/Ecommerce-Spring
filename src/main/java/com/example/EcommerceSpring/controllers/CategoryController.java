package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/*
    @Component --> Spring created object on our behalf and manage its lifecycle
*/

/*
@RestController is combination of 2 annotations
	@Controller --> just semantics purpose for @Component for Controller classes
    @ResponseBody --> If you are returning anything, return as HTTP response
*/
@RestController
@RequestMapping("api/categories")
public class CategoryController {

/*
Dependency Injection is a programming technique in which an object or function receives other objects
or functions that it requires, as opposed to creating them internally

Dependencies are typically "injected" into a class through its constructor, a public property, or a method.

In Golang, we can use uberFX lib for DI.
*/

/*
    Spring boot can create the object of categoryService in 2 ways (Dependency Injection)
    1. Constructor Based Injection
    2. Field Based Injection

    Field injection does not support final keyword attachment.
    Mostly we have to use Construction Injection.
*/

    /*
        @Autowired helps in Field Injection
    */
    private ICategoryService categoryService;

     public CategoryController(ICategoryService _categoryService) {
         /*
             Here we are not creating object, we are getting object externally so DI
         */
         this.categoryService = _categoryService;
     }

     /*
        ResponseEntity is used to configure the response (status code, headers etc.)
     */
    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {

        if(name != null && !name.isBlank()){
            CategoryDTO categoryDTO = this.categoryService.findByName(name);
            return ResponseEntity.ok(categoryDTO);
        }

        List<CategoryDTO> response = this.categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO response = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(response);
    }
}
