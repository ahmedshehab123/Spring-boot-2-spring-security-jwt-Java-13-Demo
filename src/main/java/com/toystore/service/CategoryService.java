package com.toystore.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.toystore.model.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toystore.exception.ConflictException;
import com.toystore.exception.ResourceNotFoundException;
import com.toystore.model.entity.Category;
import com.toystore.model.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	ProductRepo productRepo;
	
	//find all categories
	public List<Category> findAllCategories(){
		return categoryRepo.findAll();
	}
	
	//find by id 
	public Category findCategoryByID(Integer id) throws ResourceNotFoundException{
		try {
		return categoryRepo.findById(id).get();
		}
		catch(NoSuchElementException e){
			throw new ResourceNotFoundException(String.format("There is no Category with that id : ", id));
		}
	}
	
	//insert new category
	public Category insertCategory(Category category) throws Exception {
		if(categoryRepo.findCategoryByName(category.getName()) != null) {
			throw new ConflictException(String.format("already created ", category.getId()));
		}
		return categoryRepo.save(category);
	}

	//delete category
	public void deleteCategory(Integer categoryId) {
		productRepo.deleteAllByCategory_Id(categoryId);
		categoryRepo.deleteById(categoryId);
	}

}
