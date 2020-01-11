package com.toolbox.springboot.backend.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductImage;

public interface DAOProductImage extends JpaRepository<ProductImage, Long>{
	
	@Query("from ProductImage where productid=?1")
	public List<ProductImage> findAllProductImages(Long id);
	
	@Transactional
	@Modifying
	@Query("delete from ProductImage where productId=?1")
	public void deleteAllById(Product product);
	
	@Query("from ProductImage where imageRoute=?1")
	public ProductImage findByProductImageName(String imageRoute);
}
