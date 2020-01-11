package com.toolbox.springboot.backend.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toolbox.springboot.backend.apirest.model.entity.Product;

public interface DAOProduct extends JpaRepository<Product, Long>{
	
	@Query("select p from Product p where p.productName like %?1%")
	public List<Product> findByProductName(String term);
	
	public List<Product> findByProductNameContainingIgnoreCase(String term);
	
	public List<Product> findByProductNameStartingWithIgnoreCase(String term);
}
