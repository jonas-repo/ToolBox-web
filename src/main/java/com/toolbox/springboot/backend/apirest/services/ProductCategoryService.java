package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;

public interface ProductCategoryService {
	
	public List<ProductCategory> findAllProducts();
	
	public List<ProductCategory> getProductsByCategory(String category);
	
	public List<String> findAllCategories();
	
	public ProductCategory save(ProductCategory productCategory);
	
	public ProductCategory findById(Long id);
	
	public ProductCategory findProductCategoryById(String category, Long id);

}
