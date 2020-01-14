package com.toolbox.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;

public interface DAOCategories extends JpaRepository<ProductCategory, Long>{

	
}
