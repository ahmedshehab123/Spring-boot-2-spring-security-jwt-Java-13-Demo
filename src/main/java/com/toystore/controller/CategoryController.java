package com.toystore.controller;

import java.util.List;

import javax.validation.Valid;

import com.toystore.model.entity.Product;
import com.toystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.toystore.model.entity.Category;
import com.toystore.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    ProductService productService;

    //list all categories
    @GetMapping(value = "/category")
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    //get by id
    @GetMapping("/category/{id}")
    public Category getCategoryByID(@PathVariable Integer id) throws Exception {
        return categoryService.findCategoryByID(id);
    }

    //add new category and update if it exist
    @PostMapping(value = "/category")
    public Category addNewCategory(@Valid @RequestBody Category category) throws Exception {
        return categoryService.insertCategory(category);
    }

    @GetMapping(value = "/category/product/{categoryId}")
    public List<Product> listCategoryProducts(@PathVariable Integer categoryId) {
        return productService.getAllCategoryProducts(categoryId);
    }


    //delete category
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

}
