package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toolbox.springboot.backend.apirest.dao.DAOProduct;
import com.toolbox.springboot.backend.apirest.model.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private DAOProduct daoProduct;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) daoProduct.findAll();
	}
	
	@Override
	public Page<Product> findAll(Pageable pageable) {
		return daoProduct.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return daoProduct.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return daoProduct.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		daoProduct.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> findByProductName(String term) {
		return daoProduct.findByProductName(term);
	}
}
