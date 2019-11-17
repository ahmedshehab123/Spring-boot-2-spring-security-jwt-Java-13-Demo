package com.toystore.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toystore.model.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	Product findProductByName(String name);

	/*@Query(value = "select * from product p inner join category c on p.category_id = c.id",nativeQuery = true)
	List<Product> findByAssociatedWithCategory(Integer category_id, Product product);*/

	List<Product> findProductByCategory_Id(Integer category_id);

	boolean deleteAllByCategory_Id(Integer categoryId);

}
