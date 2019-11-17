package com.toystore.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toystore.model.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{
	Category findCategoryByName(String name);

}
 