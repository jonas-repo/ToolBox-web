package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolbox.springboot.backend.apirest.dao.DAOCategories;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private DAOCategories daoProductCategories;

	@Override
	public List<ProductCategory> findAllProducts() {
		return daoProductCategories.findAll();
	}

	@Override
	public List<ProductCategory> getProductsByCategory(String category) {
		return daoProductCategories.getProductsByCategory(category);
	}

	@Override
	public List<String> findAllCategories() {
		return daoProductCategories.findAllCategories();
	}
	

}
