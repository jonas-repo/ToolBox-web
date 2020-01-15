package com.toolbox.springboot.backend.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;

public interface DAOCategories extends JpaRepository<ProductCategory, Long>{
	@Query("from ProductCategory p where p.productCategory=?1")
	public List<ProductCategory> getProductsByCategory(String category);
	
	@Query("SELECT DISTINCT p.productCategory from ProductCategory p")
	public List<String> findAllCategories();
	
	@Query("from ProductCategory p where p.productCategory=?1 and p.product=?2")
	public ProductCategory findProductCategoryById(String category, Long id);
}
