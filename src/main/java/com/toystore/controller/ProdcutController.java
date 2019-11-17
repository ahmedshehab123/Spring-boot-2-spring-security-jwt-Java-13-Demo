package com.toystore.controller;

import java.util.List;

import javax.validation.Valid;

import com.toystore.model.entity.Category;
import com.toystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.toystore.model.entity.Product;
import com.toystore.service.ProductService;

@RestController
@RequestMapping(value = "/api")
public class ProdcutController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	//get all products
	@GetMapping(value = "/product")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//find product by id
	@GetMapping(value = "/product/{id}")
	public Product getProductByID(@PathVariable Integer id) throws Exception{
		return productService.findProductByID(id);
	}
	//insert product
	@PostMapping(value = "/product")
	public Product addNewProduct(@Valid @RequestBody Product product) throws Exception{
		Category category=categoryService.findCategoryByID(product.getCategory().getId());
		product.setCategory(category);
		return productService.insertProduct(product);
	}
	//update product 
	@PutMapping(value = "/product/{id}")
	public Product updateProductInfo(@PathVariable Integer id, @Valid @RequestBody Product product) throws Exception{
		Product p = productService.findProductByID(id);
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setDescription(product.getDescription());
		
		return productService.insertProduct(p);
	}
	//delete product
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}


}
