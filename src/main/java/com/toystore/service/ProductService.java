package com.toystore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.exception.ConflictException;
import com.toystore.exception.ResourceNotFoundException;
import com.toystore.model.entity.Category;
import com.toystore.model.entity.Product;
import com.toystore.model.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    //get all products
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    //get all category products
    public List<Product> getAllCategoryProducts(Integer categoryId) {

        return productRepo.findProductByCategory_Id(categoryId);
    }

    //find product by id
    public Product findProductByID(Integer id) throws ResourceNotFoundException {
        try {
            return productRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(String.format("There is no Product with that id : ", id));
        }
    }

    //add new product
    public Product insertProduct(Product product) throws ConflictException {
        if (productRepo.findProductByName(product.getName()) != null) {
            throw new ConflictException(String.format("There is a Product with that name : ", product.getId()));
        }
        return productRepo.save(product);
    }

    //delete product
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    //add category to product
    public void addCategory(Product product, Category category) throws ConflictException {
        if (product.getCategory() != null) {
            throw new ConflictException(String.format("Product already has a category"));
        }
        product.setCategory(category);
        productRepo.save(product);
    }

    /*
    public void removeCategory(Product product, Category category) {
        product.getCategory().remove(category);
        productRepo.save(product);
*/
}
