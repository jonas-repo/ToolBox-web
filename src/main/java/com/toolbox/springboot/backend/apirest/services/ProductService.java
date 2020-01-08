package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.toolbox.springboot.backend.apirest.model.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Product findById(Long id);
	
	public Product save(Product product);
	
	public void delete(Long id);
}
