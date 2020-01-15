package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;

public interface ProductCategoryService {
	
	public List<ProductCategory> findAllProducts();
	
	public List<ProductCategory> getProductsByCategory(String category);
	
	public List<String> findAllCategories();

}
